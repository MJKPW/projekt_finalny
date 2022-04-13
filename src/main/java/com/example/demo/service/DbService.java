package com.example.demo.service;

import com.example.demo.controller.IncorrectInputException;
import com.example.demo.controller.InsufficientFundsException;
import com.example.demo.controller.TransactionLogNotFoundException;
import com.example.demo.controller.WalletStateNotFoundException;
import com.example.demo.domain.TransactionLogger;
import com.example.demo.domain.WalletState;
import com.example.demo.repository.TransactionLoggerRepository;
import com.example.demo.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DbService {

    private final WalletRepository walletRepository;
    private final TransactionLoggerRepository transactionLoggerRepository;
    private final NBPService nbpService;

    public DbService(WalletRepository walletRepository,
                     TransactionLoggerRepository transactionLoggerRepository,
                     NBPService nbpService) {
        this.walletRepository = walletRepository;
        this.transactionLoggerRepository = transactionLoggerRepository;
        this.nbpService = nbpService;
    }

    public WalletState getWalletStatus(Long id) {
        return walletRepository.findById(id).orElseThrow(WalletStateNotFoundException::new);
    }

    public List<WalletState> getWalletStatusHistory() {
        return walletRepository.findAll();
    }

    public TransactionLogger getTransactionLogger(Long id) {
        return transactionLoggerRepository.findById(id).orElseThrow(TransactionLogNotFoundException::new);
    }

    public List<TransactionLogger> getTransactionHistory() {
        return transactionLoggerRepository.findAll();
    }

    public void cancelTransaction() {
        List<WalletState> states = getWalletStatusHistory();
        if(states.size() == 0) return;
        Long id = states.get(states.size()-1).getId();
        walletRepository.deleteById(id);
    }

    private WalletState initialize() {
        WalletState state = WalletState.builder()
                                       .chf(new BigDecimal(0))
                                       .eur(new BigDecimal(0))
                                       .gbp(new BigDecimal(0))
                                       .jpy(new BigDecimal(0))
                                       .pln(new BigDecimal(0))
                                       .usd(new BigDecimal(0))
                                       .xag(new BigDecimal(0))
                                       .xau(new BigDecimal(0))
                                       .plnToUsd(nbpService.getAsk("usd"))
                                       .build();
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                               .time(LocalTime.now())
                                                               .date(LocalDate.now())
                                                               .build();
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState changePLN(BigDecimal input) throws CloneNotSupportedException {
        List<WalletState> states = getWalletStatusHistory();
        if(states.size() == 0) return initialize();
        WalletState state = states.get(states.size()-1).clone();
        BigDecimal pln = state.getPln().add(input);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                               .id(state.getId()+2)
                                                               .time(LocalTime.now())
                                                               .date(LocalDate.now())
                                                               .dPln(pln.subtract(state.getPln()))
                                                               .build();
        state.setPln(pln);
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState changeUSD(BigDecimal input) throws CloneNotSupportedException {
        List<WalletState> states = getWalletStatusHistory();
        if(states.size() == 0) return initialize();
        WalletState state = states.get(states.size()-1).clone();
        BigDecimal usd = state.getUsd().add(input);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                               .id(state.getId()+2)
                                                               .time(LocalTime.now())
                                                               .date(LocalDate.now())
                                                               .dUsd(usd.subtract(state.getUsd()))
                                                               .build();
        state.setUsd(usd);
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState changeEUR(BigDecimal input) throws CloneNotSupportedException {
        List<WalletState> states = getWalletStatusHistory();
        if(states.size() == 0) return initialize();
        WalletState state = states.get(states.size()-1).clone();
        BigDecimal eur = state.getEur().add(input);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                               .id(state.getId()+2)
                                                               .time(LocalTime.now())
                                                               .date(LocalDate.now())
                                                               .dEur(eur.subtract(state.getEur()))
                                                               .build();
        state.setEur(eur);
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState changeGBP(BigDecimal input) throws CloneNotSupportedException {
        List<WalletState> states = getWalletStatusHistory();
        if(states.size() == 0) return initialize();
        WalletState state = states.get(states.size()-1).clone();
        BigDecimal gbp = state.getGbp().add(input);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                               .id(state.getId()+2)
                                                               .time(LocalTime.now())
                                                               .date(LocalDate.now())
                                                               .dGbp(gbp.subtract(state.getGbp()))
                                                               .build();
        state.setGbp(gbp);
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState changeCHF(BigDecimal input) throws CloneNotSupportedException {
        List<WalletState> states = getWalletStatusHistory();
        if(states.size() == 0) return initialize();
        WalletState state = states.get(states.size()-1).clone();
        BigDecimal chf = state.getChf().add(input);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                               .id(state.getId()+2)
                                                               .time(LocalTime.now())
                                                               .date(LocalDate.now())
                                                               .dChf(chf.subtract(state.getChf()))
                                                               .build();
        state.setChf(chf);
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState changeJPY(BigDecimal input) throws CloneNotSupportedException {
        List<WalletState> states = getWalletStatusHistory();
        if(states.size() == 0) return initialize();
        WalletState state = states.get(states.size()-1).clone();
        BigDecimal jpy = state.getJpy().add(input);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                               .id(state.getId()+2)
                                                               .time(LocalTime.now())
                                                               .date(LocalDate.now())
                                                               .dJpy(jpy.subtract(state.getJpy()))
                                                               .build();
        state.setJpy(jpy);
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState changeXAU(BigDecimal input) throws CloneNotSupportedException {
        List<WalletState> states = getWalletStatusHistory();
        if(states.size() == 0) return initialize();
        WalletState state = states.get(states.size()-1).clone();
        BigDecimal xau = state.getXau().add(input);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                               .id(state.getId()+2)
                                                               .time(LocalTime.now())
                                                               .date(LocalDate.now())
                                                               .dXau(xau.subtract(state.getXau()))
                                                               .build();
        state.setXau(xau);
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState changeXAG(BigDecimal input) throws CloneNotSupportedException {
        List<WalletState> states = getWalletStatusHistory();
        if(states.size() == 0) return initialize();
        WalletState state = states.get(states.size()-1).clone();
        BigDecimal xag = state.getXag().add(input);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                               .id(state.getId()+2)
                                                               .time(LocalTime.now())
                                                               .date(LocalDate.now())
                                                               .dXag(xag.subtract(state.getXag()))
                                                               .build();
        state.setXag(xag);
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState updatePlnToUsd() throws CloneNotSupportedException {
        List<WalletState> states = getWalletStatusHistory();
        if(states.size() == 0) return initialize();
        WalletState state = states.get(states.size()-1).clone();
        state.setPlnToUsd(nbpService.getAsk("usd"));
        return walletRepository.save(state);
    }

    private WalletState transactionValidation(BigDecimal input) throws CloneNotSupportedException {
        if(input.doubleValue() < 0) throw new IncorrectInputException();
        List<WalletState> states = getWalletStatusHistory();
        if(states.size() == 0) return initialize();
        return states.get(states.size()-1).clone();
    }

    public WalletState buyUSD(BigDecimal input) throws CloneNotSupportedException {
        WalletState state = transactionValidation(input);
        BigDecimal pln = state.getPln();
        double rate = nbpService.getAsk("usd");
        BigDecimal plnCost = input.multiply(new BigDecimal(rate));
        if(pln.doubleValue() < plnCost.doubleValue()) throw new InsufficientFundsException();
        pln = pln.subtract(plnCost);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                            .id(state.getId()+2)
                                                            .time(LocalTime.now())
                                                            .date(LocalDate.now())
                                                            .dUsd(input)
                                                            .dPln(plnCost.multiply(new BigDecimal(-1)))
                                                            .build();
        state.setPln(pln);
        state.setUsd(state.getUsd().add(input));
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState sellUSD(BigDecimal input) throws CloneNotSupportedException {
        WalletState state = transactionValidation(input);
        BigDecimal pln = state.getPln();
        double rate = nbpService.getBid("usd");
        BigDecimal plnGain = input.multiply(new BigDecimal(rate));
        if(state.getUsd().doubleValue() < input.doubleValue()) throw new InsufficientFundsException();
        pln = pln.add(plnGain);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                                .id(state.getId()+2)
                                                                .time(LocalTime.now())
                                                                .date(LocalDate.now())
                                                                .dUsd(input.multiply(new BigDecimal(-1)))
                                                                .dPln(plnGain)
                                                                .build();
        state.setPln(pln);
        state.setUsd(state.getUsd().subtract(input));
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState buyEUR(BigDecimal input) throws CloneNotSupportedException {
        WalletState state = transactionValidation(input);
        BigDecimal pln = state.getPln();
        double rate = nbpService.getAsk("eur");
        BigDecimal plnCost = input.multiply(new BigDecimal(rate));
        if(pln.doubleValue() < plnCost.doubleValue()) throw new InsufficientFundsException();
        pln = pln.subtract(plnCost);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                            .id(state.getId()+2)
                                                            .time(LocalTime.now())
                                                            .date(LocalDate.now())
                                                            .dEur(input)
                                                            .dPln(plnCost.multiply(new BigDecimal(-1)))
                                                            .build();
        state.setPln(pln);
        state.setEur(state.getEur().add(input));
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState sellEUR(BigDecimal input) throws CloneNotSupportedException {
        WalletState state = transactionValidation(input);
        BigDecimal pln = state.getPln();
        double rate = nbpService.getBid("eur");
        BigDecimal plnGain = input.multiply(new BigDecimal(rate));
        if(state.getEur().doubleValue() < input.doubleValue()) throw new InsufficientFundsException();
        pln = pln.add(plnGain);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                .id(state.getId()+2)
                .time(LocalTime.now())
                .date(LocalDate.now())
                .dEur(input.multiply(new BigDecimal(-1)))
                .dPln(plnGain)
                .build();
        state.setPln(pln);
        state.setEur(state.getEur().subtract(input));
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState buyGBP(BigDecimal input) throws CloneNotSupportedException {
        WalletState state = transactionValidation(input);
        BigDecimal pln = state.getPln();
        double rate = nbpService.getAsk("gbp");
        BigDecimal plnCost = input.multiply(new BigDecimal(rate));
        if(pln.doubleValue() < plnCost.doubleValue()) throw new InsufficientFundsException();
        pln = pln.subtract(plnCost);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                            .id(state.getId()+2)
                                                            .time(LocalTime.now())
                                                            .date(LocalDate.now())
                                                            .dGbp(input)
                                                            .dPln(plnCost.multiply(new BigDecimal(-1)))
                                                            .build();
        state.setPln(pln);
        state.setGbp(state.getGbp().add(input));
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState sellGBP(BigDecimal input) throws CloneNotSupportedException {
        WalletState state = transactionValidation(input);
        BigDecimal pln = state.getPln();
        double rate = nbpService.getBid("gbp");
        BigDecimal plnGain = input.multiply(new BigDecimal(rate));
        if(state.getGbp().doubleValue() < input.doubleValue()) throw new InsufficientFundsException();
        pln = pln.add(plnGain);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                            .id(state.getId()+2)
                                                            .time(LocalTime.now())
                                                            .date(LocalDate.now())
                                                            .dGbp(input.multiply(new BigDecimal(-1)))
                                                            .dPln(plnGain)
                                                            .build();
        state.setPln(pln);
        state.setGbp(state.getGbp().subtract(input));
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState buyJPY(BigDecimal input) throws CloneNotSupportedException {
        WalletState state = transactionValidation(input);
        BigDecimal pln = state.getPln();
        double rate = nbpService.getAsk("jpy");
        BigDecimal plnCost = input.multiply(new BigDecimal(rate));
        if(pln.doubleValue() < plnCost.doubleValue()) throw new InsufficientFundsException();
        pln = pln.subtract(plnCost);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                            .id(state.getId()+2)
                                            .time(LocalTime.now())
                                            .date(LocalDate.now())
                                            .dJpy(input)
                                            .dPln(plnCost.multiply(new BigDecimal(-1)))
                                            .build();
        state.setPln(pln);
        state.setJpy(state.getJpy().add(input));
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState sellJPY(BigDecimal input) throws CloneNotSupportedException {
        WalletState state = transactionValidation(input);
        BigDecimal pln = state.getPln();
        double rate = nbpService.getBid("jpy");
        BigDecimal plnGain = input.multiply(new BigDecimal(rate));
        if(state.getJpy().doubleValue() < input.doubleValue()) throw new InsufficientFundsException();
        pln = pln.add(plnGain);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                .id(state.getId()+2)
                                                .time(LocalTime.now())
                                                .date(LocalDate.now())
                                                .dJpy(input.multiply(new BigDecimal(-1)))
                                                .dPln(plnGain)
                                                .build();
        state.setPln(pln);
        state.setJpy(state.getJpy().subtract(input));
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState buyCHF(BigDecimal input) throws CloneNotSupportedException {
        WalletState state = transactionValidation(input);
        BigDecimal pln = state.getPln();
        double rate = nbpService.getAsk("chf");
        BigDecimal plnCost = input.multiply(new BigDecimal(rate));
        if(pln.doubleValue() < plnCost.doubleValue()) throw new InsufficientFundsException();
        pln = pln.subtract(plnCost);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                    .id(state.getId()+2)
                                                    .time(LocalTime.now())
                                                    .date(LocalDate.now())
                                                    .dChf(input)
                                                    .dPln(plnCost.multiply(new BigDecimal(-1)))
                                                    .build();
        state.setPln(pln);
        state.setChf(state.getChf().add(input));
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState sellCHF(BigDecimal input) throws CloneNotSupportedException {
        WalletState state = transactionValidation(input);
        BigDecimal pln = state.getPln();
        double rate = nbpService.getBid("chf");
        BigDecimal plnGain = input.multiply(new BigDecimal(rate));
        if(state.getChf().doubleValue() < input.doubleValue()) throw new InsufficientFundsException();
        pln = pln.add(plnGain);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                    .id(state.getId()+2)
                                                    .time(LocalTime.now())
                                                    .date(LocalDate.now())
                                                    .dChf(input.multiply(new BigDecimal(-1)))
                                                    .dPln(plnGain)
                                                    .build();
        state.setPln(pln);
        state.setChf(state.getChf().subtract(input));
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState buyXAU(BigDecimal input) throws CloneNotSupportedException {
        WalletState state = transactionValidation(input);
        BigDecimal pln = state.getPln();
        double rate = nbpService.currentGoldExchange()[0].getCena();
        BigDecimal plnCost = input.multiply(new BigDecimal(rate));
        if(pln.doubleValue() < plnCost.doubleValue()) throw new InsufficientFundsException();
        pln = pln.subtract(plnCost);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                            .id(state.getId()+2)
                                                            .time(LocalTime.now())
                                                            .date(LocalDate.now())
                                                            .dXau(input)
                                                            .dPln(plnCost.multiply(new BigDecimal(-1)))
                                                            .build();
        state.setPln(pln);
        state.setXau(state.getXau().add(input));
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

    public WalletState sellXAU(BigDecimal input) throws CloneNotSupportedException {
        WalletState state = transactionValidation(input);
        BigDecimal pln = state.getPln();
        double rate = nbpService.currentGoldExchange()[0].getCena();
        BigDecimal plnGain = input.multiply(new BigDecimal(rate));
        if(state.getXau().doubleValue() < input.doubleValue()) throw new InsufficientFundsException();
        pln = pln.add(plnGain);
        TransactionLogger transactionLogger = TransactionLogger.builder()
                                                            .id(state.getId()+2)
                                                            .time(LocalTime.now())
                                                            .date(LocalDate.now())
                                                            .dXau(input.multiply(new BigDecimal(-1)))
                                                            .dPln(plnGain)
                                                            .build();
        state.setPln(pln);
        state.setXau(state.getXau().subtract(input));
        state.setId(transactionLogger.getId()-1);
        state.setTransactionLogger(transactionLogger);
        return walletRepository.save(state);
    }

}
