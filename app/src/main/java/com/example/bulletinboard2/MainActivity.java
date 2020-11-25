package com.example.bulletinboard2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout cover0;
    ConstraintLayout cover1;
    ConstraintLayout cover2;
    LinearLayout cover3;
    LinearLayout cover4;


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
                    Intent myIntent = new Intent(v.getContext(), Article1.class);
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
                    Intent myIntent = new Intent(v.getContext(), Article2.class);
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
                    Intent myIntent = new Intent(v.getContext(), Article3.class);
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
                    Intent myIntent = new Intent(v.getContext(), Article4.class);
                    startActivityForResult(myIntent, 0);
                }
            }
        });
    }
}