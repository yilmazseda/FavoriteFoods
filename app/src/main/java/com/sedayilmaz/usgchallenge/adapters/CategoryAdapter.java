package com.sedayilmaz.usgchallenge.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sedayilmaz.usgchallenge.R;
import com.sedayilmaz.usgchallenge.services.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context context;
    private List<Category> categoryList;



    public CategoryAdapter(Context context, List<Category> categoryList )
    {
        this.context=context;
        this.categoryList=categoryList;

    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.categories_items,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {

    //holder.categoryDescription.setText(categoryList.get(position).getStrCategoryDescription());
        holder.categoryName.setText(categoryList.get(position).getstrCategoryName());

        // bind for ImageView
        Glide.with(context)
                .load(categoryList.get(position).getStrCategoryThumb())
                .into(holder.categoryImage);

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static  class CategoryViewHolder extends RecyclerView.ViewHolder
    {

        TextView categoryName;
        ImageView categoryImage;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryNameText);
            categoryImage = itemView.findViewById(R.id.categoryImageView);
        }


    }
}
