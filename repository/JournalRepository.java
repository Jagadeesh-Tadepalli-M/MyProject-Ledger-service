package com.fintech.ledger.repository;

import com.fintech.ledger.entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository
        extends JpaRepository<JournalEntry,Long> {

}
