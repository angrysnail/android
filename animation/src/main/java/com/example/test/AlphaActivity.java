package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

public class AlphaActivity extends Activity implements AnimationListener {

    private ImageView splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alpha);

        splash = (ImageView) findViewById(R.id.splash);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.setAnimationListener(this);
        splash.startAnimation(anim);
    }

    int i = 0;

    public void alpha(View view) {
        Animation anim = new AlphaAnimation(1.0f, 0.0f);

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


        anim.setDuration(3000);
        anim.setFillAfter(true);
        splash.startAnimation(anim);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        Log.i("alpha", "onAnimationStart called.");
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Log.i("alpha", "onAnimationEnd called");
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        Log.i("alpha", "onAnimationRepeat called");
    }
}
