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
import com.sedayilmaz.usgchallenge.services.FoodLists;

import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodListViewHolder> {

    private Context context;
    private List<FoodLists> foodLists;



    public FoodListAdapter(Context context, List<FoodLists> foodLists )
    {
        this.context=context;
        this.foodLists=foodLists;

    }

    @NonNull
    @Override
    public FoodListAdapter.FoodListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.food_list_items,parent,false);
        return new FoodListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListAdapter.FoodListViewHolder holder, int position) {

        //holder.categoryDescription.setText(categoryList.get(position).getStrCategoryDescription());
        holder.foodName.setText(foodLists.get(position).getStrMeal());

        // bind for ImageView
        Glide.with(context)
                .load(foodLists.get(position).getStrMealThumb())
                .into(holder.foodImage);

    }

    @Override
    public int getItemCount() {
        return foodLists.size();
    }

    public static  class FoodListViewHolder extends RecyclerView.ViewHolder
    {

        TextView foodName;
        ImageView foodImage;
        public FoodListViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodName);
            foodImage = itemView.findViewById(R.id.foodImage);
        }


    }
}