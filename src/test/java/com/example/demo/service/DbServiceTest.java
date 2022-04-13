package com.example.demo.service;

import com.example.demo.controller.IncorrectInputException;
import com.example.demo.controller.InsufficientFundsException;
import com.example.demo.controller.TransactionLogNotFoundException;
import com.example.demo.controller.WalletStateNotFoundException;
import com.example.demo.domain.TransactionLogger;
import com.example.demo.domain.WalletState;
import com.example.demo.repository.WalletRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;


@SpringBootTest
class DbServiceTest {

    @Autowired
    private DbService service;
    @Autowired
    private WalletRepository walletRepository;

    @Test
    public void findWalletStatusWrongIdTest() {
        //Given
        //When
        //Then
        Assertions.assertThrows(WalletStateNotFoundException.class, () -> {
            service.getWalletStatus(-1L);
        });
    }

    @Test
    public void findTransactionLoggerWrongIdTest() {
        //Given
        //When
        //Then
        Assertions.assertThrows(TransactionLogNotFoundException.class, () -> {
            service.getTransactionLogger(-1L);
        });
    }

    @Test
    public void findAllStatesAndTransactionsTest() {
        //Given
        WalletState walletState = WalletState.builder()
                .build();
        TransactionLogger logger = TransactionLogger.builder()
                .build();
        //When
        walletState.setTransactionLogger(logger);
        walletRepository.save(walletState);
        //Then
        Assertions.assertNotEquals(0, service.getTransactionHistory().size());
        Assertions.assertNotEquals(0, service.getWalletStatusHistory().size());
        service.cancelTransaction();
        Assertions.assertThrows(WalletStateNotFoundException.class, () -> {
            service.getWalletStatus(walletState.getId());
        });
    }

    @Test
    public void changePLNTest() throws CloneNotSupportedException {
        //Given
        //When
        List<WalletState> states = service.getWalletStatusHistory();
        //Then
        if(states.size() == 0) {
            service.changePLN(new BigDecimal(100));
            Assertions.assertEquals(1, service.getWalletStatusHistory().size());
        } else {
            BigDecimal pln = states.get(states.size()-1).getPln();
            service.changePLN(new BigDecimal(100));
            Assertions.assertEquals(100, service.getWalletStatusHistory()
                      .get(states.size()).getPln().subtract(pln).intValue());
        }
        //CleanUp
        service.cancelTransaction();
    }

    @Test
    public void changeUSDTest() throws CloneNotSupportedException {
        //Given
        //When
        List<WalletState> states = service.getWalletStatusHistory();
        //Then
        if(states.size() == 0) {
            service.changeUSD(new BigDecimal(100));
            Assertions.assertEquals(1, service.getWalletStatusHistory().size());
        } else {
            BigDecimal usd = states.get(states.size()-1).getUsd();
            service.changeUSD(new BigDecimal(100));
            Assertions.assertEquals(100, service.getWalletStatusHistory()
                    .get(states.size()).getUsd().subtract(usd).intValue());
        }
        //CleanUp
        service.cancelTransaction();
    }

    @Test
    public void changeEURTest() throws CloneNotSupportedException {
        //Given
        //When
        List<WalletState> states = service.getWalletStatusHistory();
        //Then
        if(states.size() == 0) {
            service.changeEUR(new BigDecimal(100));
            Assertions.assertEquals(1, service.getWalletStatusHistory().size());
        } else {
            BigDecimal eur = states.get(states.size()-1).getEur();
            service.changeEUR(new BigDecimal(100));
            Assertions.assertEquals(100, service.getWalletStatusHistory()
                    .get(states.size()).getEur().subtract(eur).intValue());
        }
        //CleanUp
        service.cancelTransaction();
    }

    @Test
    public void changeGBPTest() throws CloneNotSupportedException {
        //Given
        //When
        List<WalletState> states = service.getWalletStatusHistory();
        service.changeGBP(new BigDecimal(5));
        //Then
        Assertions.assertEquals(states.size()+1, service.getWalletStatusHistory().size());
        //CleanUp
        service.cancelTransaction();
    }

    @Test
    public void changeCHFTest() throws CloneNotSupportedException {
        //Given
        //When
        List<WalletState> states = service.getWalletStatusHistory();
        service.changeCHF(new BigDecimal(5));
        //Then
        Assertions.assertEquals(states.size()+1, service.getWalletStatusHistory().size());
        //CleanUp
        service.cancelTransaction();
    }

    @Test
    public void changeJPYTest() throws CloneNotSupportedException {
        //Given
        //When
        List<WalletState> states = service.getWalletStatusHistory();
        service.changeJPY(new BigDecimal(5));
        //Then
        Assertions.assertEquals(states.size()+1, service.getWalletStatusHistory().size());
        //CleanUp
        service.cancelTransaction();
    }

    @Test
    public void changeXAUTest() throws CloneNotSupportedException {
        //Given
        //When
        List<WalletState> states = service.getWalletStatusHistory();
        service.changeXAU(new BigDecimal(5));
        //Then
        Assertions.assertEquals(states.size()+1, service.getWalletStatusHistory().size());
        //CleanUp
        service.cancelTransaction();
    }

    @Test
    public void changeXAGTest() throws CloneNotSupportedException {
        //Given
        //When
        List<WalletState> states = service.getWalletStatusHistory();
        service.changeXAG(new BigDecimal(5));
        //Then
        Assertions.assertEquals(states.size()+1, service.getWalletStatusHistory().size());
        //CleanUp
        service.cancelTransaction();
    }

    @Test
    public void sellTests() throws CloneNotSupportedException {
        //Given
        //When
        //Then
        Assertions.assertThrows(IncorrectInputException.class, ()->service.buyUSD(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->service.buyJPY(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->service.buyEUR(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->service.buyGBP(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->service.buyCHF(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->service.buyXAU(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->service.sellUSD(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->service.sellEUR(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->service.sellGBP(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->service.sellCHF(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->service.sellXAU(new BigDecimal(-5)));
        Assertions.assertThrows(IncorrectInputException.class, ()->service.sellJPY(new BigDecimal(-5)));
    }

    @Test
    public void buyAndSellTests() throws CloneNotSupportedException {
        //Given
        //When
        List<WalletState> states = service.getWalletStatusHistory();
        //Then
        if(states.size() != 0) {
            WalletState walletState = states.get(states.size()-1);
            Assertions.assertThrows(RuntimeException.class, ()->service.sellUSD(walletState.getUsd().add(new BigDecimal(1))));
            Assertions.assertThrows(RuntimeException.class, ()->service.sellEUR(walletState.getEur().add(new BigDecimal(1))));
            Assertions.assertThrows(RuntimeException.class, ()->service.sellGBP(walletState.getGbp().add(new BigDecimal(1))));
            Assertions.assertThrows(RuntimeException.class, ()->service.sellCHF(walletState.getChf().add(new BigDecimal(1))));
            Assertions.assertThrows(RuntimeException.class, ()->service.sellXAU(walletState.getXau().add(new BigDecimal(1))));
            Assertions.assertThrows(RuntimeException.class, ()->service.sellJPY(walletState.getJpy().add(new BigDecimal(1))));
        }
    }


}