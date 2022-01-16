package com.example.bloom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent i = getIntent();
        String active_user = "Hello, " + i.getStringExtra("username") + "!";

        TextView active_user_tv = findViewById(R.id.active_user_textView);
        active_user_tv.setText(active_user);
    }
}