package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Button zero, one, two, three, four, five, six, seven, eight, nine, spot;
    Button add, sub, mul, div;
    Button equal,AC,del;
    private boolean isOperatorSet = false;
    private String currentInput = "";
    private char lastOperator = '\0'; // 上一个操作符，初始设为无效字符
    private double firstNumber, secondNumber;

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
        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = "";
                temp = result.getText().toString().substring(0, result.length() - result.length());
                result.setText(temp + "");
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String temp = "";
                    temp = result.getText().toString().substring(0, result.length() - 1);
                    result.setText(temp + "");
                }catch(RuntimeException a){
                    result.setText("Error");
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
                if (!currentInput.contains(".")) {
                    appendNumberToResult(".");
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendNumberToResult("+");

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appendNumberToResult("-");
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appendNumberToResult("×");
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appendNumberToResult("÷");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation();
            }
        });
    }

    private void setOperator(char operator) {//运算符分隔数字
        if (!isOperatorSet) {
            firstNumber = Double.parseDouble(currentInput);
        } else if (lastOperator == '-') {
            secondNumber -= Double.parseDouble(currentInput);
        } else {
            secondNumber = Double.parseDouble(currentInput);
        }
        char lastOperator = this.lastOperator;
        this.lastOperator = operator;
        isOperatorSet = true;
        switch (lastOperator) {
            case '+':
                secondNumber += firstNumber;
                break;
            case '-':
                secondNumber -= firstNumber;
                break;
            case '*':
                secondNumber *= firstNumber;
                break;
            case '/':
                secondNumber /= firstNumber;
                break;
        }
    }

    private void appendNumberToResult(String number) {//输入数字和符号
        if(isOperatorSet==true){
            result.setText(null);
            result.setText(result.getText()+number);
            isOperatorSet=false;
        }else
            result.setText(result.getText()+number);
    }
    
    private void performCalculation() {//计算
        if (!isOperatorSet) {
            firstNumber = Double.parseDouble(currentInput);
        } else {
            secondNumber = Double.parseDouble(currentInput);
        }
        switch (lastOperator) {
            case '+':
                secondNumber += firstNumber;
                break;
            case '-':
                secondNumber -= firstNumber;
                break;
            case '*':
                secondNumber *= firstNumber;
                break;
            case '/':
                if (firstNumber != 0) {
                    secondNumber /= firstNumber;
                } else {
                    result.setText("Error: Division by zero");
                    return;
                }
                break;
        }
        currentInput = Double.toString(secondNumber);
        result.setText(currentInput);
        firstNumber = secondNumber;
        isOperatorSet = false;
    }

}







