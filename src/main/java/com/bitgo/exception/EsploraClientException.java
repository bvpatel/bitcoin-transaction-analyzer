package com.bitgo.exception;

public class EsploraClientException extends RuntimeException {

    public EsploraClientException(Exception ex) {
        this("Error occurred while Esplora client",ex);
    }
    public EsploraClientException(String message, Exception ex) {
        super(message, ex);
    }
}
