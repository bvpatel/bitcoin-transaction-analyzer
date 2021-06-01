package com.bitgo.service;

import com.bitgo.api.impl.BlockstreamClient;
import com.bitgo.domain.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BlockchainService {

    private BlockstreamClient client = new BlockstreamClient();

    public List<Transaction> getAllTransactions(long blockHeight) {
        String blockHash = client.getBlockHash(blockHeight);
        List<Transaction> result = new ArrayList<>();
        int i =0;
        while(true) {
            try {
                List<Transaction> transactions = client.getTransactions(blockHash, i);
                result.addAll(transactions);
                if(transactions.size() < BlockstreamClient.TRANSACTION_PAGE_SIZE)
                    break;
            } catch (Exception e){
                System.out.println(e.getMessage());
                break;
            }
            i++;
        }
        return result;
    }
}
