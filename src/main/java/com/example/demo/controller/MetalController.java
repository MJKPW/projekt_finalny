package com.example.demo.controller;

import com.example.demo.domain.MetalExchangeDto;
import com.example.demo.service.MetalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/metal_exchange")
public class MetalController {

    private final MetalService service;

    public MetalController(MetalService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/full_information")
    public ResponseEntity<MetalExchangeDto> getExchange() {
        return ResponseEntity.ok(service.currentExchange());
    }
}
