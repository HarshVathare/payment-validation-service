package com.hulkhiretech.payments.Service.Impl.Validator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hulkhiretech.payments.Entity.MerchantPaymentRequest;
import com.hulkhiretech.payments.Exception.PaymentValidationException;
import com.hulkhiretech.payments.Pojo.PaymentRequest;
import com.hulkhiretech.payments.Repository.MerchantPaymentRequestRepository;
import com.hulkhiretech.payments.Service.Interfaces.BusinessValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ValidatorCheck2 implements BusinessValidator {

    private final MerchantPaymentRequestRepository merchantPaymentRequestRepository;;

    @Override
    public void validate(PaymentRequest req) {
        log.info("ValidatorCheck2: Validating payment "+"req : {}", req);
        // Add your validation logic here

        //save the payment request to the database
//        MerchantPaymentRequest merchantPaymentRequest = new MerchantPaymentRequest();
//        merchantPaymentRequest.setEndUserId(req.getUser().getEndUserId());
//        merchantPaymentRequest.setMerchantTxnReference(req.getPayment().getMerchantTxnRef());
//        merchantPaymentRequest.setTransactionRequest(convertToJson(req));
//        merchantPaymentRequestRepository.save(merchantPaymentRequest);
//        log.info("Payment request saved to database: {}", merchantPaymentRequest);

        //create method for get data
//        getDataFromDatabase(req.getUser().getEndUserId(), req.getPayment().getMerchantTxnRef());


    }

//    private void getDataFromDatabase(String endUserId, String merchantTxnRef) {
//
//        MerchantPaymentRequest merchantPaymentRequest = merchantPaymentRequestRepository.findByEndUserIdAndMerchantTxnReference(endUserId, merchantTxnRef);
//        if (merchantPaymentRequest != null) {
//            log.info("Payment request found in database: {}", merchantPaymentRequest);
//        } else {
//            log.info("Payment request not found in database for endUserId: {} and merchantTxnRef: {}", endUserId, merchantTxnRef);
//        }
//    }


    // create a method for object mapper
//    public String convertToJson(Object object) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            return objectMapper.writeValueAsString(object);
//        } catch (PaymentValidationException | JsonProcessingException e) {
//            log.error("Error converting object to JSON: {}", e.getMessage());
//            return null;
//        }
//    }


}
