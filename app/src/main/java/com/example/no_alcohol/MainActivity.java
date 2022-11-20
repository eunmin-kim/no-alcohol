package com.example.no_alcohol;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        actionBar.setTitle(Html.fromHtml("<font color='#000099'>스탑 알콜</font>"));

    }

    public void stopAlcohol(View v) {
        Button btnStopAlcohol = findViewById(R.id.stopAlcohol);
        if (btnStopAlcohol.getText().equals("현재 금주 중 입니다!")) {
            btnStopAlcohol.setText("금주 시작하기");
        } else {
            btnStopAlcohol.setText("현재 금주 중 입니다!");
        }
    }
}