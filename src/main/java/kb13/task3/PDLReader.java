package kb13.task3;

import org.json.JSONObject;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PDLReader {
    @SneakyThrows
    public Company fetch(String website){
        String API_KEY = "";
        URL url = new URL("https://api.peopledatalabs.com/v5/company/enrich?website=ucu.edu.ua");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Api-Key", API_KEY);
        connection.connect();
        String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        JSONObject jsonObject = new JSONObject(text);
        String name = jsonObject.optString("name", "Unknown");
        String description = jsonObject.optString("description", "No description available");
        String logo = jsonObject.optString("logo", "No logo available");
        Company company = new Company();
        company.setName(name);
        company.setDescription(description);
        company.setLogo(logo);
        return company;
    }
}
