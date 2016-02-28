package com.lifeistech.android.cocktailmaker;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by joeykw on 2016/02/27.
 */
public class CocktailConclusion extends AppCompatActivity {

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cocktailconclusion);

        ImageView imgcocktail;
        TextView textView;

        textView = (TextView)findViewById(R.id.textView);


        //分身（インスタンス）を生成


        //このアクティビティ内のprefと、他のActivityから情報を引っ張ってくる



    }


}
