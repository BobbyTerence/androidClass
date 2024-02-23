package com.example.wtffarmsounds;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class farmActivity extends AppCompatActivity {
    Button chkBtn, cowBtn, pigBtn;
    MediaPlayer mpChk, mpCow, mpPig;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm);

        //Assign buttons
        chkBtn = (Button) findViewById(R.id.btnChk);
        cowBtn = (Button) findViewById(R.id.btnCow);
        pigBtn = (Button) findViewById(R.id.btnPig);

        //Point to the overloaded onClick function
        chkBtn.setOnClickListener(chicken);
        cowBtn.setOnClickListener(cow);
        pigBtn.setOnClickListener(pig);

        //Create Media player objects for each button and assign file to read
        mpChk = new MediaPlayer();
        mpChk = MediaPlayer.create(this, R.raw.chicken);
        mpCow = new MediaPlayer();
        mpCow = MediaPlayer.create(this, R.raw.cows);
        mpPig = new MediaPlayer();
        mpPig = MediaPlayer.create(this, R.raw.pigs);
        //Set Playing state
        playing = 0;
    }

    Button.OnClickListener chicken = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(playing) {
                case 0:
                    mpChk.start();
                    playing = 1;
                    chkBtn.setText("Pause Chicken");
                    cowBtn.setVisibility(View.INVISIBLE);
                    pigBtn.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpChk.pause();
                    playing = 0;
                    chkBtn.setText("Play Chicken");
                    cowBtn.setVisibility(View.VISIBLE);
                    pigBtn.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    Button.OnClickListener cow = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(playing) {
                case 0:
                    mpCow.start();
                    playing = 1;
                    cowBtn.setText("Pause Cow");
                    chkBtn.setVisibility(View.INVISIBLE);
                    pigBtn.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpCow.pause();
                    playing = 0;
                    cowBtn.setText("Play Cow");
                    chkBtn.setVisibility(View.VISIBLE);
                    pigBtn.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
    Button.OnClickListener pig = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(playing) {
                case 0:
                    mpPig.start();
                    playing = 1;
                    pigBtn.setText("Pause Pig");
                    cowBtn.setVisibility(View.INVISIBLE);
                    chkBtn.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpPig.pause();
                    playing = 0;
                    pigBtn.setText("Play Pig");
                    cowBtn.setVisibility(View.VISIBLE);
                    chkBtn.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}