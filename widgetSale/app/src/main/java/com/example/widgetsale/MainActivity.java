package com.example.widgetsale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //Variables for ticket price
    final double bluWid = 2.5;
    final double grnWid = 3.0;
    final double ylwWid = 4.5;
    final double redWid = 5.0;

    //Variables for rest of program
    int numWid;
    double widCost;
    double totalPrice;
    String widgetChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText widgets = (EditText)findViewById(R.id.txtWid);
        final Spinner widget = (Spinner)findViewById(R.id.arrWid);
        Button cost = (Button)findViewById (R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = (TextView)findViewById(R.id.costDis);
            @Override
            public void onClick(View v) {
                numWid = Integer.parseInt(widgets.getText().toString());
                widgetChoice = widget.getSelectedItem().toString();
                switch (widgetChoice) {
                    case "Blue":
                        widCost = bluWid;
                        break;
                    case "Green":
                        widCost = grnWid;
                        break;
                    case "Yellow":
                        widCost = ylwWid;
                        break;
                    case "Red":
                        widCost = redWid;
                        break;
                    default:
                        break;
                }
                totalPrice = widCost * numWid;
                DecimalFormat currency = new DecimalFormat("$###,###.##");

                result.setText(String.format("Cost for %s is %s", widgetChoice, currency.format(totalPrice)));
            }
        });
    }
}