package com.lifeistech.android.cocktailmaker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private ImageView buttonGin;
    private ImageView buttonVodka;
    private ImageView buttonTonic;
    private ImageView buttonOrange;
    private ImageView buttonGrape;
    public int cocktailnum = 0;

    //アプリが起動した時に呼ばれる関数
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SharedPreferencesを使うための初期設定
        pref = getSharedPreferences("cocktail_base", MODE_PRIVATE);

        editor = pref.edit();
        editor.putBoolean("Gin", false);
        editor.commit();


        //button-変数と activity_main.xmlのidを結びつける
        buttonGin = (ImageView)findViewById(R.id.buttongin);
        buttonTonic = (ImageView)findViewById(R.id.buttontonic);
        buttonGrape = (ImageView)findViewById(R.id.buttongrape);
        buttonOrange = (ImageView)findViewById(R.id.buttonorange);
        buttonVodka = (ImageView)findViewById(R.id.buttonvodka);


        //ジンが取られたら
        if(pref.getBoolean("Gin", false) == true){
            //ジンを見えなくする
            buttonGin.setVisibility(View.INVISIBLE);

        }

        //ウォッカが取られたら
        if(pref.getBoolean("Vodka", false) == true){
            //ジンを見えなくする
            buttonVodka.setVisibility(View.INVISIBLE);

        }
    }

    public void clickGin(View v){
        //トーストを表示
        Toast.makeText(this, "ジンを手に取りました", Toast.LENGTH_SHORT).show();
        //SharedPreferencesにジンを手に入れたことを書き込む
        editor = pref.edit();
        editor.putBoolean("Gin", true);
        editor.commit();
        //ジンを見えなくする
        buttonGin.setVisibility(View.INVISIBLE);

    }

    //ウォッカをクリックした際の処理
    public void clickVodka (View v){
        //トーストを表示
        Toast.makeText(this, "ウォッカを手に取りました", Toast.LENGTH_SHORT).show();

        //SharedPreferencesにウォッカを手に入れたことを書き込む
        editor = pref.edit();
        editor.putBoolean("Vodka", true);
        editor.commit();
        //ジンを見えなくする
        buttonVodka.setVisibility(View.INVISIBLE);

    }

    //トニックをクリックした時の処理
    public void clickTonic(View v){
        //ジンを選択しているかどうか→ジントニックを作る
        //int coctailnum = 1を取得し、画面遷移
        if (pref.getBoolean("Gin",false)==true){
            //Tonicを見えなくする
            Toast.makeText(this, "トニックを手に取りました", Toast.LENGTH_SHORT).show();

            buttonTonic.setVisibility(View.INVISIBLE);

            editor = pref.edit();
            editor.putBoolean("Tonic", true);
            editor.commit();

            Toast.makeText(this, "作れるカクテルがあるよ！", Toast.LENGTH_SHORT).show();

            cocktailnum = 1;

            //shake画面へ移動
            Intent intent = new Intent(this, shakeActivity2.class);

            //intの値の受け渡し処理
            intent.putExtra("COCKTAILCODE", cocktailnum);
            startActivity(intent);

        } else{
            Toast.makeText(this, "作れるカクテルがありません", Toast.LENGTH_SHORT).show();
        }

    }


    //オレンジジュースを選択した場合の処理
    public void clickorange(View v){
        //ジンを選択している場合→オレンジブロッサムへ
        //→int coctailnum = 3を取得する
        if (pref.getBoolean("Gin",false)==true){
            //Orangejuiceを見えなくする
            Toast.makeText(this, "オレンジジュースを手に取りました", Toast.LENGTH_SHORT).show();

            buttonOrange.setVisibility(View.INVISIBLE);

            editor = pref.edit();
            editor.putBoolean("Orange", true);
            editor.commit();

            Toast.makeText(this, "作れるカクテルがあるよ！", Toast.LENGTH_SHORT).show();

            cocktailnum = 3;

            //shake画面へ移動
            Intent intent = new Intent(this, shakeActivity2.class);

            //intの値の受け渡し処理
            intent.putExtra("COCKTAILCODE", cocktailnum);
            startActivity(intent);

        }else{
            Toast.makeText(this, "作れるカクテルがありません", Toast.LENGTH_SHORT).show();
        }

    }

    //グレープフルーツジュースをクリックした時の処理
    public void clickgrape (View v){
        //ジンを選択しているかどうか→作れるお酒なし
        if (pref.getBoolean("Gin",false)==true){
            Toast.makeText(this, "作れるカクテルがありません", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "作れるカクテルがありません", Toast.LENGTH_SHORT).show();
        }

    }

}
