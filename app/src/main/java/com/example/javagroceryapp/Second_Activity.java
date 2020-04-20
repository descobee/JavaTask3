package com.example.javagroceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Second_Activity extends AppCompatActivity {
    TextView text1, text2;
    ImageView image1;
    String word1;
    int pics, price1;

    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        number = 0;
        TextView text4 = findViewById(R.id.dogCount);
        text4.setText(String.valueOf(number));

        text1 = findViewById(R.id.SAname);
        text2 = findViewById(R.id.SAprice);
        image1 = findViewById(R.id.image2);

        getDogs();
        setDogs();
    }
    public void getDogs(){
        if (getIntent().hasExtra("name1") && getIntent().hasExtra("price1") &&
                getIntent().hasExtra("image1"));

        word1 = getIntent().getStringExtra("name1");
        price1 = getIntent().getIntExtra("price1", 1);
        pics = getIntent().getIntExtra("image1", 1);
    }
    public void setDogs(){
        text1.setText(word1);
        text2.setText(String.valueOf(price1));
        image1.setImageResource(pics);
    }

    public void reduceClick(View view) {
        number--;
        TextView text4 = findViewById(R.id.dogCount);
        text4.setText(String.valueOf(number));
    }

    public void addClick(View view) {
        number++;
        TextView text4 = findViewById(R.id.dogCount);
        text4.setText(String.valueOf(number));
    }

    public void orderClick(View view) {
        Toast.makeText(this, "Your Order Has Been Taken", Toast.LENGTH_SHORT).show();
        Intent intent2 = new Intent(this, Third_Activity.class);
        intent2.putExtra("SA1", number);
        intent2.putExtra("SA4", price1);
        intent2.putExtra("SA2", pics);
        intent2.putExtra("SA3", word1);
        startActivity(intent2);
    }
}
