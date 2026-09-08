package com.hulkhiretech.payments.Service.Impl.Validator;


import com.hulkhiretech.payments.Constant.ErrorCodeEnum;
import com.hulkhiretech.payments.Exception.PaymentValidationException;
import com.hulkhiretech.payments.Pojo.PaymentRequest;
import com.hulkhiretech.payments.Service.Interfaces.BusinessValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ValidatorCheck1 implements BusinessValidator {
    @Override
    public void validate(PaymentRequest req) {
        log.info("ValidatorCheck1: Validating payment "+"req : {}", req);

//        // Add your validation logic here
//        if(req.getUser().getFirstName().isEmpty() || req.getUser().getLastName().isEmpty()){
//            throw new PaymentValidationException(
//                    ErrorCodeEnum.INVALID_USER_NAME.getErrorCode(),
//                    ErrorCodeEnum.INVALID_USER_NAME.getErrorMessage(),
//                    ErrorCodeEnum.INVALID_USER_NAME.getHttpStatus()
//            );
//        }
//
//        if( (req.getPayment().getTotalAmount() <= 0 ) || ( req.getPayment().getTotalAmount() == null) ){
//            throw new PaymentValidationException(
//                     ErrorCodeEnum.INVALID_PAYMENT_AMOUNT.getErrorCode(),
//                    ErrorCodeEnum.INVALID_PAYMENT_AMOUNT.getErrorMessage(),
//                    ErrorCodeEnum.INVALID_PAYMENT_AMOUNT.getHttpStatus()
//            );
//        }



    }
}
