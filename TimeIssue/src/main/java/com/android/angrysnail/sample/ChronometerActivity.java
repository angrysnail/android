package com.android.angrysnail.sample;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;

import com.android.angrysnail.sample.time.R;

/**
 * Created by canyongz on 2015/11/21.
 */
public class ChronometerActivity extends AppCompatActivity {
    private static final String TAG = ChronometerActivity.class.getName();
    private Button startBtn = null;
    private Button stopBtn = null;
    private Button restartBtn = null;
    private Chronometer meter = null;
    private CalendarView calendarView = null;
    private Button lanucherTimer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View content = getLayoutInflater().inflate(R.layout.layout_time_ui_control, null);
        setContentView(content);
        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);
        restartBtn = (Button) findViewById(R.id.restartBtn);
        meter = (Chronometer) findViewById(R.id.chronometer);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "Clicked on startBtn");
                meter.start();
            }
        });
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "Clicked on restartBtn");
                meter.setBase(SystemClock.elapsedRealtime());
                meter.setFormat("当前时间:%s");
            }
        });
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setDate(150000, true, true);


        lanucherTimer = (Button) findViewById(R.id.lanucher1);
        lanucherTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(ChronometerActivity.this, TimerActivity.class));
                startActivity(intent);
            }
        });
    }

    public void stopMeter(View v) {
        Log.e(TAG, "Clicked on stopBtn by " + v);
        meter.stop();
    }
}
