package com.example.wflowersconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Create Variables
    double conversionRate;
    double usdEntered;
    double convertedAmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);*/

        //Assign given value to a constant
        final EditText weight = (EditText) findViewById(R.id.usdCon);

        //Assign Values to selected Radio Buttons
        final RadioButton euroCon = (RadioButton) findViewById(R.id.euroCon);
        final RadioButton pesoCon = (RadioButton) findViewById(R.id.pesoCon);
        final RadioButton cadCon = (RadioButton) findViewById(R.id.cadCon);
        final RadioButton randCon = (RadioButton) findViewById(R.id.randCon);

        //Create a value to represent the Result text box
        final TextView result = (TextView) findViewById(R.id.txtResult);

        //Create the button variable to listen to
        Button convert = (Button) findViewById(R.id.btnConvert);

        //Set conversion rates and error when over $100,000 has been entered
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usdEntered = Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.##");
                if(euroCon.isChecked()) {
                    if(usdEntered <= 100000.00) {
                        conversionRate = .92;
                        convertedAmt = usdEntered * conversionRate;
                        result.setText(String.format("%s Euros", tenth.format(convertedAmt)));
                    } else {
                        Toast.makeText(MainActivity.this,"Amount entered must be less than 100,000", Toast.LENGTH_LONG).show();
                    }
                }
                if(pesoCon.isChecked()) {
                    if(usdEntered <= 100000.00) {
                        conversionRate = 17.23;
                        convertedAmt = usdEntered * conversionRate;
                        result.setText(String.format("%s Pesos", tenth.format(convertedAmt)));
                    } else {
                        Toast.makeText(MainActivity.this,"Amount entered must be less than 100,000", Toast.LENGTH_LONG).show();
                    }
                }
                if(cadCon.isChecked()) {
                    if(usdEntered <= 100000.00) {
                        conversionRate = 1.34;
                        convertedAmt = usdEntered * conversionRate;
                        result.setText(String.format("%s Canadian Dollar", tenth.format(convertedAmt)));
                    } else {
                        Toast.makeText(MainActivity.this,"Amount entered must be less than 100,000", Toast.LENGTH_LONG).show();
                    }
                }
                if(randCon.isChecked()) {
                    if(usdEntered <= 100000.00) {
                        conversionRate = 18.86;
                        convertedAmt = usdEntered * conversionRate;
                        result.setText(String.format("%s South African Rand", tenth.format(convertedAmt)));
                    } else {
                        Toast.makeText(MainActivity.this,"Amount entered must be less than 100,000", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}