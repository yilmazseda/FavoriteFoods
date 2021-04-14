package com.sedayilmaz.usgchallenge.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sedayilmaz.usgchallenge.R;
import com.sedayilmaz.usgchallenge.services.Region;

import java.util.List;

public class Adapters extends RecyclerView.Adapter<Adapters.MyViewHolder>{

    //ViewHolder : recyler_layout'umuz ile v
    private Context mContext;
    private List<Region> regionList1;
    private String[] colors ={"#FFC300","#DAF7A6"};

    private  RecyclerViewClickListener listener;




    public Adapters(Context mContext,List<Region> regionList1,RecyclerViewClickListener listener)
    {
        this.mContext=mContext;
        this.regionList1=regionList1;
        this.listener=listener;
    }

    //layout ile recylerview'i bağlamızı sağlar.
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View v ;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v=layoutInflater.inflate(R.layout.strarea_items,parent,false);
        return new MyViewHolder(v);
    }

    //Bağlama : hnagi pozisyonda ne gösterilsin gibi
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        //Hangi pozisyonda ne gösterilsin
        //holder.strArea.setText(countryList1.get(position).getStrArea());
        holder.getBindColor(regionList1.get(position),colors,position);
    }

    @Override
    public int getItemCount()
    {
        //Liste elemanları kadar döndür
        //kaçtane veri gelirse o kadar veri döndürür
        return regionList1.size();
    }



    //görünümler  tanımlanır
    //MyViewHolder'ın bir viewHolder olduğunu söyledik
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView strArea;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //Görünümler ile bağladık
            itemView.setOnClickListener(this);
        }

        //Satırlara renk ekle
        public void getBindColor(Region regionList1,String[] colors,Integer position)
        {
            //2 adet rengi döngüye aldım ve her satırda renklerden biri olacak
            itemView.setBackgroundColor(Color.parseColor(colors[position % 2 ]));
            strArea = itemView.findViewById(R.id.textViewStrArea);
            strArea.setText(regionList1.getStrArea());

        }

        @Override
        public void onClick(View v) {
            listener.onClick(itemView,getAdapterPosition());
        }
    }

    public  interface  RecyclerViewClickListener
    {
        void  onClick(View v,int posiiton );
    }

}
