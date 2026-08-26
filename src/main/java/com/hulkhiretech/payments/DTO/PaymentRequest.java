package com.hulkhiretech.payments.DTO;

import com.hulkhiretech.payments.Pojo.Payment;
import com.hulkhiretech.payments.Pojo.User;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private User user;

    private Payment payment;

}
