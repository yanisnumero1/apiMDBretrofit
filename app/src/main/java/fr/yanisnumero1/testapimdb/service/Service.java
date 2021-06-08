package fr.yanisnumero1.testapimdb.service;

import retrofit2.Call;

import fr.yanisnumero1.testapimdb.been.ReponseApi;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {


    @GET("search/movie")
    Call<ReponseApi> searchMovie(@Query("api_key") String apiKey, @Query("query") String query, @Query("page") int page);


}
