package com.example.spring3edutest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class Spring3EduTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test()
    void FailTest() {

        //given
        fail("실패");
    }

}
