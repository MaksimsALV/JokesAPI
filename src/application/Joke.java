package application;
import API.JokesAPI;

import java.text.SimpleDateFormat;
import java.util.Date; //javas timestamps
import java.util.UUID;

public class Joke {
    private UUID id;
    private String joke;
    private String punchline;
    private String category;
    private int rating;
    private String date_created;
    private String date_updated;


    public Joke(String joke, String punchline, String category) {
        this.id = UUID.randomUUID();
        this.joke = joke;
        this.punchline = punchline;
        this.category = category;
        this.date_created = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(new Date());
        this.date_updated = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(new Date());
    }

    //getters
    public UUID getId() {
        return id;
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
    public int getRating() {
        return rating;
    }
    public String getDate_created() {
        return date_created;
    }
    public String getDate_updated() {
        return date_updated;
    }

    //setters
    public void setRating(int rating) {
        this.rating = rating;
    }
}


