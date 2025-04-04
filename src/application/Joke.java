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
    private String rating;
    private String date_created;
    private String date_updated;
    private String date_deleted;


    public Joke(String joke, String punchline, String category) {
        setId();
        //this.id = UUID.randomUUID();
        setJoke(joke);
        //this.joke = joke;
        setPunchline(punchline);
        //this.punchline = punchline;
        setCategory(category);
        //this.category = category;
        setDate_created();
        //this.date_created = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(new Date());
        setDate_updated();
        //this.date_updated = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(new Date());
    }

    //getters
    //its weird, javaFX needs them to work, but there is no usages for some of them...
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
    public String getRating() {
        return rating;
    }
    public String getDate_created() {
        return date_created;
    }
    public String getDate_updated() {
        return date_updated;
    }
    public String getDate_deleted() {
        return date_deleted;
    }

    //setters
    public void setId() {
        this.id = UUID.randomUUID();
    }
    public void setJoke(String joke) {
        this.joke = joke;
    }
    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public void setDate_created() {
        this.date_created = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(new Date());
    }
    public void setDate_updated() {
        this.date_updated = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(new Date());
    }
    public void setDate_deleted() {
        this.date_deleted = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(new Date());
    }
}


