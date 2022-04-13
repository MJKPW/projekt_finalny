package com.example.demo.service;

import com.example.demo.domain.MetalExchangeDto;
import com.example.demo.client.MetalClient;
import org.springframework.stereotype.Service;

@Service
public class MetalService {

    private final MetalClient metalClient;

    public MetalService(MetalClient metalClient) {
        this.metalClient = metalClient;
    }

    public MetalExchangeDto currentExchange() {
        return metalClient.getExchange();
    }

}
