package com.example.demo.domain;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TransactionLoggerDto {
    private Long id;
    private String time;
    private String date;
    private BigDecimal pln;
    private BigDecimal usd;
    private BigDecimal eur;
    private BigDecimal gbp;
    private BigDecimal chf;
    private BigDecimal jpy;
    private BigDecimal xau;
    private BigDecimal xag;
    private Long WalletStateId;
}
