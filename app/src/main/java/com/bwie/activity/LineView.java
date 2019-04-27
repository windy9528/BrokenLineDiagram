package com.bwie.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author: 杨高峰(windy)
 * Date: 2019/4/27 9:05
 * Description:
 */
public class LineView extends View {


    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        invalidate();
    }

    private Paint paint;
    int startX = 100;
    int startY = 50;
    int stopX = 1000;
    int stopY = 1250;
    private String[] time = new String[]{"5:00", "10:00", "15:00", "20:00", "24:00"};
    private String[] quality = new String[]{
            "500", "差", "400", "中", "300", "良", "200", "好", "100", "优"
    };
    private Path mpath = new Path();
    ;


    public LineView(Context context) {
        this(context, null);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        this(context, null, 0);
        initView();
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        //新建画笔
        paint = new Paint();
        //设置画笔颜色
        paint.setTextSize(40);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int count = 0;
        int num = 0;

        drawLine(canvas);

        //画折线
        paint.setColor(Color.WHITE);
        mpath.moveTo(startX, startY);//原点出发
        mpath.lineTo(startX + 50, startY - 1200);
        mpath.lineTo(startX + 10, startY - 1150);

        canvas.drawPath(mpath, paint);

        canvas.drawLine(100, 1250, 150, 1200, paint);
        canvas.drawLine(150, 1200, 200, 1100, paint);
        canvas.drawLine(200, 1100, 250, 1050, paint);
        canvas.drawLine(250, 1050, 300, 950, paint);
        canvas.drawLine(300, 950, 350, 1150, paint);
        canvas.drawLine(350, 1150, 400, 400, paint);
        canvas.drawLine(400, 400, 450, 600, paint);
        canvas.drawLine(450, 600, 500, 700, paint);
        canvas.drawLine(500, 700, 550, 300, paint);
        canvas.drawLine(550, 300, 600, 500, paint);
        canvas.drawLine(600, 500, 650, 550, paint);
        canvas.drawLine(650, 550, 700, 700, paint);
        canvas.drawLine(700, 700, 750, 800, paint);
        canvas.drawLine(750, 800, 800, 850, paint);
        canvas.drawLine(800, 850, 850, 900, paint);
        canvas.drawLine(850, 900, 900, 100, paint);
        canvas.drawLine(900, 100, 950, 200, paint);


        //先画坐标轴
        //X轴
        canvas.drawLine(100, 1250, 1000, 1250, paint);
        //Y轴
        for (int i = 50; i <= 1250; i += 120) {
            if (i <= 50 + 120 * 2 && i > 50) {
                paint.setColor(Color.WHITE);
                canvas.drawLine(100, 50, 100, 290, paint);
            } else if (i <= 50 + 120 * 4 && i > 50 + 120 * 2) {
                paint.setColor(Color.RED);
                canvas.drawLine(100, 290, 100, 530, paint);
            } else if (i <= 50 + 120 * 6 && i > 50 + 120 * 4) {
                paint.setColor(Color.GREEN);
                canvas.drawLine(100, 530, 100, 770, paint);
            } else if (i <= 50 + 120 * 8 && i > 50 + 120 * 6) {
                paint.setColor(Color.YELLOW);
                canvas.drawLine(100, 770, 100, 910, paint);
            } else {
                //if (i <= 51 + 120 * 8 && i > 50 + 120 * 8)
                paint.setColor(Color.GREEN);
                canvas.drawLine(100, 910, 100, 1250, paint);
            }
        }
        //canvas.drawLine(100, 50, 100, 1250, paint);

        //画圆点
        paint.setColor(Color.WHITE);
        canvas.drawText("0", 100 - paint.measureText("0") / 2 - 30, 1250 + 50, paint);

        //横坐标
        for (int i = 150; i < 900; i += 150, count++) {
            //获得i
            paint.setColor(Color.BLUE);
            float textWidth = paint.measureText(time[count]);
            canvas.drawText(time[count], startX + i - textWidth / 2, stopY + 50, paint);
        }

        //纵坐标
        for (int i = 50; i < 50 + 120 * 2; i += 120, num++) {
            paint.setColor(Color.WHITE);
            float textHeight = paint.measureText(quality[num]);
            canvas.drawText(quality[num], startX - 80, startY + i - textHeight / 2, paint);
        }
        for (int i = 50 + 120 * 2; i < 50 + 120 * 4; i += 120, num++) {
            paint.setColor(Color.RED);
            float textHeight = paint.measureText(quality[num]);
            canvas.drawText(quality[num], startX - 80, startY + i - textHeight / 2, paint);
        }
        for (int i = 50 + 120 * 4; i < 50 + 120 * 6; i += 120, num++) {
            paint.setColor(Color.GREEN);
            float textHeight = paint.measureText(quality[num]);
            canvas.drawText(quality[num], startX - 80, startY + i - textHeight / 2, paint);
        }
        for (int i = 50 + 120 * 6; i < 50 + 120 * 8; i += 120, num++) {
            paint.setColor(Color.YELLOW);
            float textHeight = paint.measureText(quality[num]);
            canvas.drawText(quality[num], startX - 80, startY + i - textHeight / 2, paint);
        }
        for (int i = 50 + 120 * 8; i < 50 + 120 * 10; i += 120, num++) {
            paint.setColor(Color.GREEN);
            float textHeight = paint.measureText(quality[num]);
            canvas.drawText(quality[num], startX - 80, startY + i - textHeight / 2, paint);
        }


    }

    private void drawLine(Canvas canvas) {

    }
}
