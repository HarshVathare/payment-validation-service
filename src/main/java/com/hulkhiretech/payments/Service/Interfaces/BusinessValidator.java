package com.hulkhiretech.payments.Service.Interfaces;

import com.hulkhiretech.payments.DTO.PaymentRequest;

public interface BusinessValidator {

    public void validate(PaymentRequest req);
}
