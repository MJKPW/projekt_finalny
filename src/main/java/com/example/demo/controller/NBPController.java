package com.example.demo.controller;

import com.example.demo.domain.NBPExchangeDto;
import com.example.demo.domain.NBPGoldDto;
import com.example.demo.service.NBPService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/exchange")
public class NBPController {

    private final NBPService service;

    public NBPController(NBPService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/full_information/{code}")
    public ResponseEntity<NBPExchangeDto> getExchange(@PathVariable String code) {
        return ResponseEntity.ok(service.currentExchange(code));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/full_information")
    public ResponseEntity<NBPGoldDto[]> getGoldExchange() {
        return ResponseEntity.ok(service.currentGoldExchange());
    }

}
