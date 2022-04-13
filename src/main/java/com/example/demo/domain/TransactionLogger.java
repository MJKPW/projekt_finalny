package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="TRANSACTION_LOGGER")
public class TransactionLogger {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    @Column(name = "TIME")
    private LocalTime time;
    @Column(name = "DATE")
    private LocalDate date;
    @Column(name = "PLN_CHANGE")
    private BigDecimal dPln;
    @Column(name = "USD_CHANGE")
    private BigDecimal dUsd;
    @Column(name = "EUR_CHANGE")
    private BigDecimal dEur;
    @Column(name = "GBP_CHANGE")
    private BigDecimal dGbp;
    @Column(name = "CHF_CHANGE")
    private BigDecimal dChf;
    @Column(name = "JPY_CHANGE")
    private BigDecimal dJpy;
    @Column(name = "XAU_CHANGE_OUNCES")
    private BigDecimal dXau;
    @Column(name = "XAG_CHANGE_OUNCES")
    private BigDecimal dXag;
}
