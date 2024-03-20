package org.myprojectofnotes2022.moviemax12.moviesisland20012;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private TextView byAchraf;
    private Animation animation;
    private static final int SPLASH_SPEED = 1800;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        byAchraf = findViewById(R.id.byachrafId);

        animation = AnimationUtils.loadAnimation(this , R.anim.by_achraf_animation);
        byAchraf.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SPEED);

    }
}