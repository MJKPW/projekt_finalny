package com.example.demo.service;

import com.example.demo.domain.NBPExchangeDto;
import com.example.demo.client.NBPClient;
import com.example.demo.domain.NBPGoldDto;
import org.springframework.stereotype.Service;

@Service
public class NBPService {

    private final NBPClient nbpClient;

    public NBPService(NBPClient nbpClient) {
        this.nbpClient = nbpClient;
    }

    public NBPExchangeDto currentExchange(String code) {
        return nbpClient.getExchange(code);
    }

    public NBPGoldDto[] currentGoldExchange() {
        return nbpClient.getGoldExchange();
    }

    public double getAsk(String code) {
        return nbpClient.getExchange(code).getRates().get(0).getAsk();
    }

    public double getBid(String code) {
        return nbpClient.getExchange(code).getRates().get(0).getBid();
    }

}
