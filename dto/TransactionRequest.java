package com.fintech.ledger.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TransactionRequest {

    @NotBlank
    private String transactionId;

    @NotNull
    private List<JournalDto> entries;

    @Data
    public static class JournalDto {

        @NotBlank
        private String accountId;

        @NotNull
        private BigDecimal debit;

        @NotNull
        private BigDecimal credit;
    }
}
