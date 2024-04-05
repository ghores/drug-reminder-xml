package com.example.yadavaredaroo.api;



import com.example.yadavaredaroo.model.Applications;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IService {

    @GET("getCurrentVersion.php")
    Call<Applications> getCurrentVersion();

}
