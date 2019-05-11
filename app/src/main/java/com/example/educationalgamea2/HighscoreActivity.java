package com.example.educationalgamea2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class HighscoreActivity extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        TextView firstPlace = findViewById(R.id.highScore1);
        TextView secondPlace = findViewById(R.id.highScore2);
        TextView thirdPlace = findViewById(R.id.highScore3);
        TextView fourthPlace = findViewById(R.id.highScore4);
        TextView fifthPlace = findViewById(R.id.highScore5);


        /*List<DbHelper> dbHelperList = db.getAllHighscores();
        for (DbHelper cn : dbHelperList) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Score: " +
                    cn.getScore();
            //String val = cn.getID() + cn.getName() + cn.getScore();
            // Writing Contacts to log
            Log.d("Name: ", log);*/
        }





        //firstPlace.setText(forste);




}