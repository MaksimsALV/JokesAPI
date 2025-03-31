package API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import application.Joke;
import org.json.JSONObject;

public class JokesAPI {
    public static Joke requestAPI() throws IOException, InterruptedException {

        //client section
        HttpClient client = HttpClient.newHttpClient();

        //request section
        HttpRequest request = HttpRequest.newBuilder() //this handles request
                .uri(URI.create("https://official-joke-api.appspot.com/random_joke")) //endpoint
                .timeout(Duration.ofSeconds(5)) //timeout for request
                .header("Content-type", "application/json") //header parameters
                .GET() //method
                .build(); //mandatory to execute request

        //response section
        HttpResponse<String> response = client //this handles response
                .send(request, HttpResponse.BodyHandlers.ofString());

        //using JSONObject library for data organization (key & value) because API returns JSON object, so i need to get the correct data from it and then store in my Joke class
        //I store it later as a String (everywhere), and add to the list also as a String to avoid complications
        JSONObject jokeResponse = new JSONObject(response.body());
        String joke = jokeResponse.getString("setup");
        String punchline = jokeResponse.get("punchline").toString();
        return new Joke(joke, punchline); // + "\n" + punchline;
    }
}


