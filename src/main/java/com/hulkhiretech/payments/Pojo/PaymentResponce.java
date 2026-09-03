package com.hulkhiretech.payments.Pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponce {

    private String txnRefference;

    private String HostedPaymentPageUrl;

}
