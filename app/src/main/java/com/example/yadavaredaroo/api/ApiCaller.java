package com.example.yadavaredaroo.api;


import com.example.yadavaredaroo.model.Applications;
import com.example.yadavaredaroo.model.IResponseMessage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCaller {

    IService iService;

    public ApiCaller() {
        iService = RetrofitClient.getRetrofit().create(IService.class);
    }

    public void getCurrent(IResponseMessage listener) {

        Call<Applications> call = iService.getCurrentVersion();

        call.enqueue(new Callback<Applications>() {
            @Override
            public void onResponse(Call<Applications> call, Response<Applications> response) {

                listener.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<Applications> call, Throwable t) {

                listener.onFailure(t.getMessage().toString() + "");

            }
        });
    }
}
