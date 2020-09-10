package com.tmr.covid192020.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tmr.covid192020.model.RingkasanModel;
import com.tmr.covid192020.api.ApiEndPoint;
import com.tmr.covid192020.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by temanrendy 2020
 */

public class RingkasanViewModel extends ViewModel {

    private MutableLiveData<RingkasanModel> mutableLiveData = new MutableLiveData<>();

    public void setSummaryWorldData() {
        Retrofit retrofit = ApiService.getRetrofitService();
        ApiEndPoint apiEndpoint = retrofit.create(ApiEndPoint.class);
        Call<RingkasanModel> call = apiEndpoint.getSummaryWorld();
        call.enqueue(new Callback<RingkasanModel>() {
            @Override
            public void onResponse(Call<RingkasanModel> call, Response<RingkasanModel> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RingkasanModel> call, Throwable t) {

            }
        });

    }

    public LiveData<RingkasanModel> getSummaryWorldData() {
        return mutableLiveData;
    }
}
