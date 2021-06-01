package com.bitgo;

import com.bitgo.domain.Transaction;
import com.bitgo.service.AncestryService;
import com.bitgo.service.BlockchainService;
import com.bitgo.service.TopTransactionService;

import java.util.List;

public class App 
{
    public static void main( String[] args )  {
        BlockchainService blockchainService = new BlockchainService();
        AncestryService ancestryService = new AncestryService();
        TopTransactionService topTransactionService = new TopTransactionService();
        //Fetch All Block from block height
        List<Transaction> transactions = blockchainService.getAllTransactions(680000);
        System.out.println("Total transactions: " + transactions.size());
        //Build graph from all transaction and Calculate ancestry
        ancestryService.calculateAncestry(transactions);
        // Top n using min heap tree
        List<Transaction> topTransactions = topTransactionService.getTopTransaction(transactions, 10);
        for(Transaction transaction: topTransactions) {
            System.out.println("TxId: " + transaction.getTxId() + ", Ancestry size: " + transaction.getAncestryCount());
        }
    }
}
