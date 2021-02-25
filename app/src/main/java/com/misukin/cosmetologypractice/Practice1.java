package com.misukin.cosmetologypractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static com.misukin.cosmetologypractice.QuestionLibrary.*;

public class Practice1 extends AppCompatActivity {

        private QuestionLibrary newQuestion = new QuestionLibrary();

        private TextView scoreView;
        private TextView questionView;
        private ToggleButton ans1;
        private ToggleButton ans2;
        private ToggleButton ans3;
        private ToggleButton ans4;
        private Button submit;
        private Button endButton;

        private String answer;
        private int score = 0;
        private int questionNumber = (int)(Math.random()*203);
        // (int)(Math.random()*(max-min)+min)


        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_practice1);

            // connect variables with buttons or textview in UI
            scoreView = (TextView) findViewById(R.id.score);
            questionView = (TextView) findViewById(R.id.question);
            ans1 = (ToggleButton) findViewById(R.id.ans1);
            ans2 = (ToggleButton) findViewById(R.id.ans2);
            ans3 = (ToggleButton) findViewById(R.id.ans3);
            ans4 = (ToggleButton) findViewById(R.id.ans4);
            endButton = (Button) findViewById(R.id.endButton);
            updateQuestion();


            // start setOnClickListener
            ans1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // set up ONLY ONE choice can be chosen
                    ans1.setChecked(true);
                    ans4.setChecked(false);
                    ans2.setChecked(false);
                    ans3.setChecked(false);
                }
            });


            ans2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ans2.setChecked(true);
                    ans1.setChecked(false);
                    ans4.setChecked(false);
                    ans3.setChecked(false);
                    }
            });


            ans3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ans3.setChecked(true);
                    ans1.setChecked(false);
                    ans2.setChecked(false);
                    ans4.setChecked(false);
                }
            });


            ans4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ans4.setChecked(true);
                    ans1.setChecked(false);
                    ans2.setChecked(false);
                    ans3.setChecked(false);
                }
            });


            endButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goBackActivity();
                }
                });


            // end setOnClickListener


            // start seperate field for Submit button
            submit = (Button) findViewById(R.id.submit);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // create conditions to find one eligible choice, which is correct and is selected
                    if (ans1.isChecked() && ans1.getText()==answer){
                        score = score + 1;
                        updateScore(score);
                        updateQuestion();
                        Toast.makeText(Practice1.this,"Correct", Toast.LENGTH_SHORT).show();
                    }
                    else if(ans2.isChecked() && ans2.getText()==answer){
                        score = score + 1;
                        updateScore(score);
                        updateQuestion();
                        Toast.makeText(Practice1.this,"Correct", Toast.LENGTH_SHORT).show();
                    }
                    else if(ans3.isChecked() && ans3.getText()==answer){
                        score = score + 1;
                        updateScore(score);
                        updateQuestion();
                        Toast.makeText(Practice1.this,"Correct", Toast.LENGTH_SHORT).show();
                    }
                    else if(ans4.isChecked() && ans4.getText()==answer){
                        score = score + 1;
                        updateScore(score);
                        updateQuestion();
                        Toast.makeText(Practice1.this,"Correct", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Practice1.this,"Wrong", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            // end submit button

        }
        public void goBackActivity(){

            Intent intent = new Intent(this, ModeOptions.class);
            startActivity(intent);
        }
        // method to update score
        private void updateScore ( int point){
            scoreView.setText("" + score);
        }


        // method to renew the question/ update new question
        public void updateQuestion() {

                questionView.setText(newQuestion.getQuestion(questionNumber));
                ans1.setText(newQuestion.getAnswer1(questionNumber));
                ans2.setText(newQuestion.getAnswer2(questionNumber));
                ans3.setText(newQuestion.getAnswer3(questionNumber));
                ans4.setText(newQuestion.getAnswer4(questionNumber));

                ans1.setTextOn(ans1.getText());
                ans2.setTextOn(ans2.getText());
                ans3.setTextOn(ans3.getText());
                ans4.setTextOn(ans4.getText());

                ans1.setTextOff(ans1.getText());
                ans2.setTextOff(ans2.getText());
                ans3.setTextOff(ans3.getText());
                ans4.setTextOff(ans4.getText());

                answer = newQuestion.getCorrectAnswer(questionNumber);
                questionNumber++;
            }
        // end updateQuestion
}// end class
