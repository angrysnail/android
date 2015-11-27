package com.android.angrysnail.sample;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.angrysnail.sample.time.R;

public class AlarmManagerTestActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.layout_alarm_manager);
        Button regBtn = (Button) findViewById(R.id.register);
        Button unregBtn = (Button) findViewById(R.id.unregister);

        Intent i = new Intent(this, TimerActivity.class);
        final PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC, 0, 30000, pi);
            }
        });
        unregBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.cancel(pi);
            }
        });
    }
}
