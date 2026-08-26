package com.hulkhiretech.payments.Controller;

import com.hulkhiretech.payments.Constant.APIEndponits;
import com.hulkhiretech.payments.DTO.PaymentRequest;
import com.hulkhiretech.payments.DTO.PaymentResponce;
import com.hulkhiretech.payments.Service.Interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(APIEndponits.PAYMENT_VALIDATION)
@Slf4j
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponce> createPayment(@RequestBody PaymentRequest paymentRequest) {

        log.info("Payment request received {}",paymentRequest);

        //call to the service layer to validate and create payment
        String txnReference = paymentService.validateAndCreatePayment(paymentRequest);

        PaymentResponce paymentResponce = new PaymentResponce
                (txnReference, "https://example.com/payment-page");

        ResponseEntity<PaymentResponce> responseEntity = new ResponseEntity<>(paymentResponce, HttpStatus.OK);
        log.info("Payment response sent {}",responseEntity);
        return responseEntity;

    }

}
