package gamedevelopers.funcandi.taskworkflow.Intro;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import gamedevelopers.funcandi.taskworkflow.R;

public class LaunchActivity extends AppCompatActivity implements View.OnClickListener {

    TextView t1, t2, t3, t4;
    Typeface t, fo;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_activity_launch);

        t1 = (TextView) findViewById(R.id.textView3);
        /*t2 = (TextView) findViewById(R.id.textView4);
        t3 = (TextView) findViewById(R.id.textView5);*/
        //t4 = (TextView) findViewById(R.id.textView6);

        b = (Button) findViewById(R.id.button2);

        t = Typeface.createFromAsset(getAssets(), "raleway.ttf");


        t1.setTypeface(t);
        /*t2.setTypeface(fo);
        t3.setTypeface(fo);*/
        //t4.setTypeface(fo);
        b.setTypeface(t);

        /*t1.setY(y/2+y/8+y/70);
        t2.setY(y/2+y/8+y/65);
        t3.setY(y/2+y/8+y/60);
        t4.setY(y/2+y/8+y/55);*/


        b.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, PlayerSelect.class);
        startActivity(intent);
    }
}
