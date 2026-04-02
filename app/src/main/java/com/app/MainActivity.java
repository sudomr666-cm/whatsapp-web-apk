package com.app;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.*;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String SERVER = "http://192.168.0.105:3000/send"; // 👈 CHANGE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.sendBtn);

        btn.setOnClickListener(v -> send());
    }

    void send() {

        OkHttpClient client = new OkHttpClient();

        String json = "{\"number\":\"8801XXXXXXXXX\",\"message\":\"Hello Boss\"}";

        RequestBody body = RequestBody.create(
                json,
                MediaType.get("application/json")
        );

        Request request = new Request.Builder()
                .url(SERVER)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });
    }
}
