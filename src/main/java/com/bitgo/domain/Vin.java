package com.bitgo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties
public class Vin {
    @JsonProperty("txid")
    private String txId;
    private long vout;
    @JsonProperty("is_coinbase")
    private boolean isCoinBase;
    @JsonProperty("prevout")
    private Vout prevOut;
    private String scriptsig;
    @JsonProperty("scriptsig_asm")
    private String scriptsigAsm;
    private List<String> witness;
    private long sequence;
    @JsonProperty("inner_redeemscript_asm")
    private String innerRedeemscriptAsm;
    @JsonProperty("inner_witnessscript_asm")
    private String innerWitnessscriptAsm;


    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public long getVout() {
        return vout;
    }

    public void setVout(long vout) {
        this.vout = vout;
    }

    public boolean isCoinBase() {
        return isCoinBase;
    }

    public void setCoinBase(boolean coinBase) {
        isCoinBase = coinBase;
    }

    public String getScriptsig() {
        return scriptsig;
    }

    public void setScriptsig(String scriptsig) {
        this.scriptsig = scriptsig;
    }

    public String getScriptsigAsm() {
        return scriptsigAsm;
    }

    public void setScriptsigAsm(String scriptsigAsm) {
        this.scriptsigAsm = scriptsigAsm;
    }

    public List<String> getWitness() {
        return witness;
    }

    public void setWitness(List<String> witness) {
        this.witness = witness;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    public Vout getPrevOut() {
        return prevOut;
    }

    public void setPrevOut(Vout prevOut) {
        this.prevOut = prevOut;
    }

    public String getInnerRedeemscriptAsm() {
        return innerRedeemscriptAsm;
    }

    public void setInnerRedeemscriptAsm(String innerRedeemscriptAsm) {
        this.innerRedeemscriptAsm = innerRedeemscriptAsm;
    }

    public String getInnerWitnessscriptAsm() {
        return innerWitnessscriptAsm;
    }

    public void setInnerWitnessscriptAsm(String innerWitnessscriptAsm) {
        this.innerWitnessscriptAsm = innerWitnessscriptAsm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vin vin = (Vin) o;
        return txId.equals(vin.txId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(txId);
    }

    @Override
    public String toString() {
        return "Vin{" +
                "txId='" + txId + '\'' +
                ", vout=" + vout +
                ", isCoinBase=" + isCoinBase +
                ", prevOut=" + prevOut +
                ", scriptsig='" + scriptsig + '\'' +
                ", scriptsigAsm='" + scriptsigAsm + '\'' +
                ", witness=" + witness +
                ", sequence=" + sequence +
                ", innerRedeemscriptAsm='" + innerRedeemscriptAsm + '\'' +
                ", innerWitnessscriptAsm='" + innerWitnessscriptAsm + '\'' +
                '}';
    }
}
