package com.example.myapplication.Retrofit;


import com.example.myapplication.Models.category.CategoryDetailData;
import com.example.myapplication.Models.loginResponse;

import okhttp3.RequestBody;
import retrofit2.Callback;

public class RestClient {
    private static final String TAG = "RestClient";



    public static void loginUser(RequestBody email, RequestBody password , Callback<loginResponse> callback) {
        RetrofitClient.getClient().loginUser(email,password).enqueue(callback);
    }





    public static void getCourses( Callback<CategoryDetailData> callback) {
        RetrofitClient.getClient().getCourse().enqueue(callback);
    }


}