package com.br.traktproject.service.configuration;


import com.br.traktproject.entities.Season;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */
public interface SeasonInterface {

    @GET(EndPoint.Season.season)
    Call<List<Season>> getSeasons(@Query("extended") String value);

}