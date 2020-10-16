package com.android.ATRGames.meaningQuestions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.ATRGames.GamesMenu;
import com.android.ATRGames.R;

public class ResultMeaning extends AppCompatActivity {

    TextView totalCountQuestion, totalPoints;
    Button ResultMeaning_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_meaning);

        int points = getIntent().getIntExtra("rightAnswerCount", 0);
        int question = getIntent().getIntExtra("questionCount", 1);

        totalCountQuestion = findViewById(R.id.totalCountQuestion);
        totalPoints = findViewById(R.id.totalPoints);
        ResultMeaning_menu = findViewById(R.id.ResultMeaning_menu);

        ResultMeaning_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResultMeaning.this, GamesMenu.class);
                startActivity(i);
                finish();
            }
        });
        totalCountQuestion.setText(question + " / 7");
        totalPoints.setText(points + " נקודות ");

    }
}