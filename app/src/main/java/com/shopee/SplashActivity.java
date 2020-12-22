package com.shopee;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    private  static int SPLASH_SCREEN = 2000;

    Animation loadAnim,logoAnim;
    ImageView load, logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logoAnim = AnimationUtils.loadAnimation(this, R.anim.ani_trans );
        loadAnim = AnimationUtils.loadAnimation(this, R.anim.ani_rotate);

        load = findViewById(R.id.img_load);
        load.setAnimation(loadAnim);

        logo = findViewById(R.id.img_shopee);
        logo.setAnimation(logoAnim);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}