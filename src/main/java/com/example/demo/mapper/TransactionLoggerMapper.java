package com.example.demo.mapper;

import com.example.demo.domain.TransactionLogger;
import com.example.demo.domain.TransactionLoggerDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionLoggerMapper {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("ss:mm:HH");

    public String parseTimeToString(LocalTime time) {
        int seconds = time.getSecond();
        String timeString = (seconds<10)? "0" + seconds: Integer.toString(seconds);
        timeString += ":";
        int minutes = time.getMinute();
        timeString += (minutes<10)? "0" + minutes: Integer.toString(minutes);
        timeString += ":";
        int hours = time.getHour();
        timeString += (hours<10)? "0" + hours: Integer.toString(hours);
        return timeString;
    }

    public String parseDateToString(LocalDate date) {
        int day = date.getDayOfMonth();
        String dateString = (day<10)? "0" + day: Integer.toString(day);
        dateString += "/";
        int month = date.getMonthValue();
        dateString += (month<10)? "0" + month: Integer.toString(month);
        dateString += "/";
        int year = date.getYear();
        dateString += year;
        return dateString;
    }

    public TransactionLoggerDto mapToTransactionLoggerDto(TransactionLogger transactionLogger) {
        return TransactionLoggerDto.builder()
                                   .id(transactionLogger.getId())
                                   .chf(transactionLogger.getDChf())
                                   .eur(transactionLogger.getDEur())
                                   .gbp(transactionLogger.getDGbp())
                                   .jpy(transactionLogger.getDJpy())
                                   .pln(transactionLogger.getDPln())
                                   .usd(transactionLogger.getDUsd())
                                   .xag(transactionLogger.getDXag())
                                   .xau(transactionLogger.getDXau())
                                   .time(parseTimeToString(transactionLogger.getTime()))
                                   .date(parseDateToString(transactionLogger.getDate()))
                                   .build();
    }

    public TransactionLogger mapToTransactionLogger(TransactionLoggerDto transactionLoggerDto) {
        return TransactionLogger.builder()
                                .id(transactionLoggerDto.getId())
                                .dChf(transactionLoggerDto.getChf())
                                .dEur(transactionLoggerDto.getEur())
                                .dGbp(transactionLoggerDto.getGbp())
                                .dJpy(transactionLoggerDto.getJpy())
                                .dPln(transactionLoggerDto.getPln())
                                .dUsd(transactionLoggerDto.getUsd())
                                .dXag(transactionLoggerDto.getXag())
                                .dXau(transactionLoggerDto.getXau())
                                .time(LocalTime.parse(transactionLoggerDto.getTime(), timeFormatter))
                                .date(LocalDate.parse(transactionLoggerDto.getDate(), dateFormatter))
                                .build();
    }

    public List<TransactionLoggerDto> mapToTransactionDtoList(List<TransactionLogger> transactionLoggerList) {
        return transactionLoggerList.stream()
                                    .map(this::mapToTransactionLoggerDto)
                                    .collect(Collectors.toList());
    }
}
