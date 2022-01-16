package com.example.bloom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}






    }

    public void handleLogin(View v) {
        TextView username_tv = findViewById(R.id.username_plainText);
        String username = username_tv.getText().toString();

        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("username", username);
        startActivity(i);
    }
}