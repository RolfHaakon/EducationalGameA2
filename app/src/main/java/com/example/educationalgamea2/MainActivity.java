package com.example.educationalgamea2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button play;
    Button highscore;
    EditText name;
    TextView nametag;
    Button settings, info;
    String strName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.play_button);
        highscore = findViewById(R.id.button_Highscore);
        name = findViewById(R.id.input_Name);
        nametag = findViewById(R.id.textView_name);
        settings = findViewById(R.id.settings);
        info = findViewById(R.id.button_info);



        play.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().length() == 0){
                    Toast.makeText(MainActivity.this,"Enter Username", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent goToGame = new Intent(MainActivity.this, GameActivity.class);
                    strName = name.getText().toString();
                    goToGame.putExtra("name", strName);
                    startActivity(goToGame);
                }
            }
        });

        settings.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(goToSettings);
            }
        });

        info.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToInfo = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(goToInfo);
            }
        });
        highscore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToHighscore = new Intent(MainActivity.this, HighscoreActivity.class);
                startActivity(goToHighscore);
            }
        });




}
}
