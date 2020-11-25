package com.example.bulletinboard2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import org.json.*;
import androidx.appcompat.app.AppCompatActivity;
import java.io.*;
import okhttp3.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Login extends AppCompatActivity {
    Button login;
    EditText editname;
    EditText editpassword;
//    String responseString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login = findViewById(R.id.blogin);
        editname = findViewById(R.id.editname);
        editpassword = findViewById(R.id.editpassword);
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name = editname.getText().toString();
                String password = editpassword.getText().toString();
                Log.d("login", "clicked" + name + password);


                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try  {
                            OkHttpClient client = new OkHttpClient().newBuilder()
                                    .build();
                            MediaType mediaType = MediaType.parse("application/json");
                            RequestBody body = RequestBody.create(mediaType, "{\r\n  \"username\": \""+name+"\",\r\n  \"password\": \""+password+"\"\r\n}");
                            Request request = new Request.Builder()
                                    .url("https://vcapi.lvdaqian.cn/login")
                                    .method("POST", body)
                                    .addHeader("Accept", "application/json")
                                    .addHeader("Content-Type", "application/json")
                                    .build();
                            Response response = client.newCall(request).execute();
                            String res = response.body().string();
                            System.out.println(res);
                            SharedPreferences preferences1 = getApplicationContext().getSharedPreferences("MY_APP",Context.MODE_PRIVATE);
                            String retrivedToken  = preferences1.getString("TOKEN","empty2");
                            Log.d("cover0", retrivedToken);
                            JSONObject obj = new JSONObject(res);
//                            String token = obj.getString("token");
                            String token = obj.getString("token");
                            Log.d("cover0", token);
                            SharedPreferences preferences = getApplicationContext().getSharedPreferences("MY_APP", Context.MODE_PRIVATE);
                            preferences.edit().putString("TOKEN",token).apply();
                            retrivedToken  = preferences1.getString("TOKEN",null);
                            Log.d("cover0", retrivedToken);
                            Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                            startActivityForResult(myIntent, 0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }
        });
    }
}



