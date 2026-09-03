package com.hulkhiretech.payments.Exception;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PaymentValidationException  extends RuntimeException {

    private final String errorCode;
    private final String errorMessage;
    private final HttpStatus httpStatusCode;

    public PaymentValidationException(
            String errorCode,
            String errorMessage,
            HttpStatus httpStatusCode) {

        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatusCode = httpStatusCode;
    }
}