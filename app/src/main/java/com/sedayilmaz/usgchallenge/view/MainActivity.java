package com.sedayilmaz.usgchallenge.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.sedayilmaz.usgchallenge.R;
import com.sedayilmaz.usgchallenge.adapters.Adapters;
import com.sedayilmaz.usgchallenge.services.Region;
import com.sedayilmaz.usgchallenge.services.GeneralAPI;
import com.sedayilmaz.usgchallenge.model.RegionModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    List<Region> regionList;
    RecyclerView recyclerView;
    Adapters adapters;
    ProgressBar progressBar;
    private Adapters.RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler);
        regionList=new ArrayList<>();
        progressBar=findViewById(R.id.progressBar);


        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getData();


    }



    //Pulling Method
    public void getData()
    {

        GeneralAPI regionAPI= retrofit.create(GeneralAPI.class);
        Call<RegionModel> call = regionAPI.getRegionMeals();
        //Çağrı bitmeden önce
        progressBar.setVisibility(View.VISIBLE);

        call.enqueue(new Callback<RegionModel>() {
            @Override
            public void onResponse(Call<RegionModel> call, Response<RegionModel> response) {
                RegionModel regionModel = response.body();
                regionList = new ArrayList<>(Arrays.asList(regionModel.getMeals()));
                //Çağrı bitti veriler çekildi
                progressBar.setVisibility(View.GONE);
                PutDataIntoRecyclerView(regionList);

            }

            @Override
            public void onFailure(Call<RegionModel> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

    //Verileri RecylerView'a koy
    private  void  PutDataIntoRecyclerView(List<Region> regionList)
    {
        setOnClickListener();
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));//recylerViewde itemların nasıl gözükceğin(alt alta olacağı için ; LinearLayoutManager)
        adapters = new Adapters(this,regionList,listener);
        recyclerView.setAdapter(adapters);
    }

    private void setOnClickListener()
    {
        listener = new Adapters.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int posiiton) {
                Intent intent = new Intent(getApplicationContext(),CategoryActivity.class);
                startActivity(intent);
            }
        };
    }



}