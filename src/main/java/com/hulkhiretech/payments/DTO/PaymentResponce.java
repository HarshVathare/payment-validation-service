package com.hulkhiretech.payments.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponce {

    private String txnRefference;

    private String HostedPageUrl;

}
