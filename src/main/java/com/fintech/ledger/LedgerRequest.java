package com.fintech.ledger.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LedgerRequest {

    private String transactionId;

    private String accountId;

    private BigDecimal debitAmount;

    private BigDecimal creditAmount;

    private String currency;

    private String description;
}
