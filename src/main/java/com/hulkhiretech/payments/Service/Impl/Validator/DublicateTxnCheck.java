package com.hulkhiretech.payments.Service.Impl.Validator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hulkhiretech.payments.Constant.ErrorCodeEnum;
import com.hulkhiretech.payments.Entity.MerchantPaymentRequest;
import com.hulkhiretech.payments.Exception.PaymentValidationException;
import com.hulkhiretech.payments.Pojo.PaymentRequest;
import com.hulkhiretech.payments.Repository.MerchantPaymentRequestRepository;
import com.hulkhiretech.payments.Service.Interfaces.BusinessValidator;
import com.hulkhiretech.payments.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DublicateTxnCheck implements BusinessValidator {

    private final MerchantPaymentRequestRepository reqRepository;

    private final ObjectMapper objectMapper;

    private final JsonUtil jsonUtil;

    @Override
    @Transactional
    public void validate(PaymentRequest req) {
        log.info("DublicateTxnCheck: Validating payment " + "req : {}", req);
        String merchantTxnRef = req.getPayment().getMerchantTxnRef();

        log.info(
                "Duplicate transaction validation started. merchantTxnRef={}",
                merchantTxnRef
        );

        //  Validate transaction reference
        if (merchantTxnRef == null || merchantTxnRef.isBlank()) {
            throw new PaymentValidationException(
                    ErrorCodeEnum.INVALID_MERCHANT_TXN_REF.getErrorCode(),
                    ErrorCodeEnum.INVALID_MERCHANT_TXN_REF.getErrorMessage(),
                    ErrorCodeEnum.INVALID_MERCHANT_TXN_REF.getHttpStatus()
            );
        }

        //  Normalize transaction reference
        merchantTxnRef = merchantTxnRef.trim();

        //  Early duplicate check
        if (reqRepository.existsByMerchantTxnReference(merchantTxnRef)) {

            log.warn(
                    "Duplicate merchant transaction reference found. merchantTxnRef={}",
                    merchantTxnRef
            );

            throw new PaymentValidationException(
                    ErrorCodeEnum.DUPLICATE_MERCHANT_TXN_REF.getErrorCode(),
                    ErrorCodeEnum.DUPLICATE_MERCHANT_TXN_REF.getErrorMessage()+ " merchantTxnRef : "+merchantTxnRef,
                    ErrorCodeEnum.DUPLICATE_MERCHANT_TXN_REF.getHttpStatus()
            );
        }

        //  Create entity
        MerchantPaymentRequest entity = new MerchantPaymentRequest();

        entity.setEndUserId(req.getUser().getEndUserId());
        entity.setMerchantTxnReference(merchantTxnRef);
        entity.setTransactionRequest(
                jsonUtil.convertToJson(req)
        );

        //  Save
        try {

            MerchantPaymentRequest savedEntity =
                    reqRepository.save(entity);

            log.info(
                    "Payment request saved successfully. id={}, merchantTxnRef={}",
                    savedEntity.getId(),
                    merchantTxnRef
            );

        } catch (DataIntegrityViolationException ex) {

            log.warn(
                    "Duplicate transaction detected by database. merchantTxnRef={}",
                    merchantTxnRef
            );

            throw new PaymentValidationException(
                    ErrorCodeEnum.DUPLICATE_MERCHANT_TXN_REF.getErrorCode(),
                    ErrorCodeEnum.DUPLICATE_MERCHANT_TXN_REF.getErrorMessage(),
                    ErrorCodeEnum.DUPLICATE_MERCHANT_TXN_REF.getHttpStatus()
            );
        }
    }
}