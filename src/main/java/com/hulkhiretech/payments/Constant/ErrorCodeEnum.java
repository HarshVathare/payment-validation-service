package com.hulkhiretech.payments.Constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCodeEnum {

    GENERIC_ERROR(
            "10000",
            "An unexpected error occurred. Please try again later.",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),

    VALIDATION_CLASS_NOT_FOUND(
            "10001",
            "Validation class not found",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),

    VALIDATION_BEAN_NOT_FOUND(
            "10002",
            "Validation bean not found",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),

    OBJ_TO_JSON_CONVERSION_ERROR(
            "10003",
            "Error converting object to JSON",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),

    JSON_TO_OBJ_CONVERSION_ERROROBJ_TO_JSON_CONVERSION_ERROR(
            "10004",
            "Error converting JSON to object",
            HttpStatus.INTERNAL_SERVER_ERROR
    ), INVALID_MERCHANT_TXN_REF(
            "10005",
            "Invalid merchant transaction reference",
            HttpStatus.BAD_REQUEST
    ),
    DUPLICATE_MERCHANT_TXN_REF(
            "10006",
            "Duplicate merchant transaction reference found",
            HttpStatus.BAD_REQUEST
    );


    private final String errorCode;
    private final String errorMessage;
    private final HttpStatus httpStatus;


}