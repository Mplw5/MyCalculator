package com.example.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Background extends AppCompatActivity {
    private ImageView imageView1, imageView3, imageView4, imageView5, imageView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.background_activity);

        imageView1 = findViewById(R.id.imageView_1);
        imageView3 = findViewById(R.id.imageView_3);
        imageView4 = findViewById(R.id.imageView_4);
        imageView5 = findViewById(R.id.imageView_5);
        imageView6 = findViewById(R.id.imageView_6);

        // 初始化ImageButton，并为其设置不同的ID
        ImageButton img1 = findViewById(R.id.imageButton);
        ImageButton img2 = findViewById(R.id.imageButton2);
        ImageButton img3 = findViewById(R.id.imageButton3);
        ImageButton img4 = findViewById(R.id.imageButton4);

        // 为ImageButton设置OnClickListener
        setOnImgButtonClickListener(img1, R.drawable.img_1, R.drawable.img_2);
        setOnImgButtonClickListener(img2, R.drawable.img, R.drawable.img2);
        setOnImgButtonClickListener(img3, R.drawable.img_3, R.drawable.img_5);
        setOnImgButtonClickListener(img4, R.drawable.img_4, R.drawable.img_6);

        // 返回主活动
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Background.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // 设置ImageButton点击事件的方法
    private void setOnImgButtonClickListener(ImageButton imgButton, int imgResId1, int imgResId2) {
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 为所有ImageView设置新的图片资源
                imageView1.setImageResource(imgResId1);
                imageView3.setImageResource(imgResId1);
                imageView4.setImageResource(imgResId1);
                imageView5.setImageResource(imgResId2);
                imageView6.setImageResource(imgResId2);
            }
        });
    }
}
