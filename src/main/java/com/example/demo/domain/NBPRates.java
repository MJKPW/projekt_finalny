package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NBPRates {
    private String no;
    private String effectiveDate;
    private double bid;
    private double ask;
}
