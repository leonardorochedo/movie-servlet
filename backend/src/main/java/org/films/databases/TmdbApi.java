package org.films.databases;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;

public class TmdbApi {
   
    private static final String API_KEY = "264bb09ec4d858065cfb8860838a32ff";

    public JSONArray searchMovies(String query, String query2) throws IOException {
        // Make a req
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://api.themoviedb.org/3" + query + "?api_key=" + API_KEY + query2);

        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            HttpEntity entity = response.getEntity();
            String responseBody = EntityUtils.toString(entity);

            // Parse the JSON response
            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(responseBody);
            return (JSONArray) jsonResponse.get("results");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
