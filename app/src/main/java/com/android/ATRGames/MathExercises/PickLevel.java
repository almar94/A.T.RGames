package com.android.ATRGames.MathExercises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.ATRGames.GamesMenu;
import com.android.ATRGames.R;

public class PickLevel extends AppCompatActivity {

    Button easy, difficult;
    ImageView home;
    TextView easy_message, difficult_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_level);

        easy = findViewById(R.id.easy);
        difficult = findViewById(R.id.difficult);
        home = findViewById(R.id.pickLevel_home);

        easy_message = findViewById(R.id.easy_message);
        difficult_message = findViewById(R.id.difficult_message);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PickLevel.this, GamesMenu.class);
                startActivity(i);
                finish();
            }
        });

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                difficult_message.setVisibility(View.GONE);
                easy_message.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        Intent i = new Intent(PickLevel.this, EasyTask.class);
                        startActivity(i);
                        finish();
                    }

                }, 3 * 1000);

            }
        });

        difficult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                difficult_message.setVisibility(View.VISIBLE);
                easy_message.setVisibility(View.GONE);

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        Intent i = new Intent(PickLevel.this, DifficultTask.class);
                        startActivity(i);
                        finish();
                    }

                }, 3 * 1000);

            }
        });
    }


}