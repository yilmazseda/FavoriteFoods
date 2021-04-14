package com.sedayilmaz.usgchallenge.services;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sedayilmaz.usgchallenge.R;

public class Category  {

    private int idCategory;
    private String strCategory;
    private String strCategoryThumb;
    private String strCategoryDescription;

    public int getIdCategory() {
        return idCategory;
    }

    public String getstrCategoryName() {
        return strCategory;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }


}
