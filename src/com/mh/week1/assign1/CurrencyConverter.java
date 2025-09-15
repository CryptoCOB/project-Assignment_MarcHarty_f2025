package com.mh.week1.assign1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that converts CAD to USD using live exchange rate data
 */
public class CurrencyConverter {
    // Default exchange rate in case API call fails
    private static final double DEFAULT_CAD_TO_USD_RATE = 0.74;

    private final HttpClient httpClient = HttpClient.newHttpClient();

    /**
     * Fetches the current CAD to USD exchange rate from a public API
     * @return The current exchange rate or the default value if the API call fails
     */
    public double getLiveExchangeRate() {
        String apiUrl = "https://open.er-api.com/v6/latest/CAD";

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {

                String jsonResponse = response.body();
                Pattern pattern = Pattern.compile("\"USD\"\\s*:\\s*([0-9.]+)");
                Matcher matcher = pattern.matcher(jsonResponse);

                if (matcher.find()) {
                    return Double.parseDouble(matcher.group(1));
                } else {
                    System.out.println("Could not parse USD rate from response. Using default rate.");
                    return DEFAULT_CAD_TO_USD_RATE;
                }
            } else {
                System.out.println("Could not fetch live exchange rate. Using default rate.");
                return DEFAULT_CAD_TO_USD_RATE;
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error fetching exchange rate: " + e.getMessage());
            System.out.println("Using default exchange rate instead.");
            return DEFAULT_CAD_TO_USD_RATE;
        }
    }

    /**
     * Converts Canadian dollars to US dollars
     * @param cad The amount in Canadian dollars
     * @param rate The exchange rate to use
     * @return The amount in US dollars
     */
    public double convertCADtoUSD(double cad, double rate) {
        return cad * rate;
    }

    /**
     * Method to run the currency converter
     */
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n=== CAD to USD Currency Converter ===");
            System.out.println("Fetching current exchange rate...");

            // Get the live exchange rate
            double exchangeRate = getLiveExchangeRate();

            System.out.println("Current exchange rate: 1 CAD = " + exchangeRate + " USD");
            System.out.print("Enter amount in Canadian dollars (CAD): ");
            double cad = scanner.nextDouble();

            double usd = convertCADtoUSD(cad, exchangeRate);
            System.out.printf("%.2f CAD = %.2f USD%n", cad, usd);
        }
    }

    // Entry point
    public static void main(String[] args) {
        new CurrencyConverter().run();
    }
}
