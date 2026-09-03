package com.hulkhiretech.payments.Service.Impl;

import com.hulkhiretech.payments.Constant.ErrorCodeEnum;
import com.hulkhiretech.payments.Constant.ValidatorRuleEnum;
import com.hulkhiretech.payments.Exception.PaymentValidationException;
import com.hulkhiretech.payments.Pojo.PaymentRequest;
import com.hulkhiretech.payments.Service.Impl.Validator.ValidatorCheck1;
import com.hulkhiretech.payments.Service.Impl.Validator.ValidatorCheck2;
import com.hulkhiretech.payments.Service.Interfaces.BusinessValidator;
import com.hulkhiretech.payments.Service.Interfaces.PaymentService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final ApplicationContext applicationContext;

    @Value("${validation.rule-list}")
    private String validationRulList;

    @Override
    public String validateAndCreatePayment(PaymentRequest req) {

        //Validation logic for the payment request can be added here
        log.info("Validating payment request: {}", req);

        validationRulList = validationRulList.replaceAll("\\s+", ""); // Remove whitespace

        String[] validationRules = validationRulList.split(",");
        //iterate through the validation rules and call the corresponding validator
        for (String rule : validationRules) {
            log.info("Validation rule: {}", rule);

            Class<? extends BusinessValidator> validatorClass =
                    ValidatorRuleEnum.getValidatorClassByName(rule);

            //code for runtime exception handling if the validator class is not found
            if (validatorClass == null) {
                log.error("No validator found for rule: {}", rule);
                  throw new PaymentValidationException(
                          ErrorCodeEnum.VALIDATION_CLASS_NOT_FOUND.getErrorCode(),
                          ErrorCodeEnum.VALIDATION_CLASS_NOT_FOUND.getErrorMessage(),
                          ErrorCodeEnum.VALIDATION_CLASS_NOT_FOUND.getHttpStatus()
                  );
            }

            BusinessValidator validatorbean = null;
            try{
                //you load the bean
                validatorbean = applicationContext.getBean(validatorClass );

                log.info("ValidatorBean: {}", validatorbean);

            }catch (Exception e){
                log.error("Error while loading validator bean for rule: {}", rule, e);
                //write exception for bean not found
                throw new PaymentValidationException(
                        ErrorCodeEnum.VALIDATION_BEAN_NOT_FOUND.getErrorCode(),
                        ErrorCodeEnum.VALIDATION_BEAN_NOT_FOUND.getErrorMessage(),
                        ErrorCodeEnum.VALIDATION_BEAN_NOT_FOUND.getHttpStatus()
                );
            }

            log.info("Calling validator: {}", validatorbean);
            validatorbean.validate(req);

        }

        // put it in a list of validators
        List<Class<? extends BusinessValidator>> validators = List.of(
                ValidatorCheck1.class,
                ValidatorCheck2.class
        );

        // Iterate through the list of validators and call their validate method
        for (Class<? extends BusinessValidator> validatorClass : validators) {
            //you load the bean
            BusinessValidator validatorbean = applicationContext.getBean(validatorClass);
//            log.info("Calling validator: {}", validatorbean);

            //call the validate method of the validator
//            validatorbean.validate(req);
        }

        log.info("All validators passed for payment request: {}", req);
        // if no exception is thrown in validation logic
        //then call the next microservices
        return "txn_00111";
    }

    //init method with post construct to load the validators from the application context
     @PostConstruct
     public void init() {
        log.info("Validation rule list : {}", validationRulList);

     }

}
