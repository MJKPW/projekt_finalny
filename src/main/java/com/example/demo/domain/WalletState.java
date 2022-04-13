package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name="WALLET_STATE")
public class WalletState implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
    @Column(name="PLN")
    private BigDecimal pln;
    @Column(name="USD")
    private BigDecimal usd;
    @Column(name="EUR")
    private BigDecimal eur;
    @Column(name="GBP")
    private BigDecimal gbp;
    @Column(name="CHF")
    private BigDecimal chf;
    @Column(name="JPY")
    private BigDecimal jpy;
    @Column(name="XAU")
    private BigDecimal xau;
    @Column(name="XAG")
    private BigDecimal xag;
    @Column(name="PLN_TO_USD_RATE")
    private Double plnToUsd;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TRANSACTION_ID")
    private TransactionLogger transactionLogger;

    public WalletState clone() throws CloneNotSupportedException {
        WalletState walletState = (WalletState) super.clone();
        walletState.setTransactionLogger(new TransactionLogger());
        return walletState;
    }
}
