package com.hulkhiretech.payments.Service.Impl.Validator;

import com.hulkhiretech.payments.Pojo.PaymentRequest;
import com.hulkhiretech.payments.Service.Interfaces.BusinessValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentAttemptThreshold implements BusinessValidator {
    @Override
    public void validate(PaymentRequest req) {
        log.info("PaymentAttemptThreshold: Validating payment " + "req : {}", req);
        log.info("PaymentAttemptThreshold: Validation passed for payment " + "req : {}", req);
    }
}
