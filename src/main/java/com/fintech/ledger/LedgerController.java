package com.fintech.ledger.controller;

import com.fintech.ledger.dto.LedgerRequest;
import com.fintech.ledger.entity.LedgerEntry;
import com.fintech.ledger.service.LedgerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ledger")
@RequiredArgsConstructor
public class LedgerController {

    private final LedgerService service;

    @PostMapping

    public LedgerEntry create(
            @RequestBody LedgerRequest request){

        return service.createEntry(request);
    }

    @GetMapping("/{accountId}")

    public List<LedgerEntry> getEntries(
            @PathVariable String accountId){

        return service.getEntries(accountId);
    }

}
