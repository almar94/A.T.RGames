package com.android.ATRGames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread background = new Thread() {
            public void run() {
                try {
                    sleep(3*1000);
                    Intent i=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {
                }
            }
        };
        background.start();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, MainScreen.class);
                startActivity(i);
                finish();
            }

        }, 3*1000);
    }
}