package com.bitgo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status {
    private boolean confirmed;
    @JsonProperty("block_height")
    private long blockHeight;
    @JsonProperty("block_hash")
    private String blockHash;
    @JsonProperty("block_time")
    private long blockTime;

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public long getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(long blockHeight) {
        this.blockHeight = blockHeight;
    }

    public long getBlockTime() {
        return blockTime;
    }

    public void setBlockTime(long blockTime) {
        this.blockTime = blockTime;
    }

    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash;
    }

    @Override
    public String toString() {
        return "Status{" +
                "confirmed=" + confirmed +
                ", blockHeight=" + blockHeight +
                ", blockHash='" + blockHash + '\'' +
                ", blockTime=" + blockTime +
                '}';
    }
}