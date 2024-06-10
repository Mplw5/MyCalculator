package com.example.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Background extends AppCompatActivity {
    private ImageButton img1,img2,img3,img4,back;
    private ImageView someImageView;
    private SharedViewModel sharedViewModel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.background_activity);

        ImageButton img1 = findViewById(R.id.imageButton);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton img2 = findViewById(R.id.imageButton);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton img3 = findViewById(R.id.imageButton);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton img4 = findViewById(R.id.imageButton);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent,3);
    }
}
