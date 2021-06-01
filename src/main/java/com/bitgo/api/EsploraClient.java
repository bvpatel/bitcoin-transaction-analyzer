package com.bitgo.api;

import com.bitgo.domain.Transaction;
import com.bitgo.exception.BlockNotFoundException;
import com.bitgo.exception.EsploraClientException;
import com.bitgo.util.JsonBodyHandler;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class EsploraClient {

    private static final HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private static final String API_ENDPOINT = "https://blockstream.info/api/";
    public static final int TRANSACTION_PAGE_SIZE = 25;

    public String getBlockHash(long blockHeight) {
        var request = HttpRequest.newBuilder(
                URI.create(API_ENDPOINT + "block-height/" + blockHeight))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception ex) {
            throw new EsploraClientException("Error occurred While getting block hash from block height: " + blockHeight, ex);
        }
        if (response.statusCode() != 200) {
            throw new BlockNotFoundException();
        }
        return response.body();

    }

    public List<Transaction> getTransactions(String blockHash, int pageId) {
        int startIndex = pageId * TRANSACTION_PAGE_SIZE;
        var request = HttpRequest.newBuilder(
                URI.create(API_ENDPOINT + "block/" + blockHash + "/txs/" + startIndex))
                .build();
        HttpResponse<Transaction[]> response = null;
        try {
            response = client.send(request, new JsonBodyHandler<>(Transaction[].class));
        } catch (Exception ex) {
            throw new EsploraClientException("Error occurred While getting transaction from index: " + startIndex + ", Block Hash: " + blockHash, ex);
        }
        if (response.statusCode() != 200) {
            throw new BlockNotFoundException();
        }
        return Arrays.asList(response.body());
    }
}
