package com.hulkhiretech.payments.Service.Interfaces;

import com.hulkhiretech.payments.Pojo.PaymentRequest;

public interface PaymentService {

    String validateAndCreatePayment(PaymentRequest req);
}
