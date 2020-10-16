package com.android.ATRGames.fillTheBlank;

import androidx.appcompat.app.AppCompatActivity;

import com.android.ATRGames.GamesMenu;
import com.android.ATRGames.R;
import com.android.ATRGames.meaningQuestions.ResultMeaning;
import com.android.ATRGames.meaningQuestions.meaningQuestionsActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FillTheBlankActivity extends AppCompatActivity {

    Button answer1, answer2, answer3;
    TextView pointsTV, question, countQuestion;
    ImageView FillTheBlank_home;

    String rightAnswer;
    int rightAnswerCount = 0;
    int pointsCount = 0;
    int questionCount = 0;
    int stop = 6;

    ArrayList<ArrayList<String>> questionArray = new ArrayList<>();
    String[][] questionData = {
            {"השמש שוקעת __", "במערב", "במזרח", "בדרום"},
            {"כשהחתול שלי רעב הוא __", "מיילל", "נובח", "מצייץ"},
            {"אדום וצהוב יוצרים __", "כתום", "ירוק", "כחול"},
            {"הכלב מקשקש __", "בזנב", "בכנפיים", "ברגליים"},
            {"הפרה חייה __", "ברפת", "בארווה", "במלונה"},
            {"שנהיה לראש ולא __", "לזנב", "ליד", "לרגל"},
            {"מרוב עצים לא רואים את __", "היער", "העץ", "הגבעה"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_the_blank);

        FillTheBlank_home = findViewById(R.id.FillTheBlank_home);
        answer1 = findViewById(R.id.answerFillTheBlank1);
        answer2 = findViewById(R.id.answerFillTheBlank2);
        answer3 = findViewById(R.id.answerFillTheBlank3);

        pointsTV = findViewById(R.id.pointsFillTheBlank);
        question = findViewById(R.id.questionFillTheBlank);
        countQuestion = findViewById(R.id.countQuestionFillTheBlank);


        FillTheBlank_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FillTheBlankActivity.this, GamesMenu.class);
                startActivity(i);
                finish();
            }
        });


        for (int i = 0; i < questionData.length; i++) {
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(questionData[i][0]);
            tmpArray.add(questionData[i][1]);
            tmpArray.add(questionData[i][2]);
            tmpArray.add(questionData[i][3]);

            questionArray.add(tmpArray);
        }
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
            MediaPlayer ring = MediaPlayer.create(FillTheBlankActivity.this, R.raw.right);
            ring.start();
            rightAnswerCount++;
            pointsCount += 10;

        } else {
            MediaPlayer ring = MediaPlayer.create(FillTheBlankActivity.this, R.raw.wrong);
            ring.start();
        }

        if (questionCount == stop) {
            Intent i = new Intent(FillTheBlankActivity.this, ResultMeaning.class);
            i.putExtra("rightAnswerCount", pointsCount);
            i.putExtra("questionCount", rightAnswerCount);
            startActivity(i);
            finish();
        } else {
            questionCount++;
            ShowNextQuestion();
        }

    }

}