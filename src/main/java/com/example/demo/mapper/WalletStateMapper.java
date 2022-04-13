package com.example.demo.mapper;

import com.example.demo.controller.TransactionLogNotFoundException;
import com.example.demo.domain.WalletState;
import com.example.demo.domain.WalletStateDto;
import com.example.demo.repository.TransactionLoggerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WalletStateMapper {

    private final TransactionLoggerRepository transactionLoggerRepository;

    public WalletStateMapper(TransactionLoggerRepository transactionLoggerRepository) {
        this.transactionLoggerRepository = transactionLoggerRepository;
    }

    public WalletStateDto mapToWalletStateDto(WalletState walletState) {
        return WalletStateDto.builder()
                             .id(walletState.getId())
                             .chf(walletState.getChf())
                             .eur(walletState.getEur())
                             .gbp(walletState.getGbp())
                             .jpy(walletState.getJpy())
                             .pln(walletState.getPln())
                             .usd(walletState.getUsd())
                             .xag(walletState.getXag())
                             .xau(walletState.getXau())
                             .plnToUsd(walletState.getPlnToUsd())
                             .transactionLoggerId(walletState.getTransactionLogger().getId())
                             .build();
    }

    public WalletState mapToWalletState(WalletStateDto walletStateDto) {
        return WalletState.builder()
                          .id(walletStateDto.getId())
                          .chf(walletStateDto.getChf())
                          .eur(walletStateDto.getEur())
                          .gbp(walletStateDto.getGbp())
                          .jpy(walletStateDto.getJpy())
                          .pln(walletStateDto.getPln())
                          .usd(walletStateDto.getUsd())
                          .xag(walletStateDto.getXag())
                          .xau(walletStateDto.getXau())
                          .plnToUsd(walletStateDto.getPlnToUsd())
                          .transactionLogger(
                                  transactionLoggerRepository.findById(walletStateDto.getTransactionLoggerId())
                                                             .orElseThrow(TransactionLogNotFoundException::new)
                          ).build();
    }

    public List<WalletStateDto> mapToWalletStateDtoList(List<WalletState> walletStateList) {
        return walletStateList.stream()
                              .map(this::mapToWalletStateDto)
                              .collect(Collectors.toList());
    }
}
