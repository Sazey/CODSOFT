package codsoft.task4;

import org.json.JSONObject;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App {

    public static void main(String[] args) throws IOException{

        HashMap<Integer, String> currencyCode = new HashMap<Integer, String>();

        currencyCode.put(1, "USD");
        currencyCode.put(2, "CAD");
        currencyCode.put(3, "EUR");
        currencyCode.put(4, "HKD");
        currencyCode.put(5, "INR");
        currencyCode.put(6, "ZAR");

        String fromCode, toCode;
        Double amount;

        Scanner scanner = new Scanner(System.in);

        System.out.println("========Welcome to the currency converter=========");


        System.out.println("Select base currency: ");

        System.out.println("1 - USD\n" +
                "2 - CAD\n" +
                "3 - EUR\n" +
                "4 - HDK\n" +
                "5 - INR\n"+
                "6 - ZAR");

        fromCode = currencyCode.get(scanner.nextInt());

        System.out.println("Select quote currency: ");

        System.out.println("1 - USD\n" +
                "2 - CAD\n" +
                "3 - EUR\n" +
                "4 - HDK\n" +
                "5 - INR\n"+
                "6 - ZAR");
        toCode = currencyCode.get(scanner.nextInt());

        System.out.println("Enter amount to convert");
        amount = scanner.nextDouble();

        sendHttpGETRequest(fromCode, toCode,amount);

        System.out.println("Thank you for using the currency converter");
    }

    private static void sendHttpGETRequest(String fromCode, String toCode, Double amount) throws IOException {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("https://open.er-api.com/v6/latest/" + fromCode);

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();
        CompletableFuture<HttpResponse<String>> future = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        try {
            if (future.get().statusCode() == HttpURLConnection.HTTP_OK) {
                String body = future.get().body();

                double exchanged = parseJSON(body,fromCode, toCode, amount);
                System.out.println();
                System.out.println(amount + fromCode + " = " + exchanged + toCode);
            } else {
                System.out.println("GET request failed!");
            }
        }catch (ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public static double parseJSON(String JSONString, String fromCode, String toCode, Double amount){
        JSONObject obj = new JSONObject(JSONString);
//        Double baseRate = obj.getJSONObject("rates").getDouble(fromCode);
        Double quoteRate = obj.getJSONObject("rates").getDouble(toCode);
        double exchanged = amount*quoteRate;

        return exchanged;
    }
}