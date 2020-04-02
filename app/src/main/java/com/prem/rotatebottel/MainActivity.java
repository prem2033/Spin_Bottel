package com.prem.rotatebottel;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random random ;
    private ImageView bottle;
    private Animation rotate;
    private static int lastDir,newDir;
    private  boolean spinning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        random = new Random();
        bottle=findViewById(R.id.bottle);
        bottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateBottel();
            }
        });
    }
    public void rotateBottel() {
        if (!spinning) {
             newDir = 360*6+random.nextInt(1800)*20;
            float  pivotX = bottle.getWidth() / 2;
            float pivotY = (float) (bottle.getHeight() / 1.90);
            rotate = new RotateAnimation(lastDir, newDir, pivotX, pivotY);
            rotate.setDuration(5000);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spinning = true;
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    spinning = false;
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            lastDir = newDir;
            bottle.startAnimation(rotate);
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
