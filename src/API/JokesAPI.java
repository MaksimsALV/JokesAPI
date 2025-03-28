package API;

import data.DataConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

import org.json.JSONObject;

import javax.xml.crypto.Data;

public class JokesAPI {
    public static void requestAPI() throws IOException, InterruptedException {
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
        System.out.println("\n#" + jokeResponse.get("id")); //key=id; value=whats inside the id (number)
        System.out.println(jokeResponse.get("setup")); //key=setup; value=whats inside the setup (joke)
        System.out.println(jokeResponse.get("punchline")); //key=punchline; value=whats inside the punchline (punchline!)

        int id = (int) jokeResponse.get("id");
        String setup = jokeResponse.get("setup").toString();
        //String punchline = jokeResponse.get("punchline").toString();
        DataConstructor.jokes.put(id, setup);
        System.out.println(DataConstructor.jokes);
    }
}

