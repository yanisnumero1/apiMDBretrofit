package fr.yanisnumero1.testapimdb.been;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ReponseApi {

    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private ArrayList<MovieB> results;
    @SerializedName("total_pages")
    private int total_pages;
    @SerializedName("total_results")
    private int total_results;

    public ReponseApi(int page, ArrayList<MovieB> results, int total_pages, int total_results) {
        this.page = page;
        this.results = results;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public int getPage() {
        return page;
    }

    public ArrayList<MovieB> getResults() {
        return results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }
}
