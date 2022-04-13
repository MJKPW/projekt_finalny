package com.example.demo.mapper;

import com.example.demo.domain.TransactionLogger;
import com.example.demo.domain.TransactionLoggerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionLoggerMapperTest {

    @Autowired
    private TransactionLoggerMapper mapper;


    @Test
    public void parseDateToStringTest() {
        //Given
        //When
        LocalDate date = LocalDate.of(1990, 5, 15);
        //Then
        assertEquals("15/05/1990", mapper.parseDateToString(date));
    }

    @Test
    public void parseTimeToStringTest() {
        //Given
        //When
        LocalTime time = LocalTime.of(14, 5, 15);
        //Then
        assertEquals("15:05:14", mapper.parseTimeToString(time));
    }

    @Test
    public void mapToTransactionLoggerDtoTest() {
        //Given
        //When
        TransactionLogger logger = TransactionLogger.builder()
                                                    .time(LocalTime.now())
                                                    .date(LocalDate.now())
                                                    .build();
        TransactionLoggerDto loggerDto = mapper.mapToTransactionLoggerDto(logger);
        //Then
        assertEquals(loggerDto.getDate(), mapper.parseDateToString(logger.getDate()));
    }

    @Test
    public void mapToTransactionLoggerTest() {
        //Given
        //When
        TransactionLoggerDto loggerDto = TransactionLoggerDto.builder()
                .time(mapper.parseTimeToString(LocalTime.now()))
                .date(mapper.parseDateToString(LocalDate.now()))
                .build();
        TransactionLogger logger = mapper.mapToTransactionLogger(loggerDto);
        //Then
        assertEquals(loggerDto.getDate(), mapper.parseDateToString(logger.getDate()));
    }

    @Test
    public void mapToTransactionDtoListTest() {
        //Given
        //When
        List<TransactionLogger> loggerList = new ArrayList<>();
        TransactionLogger logger = TransactionLogger.builder()
                                        .time(LocalTime.now())
                                        .date(LocalDate.now())
                                        .build();
        loggerList.add(logger);
        List<TransactionLoggerDto> loggerDtos = mapper.mapToTransactionDtoList(loggerList);
        //Then
        assertEquals(1, loggerDtos.size());
    }


}