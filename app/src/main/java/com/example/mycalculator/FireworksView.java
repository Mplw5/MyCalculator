package com.example.mycalculator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class FireworksView extends View {

    private Firework[] fireworks;

    public FireworksView(Context context) {
        super(context);
        init();
    }

    public FireworksView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FireworksView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        fireworks = new Firework[100]; // 创建100个烟花粒子
        for (int i = 0; i < fireworks.length; i++) {
            fireworks[i] = new Firework();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(0xFFFF0000); // 红色

        for (Firework firework : fireworks) {
            canvas.drawCircle(firework.x, firework.y, 10, paint);
            // 更新烟花粒子的位置
            firework.update();
        }

        // 重新绘制，产生动画效果
        invalidate();
    }

    private class Firework {
        float x, y, dx, dy, life;

        public Firework() {
            reset();
        }

        public void reset() {
            x = getWidth() / 2;
            y = getHeight();
            dx = (float) (Math.random() * 6) - 3;
            dy = (float) (-Math.random() * 10) - 10; // 向上移动
            life = 0;
        }

        public void update() {
            if (life > 100) {
                reset();
            }
            life++;
            x += dx;
            y += dy;
            dy += 0.1; // 重力效果
        }
    }
}

