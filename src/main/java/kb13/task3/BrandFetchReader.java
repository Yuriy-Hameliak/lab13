package kb13.task3;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;

public class BrandFetchReader {
    private static final String website = "https://api.brandfetch.io/v2/brands/";
    public static String API_KEY = "cnKAM2SVQJaz54jWSOj7fXdYmiRAs8k3RLp/X3GrgkM=";
    @SneakyThrows
    public Company fetch(String comp) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest  request = HttpRequest.newBuilder()
        .GET()
        .uri(new URI(website + comp)).header("Authorization", "Bearer " + API_KEY).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), Company.class);
    }
}
