package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.service.DbFacade;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/wallet")
public class WalletController {

    private final DbFacade dbFacade;

    public WalletController(DbFacade facade) {
        this.dbFacade = facade;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/state_history")
    public ResponseEntity<List<WalletStateDto>> getWalletStatusHistory() {
        return ResponseEntity.ok(dbFacade.getStateHistory());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/state/{id}")
    public ResponseEntity<WalletStateDto> getWalletStatus(@PathVariable Long id) {
        return ResponseEntity.ok(dbFacade.getWalletStatus(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transaction_history")
    public ResponseEntity<List<TransactionLoggerDto>> getTransactionHistory() {
        return ResponseEntity.ok(dbFacade.getTransactionHistory());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/transaction/{id}")
    public ResponseEntity<TransactionLoggerDto> getTransaction(@PathVariable Long id) {
        return ResponseEntity.ok(dbFacade.getTransaction(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/change_pln", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> changePLN(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.changePLN(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/change_usd", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> changeUSD(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.changeUSD(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/change_eur", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> changeEUR(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.changeEUR(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/change_gbp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> changeGBP(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.changeGBP(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/change_chf", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> changeCHF(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.changeCHF(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/change_jpy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> changeJPY(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.changeJPY(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/change_xau", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> changeXAU(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.changeXAU(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/change_xag", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> changeXAG(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.changeXAG(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update_pln_usd_exchange_rate")
    public ResponseEntity<WalletStateDto> updateExchange() throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.updatePlnToUsd());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cancel_transaction")
    public ResponseEntity<Void> cancelExchange() {
        dbFacade.cancelTransaction();
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/buy_usd", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> buyUSD(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.buyUSD(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sell_usd", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> sellUSD(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.sellUSD(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/buy_eur", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> buyEUR(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.buyEUR(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sell_eur", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> sellEUR(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.sellEUR(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/buy_gbp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> buyGBP(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.buyGBP(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sell_gbp", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> sellGBP(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.sellGBP(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/buy_jpy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> buyJPY(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.buyJPY(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sell_jpy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> sellJPY(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.sellJPY(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/buy_chf", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> buyCHF(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.buyCHF(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sell_chf", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> sellCHF(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.sellCHF(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/buy_xau", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> buyXAU(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.buyXAU(input.getValue()));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sell_xau", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WalletStateDto> sellXAU(@RequestBody InputDto input) throws CloneNotSupportedException {
        return ResponseEntity.ok(dbFacade.sellXAU(input.getValue()));
    }

}
