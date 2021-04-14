package com.sedayilmaz.usgchallenge.model;

import com.sedayilmaz.usgchallenge.services.Category;
import com.sedayilmaz.usgchallenge.services.Region;

public class CategoryModel {

//Nested json!a sahibiz o yüzden array içerisinde tutuyoruz
    private Category[] categories;
    public Category[] getCategories() { return categories;}
    public void setCategories(Category[] categories){this.categories=categories;}
}
