package com.android.ATRGames.MathExercises;

import java.util.Random;

public class Questions {
    private int firstNumber;
    private int secondNumber;
    private int theAnswer;

    private int[] answerArray;
    private int answerPosition;

    private int maximum;
    private String questionsString;

    public Questions(int maximum) {
        this.maximum = maximum;
        Random randomMax = new Random();
        this.firstNumber = randomMax.nextInt(maximum);
        this.secondNumber = randomMax.nextInt(maximum);
        this.theAnswer =  this.firstNumber + this.secondNumber;
        this.questionsString = firstNumber + " + " + secondNumber+ " = ";

        this.answerPosition = randomMax.nextInt(4);
        this.answerArray = new int[] {0,1,2,3};

        this.answerArray[0] = theAnswer +1;
        this.answerArray[1] = theAnswer + 10;
        this.answerArray[2] = theAnswer -5;
        this.answerArray[3] = theAnswer -7;

        this.answerArray = shuffleArray(this.answerArray);

        answerArray[answerPosition] = theAnswer;

    }

    private int [] shuffleArray(int [] array){
        int index, temp;
        Random randomNumber = new Random();
        for (int i = array.length-1; i > 0 ; i--) {
            index = randomNumber.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getTheAnswer() {
        return theAnswer;
    }

    public void setTheAnswer(int theAnswer) {
        this.theAnswer = theAnswer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }


    public String getQuestionsString() {
        return questionsString;
    }

    public void setQuestionsString(String questionsString) {
        questionsString = questionsString;
    }
}