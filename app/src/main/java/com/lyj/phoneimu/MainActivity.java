package com.lyj.phoneimu;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button accxBtn;
    private Button accyBtn;
    private Button acczBtn;
    private Button gyrxBtn;
    private Button gyryBtn;
    private Button gyrzBtn;
    private Button magxBtn;
    private Button magyBtn;
    private Button magzBtn;

    private SensorManager sensorManager;
    private Sensor sensorAcc;
    private Sensor sensorGyr;
    private Sensor sensorMag;

    private float[] acc = new float[3];
    private float[] gyr = new float[3];
    private float[] mag = new float[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accxBtn = (Button) findViewById(R.id.accxBtn);
        accyBtn = (Button) findViewById(R.id.accyBtn);
        acczBtn = (Button) findViewById(R.id.acczBtn);
        gyrxBtn = (Button) findViewById(R.id.gyrxBtn);
        gyryBtn = (Button) findViewById(R.id.gyryBtn);
        gyrzBtn = (Button) findViewById(R.id.gyrzBtn);
        magxBtn = (Button) findViewById(R.id.magxBtn);
        magyBtn = (Button) findViewById(R.id.magyBtn);
        magzBtn = (Button) findViewById(R.id.magzBtn);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorAcc = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensorGyr = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorMag = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sensorManager.registerListener(listenerAcc, sensorAcc, SensorManager.SENSOR_DELAY_GAME);
        sensorManager.registerListener(listenerGyr, sensorGyr, SensorManager.SENSOR_DELAY_GAME);
        sensorManager.registerListener(listenerMag, sensorMag, SensorManager.SENSOR_DELAY_GAME);
    }

    private SensorEventListener listenerAcc = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            acc = event.values;
            accxBtn.setText(String.format("%.4f", acc[0]));
            accyBtn.setText(String.format("%.4f", acc[1]));
            acczBtn.setText(String.format("%.4f", acc[2]));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    private SensorEventListener listenerGyr = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            gyr = event.values;
            gyrxBtn.setText(String.format("%.4f", gyr[0]));
            gyryBtn.setText(String.format("%.4f", gyr[1]));
            gyrzBtn.setText(String.format("%.4f", gyr[2]));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    private SensorEventListener listenerMag = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            mag = event.values;
            magxBtn.setText(String.format("%.4f", mag[0]));
            magyBtn.setText(String.format("%.4f", mag[1]));
            magzBtn.setText(String.format("%.4f", mag[2]));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

}
