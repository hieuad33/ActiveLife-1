package in.brandvidiya.yogaforweightloss.mainpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import in.brandvidiya.yogaforweightloss.R;
import in.brandvidiya.yogaforweightloss.slider.slider;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT =3000;
    Animation up,down;
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView imageView = findViewById(R.id.appsplash);
        up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        imageView.setAnimation(up);


        TextView textView = findViewById(R.id.appname);
        down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        textView.setAnimation(down);


        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {

                Intent homeIntent = new Intent(MainActivity.this, slider.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }


}