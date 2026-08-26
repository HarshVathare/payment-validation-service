package com.hulkhiretech.payments.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MyController.class)
class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;


    // =========================
    // GET /hello
    // =========================

    @Test
    void hello_shouldReturnHelloWorld() throws Exception {

        mockMvc.perform(
                        get("/v1/api/hello")
                )
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }


    // =========================
    // POST endpoint
    // =========================

    @Test
    void postExample_shouldReturnReceivedValues() throws Exception {

        String requestBody = """
                {
                    "name": "Harsh",
                    "email": "harsh@example.com",
                    "age": 24
                }
                """;

        mockMvc.perform(
                        post("/v1/api/value1/value2/value3")
                                .param("p1", "param1")
                                .param("p2", "param2")
                                .param("p3", "param3")
                                .header("my-Header", "headerValue")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(
                        "Received values: value1, value2, value3, " +
                                "param1, param2, param3, headerValue, " +
                                "ReqestBody(name=Harsh, email=harsh@example.com, age=24)"
                ));
    }
}