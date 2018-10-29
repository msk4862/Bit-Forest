package gamedevelopers.funcandi.taskworkflow;

import android.content.Intent;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button level1,level2,level3, level4, level5;
    TextView gamename;
    public Typeface Carter,Bungee, wooden;

    private MediaPlayer game, click;


    public static boolean isLevel1 = true;
    public static boolean isLevel2 = true;
    public static boolean isLevel3 = true;
    public static boolean isLevel4 = true;
    public static boolean isLevel5 = true;


    public String vendor="Domino's";

Button back;

    Animation myAnim;

    public static ArrayList<String> tasks1 = new ArrayList<String>();
    public static ArrayList<String> tasks2 = new ArrayList<String>();
    public static ArrayList<String> tasks3 = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        game = MediaPlayer.create(this, R.raw.bg);
        click = MediaPlayer.create(this, R.raw.bubble);

        game.setLooping(true);

        back=(Button) findViewById(R.id.back);
        back.setOnClickListener(this);


        tasks1.add("Upload a selfie with "+ vendor+" outlet");
        tasks1.add("Upload a selfie with "+ "KFC's"+" outlet");


        tasks2.add("Solve the puzzle!");



        tasks3.add("Upload a selfie with your family");



        gamename=(TextView) findViewById(R.id.gamename);
       level1=(Button) findViewById(R.id.level1);
        level2=(Button) findViewById(R.id.level2);
        level3=(Button) findViewById(R.id.level3);
        level4=(Button) findViewById(R.id.level4);
        level5=(Button) findViewById(R.id.level5);

        Carter = Typeface.createFromAsset(getAssets(), "CarterOne.ttf");
        wooden = Typeface.createFromAsset(getAssets(), "wood.ttf");

        level1.setTypeface(Carter);
        level2.setTypeface(Carter);
        level3.setTypeface(Carter);
        level4.setTypeface(Carter);
        level5.setTypeface(Carter);

        gamename.setTypeface(wooden);

        if(isLevel1){
            level1.setBackgroundResource(R.drawable.open3star);
            level2.setBackgroundResource(R.drawable.open0star);

        }

        if(isLevel2){
            level2.setBackgroundResource(R.drawable.open3star);
            level3.setBackgroundResource(R.drawable.open0star);

        }

        if(isLevel3){
            level3.setBackgroundResource(R.drawable.open3star);
            level4.setBackgroundResource(R.drawable.open0star);

        }

        if(isLevel4){
            level4.setBackgroundResource(R.drawable.open3star);
            level5.setBackgroundResource(R.drawable.open0star);

        }
        if(isLevel5){
            level5.setBackgroundResource(R.drawable.open3star);

        }


        level1.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0x00000000));
        level2.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF,0x00000000));
        level3.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0x00000000));
        level4.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0x00000000));
        level5.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0x00000000));

        level1.setOnClickListener(this);
        level2.setOnClickListener(this);
        level3.setOnClickListener(this);
        level4.setOnClickListener(this);
        level5.setOnClickListener(this);


        myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        myAnim.setDuration(1000);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Restart all level
       /* if (isLevel3) {
            if (Build.VERSION_CODES.KITKAT <= Build.VERSION.SDK_INT) {
                ((ActivityManager)getApplicationContext().getSystemService(ACTIVITY_SERVICE))
                        .clearApplicationUserData(); // note: it has a return value!
            } else {
                // use old hacky way, which can be removed
                // once minSdkVersion goes above 19 in a few years.
            }
        }*/

        level1.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0x00000000));
        level2.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF,0x00000000));
        level3.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0x00000000));
        level4.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0x00000000));
        level5.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0x00000000));

    }

    @Override
    protected void onResume() {
        super.onResume();

        game.setLooping(true);
        game.start();
    }


    @Override
    protected void onPause() {
        super.onPause();

        game.pause();
    }

    public void onBackPressed() {
        super.onBackPressed();

        game.pause();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.level1) {
            Intent i = new Intent(MainActivity.this, Level1.class);
            level1.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFF00, 0x0000FF00));
            startActivity(i);

        } else if (v.getId() == R.id.level2) {
            if(isLevel1) {
                Intent i = new Intent(MainActivity.this, Level2.class);
                level2.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xF00FF0F0));
                startActivity(i);
            }
        } else if (v.getId() == R.id.level3) {
            if(isLevel2) {
                Intent i = new Intent(MainActivity.this, Level3.class);
                level3.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xF00FF0F0));
                startActivity(i);
            }
        }

        else if (v.getId() == R.id.level4) {
            if(isLevel3) {
                Intent i = new Intent(MainActivity.this, Level4.class);
                level4.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xF00FF0F0));
                startActivity(i);
            }
        }

        else if (v.getId() == R.id.level5) {
            if(isLevel4) {
                Intent i = new Intent(MainActivity.this, Level5.class);
                level5.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xF00FF0F0));
                startActivity(i);
            }
        }


        else if(v.getId()==R.id.back){

            back.startAnimation(myAnim);
            click.start();

            myAnim.setAnimationListener(new Animation.AnimationListener(){
                public void onAnimationStart(Animation a){}
                public void onAnimationRepeat(Animation a){}
                public void onAnimationEnd(Animation a){

                    Intent i = new Intent(MainActivity.this, LauncherActivity.class);
                    startActivity(i);
                }

            });

        }
    }



}
