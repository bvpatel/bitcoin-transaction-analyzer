package com.bitgo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vout{
    private String scriptpubkey;
    @JsonProperty("scriptpubkey_asm")
    private String scriptpubkeyAsm;
    @JsonProperty("scriptpubkey_type")
    private String scriptpubkeyType;
    @JsonProperty("scriptpubkey_address")
    private String scriptpubkeyAddress;
    private long value;

    public String getScriptpubkey() {
        return scriptpubkey;
    }

    public void setScriptpubkey(String scriptpubkey) {
        this.scriptpubkey = scriptpubkey;
    }

    public String getScriptpubkeyAsm() {
        return scriptpubkeyAsm;
    }

    public void setScriptpubkeyAsm(String scriptpubkeyAsm) {
        this.scriptpubkeyAsm = scriptpubkeyAsm;
    }

    public String getScriptpubkeyType() {
        return scriptpubkeyType;
    }

    public void setScriptpubkeyType(String scriptpubkeyType) {
        this.scriptpubkeyType = scriptpubkeyType;
    }

    public String getScriptpubkeyAddress() {
        return scriptpubkeyAddress;
    }

    public void setScriptpubkeyAddress(String scriptpubkeyAddress) {
        this.scriptpubkeyAddress = scriptpubkeyAddress;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Vout{" +
                "scriptpubkey='" + scriptpubkey + '\'' +
                ", scriptpubkeyAsm='" + scriptpubkeyAsm + '\'' +
                ", scriptpubkeyType='" + scriptpubkeyType + '\'' +
                ", scriptpubkeyAddress='" + scriptpubkeyAddress + '\'' +
                ", value=" + value +
                '}';
    }
}