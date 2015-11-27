package com.android.angrysnail.sample;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.android.angrysnail.sample.chart.CusCanvas;
import com.android.angrysnail.sample.time.R;

import java.util.Timer;
import java.util.TimerTask;

public class TimerActivity extends AppCompatActivity {
    private ProgressBar bar1 = null;
    private int progress = 0;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.layout_timer);
        bar1 = (ProgressBar) findViewById(R.id.progressBar1);
        Timer timer = new Timer();
        final Handler handler = new Handler();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        bar1.setProgress(progress++);
                        //下面这一句会报错，不能运行
                        //final CusCanvas a = (CusCanvas) findViewById(R.id.calendarView);
                        //a.drawText();
                    }
                });
            }
        }, 0, 500);
    }
}
