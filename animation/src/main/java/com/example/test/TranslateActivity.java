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
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class TranslateActivity extends Activity {

    private ImageView trans_iamge;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translate);
        trans_iamge = (ImageView) findViewById(R.id.trans_image);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate);

        trans_iamge.startAnimation(anim);
    }

    public void translate(View view) {
        Animation anim = new TranslateAnimation(200, 0, 300, 0);
        anim.setFillAfter(true);
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
        anim.setDuration(2000);
        anim.setFillAfter(true);
//        OvershootInterpolator overshoot = new OvershootInterpolator();
//        anim.setInterpolator(overshoot);
        trans_iamge.startAnimation(anim);
    }
}
