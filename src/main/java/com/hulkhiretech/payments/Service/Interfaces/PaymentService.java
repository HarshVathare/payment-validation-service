package com.hulkhiretech.payments.Service.Interfaces;

import com.hulkhiretech.payments.DTO.PaymentRequest;

public interface PaymentService {

    String validateAndCreatePayment(PaymentRequest req);
}
