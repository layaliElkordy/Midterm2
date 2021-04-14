package com.example.midterm2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.tv); TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(MainActivity.this,MainActivity2.class)); }
        };
        Timer opening = new Timer(); opening.schedule(task,5000); new CountDownTimer(5000, 10) {
            public void onTick(long millisUntilFinished) {

                tv.setText("seconds remaining: " +new SimpleDateFormat("ss").format(new Date(
                        millisUntilFinished))); }
            public void onFinish() { tv.setText("done!");
            } }.start();
    } }