package com.example.fitnesstimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatch extends AppCompatActivity {

    Button btnStart,btnStop,btnSchedule;
    ImageView ivAnchor;
    Animation roundingalone;
    Chronometer time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnSchedule = findViewById(R.id.btnSchedule);
        ivAnchor = findViewById(R.id.ivAnchor);
        time = findViewById(R.id.time);

        //optional animation
        btnStop.setAlpha(0);

        //loading Animations
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ivAnchor.startAnimation(roundingalone);
                    btnStop.animate().alpha(1).translationY(-180).setDuration(300).start();
                    btnStart.animate().alpha(0).setDuration(300).start();
                    //start time
                time.setBase(SystemClock.elapsedRealtime());
                time.start();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.stop();
                btnStop.animate().alpha(0).setDuration(300).start();
                btnStart.animate().alpha(1).translationY(70).setDuration(300).start();
            }
        });
        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSchedule.setAlpha(1);
                Intent comingSoon = new Intent(StopWatch.this, schedule.class);
                startActivity(comingSoon);
            }
        });
    }
}