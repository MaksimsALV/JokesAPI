package data;

import org.json.JSONObject;

import java.util.ArrayList;

public class DataConstructor {
    public static ArrayList<JSONObject> data = new ArrayList<>();
    int ID;
    String joke;
    String punchline;

    public DataConstructor(int ID, String joke, String punchline) {
        this.ID = ID;
        this.joke = joke;
        this.punchline = punchline;
    }
}
