package com.fintech.ledger.repository;

import com.fintech.ledger.entity.LedgerEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LedgerRepository
        extends JpaRepository<LedgerEntry,Long> {

    List<LedgerEntry> findByAccountId(String accountId);

}
