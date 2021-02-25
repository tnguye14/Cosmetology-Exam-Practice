package com.misukin.cosmetologypractice;

public class Main {

    public int generateRandomNumber(int max){
        double randomNum = Math.random();
        double number = randomNum*max;
        int questionNumber = (int)number;
        return questionNumber;
    }

    // Add getGameOverMessage() here
    public String getGameOverMessage(int totalCorrect, int totalQuestions){
        if(totalCorrect==totalQuestions){
            String won = "Woohoo, you got "+totalCorrect+" correct answers!";
            return won;
        }
        else{
            String lose = "Ooopps, you got "+totalCorrect+" out of "+totalQuestions+", better try next time!";
            return lose;
        }

    }

}

