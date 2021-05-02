package com.example.retrofitjava.Services;

import com.example.retrofitjava.Model.CrytoModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {

    //https://api.nomics.com/v1/prices?key=b018de8bb636c59f3f10b2a81ca1bd1f

    @GET("prices?key=b018de8bb636c59f3f10b2a81ca1bd1f")
    Observable<List<CrytoModel>> getData();

    //Call<List<CrytoModel>> getData();
}
