package com.example.educationalgamea2;

import android.app.Activity;
import android.content.Intent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameOverActivity extends AppCompatActivity {

    Button play,highscore;
    TextView displayscore;
    String _name;
    int _score;
    DatabaseHandler db = new DatabaseHandler(this);




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        play = findViewById(R.id.play_button);
        highscore = findViewById(R.id.button_Highscore);
        displayscore = findViewById(R.id.displayScore);


        // Inserting Contacts
        //db.addScore(new DatabaseHandler(1, "Rolf" , 50));
        /*db.addScore(new DbHelper(1,"Rolf",50));
        db.addScore(new DbHelper(2,"Bjorn",40));
        db.addScore(new DbHelper(3,"Tor",25));
        db.addScore(new DbHelper(4,"Toe",34));
        db.addScore(new DbHelper(5,"Tre",90));
        db.addScore(new DbHelper(6,"ore",40));*/




        /*Intent getScore = getIntent();
        int finalScore = getScore.getIntExtra("finalScore",0);
        String name1 = getScore.getStringExtra("name");*/

        Intent goToGameOver = getIntent();
        Bundle extras = goToGameOver.getExtras();
        String name1 = extras.getString("name");
        int finalScore = extras.getInt("finalScore");
        _name = name1;
        _score = finalScore;
        Toast.makeText(GameOverActivity.this,name1, Toast.LENGTH_LONG).show();
        String disString1 = String.valueOf(finalScore);
        String disStringFinal = "Score: " + disString1;
        displayscore.setText(disStringFinal);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToGame = new Intent(GameOverActivity.this, GameActivity.class);
                startActivity(goToGame);
            }
        });

        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHighscore = new Intent(GameOverActivity.this, HighscoreActivity.class);
                startActivity(goToHighscore);
            }
        });


       /* int secondScore = 50;
        int thirdScore = 2;
        int fourthScore = 5;
        int fifthScore = 3;
        int sixthScore = 4;

        db.addScore(finalScore);
        db.addScore(secondScore);
        db.addScore(thirdScore);

        db.addScore(fourthScore);
        db.addScore(fifthScore);
        db.addScore(sixthScore);


        String[] Allscores = db.getAllScores();
        String firstScore = Allscores[0];
        String secScore = Allscores[1];
        String thiScore = Allscores[2];
        String fouScore = Allscores[3];
        String fifScore = Allscores[4];
        String sixScore = Allscores[5];


        Toast.makeText(GameOverActivity.this,firstScore, Toast.LENGTH_LONG).show();*/




    }







    /*public GameOverActivity(String name, int score){


    STATIC??


        this._name = name;
        this._score = score;
    }*/


}
