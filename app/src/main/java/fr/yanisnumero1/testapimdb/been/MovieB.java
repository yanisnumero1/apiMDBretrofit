package fr.yanisnumero1.testapimdb.been;

import com.google.gson.annotations.SerializedName;

public class MovieB {

    @SerializedName("id")
    private int id;
    @SerializedName("original_title")
    private String original_title;
    @SerializedName("overview")
    private String overview;


    public MovieB(int id, String original_title, String overview) {
        this.id = id;
        this.original_title = original_title;
        this.overview=overview;
    }

    public int getId() {
        return id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }
}

