package gamedevelopers.funcandi.taskworkflow.Intro;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import gamedevelopers.funcandi.taskworkflow.Intro.ui.MainActivity;
import gamedevelopers.funcandi.taskworkflow.R;

public class PlayerSelect extends AppCompatActivity implements View.OnClickListener{

    ImageButton boy, girl;
    TextView text;

    public static String GENDER = "gender";
    Intent i;

    Typeface t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_activity_player_select);

        t = Typeface.createFromAsset(getAssets(), "raleway.ttf");

        boy = (ImageButton) findViewById(R.id.boy);
        girl = (ImageButton) findViewById(R.id.girl);

        text = (TextView) findViewById(R.id.textView8);
        text.setTypeface(t);

        boy.setOnClickListener(this);
        girl.setOnClickListener(this);



        i = new Intent(this, MainActivity.class);





    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.boy) {
            i.putExtra(GENDER, 'B');
        }
        else {
            i.putExtra(GENDER, 'G');
        }

        startActivity(i);
    }
}
