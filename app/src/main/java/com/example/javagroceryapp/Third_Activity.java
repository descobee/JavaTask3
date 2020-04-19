package com.example.javagroceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Third_Activity extends AppCompatActivity {
    int pics, number, amount;
    String name1;
    ImageView photo;
    TextView words, price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_);

        words = findViewById(R.id.finalName);
        price = findViewById(R.id.lastPrice);
        photo = findViewById(R.id.lastImage);

        getCheckOut();
        setCheckOut();

    }

    public void getCheckOut(){
        if (getIntent().hasExtra("SA1") && getIntent().hasExtra("SA2") && getIntent().hasExtra("SA3") && getIntent().hasExtra("SA4"));
        name1 = getIntent().getStringExtra("SA4");
        number = getIntent().getIntExtra("SA1", 1);
        pics = getIntent().getIntExtra("SA2", 1);
        amount = getIntent().getIntExtra("SA3", 1);
    }
    public void setCheckOut(){
        words.setText(name1);
        price.setText(String.valueOf(amount*number));
        photo.setImageResource(pics);
    }

    public void shareIt(View view) {
        Toast.makeText(this, "Your order has been shared to Gmail", Toast.LENGTH_LONG).show();
    }
}
