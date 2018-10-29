package gamedevelopers.funcandi.taskworkflow;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by msk on 07-10-2017.
 */




           /* The roulette has 37 sectors. The whole circle is 360 degrees. That makes 360 / 37 = 9.72 degrees
            each of the sectors. The first sector (number 32 red) starts from half the previous sector (number 0) and is 9.72
            degrees. That means it starts from 9.72 / 2 = 4.86 and ends in 4.86 + 9.72 = 14.58 degrees. In other hand 14.58
            equals 3 times 4.86. So i pick half the sector 4.86 as a FACTOR. Based on this factor  we calculate all the sectors.
                    The first one as we said is from FACTOR to FACTOR * 3. Second sector (number 15 black) is from FACTOR * 3 to FACTOR * 5.
                    And this continues for all of the sectors. Only the sector 0 is a little bit different. It starts from 360 degrees minus
                    FACTOR and ends with 0 degrees + FACTOR.*/

public class WheelActivity extends AppCompatActivity {

    TextView text;
    Button btn;
    ImageView wheel;

    Random r;

    Typeface t;

    int degrees=0, old_degrees=0;

    private static final float FACTOR = 15f;

    public static String value="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition( R.anim.slide_in, R.anim.slide_out );

        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_wheel);

        t = Typeface.createFromAsset(getAssets(), "budmo.ttf");

        text = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);
        wheel = (ImageView) findViewById(R.id.wheel);

        text.setTypeface(t);
        btn.setTypeface(t);

        r = new Random();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                old_degrees = degrees % 360;

                degrees = r.nextInt(3600) + 720;

                RotateAnimation rotate = new RotateAnimation(old_degrees, degrees, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(3600);
                rotate.setFillAfter(true);

                rotate.setInterpolator(new DecelerateInterpolator());

                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        text.setText("");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        text.setText(currentnumber(360 - (degrees % 360)));
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                wheel.startAnimation(rotate);
            }
        });
    }

    private String currentnumber(int degrees) {


        if (degrees >= (FACTOR * 1) && degrees <= (FACTOR * 3)) {
            value = "800";
        }

        if (degrees >= (FACTOR * 3) && degrees <= (FACTOR * 5)) {
            value = "600";
        }
        if (degrees >= (FACTOR * 5) && degrees <= (FACTOR * 7)) {
            value = "2000";
        }

        if (degrees >= (FACTOR * 7) && degrees <= (FACTOR * 9)) {
            value = "700";
        }
        if (degrees >= (FACTOR * 9) && degrees <= (FACTOR * 11)) {
            value = "1200";
        }
        if (degrees >= (FACTOR * 11) && degrees <= (FACTOR * 13)) {
            value = "50";
        }
        if (degrees >= (FACTOR * 13) && degrees <= (FACTOR * 15)) {
            value = "400";
        }
        if (degrees >= (FACTOR * 15) && degrees <= (FACTOR * 17)) {
            value = "1500";
        }
        if (degrees >= (FACTOR * 17) && degrees <= (FACTOR * 19)) {
            value = "300";
        }
        if (degrees >= (FACTOR * 19) && degrees <= (FACTOR * 21)) {
            value = "2000";
        }
        if (degrees >= (FACTOR * 21) && degrees <= (FACTOR * 23)) {
            value = "500";
        }


        // First section
        if ((degrees >= (FACTOR * 23) && degrees < 360) || (degrees >= 0 && degrees < (FACTOR *1))) {
            value = "1000";
        }


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(WheelActivity.this, Level1.class);
                startActivity(i);
            }
        }, 800);


        /*if (degrees >= (FACTOR * 25) && degrees <= (FACTOR * 27)) {
            value = "0";
        }
        if (degrees >= (FACTOR * 27) && degrees <= (FACTOR * 29)) {
            value = "3";
        }
        if (degrees >= (FACTOR * 29) && degrees <= (FACTOR * 31)) {
            value = "17";
        }
        if (degrees >= (FACTOR * 31) && degrees <= (FACTOR * 33)) {
            value = "11";
        }
        if (degrees >= (FACTOR * 33) && degrees <= (FACTOR * 35)) {
            value = "15";
        }
        if (degrees >= (FACTOR * 35) && degrees <= (FACTOR * 37)) {
            value = "13";
        }
        if (degrees >= (FACTOR * 37) && degrees <= (FACTOR * 39)) {
            value = "6";
        }
        if (degrees >= (FACTOR * 39) && degrees <= (FACTOR * 41)) {
            value = "4";
        }
        if (degrees >= (FACTOR * 41) && degrees <= (FACTOR * 43)) {
            value = "18";
        }
        if (degrees >= (FACTOR * 43) && degrees <= (FACTOR * 45)) {
            value = "9";
        }
        if (degrees >= (FACTOR * 45) && degrees <= (FACTOR * 47)) {
            value = "11";
        }
        if (degrees >= (FACTOR * 47) && degrees <= (FACTOR * 49)) {
            value = "7";
        }*/

        LauncherActivity.REWARD+= Integer.parseInt(value);



        return "You Got\n" +" \u20BF "+ value ;
    }


}

