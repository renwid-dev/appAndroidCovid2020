package com.tmr.covid192020.api;

import com.tmr.covid192020.model.RiwayatModel;
import com.tmr.covid192020.model.CountryModel;
import com.tmr.covid192020.model.RingkasanModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by temanrendy 2020
 */

public interface ApiEndPoint {

    @GET(Api.END_POINT_WORLD_HISTORY)
    Call<List<RiwayatModel>> getHistoryList(@Path("date") String date);

    @GET(Api.END_POINT_SUMMARY_WORLD)
    Call<RingkasanModel> getSummaryWorld();

    @GET(Api.END_POINT_IDN)
    Call<CountryModel> getSummaryIdn();

}
