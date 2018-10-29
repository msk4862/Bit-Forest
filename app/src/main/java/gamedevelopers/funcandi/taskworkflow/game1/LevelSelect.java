package gamedevelopers.funcandi.taskworkflow.game1;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import gamedevelopers.funcandi.taskworkflow.R;

public class LevelSelect extends AppCompatActivity implements View.OnClickListener {

    Button l1, l2;
    TextView text;
    Bundle extras;
    Typeface t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u_activity_level_select);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        t = Typeface.createFromAsset(this.getAssets(),"raleway.ttf");

        extras = new Bundle();

        Intent i=getIntent();
        String gend=i.getStringExtra("gender");

        extras.putString("gender", gend);

        l1 = (Button) findViewById(R.id.button);
        l2 = (Button) findViewById(R.id.button1);
        text = (TextView) findViewById(R.id.textView);

        text.setTypeface(t);
        l1.setTypeface(t);
        l2.setTypeface(t);

        l1.setOnClickListener(this);
        l2.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button){
            Intent i=new Intent(LevelSelect.this,Game.class);
            extras.putString("level", "1");
            i.putExtras(extras);
            startActivity(i);
        }
        else
        {
            Intent i=new Intent(LevelSelect.this,Game.class);
            extras.putString("level", "2");
            i.putExtras(extras);
            startActivity(i);

        }
    }
}
