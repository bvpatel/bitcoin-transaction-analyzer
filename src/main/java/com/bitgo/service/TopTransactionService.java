package com.bitgo.service;

import com.bitgo.domain.Transaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class TopTransactionService {

    public List<Transaction> getTopTransaction(List<Transaction> transactions, int n) {
        PriorityQueue<Transaction> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minHeap.add(transactions.get(i));
        }
        for (int i = n; i < transactions.size(); i++) {
            if (minHeap.peek().getAncestryCount() > transactions.get(i).getAncestryCount())
                continue;
            else {
                minHeap.poll();
                minHeap.add(transactions.get(i));
            }
        }
        List<Transaction> result = new ArrayList<>();
        Iterator<Transaction> iterator = minHeap.iterator();
        while (iterator.hasNext())
            result.add((Transaction) iterator.next());
        return result;
    }
}