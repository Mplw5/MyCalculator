package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Button zero, one, two, three, four, five, six, seven, eight, nine, spot,cvt;
    Button add, sub, mul, div;
    Button equal,AC,del;
    private boolean isOperatorSet = false;
    private String mathNow = "";
    private int precision = 2;
    private BaseCalculator baseCalculator = new BaseCalculator();
    private static final String TAG = "Calculator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        add = findViewById(R.id.add);
        sub = findViewById(R.id.subtract);
        mul = findViewById(R.id.multiply);
        div = findViewById(R.id.divide);
        equal = findViewById(R.id.equal);
        AC = findViewById(R.id.AC);
        del = findViewById(R.id.Del);
        cvt = findViewById(R.id.Cvt);
        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathNow = "";
                result.setText("");
                isOperatorSet = false;
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mathNow.isEmpty()) {
                    String temp = mathNow.substring(0, mathNow.length() - 1);
                    mathNow = temp;
                    result.setText(mathNow);
                }
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
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult(" + ");
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult(" - ");
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult(" × ");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult(" ÷ ");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = "";
                temp = result.getText().toString().substring(0, result.length() - result.length());
                mathNow = result.getText().toString();
                double resul = baseCalculator.cal(mathNow,precision); //调用科学计算器
                String res = String.valueOf(resul);
                if (resul == Double.MAX_VALUE)
                    result.setText(temp + "ERROR");
                else {
                    result.setText(temp + res);
                }
            }
        });

    }
    public void Cvt(View v) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivityForResult(intent,3);
    }

    private void appendNumberToResult(String number) {
        if (isOperatorSet) {
            mathNow = number;
            isOperatorSet = false;
        } else {
            mathNow += number;
        }
        result.setText(mathNow); // 更新显示的内容
    }


}







