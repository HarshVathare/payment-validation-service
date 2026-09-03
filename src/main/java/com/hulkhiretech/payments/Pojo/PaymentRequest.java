package com.hulkhiretech.payments.Pojo;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private User user;

    private Payment payment;

}
