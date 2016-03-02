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
    public int resultnum;


    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cocktailconclusion);

        explaincock = (TextView)findViewById(R.id.textView);

        //MainActivityの結果を引き継ぎ
        Bundle extras = getIntent().getExtras();
        resultnum = extras.getInt("COCKTAILCODE");

        gintonic();
        orangeblossom();
        screwdriver();

    }

    //resultnumの値に応じて、対応するカクテルの画像と説明を表示

    //　ジントニック (resultnum == 1)
    public void gintonic() {
        if (resultnum == 1){

            explaincock.setText("ジントニックの説明");

            //画像の配置
            ImageView imageview = (ImageView)findViewById(R.id.imgcocktail);
            imageview.setImageResource(R.drawable.gintonic);


        }
    }

    //オレンジブロッサム (resultnum == 3)
    public void orangeblossom() {
        if (resultnum == 3){

            explaincock.setText("オレンジ・ブロッサム（英語：orange blossom）は、ジンベースのカクテル。");

            //画像の配置
            ImageView imageview = (ImageView)findViewById(R.id.imgcocktail);
            imageview.setImageResource(R.drawable.orangeblossam);


        }
    }

    //スクリュードライバー (resultnum == 12)
    public void screwdriver() {
        if (resultnum == 12){

            explaincock.setText("スクリュードライバーの説明");

            //画像の配置
            ImageView imageview = (ImageView)findViewById(R.id.imgcocktail);
            imageview.setImageResource(R.drawable.screwdriver);


        }
    }


}
