package com.sedayilmaz.usgchallenge.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sedayilmaz.usgchallenge.R;
import com.sedayilmaz.usgchallenge.adapters.CategoryAdapter;
import com.sedayilmaz.usgchallenge.model.CategoryModel;
import com.sedayilmaz.usgchallenge.services.Category;
import com.sedayilmaz.usgchallenge.services.GeneralAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryActivity extends AppCompatActivity {
    Retrofit retrofit;
    TextView textView;
    List<Category> categoryList;
    RecyclerView recyclerViewCategory;
    CategoryAdapter categoryAdapter;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerViewCategory = findViewById(R.id.recyclerViewCategory);
        categoryList = new ArrayList<>();
        textView=findViewById(R.id.categoryNameText);
        progressBar=findViewById(R.id.progressBar2);


        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        getCategoryData();

    }

    public void getCategoryData()
    {

        GeneralAPI categoriesAPI= retrofit.create(GeneralAPI.class);
        Call<CategoryModel> call = categoriesAPI.getCategories();
        progressBar.setVisibility(View.VISIBLE);

        call.enqueue(new Callback<CategoryModel>() {
            @Override
            public void onResponse(Call<CategoryModel> call, Response<CategoryModel> response) {

                CategoryModel categoryModel = response.body();
                categoryList = new ArrayList<>(Arrays.asList(categoryModel.getCategories()));
                progressBar.setVisibility(View.GONE);
                PutDataIntoRecyclerView(categoryList);

            }

            @Override
            public void onFailure(Call<CategoryModel> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

    private  void  PutDataIntoRecyclerView(List<Category> categoryList)
    {
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(CategoryActivity.this));//recylerViewde itemların nasıl gözükceğin(alt alta olacağı için ; LinearLayoutManager)
        categoryAdapter = new CategoryAdapter(this,categoryList);
        recyclerViewCategory.setAdapter(categoryAdapter);
    }


}