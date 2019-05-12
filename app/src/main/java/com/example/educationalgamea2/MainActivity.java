package com.example.educationalgamea2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements SensorEventListener {

    Button play;
    Button highscore;
    EditText name;
    TextView nametag;
    Button settings, info;
    String strName;

    //Sensor
    private float lastX, lastY, lastZ;

    private SensorManager sensorManager;
    private Sensor accelerometer;


    private float deltaX = 0;
    private float deltaY = 0;
    private float deltaZ = 0;

    private float vibrateThreshold = 0;

    int dontShakeOnStart = 0;







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
                if (name.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter Username", Toast.LENGTH_LONG).show();
                } else {
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


        //sensor

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            // success! we have an accelerometer

            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            vibrateThreshold = accelerometer.getMaximumRange() / 2;
        } else {
            // fail! we dont have an accelerometer!
            Toast.makeText(MainActivity.this,"Failed to load accelerometer", Toast.LENGTH_LONG).show();
        }




    }

    //onResume() register the accelerometer for listening the events
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    //onPause() unregister the accelerometer for stop listening the events
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {


        // get the change of the x,y,z values of the accelerometer
        deltaX = Math.abs(lastX - event.values[0]);
        deltaY = Math.abs(lastY - event.values[1]);
        deltaZ = Math.abs(lastZ - event.values[2]);


        // if the change is below 2, it is just plain noise
        if (deltaX < 2)
            deltaX = 0;
        if (deltaY < 2)
            deltaY = 0;
        if (deltaZ < 2)
            deltaZ = 0;


        lastX = event.values[0];
        lastY = event.values[1];
        lastZ = event.values[2];



        shakeShakeIt();


    }

    public void shakeShakeIt() {
        if (dontShakeOnStart > 0) {
            if ((deltaX > vibrateThreshold) || (deltaY > vibrateThreshold) || (deltaZ > vibrateThreshold)) {
                Toast.makeText(MainActivity.this, "Device Shaken", Toast.LENGTH_LONG).show();
            }
        }
        dontShakeOnStart = dontShakeOnStart + 1;
    }

}



