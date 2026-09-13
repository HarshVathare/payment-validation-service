package com.hulkhiretech.payments.Service.Impl;

import com.hulkhiretech.payments.Constant.ErrorCodeEnum;
import com.hulkhiretech.payments.Constant.ValidatorRuleEnum;
import com.hulkhiretech.payments.Controller.PaymentController;
import com.hulkhiretech.payments.Entity.ValidationRule;
import com.hulkhiretech.payments.Exception.PaymentValidationException;
import com.hulkhiretech.payments.Pojo.PaymentRequest;
import com.hulkhiretech.payments.Repository.ValidationRuleRepository;
import com.hulkhiretech.payments.Service.Interfaces.BusinessValidator;
import com.hulkhiretech.payments.Service.Interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final ApplicationContext applicationContext;
    private final ValidationRuleRepository validationRuleRepository;

    @Override
    public String validateAndCreatePayment(PaymentRequest req) {

        log.info("Validating payment request: {}", req);

        // Get active validation rules from DB
        List<ValidationRule> validationRules =
                validationRuleRepository.findByIsActiveTrueOrderByPriorityAsc();

        log.info("Validation rules loaded from DB: {}", validationRules.size());

        // Execute validators according to DB configuration
        for (ValidationRule rule : validationRules) {

            String ruleName = rule.getValidatorName();

            log.info("Processing validation rule: {}", ruleName);

            // Find validator class from enum
            Class<? extends BusinessValidator> validatorClass =
                    ValidatorRuleEnum.getValidatorClassByName(ruleName);

            if (validatorClass == null) {

                log.error("No validator class found for rule: {}", ruleName);

                throw new PaymentValidationException(
                        ErrorCodeEnum.VALIDATION_CLASS_NOT_FOUND.getErrorCode(),
                        ErrorCodeEnum.VALIDATION_CLASS_NOT_FOUND.getErrorMessage(),
                        ErrorCodeEnum.VALIDATION_CLASS_NOT_FOUND.getHttpStatus()
                );
            }

            // Get validator bean from Spring container
            BusinessValidator validatorBean;

            try {

                validatorBean = applicationContext.getBean(validatorClass);

                log.info(
                        "Validator bean loaded successfully: {}",
                        validatorBean.getClass().getSimpleName()
                );

            } catch (Exception e) {

                log.error(
                        "Error while loading validator bean for rule: {}",
                        ruleName,
                        e
                );

                throw new PaymentValidationException(
                        ErrorCodeEnum.VALIDATION_BEAN_NOT_FOUND.getErrorCode(),
                        ErrorCodeEnum.VALIDATION_BEAN_NOT_FOUND.getErrorMessage(),
                        ErrorCodeEnum.VALIDATION_BEAN_NOT_FOUND.getHttpStatus()
                );
            }

            // Execute validator
            log.info("Calling validator: {}", ruleName);

            validatorBean.validate(req);

            log.info("Validator passed: {}", ruleName);
        }

        log.info("All validators passed for payment request: {}", req);

        // Call next payment service here
        return "txn_00111";
    }
}








//package com.hulkhiretech.payments.Service.Impl;
//
//import com.hulkhiretech.payments.Constant.ErrorCodeEnum;
//import com.hulkhiretech.payments.Constant.ValidatorRuleEnum;
//import com.hulkhiretech.payments.Entity.ValidationRule;
//import com.hulkhiretech.payments.Exception.PaymentValidationException;
//import com.hulkhiretech.payments.Pojo.PaymentRequest;
//import com.hulkhiretech.payments.Repository.ValidationRuleRepository;
//import com.hulkhiretech.payments.Service.Impl.Validator.ValidatorCheck1;
//import com.hulkhiretech.payments.Service.Impl.Validator.ValidatorCheck2;
//import com.hulkhiretech.payments.Service.Interfaces.BusinessValidator;
//import com.hulkhiretech.payments.Service.Interfaces.PaymentService;
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class PaymentServiceImpl implements PaymentService {
//
//    private final ApplicationContext applicationContext;
//
////    @Value("${validation.rule-list}")
////    private String validationRuleListCommaSeparated;
//
//    private final ValidationRuleRepository validationRuleRepository;
//
//    @Override
//    public String validateAndCreatePayment(PaymentRequest req) {
//
//        //Validation logic for the payment request can be added here
//        log.info("Validating payment request: {}", req);
////
////        validationRuleList = validationRuleList.replaceAll("\\s+", ""); // Remove whitespace
////
////        String[] validationRules = validationRuleList.split(",");
//        //iterate through the validation rules and call the corresponding validator
//
//        List<String> ValidatorNames = validationRuleRepository.findActiveValidatorNames();
//
//        log.info("Validation rule get from DB: {}", ValidatorNames);
//        for (String rule : ValidatorNames) {
//            log.info("-> Validation rule get from DB: {}", ValidatorNames);
//
//            Class<? extends BusinessValidator> validatorClass =
//                    ValidatorRuleEnum.getValidatorClassByName(rule);
//
//            //code for runtime exception handling if the validator class is not found
//            if (validatorClass == null) {
//                log.error("No validator found for rule: {}", rule);
//                  throw new PaymentValidationException(
//                          ErrorCodeEnum.VALIDATION_CLASS_NOT_FOUND.getErrorCode(),
//                          ErrorCodeEnum.VALIDATION_CLASS_NOT_FOUND.getErrorMessage(),
//                          ErrorCodeEnum.VALIDATION_CLASS_NOT_FOUND.getHttpStatus()
//                  );
//            }
//
//            BusinessValidator validatorbean = null;
//            try{
//                //you load the bean
//                validatorbean = applicationContext.getBean(validatorClass );
//
//                log.info("ValidatorBean: {}", validatorbean);
//
//            }catch (Exception e){
//                log.error("Error while loading validator bean for rule: {}", rule, e);
//                //write exception for bean not found
//                throw new PaymentValidationException(
//                        ErrorCodeEnum.VALIDATION_BEAN_NOT_FOUND.getErrorCode(),
//                        ErrorCodeEnum.VALIDATION_BEAN_NOT_FOUND.getErrorMessage(),
//                        ErrorCodeEnum.VALIDATION_BEAN_NOT_FOUND.getHttpStatus()
//                );
//            }
//
//            log.info("Calling validator: {}", validatorbean);
//            validatorbean.validate(req);
//
//        }
//
//        // put it in a list of validators
//        List<Class<? extends BusinessValidator>> validators = List.of(
//                ValidatorCheck1.class,
//                ValidatorCheck2.class
//        );
//
//        // Iterate through the list of validators and call their validate method
//        for (Class<? extends BusinessValidator> validatorClass : validators) {
//            //you load the bean
//            BusinessValidator validatorbean = applicationContext.getBean(validatorClass);
////            log.info("Calling validator: {}", validatorbean);
//
//            //call the validate method of the validator
////            validatorbean.validate(req);
//        }
//
//        log.info("All validators passed for payment request: {}", req);
//        // if no exception is thrown in validation logic
//        //then call the next microservices
//        return "txn_00111";
//    }
//
//    //init method with post construct to load the validators from the application context
//     @PostConstruct
//     public void init() {
//        List<ValidationRule> validationRuleList = validationRuleRepository.findByIsActiveTrueOrderByPriorityAsc();
//
////         validationRuleList.forEach(rule -> {
////             log.info("Validator rule from DB: {}", rule.getValidatorName());
////         });
//
//     }
//
//}
