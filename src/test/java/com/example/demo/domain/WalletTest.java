package com.example.demo.domain;

import com.example.demo.repository.WalletRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
class WalletTest {

    @Autowired
    private WalletRepository walletRepository;

    @Test
    public void test() {
        //Given
        WalletState walletState = WalletState.builder()
                                             .pln(new BigDecimal(100))
                                             .eur(new BigDecimal(100))
                                             .usd(new BigDecimal(100))
                                             .xag(new BigDecimal("0.5"))
                                             .xau(new BigDecimal("0.5"))
                                             .build();
        TransactionLogger logger = TransactionLogger.builder()
                                                    .dPln(new BigDecimal(100))
                                                    .dEur(new BigDecimal(100))
                                                    .dUsd(new BigDecimal(100))
                                                    .dXag(new BigDecimal("0.5"))
                                                    .dXau(new BigDecimal("0.5"))
                                                    .date(LocalDate.now())
                                                    .time(LocalTime.now())
                                                    .build();
        walletState.setTransactionLogger(logger);
        //When
        walletRepository.save(walletState);
        //Then
        Assertions.assertNotEquals(0, walletRepository.findAll().size());
        //CleanUp
        walletRepository.deleteById(walletState.getId());
    }

}