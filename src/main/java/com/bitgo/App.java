package com.bitgo;

import com.bitgo.api.EsploraClient;
import com.bitgo.domain.Transaction;
import com.bitgo.service.BlockchainService;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        BlockchainService blockchainService = new BlockchainService();
        //System.out.println(new EsploraClient().getBlockHash(680000));
        //Fetch All Block from block height
        List<Transaction> transactions = blockchainService.getAllTransactions(680000);
        System.out.println("Total transactions: " + transactions.size());
        //Build graph from all transaction
        // Calculate ancestry
        // Top n using min heap tree
    }
}
