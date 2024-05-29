package com.example.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    Button zero, one, two, three, four, five, six, seven, eight, nine, spot,C;
    TextView result;
    private static final String TAG = "Calculator";
    private String mathNow = "";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        result = (TextView) findViewById(R.id.result);
        zero = findViewById(R.id.btn0);
        one = findViewById(R.id.btn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        spot = findViewById(R.id.spot);
        C = findViewById(R.id.C);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathNow += 0;
                result.setText(mathNow);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathNow += 1;
                result.setText(mathNow);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathNow += 2;
                result.setText(mathNow);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathNow += 3;
                result.setText(mathNow);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathNow += 4;
                result.setText(mathNow);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathNow += 5;
                result.setText(mathNow);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathNow += 6;
                result.setText(mathNow);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathNow += 7;
                result.setText(mathNow);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathNow += 8;
                result.setText(mathNow);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathNow += 9;
                result.setText(mathNow);
            }
        });
        spot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mathNow.contains(".")) {
                    mathNow += ".";
                    result.setText(mathNow);
                }
            }
        });
    }
    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent,3);
    }
}
