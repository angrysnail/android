package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;

public class RotateActivity extends Activity {

    private int currAngle;
    private View piechart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rotate);

        piechart = findViewById(R.id.piechart);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        piechart.startAnimation(animation);
    }

    int i = 0;


    public void positive(View v) {
        Animation anim = new RotateAnimation(currAngle, currAngle + 180, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        Animation anim2 = new RotateAnimation(currAngle, currAngle + 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        i++;
        i = i % 9;
        /** 匀速插值器 */
        Interpolator lir = new LinearInterpolator();
        if (i == 1)
            lir = new AccelerateDecelerateInterpolator();
        if (i == 2)
            lir = new AccelerateInterpolator();
        if (i == 3)
            lir = new AnticipateInterpolator();
        if (i == 4)
            lir = new AnticipateOvershootInterpolator();
        if (i == 5)
            lir = new BounceInterpolator();
        if (i == 6)
            lir = new CycleInterpolator(0.5f);
        if (i == 7)
            lir = new DecelerateInterpolator();
        if (i == 8)
            lir = new OvershootInterpolator();

        anim.setInterpolator(lir);
        anim.setDuration(1000);
        /** 动画完成后不恢复原状 */
        anim.setFillAfter(true);
        currAngle += 180;
        if (currAngle > 360) {
            currAngle = currAngle - 360;
        }
        piechart.startAnimation(anim);
    }

    public void negative(View v) {
        Animation anim = new RotateAnimation(currAngle, currAngle - 180, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        /** 匀速插值器 */
        DecelerateInterpolator lir = new DecelerateInterpolator();
        anim.setInterpolator(lir);
        anim.setDuration(1000);
        /** 动画完成后不恢复原状 */
        anim.setFillAfter(true);
        currAngle -= 180;
        if (currAngle < -360) {
            currAngle = currAngle + 360;
        }
        piechart.startAnimation(anim);
    }
}