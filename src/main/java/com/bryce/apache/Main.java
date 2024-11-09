package com.bryce.apache;

import com.bryce.api.model.TVSeriesPage;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


/**
 * Very simple demonstration of Java REST API invocation using Apache HTTP Component libraries with GSON f
 * or result processing.
 *
 * @author Gareth
 */
public class Main {

    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CONTENT_TYPE_JSON_HEADER = "Content-Type";

    private static final String BASE_URL = "https://jsonmock.hackerrank.com/api/tvseries?page=";

    public static void main(final String[] args) throws IOException {

        try (final CloseableHttpClient client = HttpClients.createDefault()) { // autoclose client
            // 1. Define GET operation
            final HttpGet httpGet = new HttpGet(BASE_URL);
            httpGet.addHeader(CONTENT_TYPE_JSON_HEADER, CONTENT_TYPE_JSON);

            // 2. Execute operation
            final CloseableHttpResponse response = client.execute(httpGet);

            final int responseCode = response.getStatusLine().getStatusCode();

            System.out.println("Response status code : " + responseCode);

            if (responseCode == 200) {
                final HttpEntity responseEntity = response.getEntity();
                final String responseBody = EntityUtils.toString(responseEntity, "UTF-8");
                System.out.println("Received response body : " + responseBody);

                // 3. Parse JSON into TVSeriesPage.
                final Gson gson = new Gson();
                final TVSeriesPage singlePage = gson.fromJson(responseBody, TVSeriesPage.class);

                // 4. Dump the page to STDOUT.
                System.out.println("Marshalled Page into POJO: " + singlePage);
            } else {
                System.out.println("Error during invocation.");
                System.exit(1);
            }
        }
    }
}
