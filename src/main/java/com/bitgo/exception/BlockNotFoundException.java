package com.bitgo.exception;

public class BlockNotFoundException extends RuntimeException {

    public BlockNotFoundException() {
        this("Block not found");
    }
    public BlockNotFoundException(String message) {
        super(message);
    }
}
