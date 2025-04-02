package application;
import API.JokesAPI;

import java.time.Instant; //javas timestamps

public class Joke {
    //private String id; //todo uuid
    private String joke;
    private String punchline;
    private String category;
    //private String rating; //todo change to integer
    private Instant date_created; //todo change to timestamp
    //private String date_updated; //todo change to timestamp

    public Joke(String joke, String punchline, String category) {
        this.joke = joke;
        this.punchline = punchline;
        this.category = category;
        this.date_created = Instant.now();
    }
    public String getJoke() {
        return joke;
    }
    public String getPunchline() {
        return punchline;
    }
    public String getCategory() {
        return category;
    }
    public Instant getDate_created() {
        return date_created;
    }
}


