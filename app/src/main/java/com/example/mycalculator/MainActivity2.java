package com.example.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    Button zero, one, two, three, four, five, six, seven, eight, nine, spot,C,Area,Length,volume,temp,weight,speed;
    private double Number,res;
    private static final String TAG = "Calculator";
    private boolean isOperatorSet = false;
    private String mathNow = "";
    TextView result,num;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        result = (TextView) findViewById(R.id.result);
        num = (TextView)findViewById(R.id.num);
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
        Area = findViewById(R.id.Area);
        Length = findViewById(R.id.Length);
        volume = findViewById(R.id.volume);
        temp = findViewById(R.id.temp);
        weight = findViewById(R.id.weight);
        speed = findViewById(R.id.speed);
        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathNow = "";
                result.setText("");
                num.setText("");
                isOperatorSet = false;
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult("0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult("9");
            }
        });
        spot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mathNow.contains(".")) {
                    appendNumberToResult(".");
                }
            }
        });
        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = num.getText().toString();
                if(!TextUtils.isEmpty(string)) {
                    Number = Double.parseDouble(string);
                }
                res = Number * 2.4710538147;
                String ans = String.format("%f",res);
                result.setText(ans+"ac");
                }
        });
        Length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = num.getText().toString();
                if(!TextUtils.isEmpty(string)) {
                    Number = Double.parseDouble(string);
                }
                res = Number * 3.280839895;
                String ans = String.format("%f",res);
                result.setText(ans+"ft");
            }
        });
        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = num.getText().toString();
                if(!TextUtils.isEmpty(string)) {
                    Number = Double.parseDouble(string);
                }
                res = Number * 35.3146667215;
                String ans = String.format("%f",res);
                result.setText(ans+"ft^3");
            }
        });
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = num.getText().toString();
                if(!TextUtils.isEmpty(string)) {
                    Number = Double.parseDouble(string);
                }
                res = Number * 33.8;
                String ans = String.format("%f",res);
                result.setText(ans+"℉");
            }
        });
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = num.getText().toString();
                if(!TextUtils.isEmpty(string)) {
                    Number = Double.parseDouble(string);
                }
                res = Number * 2.2046226218;
                String ans = String.format("%f",res);
                result.setText(ans+"lb");
            }
        });
        speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = num.getText().toString();
                if(!TextUtils.isEmpty(string)) {
                    Number = Double.parseDouble(string);
                }
                res = Number * 3.6;
                String ans = String.format("%f",res);
                result.setText(ans+"km/h");
            }
        });
    }
    private void appendNumberToResult(String number) {
        if (isOperatorSet) {
            mathNow = number;
            isOperatorSet = false;
        } else {
            mathNow += number;
        }
        num.setText(mathNow);
    }
    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent,3);
    }
}
