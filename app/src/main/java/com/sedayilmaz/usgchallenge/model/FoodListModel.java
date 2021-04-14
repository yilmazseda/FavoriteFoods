package com.sedayilmaz.usgchallenge.model;

import com.sedayilmaz.usgchallenge.services.Category;
import com.sedayilmaz.usgchallenge.services.FoodLists;

public class FoodListModel {

    private FoodLists[] meals;
    public FoodLists[] getMeals() { return meals;}
    public void setMeals(FoodLists[] meals){this.meals=meals;}
}
