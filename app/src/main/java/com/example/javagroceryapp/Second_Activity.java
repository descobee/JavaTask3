package com.example.javagroceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Second_Activity extends AppCompatActivity {
    TextView text1, text2,text4;
    ImageView image1;
    String word1, word2, word3;
    int pics, number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        text1 = findViewById(R.id.SAname);
        text2 = findViewById(R.id.SAprice);
        text4 = findViewById(R.id.dogCount);
        image1 = findViewById(R.id.dogImage);
        number = 0;
        text4.setText(String.valueOf(number));

        getDogs();
        setDogs();
    }
    public void getDogs(){
        if (getIntent().hasExtra("name1") && getIntent().hasExtra("name2") &&
                getIntent().hasExtra("name4"));

        word1 = getIntent().getStringExtra("name1");
        word2 = getIntent().getStringExtra("name2");
        pics = getIntent().getIntExtra("name4", 1);
    }
    public void setDogs(){
        text1.setText(word1);
        text2.setText(word2);
        image1.setImageResource(pics);
    }

    public void addClick(View view) {
        number++;
        text4.setText(String.valueOf(number));
    }

    public void removeClick(View view) {
        number--;
        text4.setText(String.valueOf(number));
    }

    public void orderClick(View view) {
        Toast.makeText(this, "Your Order Has Been Taken", Toast.LENGTH_LONG).show();
        Intent intent2 = new Intent(this, Third_Activity.class);
        intent2.putExtra("SA1", number);
        intent2.putExtra("SA4", word2);
        intent2.putExtra("SA2", pics);
        intent2.putExtra("SA3", word1);
        startActivity(intent2);
    }
}
