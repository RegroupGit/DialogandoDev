package com.matilhadeestudos.mensageiroqualquer.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.matilhadeestudos.mensageiroqualquer.R;

import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {





    TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);




        getSupportActionBar().hide();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gotoMainActivity();
                    }
                });

            }
        };
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(timerTask,2000);

    }

    private void gotoMainActivity() {


        Intent intent = new Intent(getApplicationContext(), TelaLogin.class);
        startActivity(intent);
        finish();
    }
}