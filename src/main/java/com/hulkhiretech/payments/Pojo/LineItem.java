package com.hulkhiretech.payments.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItem {

    Integer quantity;
    String currency;
    String productName;
    Integer unitAmount;

}
