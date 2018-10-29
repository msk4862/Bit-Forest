package gamedevelopers.funcandi.taskworkflow.game1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import gamedevelopers.funcandi.taskworkflow.Level1;


public class Game extends Activity {

    private GameView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       requestWindowFeature(Window.FEATURE_NO_TITLE);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //set to full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
Intent i=getIntent();
Log.d("mylog","In game");
        Bundle extras=i.getExtras();
        //String gend=extras.getString("gender");
        //int level = Integer.parseInt(extras.getString("level"));
        gameView=new GameView(this,"underworld_boy", 1);
        setContentView(gameView);


    }

    @Override
    public void onBackPressed()
    {
        gameView.stopView();
        super.onBackPressed();


        Intent i = new Intent(this, Level1.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }



}

