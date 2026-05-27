package com.fintech.ledger.controller;

import com.fintech.ledger.dto.TransactionRequest;
import com.fintech.ledger.service.LedgerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ledger")
@RequiredArgsConstructor
public class LedgerController {

    private final LedgerService service;

    @PostMapping
    public String create(
            @Valid
            @RequestBody
            TransactionRequest request){

        service.process(request);

        return "Transaction Created";
    }

}
