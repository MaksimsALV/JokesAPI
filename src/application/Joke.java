package application;
import API.JokesAPI;

import java.text.SimpleDateFormat;
import java.time.Instant; //javas timestamps
import java.util.Date; //javas timestamps

public class Joke {
    //private String id; //todo uuid
    private String joke;
    private String punchline;
    private String category;
    //private String rating; //todo change to integer
    private String date_created;
    //private String date_updated; //todo change to timestamp


    public Joke(String joke, String punchline, String category) {
        this.joke = joke;
        this.punchline = punchline;
        this.category = category;
        this.date_created = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.ms").format(new Date());
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
    public String getDate_created() {
        return date_created;
    }
}


