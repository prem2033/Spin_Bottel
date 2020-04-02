package com.prem.rotatebottel;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class splashScreen extends AppCompatActivity {
    Thread thread;
    ImageView bottle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
         thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread.sleep(1000);
                    startActivity(new Intent(splashScreen.this,MainActivity.class));
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
         });
           thread.start();
    }
}
