package com.android.ATRGames.meaningQuestions;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.ATRGames.GamesMenu;
import com.android.ATRGames.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class meaningQuestionsActivity extends AppCompatActivity {

    Button answer1, answer2, answer3;
    ImageView home;
    TextView pointsTV, question, countQuestion;

    String rightAnswer;
    int rightAnswerCount = 0;
    int pointsCount = 0;
    int questionCount = 0;
    int stop = 6;

    ArrayList<ArrayList<String>> questionArray = new ArrayList<>();
    String[][] questionData = {
            {"נָטָל", "לקח", "הטיל", "שמר"},
            {"חָמָה", "שמש", "חממה", "חם"},
            {"דִילֵמָה", "בעיה", "דיל", "דמה"},
            {"זָקִיף", "זקוף", "שומר", "קוטף"},
            {"אָחָז", "החזיק", "חזק", "אח"},
            {"נָס", "ברח", "קפץ", "ניסה"},
            {"צָוָוח", "צרח", "בכה", "ציווה"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning_questions);

        home = findViewById(R.id.home1);
        answer1 = findViewById(R.id.answer11);
        answer2 = findViewById(R.id.answer12);
        answer3 = findViewById(R.id.answer13);

        pointsTV = findViewById(R.id.points);
        question = findViewById(R.id.question);
        countQuestion = findViewById(R.id.countQuestion1);


        for (int i = 0; i < questionData.length; i++) {
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(questionData[i][0]);
            tmpArray.add(questionData[i][1]);
            tmpArray.add(questionData[i][2]);
            tmpArray.add(questionData[i][3]);

            questionArray.add(tmpArray);
        }
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(meaningQuestionsActivity.this, GamesMenu.class);
                startActivity(i);
                finish();
            }
        });
        ShowNextQuestion();
    }

    public void ShowNextQuestion() {
        countQuestion.setText(rightAnswerCount + "/" + questionCount);

        Random random = new Random();
        int randomNum = random.nextInt(questionArray.size());

        ArrayList<String> questionRandom = questionArray.get(randomNum);

        question.setText(questionRandom.get(0));
        rightAnswer = questionRandom.get(1);

        questionRandom.remove(0);
        Collections.shuffle(questionRandom);
        answer1.setText(questionRandom.get(0));
        answer2.setText(questionRandom.get(1));
        answer3.setText(questionRandom.get(2));

        questionArray.remove(randomNum);
        pointsTV.setText(pointsCount + " נקודות ");
    }

    public void checkAnswer(View view) {
        Button answerButton = findViewById(view.getId());
        String btnText = answerButton.getText().toString();

        if (btnText.equals(rightAnswer)) {
            MediaPlayer ring = MediaPlayer.create(meaningQuestionsActivity.this, R.raw.right);
            ring.start();
            rightAnswerCount ++;
            pointsCount += 10;

        } else {
            MediaPlayer ring = MediaPlayer.create(meaningQuestionsActivity.this, R.raw.wrong);
            ring.start();
        }

        if (questionCount == stop){
            Intent i = new Intent(meaningQuestionsActivity.this, ResultMeaning.class);
            i.putExtra("rightAnswerCount", pointsCount);
            i.putExtra("questionCount", rightAnswerCount);
            startActivity(i);
            finish();
        }else {
        questionCount++;
            ShowNextQuestion();
        }

    }


}