package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Activities.CategoryActivity;
import com.example.myapplication.Models.loginResponse;
import com.example.myapplication.Retrofit.RestClient;
import com.example.myapplication.Utils.Utils;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    EditText editEmail,editPassword;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail=findViewById(R.id.email);
        editPassword=findViewById(R.id.password);
        btn=findViewById(R.id.Button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=editEmail.getText().toString().trim();
                String Password=editPassword.getText().toString().trim();

                RequestBody email = RequestBody.create(MediaType.parse("text/plain"), Email);
                RequestBody password = RequestBody.create(MediaType.parse("text/plain"), Password);

                RestClient.loginUser(email, password, new Callback<loginResponse>() {
                    @Override
                    public void onResponse(Call<loginResponse> call, Response<loginResponse> response) {
                        Utils.dismissProgressDialog();

                        if (response != null && response.body() != null) {

                            loginResponse loginResponse = response.body();
                            if (Integer.parseInt(loginResponse.getStatus()) == 1) {
                                startActivity(new Intent(MainActivity.this, CategoryActivity.class));
                                Utils.displayToast(MainActivity.this, loginResponse.getMessage());

                            }
                        }
                    }



                    @Override
                    public void onFailure(Call<loginResponse> call, Throwable t) {

                        Utils.dismissProgressDialog();
                        Toast.makeText(MainActivity.this, "Invalid Credential", Toast.LENGTH_SHORT).show();

                    }
                });








            }
        });



    }

}
