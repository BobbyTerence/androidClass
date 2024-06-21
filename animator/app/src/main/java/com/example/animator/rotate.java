package com.example.animator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class rotate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);
        ImageView imgAnim = (ImageView) findViewById(R.id.animImage);
        imgAnim.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));

        Button btnRtn = (Button)findViewById(R.id.btnHome);

        btnRtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(rotate.this, MainActivity.class));
            }
        });
    }
}