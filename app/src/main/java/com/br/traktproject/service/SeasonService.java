package com.br.traktproject.service;

import com.br.traktproject.entities.Season;
import com.br.traktproject.exceptions.NotAvailableServer;
import com.br.traktproject.interfaces.OnErrorListener;
import com.br.traktproject.interfaces.OnSuccessListener;
import com.br.traktproject.service.configuration.ApiConfiguration;
import com.br.traktproject.service.configuration.SeasonInterface;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */
public class SeasonService {

    private static SeasonService sSeasonService = new SeasonService();
    private static OnSuccessListener<List<Season>> mOnSuccessListener;
    private static OnErrorListener<Exception> mOnErrorListener;
    private SeasonInterface mService = ApiConfiguration.createService(SeasonInterface.class);

    public static SeasonService getInstance(OnSuccessListener<List<Season>> onSuccessListener, OnErrorListener<Exception> onErrorListener) {
        mOnSuccessListener = onSuccessListener;
        mOnErrorListener = onErrorListener;
        return sSeasonService;
    }

    private SeasonService() {
    }

    public void getSeasons() {
        Call<List<Season>> call = mService.getSeasons("full,images,episodes");
        call.enqueue(new Callback<List<Season>>() {
            @Override
            public void onResponse(Call<List<Season>> call, Response<List<Season>> response) {
                if (response.isSuccessful()) {
                    if (mOnSuccessListener != null) {
                        mOnSuccessListener.onSuccess(response.body());
                    }
                } else {
                    if (mOnErrorListener != null) {
                        mOnErrorListener.onError(new NotAvailableServer());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Season>> call, Throwable t) {
                if (mOnSuccessListener != null) {
                    mOnErrorListener.onError(new NotAvailableServer());
                }
            }

        });
    }

}
