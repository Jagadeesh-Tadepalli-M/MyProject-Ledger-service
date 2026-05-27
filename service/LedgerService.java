package com.fintech.ledger.service;

import com.fintech.ledger.dto.TransactionRequest;
import com.fintech.ledger.entity.*;
import com.fintech.ledger.exception.InvalidLedgerException;
import com.fintech.ledger.repository.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LedgerService {

    private final TransactionRepository transactionRepository;
    private final JournalRepository journalRepository;
    private final AuditRepository auditRepository;

    public void process(
            TransactionRequest request){

        BigDecimal totalDebit=
                request.getEntries()
                .stream()
                .map(x->x.getDebit())
                .reduce(
                  BigDecimal.ZERO,
                  BigDecimal::add);

        BigDecimal totalCredit=
                request.getEntries()
                .stream()
                .map(x->x.getCredit())
                .reduce(
                  BigDecimal.ZERO,
                  BigDecimal::add);

        if(totalDebit.compareTo(
                totalCredit)!=0){

            throw new InvalidLedgerException(
              "Debit and Credit mismatch");
        }

        Transaction transaction=
                Transaction.builder()
                .transactionId(
                        request.getTransactionId())
                .status("SUCCESS")
                .createdAt(
                        LocalDateTime.now())
                .build();

        transactionRepository.save(
                transaction);

        request.getEntries()
                .forEach(entry->{

                    journalRepository.save(
                            JournalEntry.builder()
                                    .transactionId(
                                            request.getTransactionId())
                                    .accountId(
                                            entry.getAccountId())
                                    .debit(
                                            entry.getDebit())
                                    .credit(
                                            entry.getCredit())
                                    .build());

                });

        auditRepository.save(
                AuditLog.builder()
                        .action(
                                "TRANSACTION_CREATED")
                        .transactionId(
                                request.getTransactionId())
                        .createdAt(
                                LocalDateTime.now())
                        .build());

    }
}
