package gamedevelopers.funcandi.taskworkflow.game1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import android.widget.TextView;

import gamedevelopers.funcandi.taskworkflow.R;

public class MainActivity extends Activity implements View.OnClickListener {
Button boy,girl;
    TextView t, credit, credit1, charchoos;
    MediaPlayer game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        int w = getWindowManager().getDefaultDisplay().getWidth();
        int h = getWindowManager().getDefaultDisplay().getHeight();

        int r = w/h;

//        boy=(Button)findViewById(R.id.boy);
//      girl=(Button)findViewById(R.id.girl);
        t=(TextView) findViewById(R.id.textView);
       game = MediaPlayer.create(this, R.raw.bg);
        game.setLooping(true);
        game.start();
       Typeface type = Typeface.createFromAsset(this.getAssets(),"raleway.ttf");
       t.setTypeface(type);

//        credit = (TextView) findViewById(R.id.credits);
        credit.setSelected(true);
        credit.setTypeface(type);
        credit.setTextSize(10*r);
        credit.setPadding(w/11,r,0,0);

        credit1 = (TextView) findViewById(R.id.textView2);
        credit1.setTypeface(type);
        credit1.setTextSize(12*r);

        charchoos = (TextView) findViewById(R.id.textView3);
        charchoos.setTypeface(type);

        boy.setOnClickListener(this);
       girl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.boy) {
            Intent i=new Intent(MainActivity.this,LevelSelect.class);
            i.putExtra("gender","underworld_boy");
            startActivity(i);

        }else if(v.getId()==R.id.girl){
            Intent i=new Intent(MainActivity.this,LevelSelect.class);
            i.putExtra("gender","underworld_girl");
            startActivity(i);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
       game.stop();
       game.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        game = MediaPlayer.create(this, R.raw.bg);
        game.setLooping(true);

    }
}
