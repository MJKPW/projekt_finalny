package com.example.demo.client;

import com.example.demo.domain.NBPExchangeDto;
import com.example.demo.domain.NBPGoldDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class NBPClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(NBPClient.class);
    private final RestTemplate restTemplate;
    private final static String PATH = "https://api.nbp.pl/api/exchangerates/rates/c";
    private final static String PATH_GOLD = "https://api.nbp.pl/api/cenyzlota";

    public String parseDateToString(LocalDate date) {
        int year = date.getYear();
        String dateString = Integer.toString(year);
        dateString += "-";
        int month = date.getMonthValue();
        dateString += (month<10)? "0" + month: Integer.toString(month);
        dateString += "-";
        int day = date.getDayOfMonth();
        dateString += (day<10)? "0" + day: Integer.toString(day);
        return dateString;
    }

    public NBPExchangeDto getExchange(String code) {
        String date = parseDateToString(LocalDate.now());
        String url = PATH + "/"+code+"/" + date + "?format=json";
        try {
            return restTemplate.getForObject(url, NBPExchangeDto.class);
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }

    public NBPGoldDto[] getGoldExchange() {
        String date = parseDateToString(LocalDate.now());
        String url = PATH_GOLD + "/" + date + "?format=json";
        try {
            return restTemplate.getForObject(url, NBPGoldDto[].class);
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }

}
