package com.hulkhiretech.payments.Service.Impl.Validator;

import com.hulkhiretech.payments.Pojo.PaymentRequest;
import com.hulkhiretech.payments.Service.Interfaces.BusinessValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ValidatorCheck2 implements BusinessValidator {
    @Override
    public void validate(PaymentRequest req) {
        log.info("ValidatorCheck2: Validating payment "+"req : {}", req);
        // Add your validation logic here
    }
}
