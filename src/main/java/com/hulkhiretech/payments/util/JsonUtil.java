package com.hulkhiretech.payments.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hulkhiretech.payments.Constant.ErrorCodeEnum;
import com.hulkhiretech.payments.Exception.PaymentValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class JsonUtil {

    private final ObjectMapper objectMapper;

    public String convertToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.error("Error converting object to JSON: {}", e.getMessage());
            throw new PaymentValidationException(
                    ErrorCodeEnum.OBJ_TO_JSON_CONVERSION_ERROR.getErrorCode(),
                    ErrorCodeEnum.OBJ_TO_JSON_CONVERSION_ERROR.getErrorMessage(),
                    ErrorCodeEnum.OBJ_TO_JSON_CONVERSION_ERROR.getHttpStatus()
            );
        }
    }

    //convert json to object
    public <T> T convertFromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            log.error("Error converting JSON to object: {}", e.getMessage());
            throw new PaymentValidationException(
                    ErrorCodeEnum.JSON_TO_OBJ_CONVERSION_ERROROBJ_TO_JSON_CONVERSION_ERROR.getErrorCode(),
                    ErrorCodeEnum.JSON_TO_OBJ_CONVERSION_ERROROBJ_TO_JSON_CONVERSION_ERROR.getErrorMessage(),
                    ErrorCodeEnum.JSON_TO_OBJ_CONVERSION_ERROROBJ_TO_JSON_CONVERSION_ERROR.getHttpStatus()
            );
        }
    }
}
