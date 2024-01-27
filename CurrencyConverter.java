package Internship;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter the base currency code (e.g., USD): ");
            String baseCurrency = scanner.nextLine().toUpperCase();

            System.out.print("Enter the target currency code (e.g., EUR): ");
            String targetCurrency = scanner.nextLine().toUpperCase();

            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

            System.out.print("Enter the amount to convert: ");
            double amountToConvert = scanner.nextDouble();

            double convertedAmount = amountToConvert * exchangeRate;

            System.out.printf("%.2f %s is equal to %.2f %s%n",
                    amountToConvert, baseCurrency, convertedAmount, targetCurrency);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        String apiKey = "YOUR_API_KEY";
        String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        connection.disconnect();

        String jsonResponse = response.toString();
        double exchangeRate = Double.parseDouble(jsonResponse
                .split("\"" + targetCurrency + "\":")[1]
                .split(",")[0]
                .replaceAll("[^0-9.]", ""));

        return exchangeRate;
    }
}
