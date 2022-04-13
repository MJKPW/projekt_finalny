package com.example.demo.domain;

import lombok.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class WalletStateDto {
    private Long id;
    private BigDecimal pln;
    private BigDecimal usd;
    private BigDecimal eur;
    private BigDecimal gbp;
    private BigDecimal chf;
    private BigDecimal jpy;
    private BigDecimal xau;
    private BigDecimal xag;
    private Double plnToUsd;
    private Long transactionLoggerId;
}
