package com.hulkhiretech.payments.Constant;

import com.hulkhiretech.payments.Repository.ValidationRuleRepository;
import com.hulkhiretech.payments.Service.Impl.Validator.DublicateTxnCheck;
import com.hulkhiretech.payments.Service.Impl.Validator.PaymentAttemptThreshold;
import com.hulkhiretech.payments.Service.Impl.Validator.ValidatorCheck1;
import com.hulkhiretech.payments.Service.Impl.Validator.ValidatorCheck2;
import com.hulkhiretech.payments.Service.Interfaces.BusinessValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public enum ValidatorRuleEnum {

    DUPLICATION_TXN_RULE("DUPLICATION_TXN_RULE", DublicateTxnCheck.class),
    PAYMENT_ATTEMPT_THRESHOLD_RULE("PAYMENT_ATTEMPT_THRESHOLD_RULE", PaymentAttemptThreshold.class);

    private final String name;
    private final Class<? extends BusinessValidator> validatorClass;

    ValidatorRuleEnum( String name, Class<? extends BusinessValidator> validatorClass) {
        this.name = name;
        this.validatorClass = validatorClass;
    }

    //get ValidatorRuleEnum by name
    public static Class<? extends BusinessValidator> getValidatorClassByName(String name) {
        for (ValidatorRuleEnum rule : ValidatorRuleEnum.values()) {
            if (rule.getName().equalsIgnoreCase(name)) {
                return rule.getValidatorClass();
            }
        }
    //  throw new IllegalArgumentException("No validator found for name: " + name);
        log.error("Validator Class not found for name: {}", name);
        return null;
    }


}
