package com.lifeistech.android.cocktailmaker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by joeykw on 2016/02/27.
 */
public class shakeActivity2 extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shake);

        //SensorManagerのインスタンスを取得
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //加速度センサーの取得
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }


    @Override
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        //センサー処理の開始
        //加速度センサーのリスナーを登録
        List<Sensor> sensors = mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.size() > 0) {
            Sensor s = sensors.get(0);
            mSensorManager.registerListener(this, s, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    public void onPause() {
        //加速度センサーのリスナーを解除
        mSensorManager.unregisterListener(this);
        super.onPause();

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        //加速度の取得
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            Intent intent = new Intent(this, CocktailConclusion.class);
            startActivity(intent);

        }

    }
}
