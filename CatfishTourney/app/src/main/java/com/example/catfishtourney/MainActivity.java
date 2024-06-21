package com.example.catfishtourney;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //Create Variables
    private Map<String, Double> fishWeights = new HashMap<>();
    private List<Fish> fishList = new ArrayList<>();
    private TextView fcTxt;
    private TextView wgtTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fcTxt = findViewById(R.id.fcTxt);
        wgtTxt = findViewById(R.id.wgtTxt);
    }

    /*
     * the method addFish is called utilizing the android:onclick property on the images
     */
    public void addFish(View view) {
        ImageView imageView = (ImageView) view;
        String tag = imageView.getTag().toString();
        promptUserForWeight(tag);
    }

    private void promptUserForWeight(final String fishType) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Weight");

        // Set up the input
        final EditText input = new EditText(this);
        input.setHint("Weight");
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL); // Restricts input type allowed
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String weightStr = input.getText().toString();
                if (!weightStr.isEmpty()) {
                    double weight = Double.parseDouble(weightStr);
                    weight = calculateFishWeight(fishType, weight);
                    addFishToList(fishType, weight);
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private double calculateFishWeight(String fishType, double weight) {
        switch (fishType) {
            case "blue":
                return weight;
            case "flathead":
                return weight * 1.25;
            case "channel":
                return weight * 0.75;
            default:
                return weight;
        }
    }

    /*
     * Adds a fish to the list
     */
    private void addFishToList(String fishType, double weight) {
        if (fishList.size() >= 3) {
            removeSmallestFish();
        }
        fishList.add(new Fish(fishType, weight));
        updateFishCountAndWeight();
    }

    /*
     * Utilized to remove the smallest fish from the list
     */
    private void removeSmallestFish() {
        Fish smallestFish = Collections.min(fishList);
        fishList.remove(smallestFish);
    }

    /*
     * This method is used to update the fish count and weight on the screen
     */
    private void updateFishCountAndWeight() {
        int totalCount = fishList.size();
        double totalWeight = 0;

        for (Fish fish : fishList) {
            totalWeight += fish.getWeight();
        }

        //tvFishCountWeight.setText("Fish Count: " + totalCount + " | Total Weight: " + totalWeight + " lbs");
        fcTxt.setText(String.valueOf(totalCount));
        wgtTxt.setText(String.format(Locale.US, "%.1f lbs", totalWeight));
    }

    /*
     * The class Fish is created and designed in order to more conveniently store information
     * about each fish that is caught and kept for the tourney
     */
    private static class Fish implements Comparable<Fish> {
        private String type;
        private double weight;

        public Fish(String type, double weight) {
            this.type = type;
            this.weight = weight;
        }

        public String getType() {
            return type;
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Fish other) {
            return Double.compare(weight, other.weight);
        }
    }
}

