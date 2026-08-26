package com.hulkhiretech.payments.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    String endUserId;
    String firstName;
    String lastName;
    String email;
    String phone;
    String country;
    String locale;

}
