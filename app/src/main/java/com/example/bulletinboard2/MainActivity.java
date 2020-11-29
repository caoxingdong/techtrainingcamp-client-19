package com.example.bulletinboard2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout cover0;
    ConstraintLayout cover1;
    ConstraintLayout cover2;
    LinearLayout cover3;
    LinearLayout cover4;
    Object[] layoutArr;
    String[] ids;
    String[] titles;
    String[] authors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cover0 = findViewById(R.id.cover0);
        cover1 = findViewById(R.id.cover1);
        cover2 = findViewById(R.id.cover2);
        cover3 = findViewById(R.id.cover3);
        cover4 = findViewById(R.id.cover4);

        cover0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getApplicationContext().getSharedPreferences("MY_APP",Context.MODE_PRIVATE);
                String retrivedToken  = preferences.getString("TOKEN",null);

                if (retrivedToken.equals("empty")) {
                    Intent myIntent = new Intent(v.getContext(), Login.class);
                    startActivityForResult(myIntent, 0);
                }
                else {
                    preferences.edit().putString("id","event_01").apply();
                    preferences.edit().putString("title","2020字节跳动全球员工摄影大赛邀请函").apply();
                    preferences.edit().putString("author","bytedance 2020年10月7日").apply();
                    Intent myIntent = new Intent(v.getContext(), Article0.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });

        cover1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getApplicationContext().getSharedPreferences("MY_APP",Context.MODE_PRIVATE);
                String retrivedToken  = preferences.getString("TOKEN",null);

                if (retrivedToken.equals("empty")) {
                    Intent myIntent = new Intent(v.getContext(), Login.class);
                    startActivityForResult(myIntent, 0);
                }
                else {
                    preferences.edit().putString("id","event_02").apply();
                    preferences.edit().putString("title","Lark·巡洋计划开发者大赛圆满结束").apply();
                    preferences.edit().putString("author","bytedance 2019年10月7日").apply();
                    Intent myIntent = new Intent(v.getContext(), Article0.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });

        cover2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getApplicationContext().getSharedPreferences("MY_APP",Context.MODE_PRIVATE);
                String retrivedToken  = preferences.getString("TOKEN",null);

                if (retrivedToken.equals("empty")) {
                    Intent myIntent = new Intent(v.getContext(), Login.class);
                    startActivityForResult(myIntent, 0);
                }
                else {
                    preferences.edit().putString("id","bytetalk_01").apply();
                    preferences.edit().putString("title","绝对坦率：打造反馈文化").apply();
                    preferences.edit().putString("author","bytedance 2020年7月7日").apply();
                    Intent myIntent = new Intent(v.getContext(), Article0.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });

        cover3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getApplicationContext().getSharedPreferences("MY_APP",Context.MODE_PRIVATE);
                String retrivedToken  = preferences.getString("TOKEN",null);

                if (retrivedToken.equals("empty")) {
                    Intent myIntent = new Intent(v.getContext(), Login.class);
                    startActivityForResult(myIntent, 0);
                }
                else {
                    preferences.edit().putString("id","teamBuilding_04").apply();
                    preferences.edit().putString("title","4-12 虹桥天地，蹦起来吧！").apply();
                    preferences.edit().putString("author","vc team 2019年4月11日").apply();
                    Intent myIntent = new Intent(v.getContext(), Article0.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });

        cover4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getApplicationContext().getSharedPreferences("MY_APP",Context.MODE_PRIVATE);
                String retrivedToken  = preferences.getString("TOKEN",null);

                if (retrivedToken.equals("empty")) {
                    Intent myIntent = new Intent(v.getContext(), Login.class);
                    startActivityForResult(myIntent, 0);
                }
                else {
                    preferences.edit().putString("id","teamBuilding_09").apply();
                    preferences.edit().putString("title","9月18日淀山湖户外团建").apply();
                    preferences.edit().putString("author","vc mobile team 2020年9月7日").apply();
                    Intent myIntent = new Intent(v.getContext(), Article0.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }
}