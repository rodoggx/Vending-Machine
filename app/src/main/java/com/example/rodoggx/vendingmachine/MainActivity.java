package com.example.rodoggx.vendingmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {
    CheckBox colaCheckbox, chipsCheckbox, candyCheckbox;
    EditText editText;
    Button button;

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
                double price = 0.0;
                //assign the checkbox value
                StringBuffer result = new StringBuffer();

                if (colaCheckbox.isChecked()) {
                    result.append("$1.00 Cola selected. ");
                    price += 1.00;
                }
                if (chipsCheckbox.isChecked()) {
                    result.append("$.50 Chips selected. ");
                    price += .50;
                }
                if (candyCheckbox.isChecked()) {
                    result.append("$.65 Candy selected.");
                    price += .65;
                }
                if (!colaCheckbox.isChecked()
                        && !chipsCheckbox.isChecked()
                        && !candyCheckbox.isChecked()) {
                    result.append("Nothing selected.");
                }

                //assign edit text value
                String coinStr = editText.getText().toString();
                //display a toast
                Toast toast = Toast.makeText(getBaseContext(),
                        result.toString() + "\n" + "Total is " + price + "\n"
                                 + "You submitted " + coinStr + "\nTHANK YOU",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

}