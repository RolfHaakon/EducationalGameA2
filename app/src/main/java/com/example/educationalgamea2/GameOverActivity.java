package com.example.educationalgamea2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameOverActivity extends AppCompatActivity {

    Button play,highscore;
    TextView displayscore;
    String _name;
    int _score;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        play = findViewById(R.id.play_button);
        highscore = findViewById(R.id.button_Highscore);
        displayscore = findViewById(R.id.displayScore);


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

    }

    /*public GameOverActivity(String name, int score){


    STATIC??


        this._name = name;
        this._score = score;
    }*/


}
