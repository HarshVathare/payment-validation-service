package com.hulkhiretech.payments.controller;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReqestBody {

    private String name;
    private String email;
    private int age;

}
