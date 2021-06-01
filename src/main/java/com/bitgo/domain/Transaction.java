package com.bitgo.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class Transaction {

    @JsonProperty("txid")
    private String txId;
    private int version;
    @JsonProperty("locktime")
    private long lockTime;
    private List<Vin> vin;
    @JsonIgnore
    private List<Transaction> parents;
    @JsonIgnore
    private int ancestryCount;

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public long getLockTime() {
        return lockTime;
    }

    public void setLockTime(long lockTime) {
        this.lockTime = lockTime;
    }

    public List<Vin> getVin() {
        return vin;
    }

    public void setVin(List<Vin> vin) {
        this.vin = vin;
    }

    public List<Transaction> getParents() {
        return parents;
    }

    public void setParents(List<Transaction> parents) {
        this.parents = parents;
    }

    public int getAncestryCount() {
        return ancestryCount;
    }

    public void setAncestryCount(int ancestryCount) {
        this.ancestryCount = ancestryCount;
    }
}
