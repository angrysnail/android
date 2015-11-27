package com.android.angrysnail.sample.chart;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by canyongz on 2015/11/23.
 */
public class CusCanvas extends View {

    public CusCanvas(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private android.graphics.Canvas canvas;
    int a = 0;

    public void drawText() {
        if (canvas == null) {
            return;
        }
        Paint p = new Paint();
        p.setTextSize(32);
        p.setColor(Color.RED);
        canvas.drawText("UIOPIOIO" + new Random().nextFloat(), 22f + a++, 44f + a++, p);
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
    }
}
