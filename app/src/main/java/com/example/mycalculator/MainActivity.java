package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Button zero, one, two, three, four, five, six, seven, eight, nine, spot,cvt;
    Button add, sub, mul, div;
    Button equal,AC,del,button_style,exchangeButton,text_color;
    ImageView background;
    private boolean isOperatorSet = false;
    private String mathNow = "";
    private int precision = 2;
    private BaseCalculator baseCalculator = new BaseCalculator();
    private static final String TAG = "Calculator";
    private int currentStyle = 1; // 1 表示 buttonstyle1，2 表示 buttonstyle2
    private List<Button> allButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        background = findViewById(R.id.imageView);
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
        button_style= findViewById(R.id.button_style);
        text_color= findViewById(R.id.text_color);
        exchangeButton = findViewById(R.id.exchange);

        List<Button> allButtons = new ArrayList<>();
        allButtons.add(findViewById(R.id.btn0));
        allButtons.add(findViewById(R.id.btn1));
        allButtons.add(findViewById(R.id.btn2));
        allButtons.add(findViewById(R.id.btn3));
        allButtons.add(findViewById(R.id.btn4));
        allButtons.add(findViewById(R.id.btn5));
        allButtons.add(findViewById(R.id.btn6));
        allButtons.add(findViewById(R.id.btn7));
        allButtons.add(findViewById(R.id.btn8));
        allButtons.add(findViewById(R.id.btn9));
        allButtons.add(findViewById(R.id.spot));
        allButtons.add(findViewById(R.id.subtract));
        allButtons.add(findViewById(R.id.multiply));
        allButtons.add(findViewById(R.id.divide));
        allButtons.add(findViewById(R.id.equal));
        allButtons.add(findViewById(R.id.AC));
        allButtons.add(findViewById(R.id.Del));
        allButtons.add(findViewById(R.id.Cvt));
        allButtons.add(findViewById(R.id.text_color));
        allButtons.add(findViewById(R.id.button_style));
        allButtons.add(findViewById(R.id.exchange));
        this.allButtons = allButtons;

        updateBackgroundImage();

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
        exchangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 切换样式
                currentStyle = (currentStyle == 1) ? 2 : 1;
                toggleButtonStyle();
                updateBackgroundImage(); // 更新背景图片
            }
        });


    }

    private void toggleButtonStyle() {
        int styleResId;
        if (currentStyle == 1) {
            styleResId = R.style.style1;
        } else {
            styleResId = R.style.style2;
        }
        for (Button button : allButtons) {
            button.setTextAppearance(this, styleResId);
        }
    }

    private void updateBackgroundImage() {
        int imgResId;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (currentStyle == 1) {
                imgResId = R.drawable.img_1;
            } else {
                imgResId = R.drawable.img;
            }
        } else {
            if (currentStyle == 1) {
                imgResId = R.drawable.img_2;
            } else {
                imgResId = R.drawable.img2;
            }
        }
        background.setImageResource(imgResId);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateBackgroundImage();
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







