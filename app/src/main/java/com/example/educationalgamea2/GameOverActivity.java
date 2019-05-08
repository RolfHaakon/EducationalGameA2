package com.example.educationalgamea2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class GameOverActivity extends AppCompatActivity {

    Button play,highscore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        play = findViewById(R.id.play_button);
        highscore = findViewById(R.id.button_Highscore);


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
}
