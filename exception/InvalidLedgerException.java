package com.fintech.ledger.exception;

public class InvalidLedgerException
        extends RuntimeException{

    public InvalidLedgerException(
            String message){

        super(message);
    }

}
