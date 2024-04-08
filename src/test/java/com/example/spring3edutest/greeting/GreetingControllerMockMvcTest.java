package com.example.spring3edutest.greeting;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {GreetingController.class})
@DisplayName("Greeting MockTest")
@Slf4j
class GreetingControllerMockMvcTest {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    void greetingTest1() throws Exception {
        log.debug("test1");
        mockMvc.perform(get("/greeting"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", isA(Number.class)))
                .andExpect(jsonPath("content").value("Hello, World!"))

        ;
    }

    @Test
    void greetingTest2() throws Exception {
        log.debug("test2");
        mockMvc.perform(get("/greeting?name=test2"))
                .andDo(print())
                .andExpect(jsonPath("id", isA(Number.class)))
                .andExpect(jsonPath("content").value("Hello, test2!"))
        ;
    }
}