package gamedevelopers.funcandi.taskworkflow;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import gamedevelopers.funcandi.taskworkflow.level5.*;


public class Level5 extends AppCompatActivity implements View.OnClickListener{

    public static boolean isCompleted1 = true;
    public static boolean isCompleted2 = true;
    public static boolean isCompleted3 = true;


    Animation myAnim;


    Button back,task1,task2,task3, treasure;

    ImageView star1, star2, star3, avatar1, avatar2, avatar3;

    private MediaPlayer click, game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        overridePendingTransition( R.anim.slide_in, R.anim.slide_out );

        //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_level5);

        click = MediaPlayer.create(this, R.raw.bubble);
        game = MediaPlayer.create(this, R.raw.bg);
        game.setLooping(true);


        back=(Button) findViewById(R.id.back);
        task1=(Button) findViewById(R.id.task1);
        task2=(Button) findViewById(R.id.task2);
        task3=(Button) findViewById(R.id.task3);

        star1 = (ImageView) findViewById(R.id.imageView2);
        star2 = (ImageView) findViewById(R.id.imageView3);
        star3 = (ImageView) findViewById(R.id.imageView4);

        avatar1 = (ImageView) findViewById(R.id.imageView5);
        avatar2 = (ImageView) findViewById(R.id.imageView6);
        avatar3 = (ImageView) findViewById(R.id.imageView7);

        treasure = (Button) findViewById(R.id.button9);

        if (isCompleted1) {
            task2.setBackgroundResource(R.drawable.t2);
            star1.setVisibility(View.VISIBLE);

            avatar1.setVisibility(View.INVISIBLE);
            avatar2.setVisibility(View.VISIBLE);
            avatar3.setVisibility(View.INVISIBLE);
        }
        if (isCompleted2) {
            task3.setBackgroundResource(R.drawable.t3);
            star2.setVisibility(View.VISIBLE);

            avatar1.setVisibility(View.INVISIBLE);
            avatar2.setVisibility(View.INVISIBLE);
            avatar3.setVisibility(View.VISIBLE);
        }
        if (isCompleted3) {
            treasure.setBackgroundResource(R.drawable.openchest);
            star3.setVisibility(View.VISIBLE);

            avatar1.setVisibility(View.INVISIBLE);
            avatar2.setVisibility(View.INVISIBLE);
            avatar3.setVisibility(View.INVISIBLE);
        }

        task1.setOnClickListener(this);
        task2.setOnClickListener(this);
        task3.setOnClickListener(this);
        back.setOnClickListener(this);
        treasure.setOnClickListener(this);



        if (isCompleted1 && isCompleted2 && isCompleted3) {
            MainActivity.isLevel4=true;
        }


//Implementing BOUNCE
        myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        myAnim.setDuration(1000);

    }


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



    public void onClick(View v) {
        if (v.getId() == R.id.task1) {
            click.start();
            task1.startAnimation(myAnim);
            myAnim.setAnimationListener(new Animation.AnimationListener(){
                public void onAnimationStart(Animation a){}
                public void onAnimationRepeat(Animation a){}
                public void onAnimationEnd(Animation a){

                    Intent i = new Intent(Level5.this, gamedevelopers.funcandi.taskworkflow.Intro.ui.StoryActivity4.class);
                    startActivity(i);
                }

            });

        } else if (v.getId() == R.id.task2) {


            if(Level5.isCompleted1) {
                click.start();
                task2.startAnimation(myAnim);

                myAnim.setAnimationListener(new Animation.AnimationListener(){
                    public void onAnimationStart(Animation a){}
                    public void onAnimationRepeat(Animation a){}
                    public void onAnimationEnd(Animation a){

                        Intent i = new Intent(Level5.this, Task2.class);
                        Log.e("mylog","in level1");
                        //startActivity(i);
                    }

                });
            }
        } else if (v.getId() == R.id.task3) {



            if(Level5.isCompleted2) {
                click.start();
                task3.startAnimation(myAnim);
                myAnim.setAnimationListener(new Animation.AnimationListener(){
                    public void onAnimationStart(Animation a){}
                    public void onAnimationRepeat(Animation a){}
                    public void onAnimationEnd(Animation a){

                        Intent i = new Intent(Level5.this, gamedevelopers.funcandi.taskworkflow.Intro.ui.QuizActivity5.class);
                        Log.e("mylog","in level1");
                        startActivity(i);
                    }

                });
            }
        }


        else if(v.getId()== R.id.button9) {

            if (isCompleted1 && isCompleted2 && isCompleted3) {
                treasure.startAnimation(myAnim);
                myAnim.setAnimationListener(new Animation.AnimationListener(){
                    public void onAnimationStart(Animation a){}
                    public void onAnimationRepeat(Animation a){}
                    public void onAnimationEnd(Animation a){

                        Intent i = new Intent(Level5.this, WheelActivity.class);
                        startActivity(i);
                    }

                });
            }
        }

        else if(v.getId()==R.id.back){
            click.start();

            back.startAnimation(myAnim);

            myAnim.setAnimationListener(new Animation.AnimationListener(){
                public void onAnimationStart(Animation a){}
                public void onAnimationRepeat(Animation a){}
                public void onAnimationEnd(Animation a){

                    Intent i = new Intent(Level5.this, gamedevelopers.funcandi.taskworkflow.Intro.ui.QuizActivity5.class);
                    startActivity(i);
                }

            });

        }
    }
}
