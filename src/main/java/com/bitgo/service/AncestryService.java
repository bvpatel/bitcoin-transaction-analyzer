package com.bitgo.service;

import com.bitgo.domain.Transaction;
import com.bitgo.domain.Vin;

import java.util.*;

public class AncestryService {

    public List<Transaction> calculateAncestry(List<Transaction> transactions) {
        //Convert transaction list into map
        Map<String, Transaction> transactionMap = convertTransactionToMap(transactions);
        Set<String> visited = new HashSet<>();
        for(Transaction transaction: transactions) {
            if(!visited.contains(transaction.getTxId())) {
                findAncestry(transaction, transactionMap, visited);
            }
        }
        return transactions;
    }

    private void findAncestry(Transaction transaction, Map<String, Transaction> transactionMap, Set<String> visited) {
        if(transaction == null)
            return;
        if(visited.contains(transaction.getTxId()))
            return;
        int count = 0;
        for(Vin vin: transaction.getVin()) {
            if(!vin.isCoinBase()){
                Transaction parent = transactionMap.get(vin.getTxId());
                if(parent != null) {
                    findAncestry(parent, transactionMap, visited);
                    count+= parent.getAncestryCount();
                    transaction.addParent(parent);
                }
                count++;
            }
        }
        transaction.setAncestryCount(count);
        visited.add(transaction.getTxId());
    }
    private Map<String, Transaction> convertTransactionToMap(List<Transaction> transactions) {
        Map<String, Transaction> result = new HashMap<>();
        for(Transaction transaction : transactions) {
            result.put(transaction.getTxId(), transaction);
        }
        return result;
    }
}
