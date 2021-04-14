package com.sedayilmaz.usgchallenge.services;

import com.sedayilmaz.usgchallenge.model.CategoryModel;
import com.sedayilmaz.usgchallenge.model.FoodListModel;
import com.sedayilmaz.usgchallenge.model.RegionModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GeneralAPI {

    //API : https://www.themealdb.com/api/json/v1/1/list.php?a=list
    @GET("json/v1/1/list.php?a=list")
    Call<RegionModel> getRegionMeals();

    //Kategori aktivitesi için
    @GET("json/v1/1/categories.php")
    Call<CategoryModel> getCategories();

    //yemek listesi
    // https://www.themealdb.com/api/json/v1/1/filter.php?c=Dessert

}
