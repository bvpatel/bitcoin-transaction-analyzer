package com.bitgo.service;

import com.bitgo.api.EsploraClient;
import com.bitgo.domain.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BlockchainService {

    private EsploraClient client = new EsploraClient();

    public List<Transaction> getAllTransactions(long blockHeight) {
        String blockHash = client.getBlockHash(blockHeight);
        List<Transaction> result = new ArrayList<>();
        int i =0;
        while(true) {
            try {
                result.addAll(client.getTransactions(blockHash, i));
            } catch (Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
                break;
            }
            i++;
        }
        return result;
    }
}
