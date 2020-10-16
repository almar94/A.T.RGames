package com.android.ATRGames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.ATRGames.MathExercises.PickLevel;
import com.android.ATRGames.pairMatching.CuteBugs;
import com.android.ATRGames.fillTheBlank.FillTheBlankActivity;
import com.android.ATRGames.meaningQuestions.meaningQuestionsActivity;
import com.android.ATRGames.pairMatching.PairMenu;

public class GamesMenu extends AppCompatActivity {

    Button game1, game2, game3, game4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_menu);

        game1 = findViewById(R.id.button1);
        game2 = findViewById(R.id.button2);
        game3 = findViewById(R.id.button3);
        game4 = findViewById(R.id.button4);

        game1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GamesMenu.this, PickLevel.class);
                startActivity(i);
                finish();

            }
        });

        game2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GamesMenu.this, PairMenu.class);
                startActivity(i);
                finish();

            }
        });

        game3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GamesMenu.this, meaningQuestionsActivity.class);
                startActivity(i);
                finish();
            }
        });

        game4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GamesMenu.this, FillTheBlankActivity.class);
                startActivity(i);
                finish();

            }
        });

    }

}