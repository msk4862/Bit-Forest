package gamedevelopers.funcandi.taskworkflow.Intro;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import gamedevelopers.funcandi.taskworkflow.LauncherActivity;
import gamedevelopers.funcandi.taskworkflow.Level1;
import gamedevelopers.funcandi.taskworkflow.Level4;
import gamedevelopers.funcandi.taskworkflow.R;


public class PlayAgainActivity3 extends AppCompatActivity {

    Intent i, i1;
    Button b, b1;

    Typeface t;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_activity_play_again);
        t = Typeface.createFromAsset(getAssets(), "raleway.ttf");


        text = (TextView) findViewById(R.id.textView7);
        text.setTypeface(t);

        //b = (Button) findViewById(R.id.button3);
        b1 = (Button) findViewById(R.id.button4);
        //b.setTypeface(t);
        b1.setTypeface(t);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i1 = new Intent(getApplicationContext(), Level4.class);
                i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(i1);
                LauncherActivity.REWARD+=10;

               /* i1 = new Intent(getApplicationContext(), EndActivity.class);
                startActivity(i1);*/
            }
        });
    }
}
