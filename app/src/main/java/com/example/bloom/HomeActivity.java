package com.example.bloom;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import veryfi.*;

public class HomeActivity extends AppCompatActivity {

    ImageView imageView;
    ActivityResultLauncher<Intent> mGetContent;
    File f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }

        Intent i = getIntent();
        String active_user = "Hello, " + i.getStringExtra("username") + "!";

        TextView active_user_tv = findViewById(R.id.active_user_textView);
        active_user_tv.setText(active_user);

        imageView = findViewById(R.id.imageView);
        mGetContent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            Intent data = result.getData();
            assert data != null;
            Bitmap image = (Bitmap) data.getExtras().get("data");
            saveFile(image);

            String clientId = BuildConfig.CLIENT_ID;
            String clientSecret = BuildConfig.CLIENT_SECRET;
            String username = BuildConfig.USERNAME;
            String apiKey = BuildConfig.APIKEY;

//            Client client = VeryfiClientFactory.createClient( clientId, clientSecret, username, apiKey);
//            System.out.println(client);
//            VeryfiAPI v = new VeryfiAPI();
//            System.out.println(v.verifyUser());



            imageView.setImageBitmap(image);
//            setContentView(R.layout.activity_receipt);
        });
    }

    public void handleTrack(View v){
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        mGetContent.launch(intent);
    }

    public void handleExpenses(View v) {
        Intent i = new Intent(this, ExpenseMonthly.class);
        startActivity(i);
    }

    public void handleTemp(View v){
        Intent i = new Intent(this, ManualTracker.class);
        startActivity(i);

    }

    public void saveFile(Bitmap bitmap) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HHmmss").format(new Date());
        FileOutputStream fOut = null;

        f = new File(Environment.getExternalStorageDirectory()
                .toString() + "/" + timeStamp + ".png");
        try {
            f.createNewFile();
        } catch (IOException e) {
            System.out.println("err" + e);
        }
        try {
            fOut = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);

        try {
            assert fOut != null;
            fOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}