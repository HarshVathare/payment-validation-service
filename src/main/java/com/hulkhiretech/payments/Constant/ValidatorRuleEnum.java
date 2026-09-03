package com.hulkhiretech.payments.Constant;

import com.hulkhiretech.payments.Service.Impl.Validator.ValidatorCheck1;
import com.hulkhiretech.payments.Service.Impl.Validator.ValidatorCheck2;
import com.hulkhiretech.payments.Service.Interfaces.BusinessValidator;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public enum ValidatorRuleEnum {

    CHECK1("CHECK1", ValidatorCheck1.class),
    CHECK2("CHECK2", ValidatorCheck2.class);

    private final String name;
    private final Class<? extends BusinessValidator> validatorClass;

    ValidatorRuleEnum(String name, Class<? extends BusinessValidator> validatorClass) {
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
//        throw new IllegalArgumentException("No validator found for name: " + name);
        log.error("Validator Class not found for name: {}", name);
        return null;
    }


}
