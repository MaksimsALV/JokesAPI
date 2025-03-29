package application;

public class Joke {
    //private String id; //todo uuid
    private String joke;
    private String punchline;
    //private String category;
    //private String rating; //todo change to integer
    //private String date_created; //todo change to timestamp
    //private String date_updated; //todo change to timestamp

    public Joke(String joke, String punchline) {
        this.joke = joke;
        this.punchline = punchline;
        //this.category = category;
    }
    public String getJoke() {
        return joke;
    }
    public String getPunchline() {
        return punchline;
    }

    /*
    public String getCategory() {
        return category;
    }
     */
}
