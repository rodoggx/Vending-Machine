package com.example.rodoggx.vendingmachine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {
    CheckBox colaCheckbox, chipsCheckbox, candyCheckbox;
    EditText editText;
    Button button;
    String cola, chips, candy, coinStr, priceStr;
    double price = 0.0;
    StringBuffer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // sets the layout of the activity to activity_main.xml
        setContentView(R.layout.activity_main);

        colaCheckbox = (CheckBox) findViewById(R.id.select_cola);
        chipsCheckbox = (CheckBox) findViewById(R.id.select_chips);
        candyCheckbox = (CheckBox) findViewById(R.id.select_candy);

        editText = (EditText) findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.submit_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //assign the checkbox value
                result = new StringBuffer();
                cola = null;
                chips = null;
                candy = null;
                price = 0.0;

                if (colaCheckbox.isChecked()) {
                    cola = "$1.00 Cola";
                    result.append(cola);
                    price += 1.00;
                }
                if (chipsCheckbox.isChecked()) {
                    chips = "$.50 Chips";
                    result.append(chips);
                    price += .50;
                }
                if (candyCheckbox.isChecked()) {
                    candy = "$.65 Candy";
                    result.append(candy);
                    price += .65;
                }
                if (!colaCheckbox.isChecked()
                        && !chipsCheckbox.isChecked()
                        && !candyCheckbox.isChecked()) {
                    result.append("Nothing selected.");
                }

                //assign edit text value
                coinStr = editText.getText().toString();
                priceStr = String.valueOf(price);
                //display a toast
                Toast toast = Toast.makeText(getBaseContext(),
                        "Submitted",
                        Toast.LENGTH_SHORT);
                toast.show();

                startSecondActivity(view);
            }
        });
    }

    public void startSecondActivity(View view) {
        Intent startIntent = new Intent(this, SecondActivity.class);

        startIntent.putExtra("submitted_coins", coinStr);
        startIntent.putExtra("product_price", priceStr);
        startIntent.putExtra("selected_cola", cola);
        startIntent.putExtra("selected_chips", chips);
        startIntent.putExtra("selected_candy", candy);

        startActivity(startIntent);
    }
}