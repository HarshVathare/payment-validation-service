package com.hulkhiretech.payments.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
@Slf4j
public class MyController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/{v1}/{v2}/{v3}")
    public String postExample(
            //pass path variables and request parameters to the method
            @PathVariable String v1,
            @PathVariable String v2,
            @PathVariable String v3,

            @RequestParam String p1,
            @RequestParam String p2,
            @RequestParam String p3,

            //pass request body to the method and Header values to the method
            @RequestHeader("my-Header") String h1,

            @RequestBody ReqestBody requestBody

    )
    {
        log.info("Received path variables: {}, {}, {}", v1, v2, v3);
        log.info("Received request parameters: {}, {}, {}", p1, p2, p3);
        log.info("Received header value: {}", h1);
        log.info("Received request body: {}", requestBody);

        return "Received values: " + v1 + ", " + v2 + ", " + v3 + "," +
                " " + p1 + ", " + p2 + ", " + p3 + "," +
                " " + h1 + ", " + requestBody;
    }

}
