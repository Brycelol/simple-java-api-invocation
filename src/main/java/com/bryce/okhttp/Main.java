package com.bryce.okhttp;

import com.bryce.api.model.TVSeriesPage;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;


/**
 * Very simple demonstration of Java REST API invocation using Ok HTTP Component libraries with GSON f
 * or result processing.
 *
 * @author Gareth
 */
public class Main {

    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CONTENT_TYPE_JSON_HEADER = "Content-Type";

    private static final String BASE_URL = "https://jsonmock.hackerrank.com/api/tvseries?page=";

    public static void main(final String[] args) throws IOException {

        final OkHttpClient client = new OkHttpClient();

        // 1. Define GET operation
        final Request httpGet = new Request.Builder()
                .url(BASE_URL)
                .addHeader(CONTENT_TYPE_JSON_HEADER, CONTENT_TYPE_JSON)
                .build();

        // 2. Execute operation
        try (final Response response = client.newCall(httpGet).execute()) { // autoclose
            final int responseCode = response.code();

            System.out.println("Response status code : " + responseCode);

            if (responseCode == 200) {
                final ResponseBody respBodyHolder = response.body();
                if (respBodyHolder != null) {
                    final String responseBody = respBodyHolder.string();
                    System.out.println("Received response body : " + responseBody);

                    // 3. Parse JSON into TVSeriesPage.
                    final Gson gson = new Gson();
                    final TVSeriesPage singlePage = gson.fromJson(responseBody, TVSeriesPage.class);

                    // 4. Dump the page to STDOUT.
                    System.out.println("Marshalled Page into POJO: " + singlePage);
                } else {
                    System.out.println("Response body was empty - exiting...");
                    System.exit(1);
                }
            } else {
                System.out.println("Error during invocation.");
                System.exit(1);
            }

        }
    }
}
