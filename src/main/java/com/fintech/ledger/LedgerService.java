package com.fintech.ledger.service;

import com.fintech.ledger.dto.LedgerRequest;
import com.fintech.ledger.entity.LedgerEntry;
import com.fintech.ledger.repository.LedgerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LedgerService {

    private final LedgerRepository repository;

    public LedgerEntry createEntry(
            LedgerRequest request){

        LedgerEntry entry =
                LedgerEntry.builder()
                .transactionId(request.getTransactionId())
                .accountId(request.getAccountId())
                .debitAmount(request.getDebitAmount())
                .creditAmount(request.getCreditAmount())
                .currency(request.getCurrency())
                .description(request.getDescription())
                .createdAt(LocalDateTime.now())
                .build();

        return repository.save(entry);
    }

    public List<LedgerEntry> getEntries(
            String accountId){

        return repository.findByAccountId(accountId);
    }

}
