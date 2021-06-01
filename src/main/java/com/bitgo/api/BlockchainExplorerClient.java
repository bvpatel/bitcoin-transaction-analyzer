package com.bitgo.api;

import com.bitgo.domain.Transaction;

import java.util.List;

public interface BlockchainExplorerClient {
    String getBlockHash(long blockHeight);
    List<Transaction> getTransactions(String blockHash, int pageId);
}
