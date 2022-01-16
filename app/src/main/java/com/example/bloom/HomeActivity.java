package com.example.bloom;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    ImageView imageView;
    ActivityResultLauncher<Intent> mGetContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent i = getIntent();
        String active_user = "Hello, " + i.getStringExtra("username") + "!";

        TextView active_user_tv = findViewById(R.id.active_user_textView);
        active_user_tv.setText(active_user);

        imageView = findViewById(R.id.imageView);
        mGetContent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent data = result.getData();
                Bitmap image = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(image);
            }
        });
    }

    public void handleTrack(View v){
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        mGetContent.launch(intent);
    }

    public void handleExpenses(View v) {
        Intent i = new Intent(this, ViewExpenseActivity.class);
        startActivity(i);
    }

}