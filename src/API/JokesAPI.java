package API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.json.JSONObject;

public class JokesAPI {
    public static String requestAPI() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient(); //client is needed to send request
        HttpRequest request = HttpRequest.newBuilder() //this handles request
                .uri(URI.create("https://official-joke-api.appspot.com/random_joke")) //endpoint
                .timeout(Duration.ofSeconds(5)) //timeout for request
                .header("Content-type", "application/json") //header parameters
                .GET() //method
                .build(); //mandatory to execute request
        HttpResponse<String> response = client //this handles response
                .send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.statusCode());
        //System.out.println("Initial String response for debug: " + response.body());
        //System.out.print("\n");

        //gets <key> and returns its <value>
        JSONObject jokeResponse = new JSONObject(response.body());
        String id = jokeResponse.getString("id");
        String joke = jokeResponse.getString("joke");
        String punchline = jokeResponse.getString("punchline");
        return "#" + id + "\n" + joke + "\n" + punchline;
    }
}

