package com.example.javagroceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Third_Activity extends AppCompatActivity {
    int pics, number, amount;
    String name1;
    ImageView photo;
    TextView words, price, totall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_);

        words = findViewById(R.id.finalName);
        price = findViewById(R.id.lastPrice);
        photo = findViewById(R.id.lastImage);
        totall = findViewById(R.id.total);

        getCheckOut();
        setCheckOut();
    }

    public void getCheckOut(){
        if (getIntent().hasExtra("SA1") && getIntent().hasExtra("SA2") && getIntent().hasExtra("SA3") && getIntent().hasExtra("SA4"));
        number = getIntent().getIntExtra("SA1", 1);
        name1 = getIntent().getStringExtra("SA3");
        pics = getIntent().getIntExtra("SA2", 1);
        amount = getIntent().getIntExtra("SA4", 1);
    }
    public void setCheckOut(){
        words.setText(name1);
        photo.setImageResource(pics);
        price.setText(String.valueOf(amount));
        totall.setText(String.valueOf("Total Amount = "+amount*number));
    }

    public void shareIt(View view) {
        Toast.makeText(this, "Choose where you wish to share your order", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Dog Name: "+name1+"\n\nNumber of Dogs Selected: "+number+
                "\n\nTotal Price of Dog(s): "+amount*number);
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "Share using"));
    }
}
