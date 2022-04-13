package com.example.demo.scheduler;

import com.example.demo.domain.WalletState;
import com.example.demo.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;


@Component
@RequiredArgsConstructor
public class TransactionScheduler {

    private final DbService service;

    @Scheduled(cron = "0 0 10 * * *")
    public void activate() throws CloneNotSupportedException {
        double rate = service.updatePlnToUsd().getPlnToUsd();
        List<WalletState> states = service.getWalletStatusHistory();
        if(rate > 3.7 && states.size() > 0) {
            BigDecimal usd = states.get(states.size()-1).getUsd();
            service.sellUSD(usd.divideToIntegralValue(new BigDecimal(2)));
        }
        if(states.size() > 0) {
            BigDecimal pln = states.get(states.size()-1).getPln();
            BigDecimal maxUsd = pln.multiply(new BigDecimal(rate));
            service.buyUSD(maxUsd.divideToIntegralValue(new BigDecimal(2)));
        }
    }
}
