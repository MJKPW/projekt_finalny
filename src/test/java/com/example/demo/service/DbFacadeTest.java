package com.example.demo.service;

import com.example.demo.controller.IncorrectInputException;
import com.example.demo.controller.TransactionLogNotFoundException;
import com.example.demo.controller.WalletStateNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;


@SpringBootTest
class DbFacadeTest {

    @Autowired
    private DbFacade facade;

    @Test
    public void findWalletStatusWrongIdTest() {
        //Given
        //When
        //Then
        Assertions.assertThrows(WalletStateNotFoundException.class, () -> {
            facade.getWalletStatus(-1L);
        });
    }

    @Test
    public void findTransactionLoggerWrongIdTest() {
        //Given
        //When
        //Then
        Assertions.assertThrows(TransactionLogNotFoundException.class, () -> {
            facade.getTransaction(-1L);
        });
    }

    @Test
    public void BuyAndSellTests() throws CloneNotSupportedException {
        //Given
        //When
        //Then
        Assertions.assertThrows(IncorrectInputException.class, ()->facade.buyUSD(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->facade.buyJPY(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->facade.buyEUR(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->facade.buyGBP(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->facade.buyCHF(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->facade.buyXAU(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->facade.sellUSD(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->facade.sellEUR(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->facade.sellGBP(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->facade.sellCHF(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->facade.sellXAU(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->facade.sellJPY(new BigDecimal(-5)));
    }


}