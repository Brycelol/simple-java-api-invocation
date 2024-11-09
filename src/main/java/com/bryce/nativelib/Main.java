package com.bryce.nativelib;

import com.bryce.api.model.TVSeriesPage;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;


/**
 * Very simple demonstration of Java REST API invocation using native libraries with GSON for result processing.
 *
 * @author Gareth
 */
public class Main {

    private static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CONTENT_TYPE_JSON_HEADER = "Content-Type";

    private static final String BASE_URL = "https://jsonmock.hackerrank.com/api/tvseries?page=";

    public static void main(final String[] args) throws IOException, InterruptedException {

        // 1. Define GET operation
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header(CONTENT_TYPE_JSON_HEADER, CONTENT_TYPE_JSON)
                .GET()
                .build();

        // 2. Execute operation
        final HttpResponse<String> response;
        try (HttpClient client = HttpClient.newBuilder()        // try-with-resources (autocloser)
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                //.proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
                //.authenticator(Authenticator.getDefault())
                .build()) {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }

        System.out.println("Response status code : " + response.statusCode());

        if (response.statusCode() == 200) {
            System.out.println("Received response body : " + response.body());

            // 3. Parse JSON into TVSeriesPage.
            final Gson gson = new Gson();
            final TVSeriesPage singlePage = gson.fromJson(response.body(), TVSeriesPage.class);

            // 4. Dump the page to STDOUT.
            System.out.println("Marshalled Page into POJO: " + singlePage);
        } else {
            System.out.println("Error during invocation.");
            System.exit(1);
        }
    }
}