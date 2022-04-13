package com.example.demo.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NBPClientTest {

    @Autowired
    private NBPClient client;

    @Test
    public void parseDateToStringTest() {
        //Given
        //When
        LocalDate date = LocalDate.of(1990, 5, 15);
        //Then
        assertEquals("1990-05-15", client.parseDateToString(date));
    }

    @Test
    public void getExchangeThrowTest() {
        //Given
        //When
        //Then
        assertThrows(RuntimeException.class, () -> {
            client.getExchange("random");
        });
    }

}