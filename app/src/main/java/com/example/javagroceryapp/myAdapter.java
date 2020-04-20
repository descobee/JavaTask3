package com.example.javagroceryapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {
    private Context mContext;
    private String [] dogNames;
    private int [] dogImage, dogPrices;

    public myAdapter(Context mContext, String[] dogNames, int[] dogPrices, int[] dogImage) {
        this.mContext = mContext;
        this.dogNames = dogNames;
        this.dogPrices = dogPrices;
        this.dogImage = dogImage;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {

        holder.text1.setText(dogNames[position]);
        holder.text2.setText(String.valueOf(dogPrices[position]));
        holder.image1.setImageResource(dogImage[position]);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,Second_Activity.class);
                intent.putExtra("name1", dogNames[position]);
                intent.putExtra("price1", dogPrices[position]);
                intent.putExtra("image1", dogImage[position]);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dogImage.length;
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView text1, text2;
        ImageView image1;
        CardView parent;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.dogName);
            text2 = itemView.findViewById(R.id.dogPrice);
            image1 = itemView.findViewById(R.id.dogImage);
            parent = itemView.findViewById(R.id.Card);
        }
    }
}
