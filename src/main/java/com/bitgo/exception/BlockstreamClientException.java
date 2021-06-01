package com.bitgo.exception;

public class BlockstreamClientException extends RuntimeException {

    public BlockstreamClientException(Exception ex) {
        this("Error occurred while Blockstream client",ex);
    }
    public BlockstreamClientException(String message, Exception ex) {
        super(message, ex);
    }
}
