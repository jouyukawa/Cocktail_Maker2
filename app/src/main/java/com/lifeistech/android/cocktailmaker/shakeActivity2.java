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
import android.widget.Toast;

import java.util.List;

/**
 * Created by joeykw on 2016/02/27.
 */

public class shakeActivity2 extends Activity implements SensorEventListener {

    //MainActivityの結果を引き継ぐ為の引数
    public int resultnum;

    private ShakeListenr mShakerListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shake);
        Toast.makeText(this, "shake!!", Toast.LENGTH_LONG).show();

        //MainActivityの結果を引き継ぎ
        Bundle extras = getIntent().getExtras();
        resultnum = extras.getInt("COCKTAILCODE");

        //ShakerListenerのインスタンスを作る
        mShakerListener = new ShakeListenr(this);

        //リスナーをセット
        mShakerListener.setOnShakeListener(new ShakeListenr.OnShakeListener(){
            //シェイクを検知すると
            //以下のOnShakeメソッドが呼び出されます

            public void onShake() {

                //結果画面へ移動
                Intent intent = new Intent(shakeActivity2.this, CocktailConclusion.class);

                //intの値の受け渡し処理
                intent.putExtra("COCKTAILCODE", resultnum);
                startActivity(intent);


            }


        });


    }


    @Override
    public void onResume() {
        super.onResume();
        //アクチビティのonResumeメソッドで
        //ShakerListenerのonResumeメソッドを呼び出してください
        //センサーの準備をします
        mShakerListener.onResume();
    }

    @Override
    public void onPause() {
        //加速度センサーのリスナーを解除
        mShakerListener.onPause();
        super.onPause();

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
