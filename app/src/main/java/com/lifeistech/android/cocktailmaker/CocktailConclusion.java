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
        tequilasunrise();
        bulldog();
        moscomule();

    }

    //resultnumの値に応じて、対応するカクテルの画像と説明を表示

    //　ジントニック (resultnum == 1)
    public void gintonic() {
        if (resultnum == 1){

            explaincock.setText("ジントニックとは、ジンベースのカクテルで最もポピュラーなカクテルの一つ。熱帯にあるイギリスの植民地で、健康飲料として飲まれていたトニックウォーターに、ジンを入れてみたら驚くほど飲み口がよかったというのが始まり。シンプルなレシピだけに、味わいはバーによって、またバーテンダーによって微妙に異なる。こだわればこだわるほど奥の深いカクテルである。");

            //画像の配置
            ImageView imageview = (ImageView)findViewById(R.id.imgcocktail);
            imageview.setImageResource(R.drawable.gintonic);


        }
    }

    //オレンジブロッサム (resultnum == 3)
    public void orangeblossom() {
        if (resultnum == 3){

            explaincock.setText("オレンジ・ブロッサム（英語：orange blossom）は、ジンベースのカクテル。「ジン・オレンジ」とも呼ばれ、文字通りのオレンジジュースのフルーティーなおいしさと、ジンのさわやかな香りがぴったりマッチしたカクテル。二つの材料をグラスに注ぐだけで出来上がるので、家庭でも簡単につくることのできる、シンプルでおいしいカクテル。");

            //画像の配置
            ImageView imageview = (ImageView)findViewById(R.id.imgcocktail);
            imageview.setImageResource(R.drawable.orangeblossam);


        }
    }

    //モスコミュールの説明
    public void moscomule() {
        if (resultnum == 9){

            explaincock.setText("モスコミュールとは、モスコミュール」は、1946年、ハリウッドのサンセット大通りに面した“コックンプル”というレストランで生まれた。その口当たりの強さから、“モスクワのラバ（強情者）”という名前がつけられたカクテル。ウオツカベースのカクテルの中で最も有名なカクテルのひとつ。");

            //画像の配置
            ImageView imageview = (ImageView)findViewById(R.id.imgcocktail);
            imageview.setImageResource(R.drawable.moscomule);


        }
    }

    //ブルドッグの説明
    public void bulldog() {
        if (resultnum == 10){

            explaincock.setText("ソルティドッグとは、イギリス海員達のスラングで“甲板員”のこと。潮風や波浪を浴びながら甲板上で仕事をすることから“塩辛い野郎”と呼ばれるようになった。このイギリス生まれのカクテルの原型は現在のレシピとずいぶん違っている。ベースはジン、これにグレープフルーツジュースを加え、塩をひとつまみ加えてシェークし、カクテルグラスに注ぐというものだった。現在のスタイルになったのはアメリカに渡ってからのこと。");

            //画像の配置
            ImageView imageview = (ImageView)findViewById(R.id.imgcocktail);
            imageview.setImageResource(R.drawable.bulldog);


        }
    }

    //スクリュードライバー (resultnum == 12)
    public void screwdriver() {
        if (resultnum == 12){

            explaincock.setText("スクリュードライバーとは、「スクリュー・ドライバー」とは“ネジ回し（ドライバー）”のこと。イランの油田（テキサスという説もある）の労働者たちが、ウオッカとオレンジジュースをネジ回しで混ぜて飲んだことから、この名前がついたという。クセのないウオッカとオレンジジュースの組み合わせなのでとても口当たりがよい。アルコール度数は高めなので、飲みすぎには注意！");

            //画像の配置
            ImageView imageview = (ImageView)findViewById(R.id.imgcocktail);
            imageview.setImageResource(R.drawable.screwdriver);


        }
    }

    //テキーラサンライズ (resultnum = 20)
    public void tequilasunrise() {
        if (resultnum == 20){

            explaincock.setText("テキーラサンライズとは、このカクテルの人気には、二つのロックグループの存在が大きくかかわっている。ローリング・ストーンズとイーグルスだ。ローリング・ストーンズのミック・ジャガーはこのカクテルと恋に落ち、イーグルスのセカンド・アルバムには、同名の曲が収録された。その秘密は、テキーラのもつシャープさにオレンジとグレナデンの甘い芳香が加わったなんともいえない味わいと、燃えるような朝焼けをグラスの中にあらわした絶妙な色合いであろう。テキーラの人気を不動のものとしたこのカクテル。ロックを聞きながら、飲んでみたい。オレンジジュースをレモンジュースにかえると「テキーラ・サンセット」になる。");

            //画像の配置
            ImageView imageview = (ImageView)findViewById(R.id.imgcocktail);
            imageview.setImageResource(R.drawable. tequilasunrise);

        }
    }


}
