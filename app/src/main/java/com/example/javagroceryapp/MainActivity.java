package com.example.javagroceryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String dogName [];
    String [] dogPrice;
    int [] dogPhoto = {R.drawable.dog1, R.drawable.american_staffordshire_terrier, R.drawable.australian_shepherd, R.drawable.beagle,
            R.drawable.golden_retriever, R.drawable.shetland_sheep_dog, R.drawable.pembroke_welsh_corgi};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerName);
        dogName = getResources().getStringArray(R.array.dog_names);
        dogPrice = getResources().getStringArray(R.array.dog_price);

        myAdapter myAdapter = new myAdapter(this, dogName, dogPrice, dogPhoto);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
