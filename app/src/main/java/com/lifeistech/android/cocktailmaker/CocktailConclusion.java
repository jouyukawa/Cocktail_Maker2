package com.lifeistech.android.cocktailmaker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by joeykw on 2016/02/27.
 */
public class CocktailConclusion extends AppCompatActivity {

    //カクテル解説用の文をここで設定
    TextView explaincock;
    String explain;

    //MainActivityの結果を引き継ぐ為の引数
    private int resultnum;


    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cocktailconclusion);

        explaincock = (TextView)findViewById(R.id.textView);

        //MainActivityの結果を引き継ぎ
        Bundle extras = getIntent().getExtras();
        resultnum = extras.getInt("COCKTAILCODE");

        gintonic();

    }

    //resultnumの値に応じて、対応するカクテルの画像と説明を表示
    public void gintonic() {
        if (resultnum == 1){

            explaincock.setText("ジントニックの説明");

            //画像の配置
            ImageView imageview = (ImageView)findViewById(R.id.imgcocktail);
            imageview.setImageResource(R.drawable.gintonic);


        }
    }




}
