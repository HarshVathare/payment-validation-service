package com.hulkhiretech.payments.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    Integer totalAmount;
    String currency;

    String paymentType = "SALE";
    String paymentMethod = "APM" ;
    String provider = "STRIPE";

    String merchantTxnRef;

    String cancelUrl;
    String successUrl;

    String brandName;

    List<LineItem> lineItems;

}
