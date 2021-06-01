package com.bitgo;

import com.bitgo.domain.Transaction;
import com.bitgo.service.AncestryService;
import com.bitgo.service.BlockchainService;
import com.bitgo.service.TopTransactionService;
import org.apache.commons.cli.*;

import java.util.List;

public class TransactionAnalyzer {
    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        Options options = new Options();

        Option input = new Option("b", "blockheight", true, "Block Height. Should be numeric value.");
        input.setRequired(true);
        options.addOption(input);

        Option output = new Option("n", "top", true, "Number of top result. Should be numeric value.");
        output.setRequired(true);
        options.addOption(output);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;
        long blockHeight;
        int top;
        try {
            cmd = parser.parse(options, args);
            blockHeight = Long.parseLong(cmd.getOptionValue("blockheight"));
            top = Integer.parseInt(cmd.getOptionValue("top"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);
            System.exit(1);
            return;
        }

        BlockchainService blockchainService = new BlockchainService();
        AncestryService ancestryService = new AncestryService();
        TopTransactionService topTransactionService = new TopTransactionService();
        //Fetch All Block from block height
        List<Transaction> transactions = blockchainService.getAllTransactions(blockHeight);
        System.out.println("Total transactions: " + transactions.size());
        //Build graph from all transaction and Calculate ancestry
        ancestryService.calculateAncestry(transactions);
        // Top n using min heap tree
        List<Transaction> topTransactions = topTransactionService.getTopTransaction(transactions, top);
        for (int i = topTransactions.size() - 1; i >= 0; i--) {
            System.out.println("TxId: " + topTransactions.get(i).getTxId() + ", Ancestry size: " + topTransactions.get(i).getAncestryCount());
        }
    }
}
