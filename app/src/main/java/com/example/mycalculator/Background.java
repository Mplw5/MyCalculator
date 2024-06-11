package com.example.mycalculator;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Background  extends AppCompatActivity {

    private String cityName;
    private TextView tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.background_activity);

    }
    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent,3);
    }

}