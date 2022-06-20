package com.matilhadeestudos.mensageiroqualquer.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.TimerTask;


import com.google.firebase.auth.FirebaseAuth;
import com.matilhadeestudos.mensageiroqualquer.Model.Usuario;
import com.matilhadeestudos.mensageiroqualquer.R;
public class SplashActivity extends AppCompatActivity {

//
    private FirebaseAuth mAuth;
    TimerTask timerTask;
    Usuario u = new Usuario();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mAuth = FirebaseAuth.getInstance();
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
        if (mAuth.getCurrentUser() == null) {
            Intent intent = new Intent(getApplicationContext(), TelaLogin.class);
            startActivity(intent);
            finish();
        }else if (mAuth.getCurrentUser() != null){
            Intent intent = new Intent(getApplicationContext(), ListaContatos.class);
            startActivity(intent);
            finish();
        }
    }
}