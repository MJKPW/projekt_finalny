package com.example.demo.client;

import com.example.demo.domain.MetalExchangeDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Component
@RequiredArgsConstructor
public class MetalClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(NBPClient.class);
    private final RestTemplate restTemplate;
    private final static String PATH = "https://metals-api.com/api/latest?" +
            "access_key=e946cgb4df4lpnkctmlbjmf11a2jt7f1ov0m6xo17ogpopxvc6krb28cky24" +
            "&base=USD" +
            "&symbols=XAU%2CXAG%2CXPD%2CXPT%2CXRH";

    public MetalExchangeDto getExchange() {
        try {
            return restTemplate.getForObject(PATH, MetalExchangeDto.class);
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException();
        }
    }

}
