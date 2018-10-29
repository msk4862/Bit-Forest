package gamedevelopers.funcandi.taskworkflow.level1;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import gamedevelopers.funcandi.taskworkflow.Level1;
import gamedevelopers.funcandi.taskworkflow.LevelCompletedDialog;
import gamedevelopers.funcandi.taskworkflow.MainActivity;
import gamedevelopers.funcandi.taskworkflow.MyBounceInterpolator;
import gamedevelopers.funcandi.taskworkflow.R;

public class Task3 extends AppCompatActivity implements View.OnClickListener {
    TextView task, title;

    Typeface wooden;

    Animation myAnim;

    Button back, complete;

    MediaPlayer click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition( R.anim.slide_in, R.anim.slide_out );

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.e("mylog", "in Task1");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_level1_3);

        Random random = new Random();
//        int index = random.nextInt(MainActivity.tasks3.size());
        task = (TextView) findViewById(R.id.task);
        task.setText(MainActivity.tasks3.get(0));

        Log.e("mylog", "in levelset");
        title = (TextView) findViewById(R.id.text);
        Log.e("mylog", "in tsdjs");

        click = MediaPlayer.create(this, R.raw.bubble);


        wooden = Typeface.createFromAsset(getAssets(), "wood.ttf");

        title.setTypeface(wooden);

        back=(Button) findViewById(R.id.back1);
        complete=(Button) findViewById(R.id.upload);

        back.setOnClickListener(this);
        complete.setOnClickListener(this);


        myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        myAnim.setDuration(1000);


    /*   // Carter = Typeface.createFromAsset(getAssets(), "CarterOne.ttf");
        Log.e("mylog","in carter");
        //
        Log.e("mylog","in carterSS");
    }*/
    }
    public void onClick(View v) {

        if (v.getId() == R.id.upload) {
            click.start();

            complete.startAnimation(myAnim);
            Level1.isCompleted3=true;
            myAnim.setAnimationListener(new Animation.AnimationListener(){
                public void onAnimationStart(Animation a){}
                public void onAnimationRepeat(Animation a){}
                public void onAnimationEnd(Animation a){

                    LevelCompletedDialog dialog = new LevelCompletedDialog(Task3.this, Level1.class);

                }

            });
        }

        if (v.getId() == R.id.back1) {
            click.start();
            back.startAnimation(myAnim);
            myAnim.setAnimationListener(new Animation.AnimationListener(){
                public void onAnimationStart(Animation a){}
                public void onAnimationRepeat(Animation a){}
                public void onAnimationEnd(Animation a){

                    Intent i = new Intent(Task3.this, Level1.class);
                    Log.e("mylog","in level1");
                    startActivity(i);
                }

            });

        }
    }

}



