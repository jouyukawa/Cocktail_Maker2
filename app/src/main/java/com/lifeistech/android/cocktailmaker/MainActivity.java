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
    private ImageView buttonRum;
    private ImageView buttonTequila;

    private ImageView buttonTonic;
    private ImageView buttonOrange;
    private ImageView buttonGrapefruit;
    private ImageView buttonGingerale;

    //カクテルナンバーを識別する値を設定
    public int cocktailnum = 0;

    //アプリが起動した時に呼ばれる関数
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SharedPreferencesを使うための初期設定
        pref = getSharedPreferences("cocktail_base", MODE_PRIVATE);

        //お酒の画面上の表示が消えていたらここで初期化する
        editor = pref.edit();
        editor.putBoolean("Gin", false);
        editor.putBoolean("Vodka", false);
        editor.putBoolean("Rum", false);
        editor.putBoolean("Tequila", false);
        editor.putBoolean("Tonic", false);

        editor.commit();

        //button-変数と activity_main.xmlのidを結びつける
        buttonGin = (ImageView)findViewById(R.id.buttongin);
        buttonVodka = (ImageView)findViewById(R.id.buttonvodka);
        buttonRum = (ImageView)findViewById(R.id.buttonrum);
        buttonTequila = (ImageView)findViewById(R.id.buttontequlla);

        buttonTonic = (ImageView)findViewById(R.id.buttontonic);
        buttonOrange = (ImageView)findViewById(R.id.buttonorange);
        buttonGrapefruit = (ImageView)findViewById(R.id.buttongrape);
        buttonGingerale = (ImageView)findViewById(R.id.buttonGinger);



        //ジンが取られたら
        if(pref.getBoolean("Gin", false) == true){
            //ジンを見えなくする
            buttonGin.setVisibility(View.INVISIBLE);

        }
        //ウォッカが取られたら
        if(pref.getBoolean("Vodka", false) == true){
            //ウォッカを見えなくする
            buttonVodka.setVisibility(View.INVISIBLE);

        }
        //ラムが取られたら
        if(pref.getBoolean("Rum", false) == true){
            //ウォッカを見えなくする
            buttonRum.setVisibility(View.INVISIBLE);
        }
        //テキーラが取られたら
        if(pref.getBoolean("Tequila", false) == true){
            //テキーラを見えなくする
            buttonTequila.setVisibility(View.INVISIBLE);
        }
    }

    //ベースとなるお酒の処理
    //ジンがクリックされた時の処理
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

    //ラムをクリックした際の処理
    public void clickrum (View v){
        //トーストを表示
        Toast.makeText(this, "ラムを手に取りました", Toast.LENGTH_SHORT).show();

        //SharedPreferencesにラムを手に入れたことを書き込む
        editor = pref.edit();
        editor.putBoolean("Rum", true);
        editor.commit();
        //ラムを見えなくする
        buttonRum.setVisibility(View.INVISIBLE);

    }

    //テキーラをクリックした際の処理
    public void clicktequila (View v){
        //トーストを表示
        Toast.makeText(this, "テキーラを手に取りました", Toast.LENGTH_SHORT).show();

        //SharedPreferencesにテキーラを手に入れたことを書き込む
        editor = pref.edit();
        editor.putBoolean("Tequila", true);
        editor.commit();
        //テキーラを見えなくする
        buttonTequila.setVisibility(View.INVISIBLE);

    }

    //割ものなどの選択
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

        //ウォッカを選択している場合→スクリュードライバーへ
        // int cocktail num = 12 取得
        }else if(pref.getBoolean("Vodka", false) == true){
            //Orangejuiceを見えなくする
            Toast.makeText(this, "オレンジジュースを手に取りました", Toast.LENGTH_SHORT).show();

            buttonOrange.setVisibility(View.INVISIBLE);

            editor = pref.edit();
            editor.putBoolean("Orange", true);
            editor.commit();

            Toast.makeText(this, "作れるカクテルがあるよ！", Toast.LENGTH_SHORT).show();

            cocktailnum = 12;

            //shake画面へ移動
            Intent intent = new Intent(this, shakeActivity2.class);

            //intの値の受け渡し処理
            intent.putExtra("COCKTAILCODE", cocktailnum);
            startActivity(intent);

            //テキーラを選択している場合→テキーラサンライズへ
            //cocktailnum = 20 を取得
        }else if(pref.getBoolean("Tequila", false) == true){
            //Orangejuiceを見えなくする
            Toast.makeText(this, "オレンジジュースを手に取りました", Toast.LENGTH_SHORT).show();

            buttonOrange.setVisibility(View.INVISIBLE);

            editor = pref.edit();
            editor.putBoolean("Orange", true);
            editor.commit();

            Toast.makeText(this, "作れるカクテルがあるよ！", Toast.LENGTH_SHORT).show();

            cocktailnum = 20;

            //shake画面へ移動
            Intent intent = new Intent(this, shakeActivity2.class);

            //intの値の受け渡し処理
            intent.putExtra("COCKTAILCODE", cocktailnum);
            startActivity(intent);

        }else {
            Toast.makeText(this, "作れるカクテルがありません", Toast.LENGTH_SHORT).show();
        }

    }

    //グレープフルーツジュースをクリックした時の処理
    public void clickgrape (View v){
        //ウォッカを選択している時→ブルドッグ
        //cocktailnum = 10
        if (pref.getBoolean("Vodka",false)==true){
            //グレープフルーツジュースを見えなくする
            Toast.makeText(this, "グレープフルーツジュースを手に取りました", Toast.LENGTH_SHORT).show();

            buttonGrapefruit.setVisibility(View.INVISIBLE);

            editor = pref.edit();
            editor.putBoolean("Grapefruit", true);
            editor.commit();

            Toast.makeText(this, "作れるカクテルがあるよ！", Toast.LENGTH_SHORT).show();

            cocktailnum = 10;

            //shake画面へ移動
            Intent intent = new Intent(this, shakeActivity2.class);

            //intの値の受け渡し処理
            intent.putExtra("COCKTAILCODE", cocktailnum);
            startActivity(intent);

        }else{
            Toast.makeText(this, "作れるカクテルがありません", Toast.LENGTH_SHORT).show();
        }

    }

    //ジンジャーエールをクリックした時の処理
    public void clickginger (View v){
        //ウォッカを選択している時→モスコミュール
        //cocktailnum = 9
        if (pref.getBoolean("Vodka",false)==true){
            //ジンジャーエールを見えなくする
            Toast.makeText(this, "ジンジャーエールを手に取りました", Toast.LENGTH_SHORT).show();

            buttonGingerale.setVisibility(View.INVISIBLE);

            editor = pref.edit();
            editor.putBoolean("Gingerale", true);
            editor.commit();

            Toast.makeText(this, "作れるカクテルがあるよ！", Toast.LENGTH_SHORT).show();

            cocktailnum = 9;

            //shake画面へ移動
            Intent intent = new Intent(this, shakeActivity2.class);

            //intの値の受け渡し処理
            intent.putExtra("COCKTAILCODE", cocktailnum);
            startActivity(intent);

        }else{
            Toast.makeText(this, "作れるカクテルがありません", Toast.LENGTH_SHORT).show();
        }

    }

}
