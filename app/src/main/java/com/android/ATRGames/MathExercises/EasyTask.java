package com.android.ATRGames.MathExercises;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.ATRGames.R;

public class EasyTask extends AppCompatActivity {

    Button start_btn,easy_show1, easy_show2, btn_math_answer11, btn_math_answer12, btn_math_answer13, btn_math_answer14;
    TextView timer, points, questions, TV_math_go;
    ProgressBar progressBar;
    ImageView easy_home;
    Game g = new Game(9);


    int sec = 50;
    CountDownTimer countDownTimer = new CountDownTimer(50000, 1000) {
        @Override
        public void onTick(long l) {
        sec--;
        timer.setText(Integer.toString(sec) + " שניות ");
        progressBar.setProgress(50 - sec);
        }

        @Override
        public void onFinish() {
            btn_math_answer11.setEnabled(false);
            btn_math_answer12.setEnabled(false);
            btn_math_answer13.setEnabled(false);
            btn_math_answer14.setEnabled(false);
            TV_math_go.setText(" נגמר הזמן "+ g.getNumberCorrect() + "/" + (g.getTotalSQuestions() - 1));
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                start_btn.setVisibility(View.VISIBLE);
                    easy_show1.setVisibility(View.VISIBLE);
                    easy_show1.setText(g.getScore() + " נקודות " );
                    easy_show2.setVisibility(View.VISIBLE);
                    easy_show2.setText(g.getNumberCorrect() + " שאלות נכונות ");
                    points.setText("0 נקודות");

                }
            }, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_task);

        start_btn = findViewById(R.id.start_btn);
        easy_show1 = findViewById(R.id.easy_show1);
        easy_show2 = findViewById(R.id.easy_show2);
        btn_math_answer11 = findViewById(R.id.btn_math_answer11);
        btn_math_answer12 = findViewById(R.id.btn_math_answer12);
        btn_math_answer13 = findViewById(R.id.btn_math_answer13);
        btn_math_answer14 = findViewById(R.id.btn_math_answer14);
        easy_home = findViewById(R.id.easy_home);

        timer = findViewById(R.id.timer);
        points = findViewById(R.id.pointsMath);
        questions = findViewById(R.id.countQuestion);
        TV_math_go = findViewById(R.id.TV_math_go);

        progressBar = findViewById(R.id.progressBar);

        timer.setText("0 שניות");
        questions.setText("");
        points.setText("0 נקודות");

        easy_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EasyTask.this, PickLevel.class);
                startActivity(i);
                finish();
            }
        });

        View.OnClickListener startBTN = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button start = (Button) view;
                start_btn.setVisibility(View.INVISIBLE);
                sec = 50;
                g = new Game(9);
                nextTurn();
                countDownTimer.start();
            }
        };
        View.OnClickListener answerBTN = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button buttonClicked = (Button) view;
                int answerSelected = Integer.parseInt(buttonClicked.getText().toString());

                g.checkAnswer(answerSelected, 10, 5);
                points.setText(Integer.toString(g.getScore()) + " נקודות ");
                nextTurn();
            }
        };

        start_btn.setOnClickListener(startBTN);

        btn_math_answer11.setOnClickListener(answerBTN);
        btn_math_answer12.setOnClickListener(answerBTN);
        btn_math_answer13.setOnClickListener(answerBTN);
        btn_math_answer14.setOnClickListener(answerBTN);

    }

    private void nextTurn() {
    g.makeNewQuestions();
    int [] answer = g.getCurrentQuestions().getAnswerArray();
        btn_math_answer11.setText(Integer.toString(answer[0]));
        btn_math_answer12.setText(Integer.toString(answer[1]));
        btn_math_answer13.setText(Integer.toString(answer[2]));
        btn_math_answer14.setText(Integer.toString(answer[3]));

        questions.setText(g.getCurrentQuestions().getQuestionsString());
        btn_math_answer11.setEnabled(true);
        btn_math_answer12.setEnabled(true);
        btn_math_answer13.setEnabled(true);
        btn_math_answer14.setEnabled(true);
        TV_math_go.setText(g.getNumberCorrect() + "/" + (g.getTotalSQuestions() - 1));
    }

}