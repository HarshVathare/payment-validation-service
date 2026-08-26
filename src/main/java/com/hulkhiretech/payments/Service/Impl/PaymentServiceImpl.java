package com.hulkhiretech.payments.Service.Impl;

import com.hulkhiretech.payments.DTO.PaymentRequest;
import com.hulkhiretech.payments.Service.Impl.Validator.ValidatorCheck1;
import com.hulkhiretech.payments.Service.Impl.Validator.ValidatorCheck2;
import com.hulkhiretech.payments.Service.Interfaces.BusinessValidator;
import com.hulkhiretech.payments.Service.Interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import java.awt.*;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final ApplicationContext applicationContext;

    @Override
    public String validateAndCreatePayment(PaymentRequest req) {

        //Validation logic for the payment request can be added here
        log.info("Validating payment request: {}", req);

        // put it in a list of validators
        List<Class<? extends BusinessValidator>> validators = List.of(
                ValidatorCheck1.class,
                ValidatorCheck2.class
        );

        // Iterate through the list of validators and call their validate method
        for (Class<? extends BusinessValidator> validatorClass : validators) {
            //you load the bean
            BusinessValidator validatorbean = applicationContext.getBean(validatorClass);
            log.info("Calling validator: {}", validatorbean);

            //call the validate method of the validator
            validatorbean.validate(req);
        }

        log.info("All validators passed for payment request: {}", req);




        // if no exception is thrown in validation logic
        //then call the next microservices



        return "txn_00111";
    }
}
