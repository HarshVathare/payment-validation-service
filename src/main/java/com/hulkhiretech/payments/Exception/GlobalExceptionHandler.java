package com.hulkhiretech.payments.Exception;
import com.hulkhiretech.payments.Constant.ErrorCodeEnum;
import com.hulkhiretech.payments.Pojo.ErrorResponce;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PaymentValidationException.class)
    public ResponseEntity<ErrorResponce> handlePaymentValidationException(
            PaymentValidationException ex) {

          ErrorResponce errorResponse = new ErrorResponce();
            errorResponse.setErrorCode(ex.getErrorCode());
            errorResponse.setErrorMessage(ex.getErrorMessage());

         return ResponseEntity.status(ex.getHttpStatusCode()).body(errorResponse);
    }

    // Add more exception handlers for other exceptions if needed
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponce> handleGenericException(
            Exception ex) {

        ErrorResponce errorResponse = new ErrorResponce();
        errorResponse.setErrorCode(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getErrorCode());
        errorResponse.setErrorMessage(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getErrorMessage());

        return ResponseEntity.status(500).body(errorResponse);
    }
}