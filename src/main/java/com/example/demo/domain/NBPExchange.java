package com.example.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class NBPExchange {
    private String code;
    List<NBPRates> rates;
}
