package com.hulkhiretech.payments.Pojo;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponce {

    private String errorCode;
    private String errorMessage;

}
