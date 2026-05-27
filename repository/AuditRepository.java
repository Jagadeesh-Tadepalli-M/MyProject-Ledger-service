package com.fintech.ledger.repository;

import com.fintech.ledger.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository
        extends JpaRepository<AuditLog,Long> {

}
