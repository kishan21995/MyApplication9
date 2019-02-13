package com.example.myapplication.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.Adapters.Adapters;
import com.example.myapplication.Models.CourseListAdapter;
import com.example.myapplication.Models.category.CategoryDetailData;
import com.example.myapplication.R;
import com.example.myapplication.Retrofit.RestClient;
import com.example.myapplication.Utils.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private CategoryDetailData categoryDetailData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerView=findViewById(R.id.recycler);
        getCourse();
    }

    private void getCourse() {


           Utils.showProgressDialog(CategoryActivity.this);
            RestClient.getCourses(new Callback<CategoryDetailData>() {
                @Override
                public void onResponse(Call<CategoryDetailData> call, Response<CategoryDetailData> response) {
                    if (response.code() == 200) {
                        Utils.dismissProgressDialog();
                        categoryDetailData = response.body();
                        if (categoryDetailData != null && categoryDetailData.getDetails().size() > 0) {
                            Log.d("Api Response :", "Got Success from Api");
                            CourseListAdapter courseListAdapter = new CourseListAdapter(getApplicationContext());
                            courseListAdapter.setData(categoryDetailData);


                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(mLayoutManager);
                            recyclerView.setAdapter(courseListAdapter);

                            Log.d("Api Response :", "Got Success from Api");
                            // noInternet.setVisibility(View.GONE);
                           /* RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2) {
                                @Override
                                public boolean canScrollVertically() {
                                    return true;
                                }

                            };
*/


                        } else {
                            Log.d("Api Response :", "Got Success from Api");

                            Toast.makeText(CategoryActivity.this, "No data", Toast.LENGTH_SHORT).show();
                            // noInternet.setVisibility(View.VISIBLE);
                            // noInternet.setText(getString(R.string.no_project));

                        }
                    } else {

                    }


                }

                @Override
                public void onFailure(Call<CategoryDetailData> call, Throwable t) {
                    Utils.dismissProgressDialog();

                }
            });
        }
    }

