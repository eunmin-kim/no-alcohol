package com.example.no_alcohol;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Chronometer cmTimer;
    Boolean resume = false;
    long elapsedTime;
    String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#378057")));
        actionBar.setTitle(Html.fromHtml("<font color='#ffffff'>스탑 알콜</font>"));

    }

    public void stopAlcohol(View v) {
        Button startBtn = findViewById(R.id.stopAlcohol);
        cmTimer = (Chronometer) findViewById(R.id.cmTimer);
        if (startBtn.getText().equals("현재 금주 중 입니다!")) {
            startBtn.setText("금주 시작하기");

        } else {
            startBtn.setText("현재 금주 중 입니다!");
            cmTimer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                public void onChronometerTick(Chronometer arg0) {
                    if (!resume) {
                        long minutes = ((SystemClock.elapsedRealtime() - cmTimer.getBase())/1000) / 60;
                        long seconds = ((SystemClock.elapsedRealtime() - cmTimer.getBase())/1000) % 60;
                        elapsedTime = SystemClock.elapsedRealtime();
                        Log.d(TAG, "onChronometerTick: " + minutes + " : " + seconds);
                    } else {
                        long minutes = ((elapsedTime - cmTimer.getBase())/1000) / 60;
                        long seconds = ((elapsedTime - cmTimer.getBase())/1000) % 60;
                        elapsedTime = elapsedTime + 1000;
                        Log.d(TAG, "onChronometerTick: " + minutes + " : " + seconds);
                    }
                }
            });
        }
    }
}
