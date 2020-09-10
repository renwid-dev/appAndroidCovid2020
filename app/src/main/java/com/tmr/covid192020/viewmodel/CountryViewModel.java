package com.tmr.covid192020.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tmr.covid192020.model.CountryModel;
import com.tmr.covid192020.api.ApiEndPoint;
import com.tmr.covid192020.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by temanrendy 2020
 */

public class CountryViewModel extends ViewModel {

    private MutableLiveData<CountryModel> mutableLiveData = new MutableLiveData<>();

    public void setCountryData() {
        Retrofit retrofit = ApiService.getRetrofitService();
        ApiEndPoint apiEndpoint = retrofit.create(ApiEndPoint.class);
        Call<CountryModel> call = apiEndpoint.getSummaryIdn();
        call.enqueue(new Callback<CountryModel>() {
            @Override
            public void onResponse(Call<CountryModel> call, Response<CountryModel> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CountryModel> call, Throwable t) {

            }
        });
    }

    public LiveData<CountryModel> getCountryData() {
        return mutableLiveData;
    }
}
