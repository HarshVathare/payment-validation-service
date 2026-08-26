package com.hulkhiretech.payments.Controller;

import com.hulkhiretech.payments.Constant.APIEndponits;
import com.hulkhiretech.payments.DTO.PaymentRequest;
import com.hulkhiretech.payments.DTO.PaymentResponce;
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
public class PaymentController {

    @PostMapping
    public ResponseEntity<PaymentResponce> createPayment(@RequestBody PaymentRequest paymentRequest) {

        log.info("Payment request received {}",paymentRequest);


        PaymentResponce paymentResponce = new PaymentResponce();
        paymentResponce.setTxnRefference("TXN_123456789");
        paymentResponce.setHostedPageUrl("https://example.com/payment-page");

        //create a response entity with the payment response and return it with a CREATED status
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentResponce);


    }

}
