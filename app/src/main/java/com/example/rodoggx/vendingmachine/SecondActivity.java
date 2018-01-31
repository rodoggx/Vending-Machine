package com.example.rodoggx.vendingmachine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        String submittedCoins = intent.getStringExtra("submitted_coins");
        String productPrice = intent.getStringExtra("product_price");
        String selectedCola = intent.getStringExtra("selected_cola");
        String selectedChips = intent.getStringExtra("selected_chips");
        String selectedCandy = intent.getStringExtra("selected_candy");

        TextView coinTextView = (TextView) findViewById(R.id.coins);
        TextView priceTextView = (TextView) findViewById(R.id.price);
        TextView colaTextView = (TextView) findViewById(R.id.product_cola);
        TextView chipsTextView = (TextView) findViewById(R.id.product_chips);
        TextView candyTextView = (TextView) findViewById(R.id.product_candy);

        if (submittedCoins == null) {
            coinTextView.setVisibility(View.GONE);
        } else {
            coinTextView.setText(submittedCoins);
        }

        if (selectedCola == null) {
            colaTextView.setVisibility(View.GONE);
        } else {
            colaTextView.setText(selectedCola);
        }

        if (selectedChips == null) {
            chipsTextView.setVisibility(View.GONE);
        } else {
            chipsTextView.setText(selectedChips);
        }

        if (selectedCandy == null) {
            candyTextView.setVisibility(View.GONE);
        } else {
            candyTextView.setText(selectedCandy);
        }

        if (productPrice == null) {
            priceTextView.setVisibility(View.GONE);
        } else {
            priceTextView.setText(productPrice);
        }
    }


}
