package com.hulkhiretech.payments.Constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCodeEnum {

    INTERNAL_SERVER_ERROR(
            "10000",
            "An unexpected error occurred",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),

    INVALID_USER_NAME(
            "10001",
            "User first name and last name cannot be empty",
            HttpStatus.BAD_REQUEST
    ),

    INVALID_PAYMENT_AMOUNT(
            "10002",
            "Payment amount must be greater than zero",
            HttpStatus.BAD_REQUEST
    ),

    VALIDATION_CLASS_NOT_FOUND(
            "10003",
            "Validation class not found",
            HttpStatus.INTERNAL_SERVER_ERROR
    ),

    VALIDATION_BEAN_NOT_FOUND(
            "10004",
            "Validation bean not found",
            HttpStatus.INTERNAL_SERVER_ERROR);

    private final String errorCode;
    private final String errorMessage;
    private final HttpStatus httpStatus;


}