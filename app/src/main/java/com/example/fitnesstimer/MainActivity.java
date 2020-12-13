package com.example.fitnesstimer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvText1, tvText2;
    Button btnWork;
    ImageView ivSplash;
    Animation anim1,anim2,anim3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText1 = findViewById(R.id.tvText1);
        tvText2 = findViewById(R.id.tvText2);
        btnWork = findViewById(R.id.btnWork);
        ivSplash = findViewById(R.id.ivSplash);

        //load animations
        anim1 = AnimationUtils.loadAnimation(this, R.anim.anim1);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.anim2);
        anim3 = AnimationUtils.loadAnimation(this, R.anim.anim3);

        //passing animation
        ivSplash.startAnimation(anim1);
        tvText1.startAnimation(anim2);
        tvText2.startAnimation(anim2);
        btnWork.startAnimation(anim3);

        //Button workout
        btnWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent watch = new Intent(MainActivity.this, StopWatch.class);
                startActivity(watch);
            }
        });
    }
}