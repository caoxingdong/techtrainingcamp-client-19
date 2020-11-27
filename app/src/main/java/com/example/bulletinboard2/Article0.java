package com.example.bulletinboard2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import org.apache.commons.text.StringEscapeUtils;


import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Article0 extends AppCompatActivity {

    TextView content;
    paraAdapter adapter;
    ListView lv;
    TextView tvTitle;
    TextView tvAuthor;

    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        String retrivedToken  = preferences.getString("TOKEN",null);
        String id  = preferences.getString("id",null);
        String title  = preferences.getString("title",null);
        String author  = preferences.getString("author",null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article0);
        lv = findViewById(R.id.lv);
        tvTitle = findViewById(R.id.article0title);
        tvAuthor = findViewById(R.id.article0author);
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    OkHttpClient client = new OkHttpClient().newBuilder()
                            .build();
                    Request request = new Request.Builder()
                            .url("https://vcapi.lvdaqian.cn/article/"+id+"?markdown=true")
                            .method("GET", null)
                            .addHeader("accept", "application/json")
                            .addHeader("Authorization", "Bearer " + retrivedToken)
                            .build();
                    Response response = client.newCall(request).execute();
                    String res = response.body().string();
                    JSONObject obj = new JSONObject(res);
                    String data = obj.getString("data");
                    String[] strings = data.split("\\n", -1);
                    if (id.equals("event_01")) {
                        strings[10] = "-" + strings[10].substring(3);
                    }
                    else if (id.equals("teamBuilding_04")) {
                        strings[1] = strings[2].substring(0,29);
                        strings[2] = strings[2].substring(29);
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter = new paraAdapter(getApplicationContext(), strings);
                            lv.setAdapter(adapter);
                            tvAuthor.setText(author);
                            tvTitle.setText(title);
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
