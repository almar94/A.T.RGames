package com.android.ATRGames.MathExercises;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Questions> Listquestions;
    private int numberCorrect;
    private int numberICorrect;
    private int totalSQuestions;
    private int score;
    private Questions currentQuestions;

    public Game(int max) {
        numberCorrect = 0;
        numberICorrect = 0;
        totalSQuestions = 0;
        score = 0;
        currentQuestions = new Questions(max);
        Listquestions = new ArrayList<Questions>();
    }

    public void makeNewQuestions() {
        currentQuestions = new Questions(totalSQuestions * 2 + 5);
        totalSQuestions++;
        Listquestions.add(currentQuestions);
    }

    public boolean checkAnswer(int submittedAnswer, int Correct, int ICorrect) {
        boolean isCorrect;
        if (currentQuestions.getTheAnswer() == submittedAnswer) {
            numberCorrect++;
            isCorrect = true;
        }else {
            numberICorrect++;
            isCorrect=false;
        }
        score = numberCorrect * Correct - numberICorrect * ICorrect;
        return isCorrect;
    }

    public List<Questions> getListquestions() {
        return Listquestions;
    }

    public void setListquestions(List<Questions> listquestions) {
        this.Listquestions = listquestions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getNumberICorrect() {
        return numberICorrect;
    }

    public void setNumberICorrect(int numberICorrect) {
        this.numberICorrect = numberICorrect;
    }

    public int getTotalSQuestions() {
        return totalSQuestions;
    }

    public void setTotalSQuestions(int totalSQuestions) {
        this.totalSQuestions = totalSQuestions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Questions getCurrentQuestions() {
        return currentQuestions;
    }

    public void setCurrentQuestions(Questions currentQuestions) {
        this.currentQuestions = currentQuestions;
    }
}
