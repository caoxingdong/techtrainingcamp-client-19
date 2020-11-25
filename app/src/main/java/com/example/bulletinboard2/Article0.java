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

    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
        String retrivedToken  = preferences.getString("TOKEN",null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article0);
        lv = findViewById(R.id.lv);
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    OkHttpClient client = new OkHttpClient().newBuilder()
                            .build();
                    Request request = new Request.Builder()
                            .url("https://vcapi.lvdaqian.cn/article/event_01?markdown=true")
                            .method("GET", null)
                            .addHeader("accept", "application/json")
                            .addHeader("Authorization", "Bearer " + retrivedToken)
                            .build();
                    Response response = client.newCall(request).execute();
                    String res = response.body().string();
                    JSONObject obj = new JSONObject(res);
                    String data = obj.getString("data");
//                    Log.d("data", (data));
                    String[] strings = data.split("\\n", -1);
                    strings[10] = "-" + strings[10].substring(3);
//                    for (int i=0; i<strings.length; i++) {
//                        System.out.println(i);
//                        System.out.println("new line: " + strings[i]);
//                        System.out.println(strings[i].length());
//                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter = new paraAdapter(getApplicationContext(), strings);
                            lv.setAdapter(adapter);
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
