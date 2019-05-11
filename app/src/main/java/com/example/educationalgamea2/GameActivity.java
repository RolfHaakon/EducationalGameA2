package com.example.educationalgamea2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.seismic.ShakeDetector;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements ShakeDetector.Listener {

    ProgressBar pb;
    TextView scoreText;
    int operator;
    int score;
    int winnerButton;
    Button answer1,answer2,answer3,answer4;
    String name1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        pb = findViewById(R.id.progressbar);
        Intent getName = getIntent();
        String name = getName.getStringExtra("name");
        name1 = name;
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector shakeDetector = new ShakeDetector(this);
        shakeDetector.start(sensorManager);

        ObjectAnimator animation = ObjectAnimator.ofInt(pb, "progress", 0, 100);

        animation.setDuration(30000);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animator) { }


            @Override
            public void onAnimationEnd(Animator animator) {
                //do something when the countdown is complete
                Intent goToGameOver = new Intent(GameActivity.this, GameOverActivity.class);
                Bundle extras = new Bundle();
                extras.putString("name",name1);
                extras.putInt("finalScore",score);
                goToGameOver.putExtras(extras);
                startActivity(goToGameOver);
            }
            @Override
            public void onAnimationCancel(Animator animator) { }
            @Override
            public void onAnimationRepeat(Animator animator) { }
        });
        score = 0;
        scoreText = findViewById(R.id.currentScore);
        scoreText.setText("Score: " + score);



        animation.start();
        questionStarter();
    }

    @Override
    public void hearShake() {
        Toast.makeText(GameActivity.this,"Its shaking", Toast.LENGTH_LONG).show();
    }


    public void questionStarter() {
        Random rand1 = new Random();
        //int operator = rand1.nextInt(2);
        int operator = 0;
        if (operator == 0) {
            multiplicationQuestion();
            }
    }


    public void multiplicationQuestion(){
        TextView qt = (TextView)findViewById(R.id.questionText);
        Button answer1 = findViewById(R.id.answer1);
        Button answer2 = findViewById(R.id.answer2);
        Button answer3 = findViewById(R.id.answer3);
        Button answer4 = findViewById(R.id.answer4);
        Random rand1 = new Random();
        //int operator = rand1.nextInt(2);
        int operator = 0;
        if (operator == 0) {
            Random rand2 = new Random();
            Random rand3 = new Random();
            int addition1 = rand2.nextInt(40);
            int addition2 = rand3.nextInt(20);
            int correctAnswer0 = addition1 * addition2;
            String correctAnswerString = String.valueOf(correctAnswer0);
            String false1AnswerString = String.valueOf(correctAnswer0 + 50);
            String false2AnswerString = String.valueOf(correctAnswer0 + 100);
            String false3AnswerString = String.valueOf(correctAnswer0 - 100);
            String part1 = String.valueOf(addition1);
            String part2 = String.valueOf(addition2);
            String questionLine = part1 + " Multiplied by " + part2;
            qt.setText(questionLine);

            //Random rand4 = new Random();
            //int answernr = rand4.nextInt(3);
            int answernr = 0;
            if (answernr == 0){
                winnerButton = 1;
                answer1.setText(correctAnswerString);
                answer2.setText(false1AnswerString);
                answer3.setText(false2AnswerString);
                answer4.setText(false3AnswerString);
            }
            if (answernr == 1){
                winnerButton = 2;
                answer1.setText(false1AnswerString);
                answer2.setText(correctAnswerString);
                answer3.setText(false2AnswerString);
                answer4.setText(false3AnswerString);
            }
            if (answernr == 2){
                winnerButton = 3;
                answer1.setText(false2AnswerString);
                answer2.setText(false1AnswerString);
                answer3.setText(correctAnswerString);
                answer4.setText(false3AnswerString);
            }
            if (answernr == 3){
                winnerButton = 4;
                answer1.setText(false3AnswerString);
                answer2.setText(false1AnswerString);
                answer3.setText(false2AnswerString);
                answer4.setText(correctAnswerString);
            }
            answer1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (winnerButton == 1) {
                        Toast.makeText(GameActivity.this,"Correct", Toast.LENGTH_LONG).show();
                        score = score + 1;
                        scoreText.setText("Score: " + score);
                        questionStarter();
                    }
                    else {
                        Toast.makeText(GameActivity.this,"Incorrect", Toast.LENGTH_LONG).show();
                        questionStarter();
                    }
                }
            });
            answer2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (winnerButton == 2) {
                        Toast.makeText(GameActivity.this,"Correct", Toast.LENGTH_LONG).show();
                        score = score + 1;
                        scoreText.setText("Score: " + score);
                        questionStarter();
                    }
                    else {
                        Toast.makeText(GameActivity.this,"Incorrect", Toast.LENGTH_LONG).show();
                        questionStarter();
                    }
                }
            });
            answer3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (winnerButton == 3) {
                        Toast.makeText(GameActivity.this,"Correct", Toast.LENGTH_LONG).show();
                        score = score + 1;
                        scoreText.setText("Score: " + score);
                        questionStarter();
                    }
                    else {
                        Toast.makeText(GameActivity.this,"Incorrect", Toast.LENGTH_LONG).show();
                        questionStarter();
                    }
                }
            });
            answer4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (winnerButton == 4) {
                        Toast.makeText(GameActivity.this,"Correct", Toast.LENGTH_LONG).show();
                        score = score + 1;
                        scoreText.setText("Score: " + score);
                        questionStarter();
                    }
                    else {
                        Toast.makeText(GameActivity.this,"Incorrect", Toast.LENGTH_LONG).show();
                        questionStarter();
                    }
                }
            });


        }

    }
}
