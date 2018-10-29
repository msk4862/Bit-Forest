package gamedevelopers.funcandi.taskworkflow.Puzzles;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import gamedevelopers.funcandi.taskworkflow.Level1;
import gamedevelopers.funcandi.taskworkflow.LevelCompletedDialog;
import gamedevelopers.funcandi.taskworkflow.R;

public class Puzzle1 extends AppCompatActivity implements View.OnClickListener{


    Button b1, b2, b3, b4;
    Drawable wrong, right;

    ImageView check;
    TextView text;


    Typeface t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle1);

            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


            t = Typeface.createFromAsset(getAssets(), "raleway.ttf");


            wrong = ContextCompat.getDrawable(this, R.drawable.brain_wrong);
            right = ContextCompat.getDrawable(this, R.drawable.brain_check);

            check = (ImageView) findViewById(R.id.imageView2);

            b1 = (Button) findViewById(R.id.button2);
            b2 = (Button) findViewById(R.id.button3);
            b3 = (Button) findViewById(R.id.button4);
            b4 = (Button) findViewById(R.id.button5);

            b1.setOnClickListener(this);
            b2.setOnClickListener(this);
            b3.setOnClickListener(this);
            b4.setOnClickListener(this);


            text = (TextView) findViewById(R.id.textView2);


            text.setTypeface(t);
            b1.setTypeface(t);
            b2.setTypeface(t);
            b3.setTypeface(t);
            b4.setTypeface(t);
        }

        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.button2) {

                check.setBackground(wrong);

                check.setVisibility(View.VISIBLE);
                timerDelayRemoveView(800, check);

            }

            if (v.getId() == R.id.button3) {

                check.setBackground(wrong);

                check.setVisibility(View.VISIBLE);
                timerDelayRemoveView(500, check);

            }

            if (v.getId() == R.id.button4) {

                check.setBackground(wrong);

                check.setVisibility(View.VISIBLE);
                timerDelayRemoveView(500, check);

            }

            if (v.getId() == R.id.button5) {




                check.setBackground(right);

                Level1.isCompleted2=true;

                check.setVisibility(View.VISIBLE);
                timerDelayRemoveView(500, check);

                LevelCompletedDialog dialog = new LevelCompletedDialog(Puzzle1.this, Level1.class);


            }
        }

        public void timerDelayRemoveView(long time, final ImageView img) {

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    img.setVisibility(View.GONE);
                }
            }, time);
        }

    }
