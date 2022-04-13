package com.example.demo.service;

import com.example.demo.domain.*;
import com.example.demo.mapper.TransactionLoggerMapper;
import com.example.demo.mapper.WalletStateMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DbFacade {

    private final DbService dbService;
    private final WalletStateMapper walletStateMapper;
    private final TransactionLoggerMapper transactionLoggerMapper;

    public DbFacade(DbService dbService,
                    WalletStateMapper walletStateMapper,
                    TransactionLoggerMapper transactionLoggerMapper) {
        this.dbService = dbService;
        this.walletStateMapper = walletStateMapper;
        this.transactionLoggerMapper = transactionLoggerMapper;
    }

    public List<WalletStateDto> getStateHistory() {
        List<WalletState> states = dbService.getWalletStatusHistory();
        return walletStateMapper.mapToWalletStateDtoList(states);
    }

    public WalletStateDto getWalletStatus(Long id) {
        WalletState state = dbService.getWalletStatus(id);
        return walletStateMapper.mapToWalletStateDto(state);
    }

    public List<TransactionLoggerDto> getTransactionHistory() {
        List<TransactionLogger> transactions = dbService.getTransactionHistory();
        return transactionLoggerMapper.mapToTransactionDtoList(transactions);
    }

    public TransactionLoggerDto getTransaction(Long id) {
        TransactionLogger transactionLogger = dbService.getTransactionLogger(id);
        return transactionLoggerMapper.mapToTransactionLoggerDto(transactionLogger);
    }

    public WalletStateDto changePLN(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.changePLN(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto changeUSD(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.changeUSD(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto changeEUR(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.changeEUR(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto changeGBP(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.changeGBP(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto changeCHF(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.changeCHF(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto changeJPY(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.changeJPY(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto changeXAU(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.changeXAU(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto changeXAG(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.changeXAG(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto updatePlnToUsd() throws CloneNotSupportedException {
        return walletStateMapper.mapToWalletStateDto(dbService.updatePlnToUsd());
    }

    public void cancelTransaction() {
        dbService.cancelTransaction();
    }

    public WalletStateDto buyUSD(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.buyUSD(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto sellUSD(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.sellUSD(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto buyEUR(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.buyEUR(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto sellEUR(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.sellEUR(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto buyGBP(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.buyGBP(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto sellGBP(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.sellGBP(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto buyJPY(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.buyJPY(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto sellJPY(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.sellJPY(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto buyCHF(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.buyCHF(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto sellCHF(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.sellCHF(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto buyXAU(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.buyXAU(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

    public WalletStateDto sellXAU(BigDecimal input) throws CloneNotSupportedException {
        WalletState wallet = dbService.sellXAU(input);
        return walletStateMapper.mapToWalletStateDto(wallet);
    }

}
