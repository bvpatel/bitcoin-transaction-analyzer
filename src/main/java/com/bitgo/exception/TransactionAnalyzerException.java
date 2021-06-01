package com.bitgo.exception;

public class TransactionAnalyzerException extends RuntimeException {

    public TransactionAnalyzerException() {
        this("Error occurred in Bitcoin Transaction Analyzer");
    }
    public TransactionAnalyzerException(String message) {
        super(message);
    }
}
