package com.hulkhiretech.payments.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdditionController.class)
class AdditionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // =========================
    // ADDITION TEST CASES
    // =========================

    @Test
    void add_shouldReturnAdditionResult() throws Exception {

        mockMvc.perform(
                        get("/add")
                                .param("val1", "10")
                                .param("val2", "20")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Addition is : 30"));
    }

    @Test
    void add_shouldHandleZeroValues() throws Exception {

        mockMvc.perform(
                        get("/add")
                                .param("val1", "0")
                                .param("val2", "0")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Addition is : 0"));
    }

    @Test
    void add_shouldHandleNegativeValues() throws Exception {

        mockMvc.perform(
                        get("/add")
                                .param("val1", "-10")
                                .param("val2", "-20")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Addition is : -30"));
    }


    // =========================
    // MULTIPLICATION TEST CASES
    // =========================

    @Test
    void multiply_shouldReturnMultiplicationResult() throws Exception {

        mockMvc.perform(
                        get("/multiply")
                                .param("val1", "10")
                                .param("val2", "5")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Multiplication is : 50"));
    }

    @Test
    void multiply_shouldHandleZero() throws Exception {

        mockMvc.perform(
                        get("/multiply")
                                .param("val1", "10")
                                .param("val2", "0")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Multiplication is : 0"));
    }

    @Test
    void multiply_shouldHandleNegativeValues() throws Exception {

        mockMvc.perform(
                        get("/multiply")
                                .param("val1", "-10")
                                .param("val2", "5")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Multiplication is : -50"));
    }


    // =========================
    // DIVISION TEST CASES
    // =========================

    @Test
    void divide_shouldReturnDivisionResult() throws Exception {

        mockMvc.perform(
                        get("/divide")
                                .param("val1", "20")
                                .param("val2", "5")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Division is : 4"));
    }

    @Test
    void divide_shouldReturnErrorWhenDividingByZero() throws Exception {

        mockMvc.perform(
                        get("/divide")
                                .param("val1", "20")
                                .param("val2", "0")
                )
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "Error: Division by zero is not allowed."
                ));
    }

    @Test
    void divide_shouldHandleNegativeValues() throws Exception {

        mockMvc.perform(
                        get("/divide")
                                .param("val1", "-20")
                                .param("val2", "5")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Division is : -4"));
    }


    // =========================
    // SUBTRACTION TEST CASES
    // =========================

    @Test
    void subtract_shouldReturnSubtractionResult() throws Exception {

        mockMvc.perform(
                        get("/subtract")
                                .param("val1", "20")
                                .param("val2", "5")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Subtraction is : 15"));
    }

    @Test
    void subtract_shouldHandleNegativeResult() throws Exception {

        mockMvc.perform(
                        get("/subtract")
                                .param("val1", "5")
                                .param("val2", "20")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Subtraction is : -15"));
    }

    @Test
    void subtract_shouldHandleZero() throws Exception {

        mockMvc.perform(
                        get("/subtract")
                                .param("val1", "0")
                                .param("val2", "0")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Subtraction is : 0"));
    }
}