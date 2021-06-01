package com.bitgo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class Transaction implements Comparable<Transaction>{

    @JsonProperty("txid")
    private String txId;
    private int version;
    @JsonProperty("locktime")
    private long lockTime;
    private List<Vin> vin;
    private List<Vout> vout;
    private long size;
    private long weight;
    private long fee;
    private Status status;

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
    public void addParent(Transaction parent) {
        if(this.parents == null)
            this.parents = new ArrayList<>();
        this.parents.add(parent);
    }

    public int getAncestryCount() {
        return ancestryCount;
    }

    public void setAncestryCount(int ancestryCount) {
        this.ancestryCount = ancestryCount;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Vout> getVout() {
        return vout;
    }

    public void setVout(List<Vout> vout) {
        this.vout = vout;
    }

    @Override
    public int compareTo(Transaction o) {
        return Integer.compare(this.getAncestryCount(), o.getAncestryCount());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return txId.equals(that.txId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(txId);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "txId='" + txId + '\'' +
                ", version=" + version +
                ", lockTime=" + lockTime +
                ", vin=" + vin +
                ", vout=" + vout +
                ", size=" + size +
                ", weight=" + weight +
                ", fee=" + fee +
                ", status=" + status +
                ", parents=" + parents +
                ", ancestryCount=" + ancestryCount +
                '}';
    }
}
