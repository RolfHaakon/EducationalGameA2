package com.example.educationalgamea2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button play;
    Button highscore;
    EditText name;
    TextView nametag;
    Button settings, info;



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


        play.setOnClickListener(View v) {
            public void onClick(View v) {
                Intent goToGame = new Intent(MainActivity.this, GameActivity.class);
            }

    }


}






}
