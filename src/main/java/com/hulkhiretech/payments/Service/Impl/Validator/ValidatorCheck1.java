package com.hulkhiretech.payments.Service.Impl.Validator;


import com.hulkhiretech.payments.DTO.PaymentRequest;
import com.hulkhiretech.payments.Service.Interfaces.BusinessValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ValidatorCheck1 implements BusinessValidator {
    @Override
    public void validate(PaymentRequest req) {
        log.info("ValidatorCheck1: Validating payment "+"req : {}", req);
        // Add your validation logic here
    }
}
