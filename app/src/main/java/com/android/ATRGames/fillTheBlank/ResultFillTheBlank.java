package com.android.ATRGames.fillTheBlank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.ATRGames.GamesMenu;
import com.android.ATRGames.R;
import com.android.ATRGames.meaningQuestions.ResultMeaning;

public class ResultFillTheBlank extends AppCompatActivity {

    TextView totalCountQuestion, totalPoints;
    Button ResultMeaning_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_fill_the_blank);

        int points = getIntent().getIntExtra("rightAnswerCount", 0);
        int question = getIntent().getIntExtra("questionCount", 1);

        totalCountQuestion = findViewById(R.id.totalCountQuestion_fill);
        totalPoints = findViewById(R.id.totalPoints_fill);
        ResultMeaning_menu = findViewById(R.id.ResultFillTheBlank_menu);

        ResultMeaning_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResultFillTheBlank.this, GamesMenu.class);
                startActivity(i);
                finish();
            }
        });
        // לשנות את ה7
        totalCountQuestion.setText(question + " / 7");
        totalPoints.setText(points + " נקודות ");

    }
}