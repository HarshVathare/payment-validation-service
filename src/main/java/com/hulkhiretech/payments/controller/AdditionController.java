package com.hulkhiretech.payments.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

    private Logger logger = LoggerFactory.getLogger(AdditionController.class);

    @GetMapping("/add")
    public String add(@RequestParam int val1, @RequestParam int val2) {
        logger.info("val1:{}| val2:{}", val1, val2);

        int sumResult = val1 + val2;
        logger.info("sumResult:{}", sumResult);

        return "Addition is : " + sumResult;
    }

    //i want to add a new endpoint that will take two numbers and return their multiplication result
    @GetMapping("/multiply")
    public String multiply(@RequestParam int val1, @RequestParam int val2) {
        logger.info("val1:{}| val2:{}", val1, val2);
        int multiplyResult = val1 * val2;
        logger.info("multiplyResult:{}", multiplyResult);
        return "Multiplication is : " + multiplyResult;
    }

    //i want to add a new endpoint that will take two numbers and return their division result
    @GetMapping("/divide")
    public String divide(@RequestParam int val1, @RequestParam int val2) {
        logger.info("val1:{}| val2:{}", val1, val2);
        if (val2 == 0) {
            logger.error("Division by zero error");
            return "Error: Division by zero is not allowed.";
        }
        int divideResult = val1 / val2;
        logger.info("divideResult:{}", divideResult);
        return "Division is : " + divideResult;
    }

    //i want to add a new endpoint that will take two numbers and return their subtraction result
    @GetMapping("/subtract")
    public String subtract(@RequestParam int val1, @RequestParam int val2) {
        logger.info("val1:{}| val2:{}", val1, val2);
        int subtractResult = val1 - val2;
        logger.info("subtractResult:{}", subtractResult);
        return "Subtraction is : " + subtractResult;
    }

}
