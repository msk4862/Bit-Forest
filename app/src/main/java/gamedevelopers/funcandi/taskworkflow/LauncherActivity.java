package gamedevelopers.funcandi.taskworkflow;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import co.gofynd.gravityview.*;

public class LauncherActivity extends Activity implements View.OnClickListener{

    ImageView bg;
    GravityView gravityView;
    Typeface wooden;

    TextView gamename;

    Button play, reward, shop, leader, close;

    Dialog rew, shopD, leadersD;

    RelativeLayout launcher;

    public static int REWARD = 0;
    TextView rewardcoin;

    static final int[] catogaries = new int[] {

            R.drawable.teddy2,
            R.drawable.ps42,
            R.drawable.tv2,
            R.drawable.bike2,
            R.drawable.car2,
            R.drawable.jet2,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.twf_activity_launcher);




        wooden = Typeface.createFromAsset(getAssets(), "wood.ttf");

        gamename=(TextView) findViewById(R.id.gamename);

        gamename.setTypeface(wooden);

        play = (Button) findViewById(R.id.play) ;
        reward = (Button) findViewById(R.id.reward) ;
        leader = (Button) findViewById(R.id.leader) ;
        shop = (Button) findViewById(R.id.shop) ;

        launcher = (RelativeLayout) findViewById(R.id.launcherbg);


        play.setOnClickListener(this);
        reward.setOnClickListener(this);
        leader.setOnClickListener(this);
        shop.setOnClickListener(this);

        bg  = (ImageView) findViewById(R.id.bg);
        launcher.setBackgroundResource(R.drawable.twf_background);

        gravityView = GravityView.getInstance(this);

       if (gravityView.deviceSupported()) {
            gravityView.setImage(bg, R.drawable.launcherbg).center();
        }
        else {
            launcher.setBackgroundResource(R.drawable.twf_background);
       }
    }


    public class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context c) {
            context = c;
        }

        //---returns the number of images---
        public int getCount() {
            return catogaries.length;
        }

        //---returns the ID of an item---
        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        //---returns an ImageView view---
        public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);

                imageView.setLayoutParams(new GridView.LayoutParams(600, 600));
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setPaddingRelative(5, 50, 5, 100);



            } else {
                imageView = (ImageView) convertView;
                imageView.setLayoutParams(new GridView.LayoutParams(600, 600));
                imageView.setPadding(5, 50, 5, 100);



            }
            imageView.setImageResource(catogaries[position]);
            return imageView;


        }
    }



    @Override
    protected void onResume() {
        super.onResume();

        gravityView.registerListener();

    }

    @Override
    protected void onStop() {
        super.onStop();

        gravityView.unRegisterListener();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:

                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;

            case R.id.reward:

                rew = new Dialog(LauncherActivity.this);
                rew.requestWindowFeature(Window.FEATURE_NO_TITLE);

                View rewView  = getLayoutInflater().inflate(R.layout.reward_dialog, null);
                rewView.setBackgroundColor(Color.TRANSPARENT);

                rew.setCancelable(true);
                rew.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                rew.setContentView(rewView);

                Window window = rew.getWindow();
                window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);

                rew.show();


                close = (Button) rew.findViewById(R.id.close) ;
                rewardcoin = (TextView) rew.findViewById(R.id.rewardcoin);

                rewardcoin.setText("\u20BF"+REWARD);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rew.dismiss();
                    }
                });

                break;


            case R.id.shop:

                shopD = new Dialog(LauncherActivity.this);
                shopD.requestWindowFeature(Window.FEATURE_NO_TITLE);

                View shopView  = getLayoutInflater().inflate(R.layout.shop_dialog, null);
                shopView.setBackgroundColor(Color.TRANSPARENT);

                shopD.setCancelable(true);
                shopD.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                shopD.setContentView(shopView);

                Window window1 = shopD.getWindow();
                window1.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);



                GridView gridView = (GridView) shopD.findViewById(R.id.grid_view);

                gridView.setAdapter(new ImageAdapter(this));
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v,
                                            int position, long id) {

                        Toast.makeText(getApplicationContext(),
                                " "+position, Toast.LENGTH_SHORT).show();


                    }
                });


                shopD.show();


                close = (Button) shopD.findViewById(R.id.close) ;

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shopD.dismiss();
                    }
                });

                break;


            case R.id.leader:

                leadersD = new Dialog(LauncherActivity.this);
                leadersD.requestWindowFeature(Window.FEATURE_NO_TITLE);


                View leadersView  = getLayoutInflater().inflate(R.layout.leaders_dialog, null);
                leadersView.setBackgroundColor(Color.TRANSPARENT);

                leadersD.setCancelable(true);
                leadersD.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                leadersD.setContentView(leadersView);

                Window window3 = leadersD.getWindow();
                window3.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);

                leadersD.show();


                close = (Button) leadersD.findViewById(R.id.close) ;

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        leadersD.dismiss();
                    }
                });

                break;
        }
    }
}
