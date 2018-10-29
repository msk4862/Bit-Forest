                package gamedevelopers.funcandi.taskworkflow.game1;

                import android.content.Context;

                import android.graphics.Bitmap;
                import android.graphics.BitmapFactory;
                import android.graphics.Canvas;
                import android.graphics.Color;
                import android.graphics.Paint;
                import android.graphics.Rect;
                import android.graphics.Typeface;
                import android.media.MediaPlayer;

                import android.util.Log;

                import android.view.MotionEvent;
                import android.view.SurfaceHolder;
                import android.view.SurfaceView;


                import java.util.ArrayList;
                import java.util.List;

                import java.util.Random;

                import gamedevelopers.funcandi.taskworkflow.LauncherActivity;
                import gamedevelopers.funcandi.taskworkflow.R;


                public class GameView extends SurfaceView {

                    int target;
                    private Background bg;
                    private SurfaceHolder holder;
                    public static int flag = 0, gameflag = 0;
                    String s,gender;

                    private Bitmap muteButton, playButton, gamepause, gameresume, Scaledmute, Scaledplay, Scaledpause, Scaledresume;
                    Typeface typeface, t;
                    MediaPlayer gameOn;
                    MediaPlayer killedEnemy;
                    MediaPlayer ScoreUp;
                    static int coll=0;
                    private List<Alert> write = new ArrayList<Alert>();
                    private GameLoopThread gameLoopThread;
                    public Player player;
                    private long lastClick;
                    static public int Bodyscore = 0;
                    private List<Sprite> spritesbad = new ArrayList<Sprite>();
                    private List<Sprite> spritesgood = new ArrayList<Sprite>();
                    private int xSpeed = 10;

                    Bitmap fire, ResizedFire;
                    FireSprite fs[];


                    private  ArrayList projectiles;
                    private  ArrayList bossProjectiles;

                    Bitmap shootButton, scaledShootButton;

                    private String s1, s2, s3, s4;

                    int level, life;

                    private Boss b;
                    Bitmap boss;
                    int bossVisible = 0;
                    int shoot=1;

                    int playerHealth, bossHealth;

                    public static int HASH = 9;
                    Random rand;

                    public GameView(Context context,String st, int level) {


                        super(context);
                        Log.d("mylog","In game");
                        gender=st;
                        this.level = level;
                        int x=context.getResources().getDisplayMetrics().widthPixels;
                       int y=context.getResources().getDisplayMetrics().heightPixels;

                        rand = new Random();
                        fs = new FireSprite[25];

                        gameLoopThread = new GameLoopThread(this);

                        gameOn = MediaPlayer.create(context, R.raw.bg);
                        coll=0;

                        gameOn.setLooping(true);
                        killedEnemy = MediaPlayer.create(context, R.raw.gameover);
                        ScoreUp = MediaPlayer.create(context, R.raw.scoreup);

                       typeface = Typeface.createFromAsset(context.getAssets(), "raleway.ttf");
                        t = Typeface.createFromAsset(context.getAssets(), "raleway.ttf");
                        playButton = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_play);
                        muteButton = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_mute);

                        Scaledmute = Bitmap.createScaledBitmap(muteButton, x/20, x/20, false);
                        Scaledplay = Bitmap.createScaledBitmap(playButton, x/20, x/20 , false);

                        gamepause = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_gamepause);
                        gameresume = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_gameresume);

                        Scaledpause = Bitmap.createScaledBitmap(gamepause, x/20, x/20, false);
                        Scaledresume = Bitmap.createScaledBitmap(gameresume, x/20, x/20 , false);


                        fire = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_fire);
                        ResizedFire = Bitmap.createScaledBitmap(fire, y/2+y/4, y/2-y/9, false);

                        shootButton = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_target);
                        scaledShootButton = Bitmap.createScaledBitmap(shootButton, x/8, x/8, false);


                        Bodyscore=0;
                        holder = getHolder();

                        boss = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_boss2);

                        if (level==1) {
                            bg = new Background( this,BitmapFactory.decodeResource(getResources(), R.drawable.underworld_back1));
                            life = 5;
                        }
                        else {
                            life=3;
                            bg = new Background( this,BitmapFactory.decodeResource(getResources(), R.drawable.underworld_back2));
                            Bitmap resizedBitmap = Bitmap.createScaledBitmap(boss,  x/2, x/3+x/14, false);
                            b = new Boss(this, resizedBitmap, y);
                        }

                        Log.d("mylog","here");
                        holder.addCallback(new SurfaceHolder.Callback() {


                            @Override

                            public void surfaceDestroyed(SurfaceHolder holder) {

                                boolean retry = true;

                                gameLoopThread.setRunning(false);
                                Log.d("mylog","stop loop");
                                gameOn.stop();
                                Log.d("mylog","stop music");
                                while (retry) {

                                    try {

                                        gameLoopThread.join();

                                        Log.d("mylog","game stop");
                                        retry = false;

                                    } catch (InterruptedException e) {

                                    }

                                }

                            }


                            @Override

                            public void surfaceCreated(SurfaceHolder holder) {


                                createplayer();
                                Log.d("mylog","createplayer");

                                flag=0;
                                gameflag=0;

                                playerHealth=getWidth()/2-getWidth()/12;
                                bossHealth=getWidth()-getWidth()/120;


                                gameLoopThread.setRunning(true);
                                Log.d("mylog","loop");


                                try {
                                    gameLoopThread.start();
                                    Log.d("mylog","loopstart");
                                } catch (Exception e) {

                                }


                                createSprites();

                                speak();


                                Log.d("mylog","createsprites");

                                Log.d("mylog","speak");
                                gameOn.start();
                                Log.d("mylog","music");


                            }


                            @Override

                            public void surfaceChanged(SurfaceHolder holder, int format,

                                                       int width, int height) {
                                Log.d("mylog","surface chnaged");

                            }

                        });



                        if(level == 2) {
                            for (int i=0,j=-1; i< 25;++i,j++) {
                                fs[i] = new FireSprite(this, ResizedFire, j*ResizedFire.getWidth()/8);
                            }
                        }




                    }

                    private void createSprites() {

                        //spritesbad.add(createSprite(R.drawable.devil));
                        //spritesbad.add(createSprite(R.drawable.devil));
                        //spritesbad.add(createSprite(R.drawable.devil));


                        spritesgood.add(createSprite(R.drawable.underworld_mons, false));
                        spritesgood.add(createSprite(R.drawable.underworld_mons, false));
                        spritesgood.add(createSprite(R.drawable.underworld_mons, true));


                        spritesbad.add(createSpritegood(R.drawable.underworld_bad1, false));
                        spritesbad.add(createSpritegood(R.drawable.underworld_bad1, false));

                        //spritesgood.add(createSpritegood(R.drawable.angel));
                        //spritesgood.add(createSpritegood(R.drawable.friend1));
                        //spritesgood.add(createSpritegood(R.drawable.friend2));


                    }

                    private void createplayer() {


                if(gender.equals("underworld_boy")) {
                    Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_b1);
                    Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_b2);

                    Bitmap bmp3 = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_b3);
                    Bitmap bmp4 = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_b4);
                    Bitmap bmp5 = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_b5);

                    player = new Player(this, bmp1, bmp2, bmp3, bmp4, bmp5);
                }else if(gender.equals("underworld_girl")){

                    Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_g1);
                    Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_g2);

                    Bitmap bmp3 = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_g3);
                    Bitmap bmp4 = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_g4);
                    Bitmap bmp5 = BitmapFactory.decodeResource(getResources(), R.drawable.underworld_g5);

                    player = new Player(this, bmp1, bmp2, bmp3, bmp4, bmp5);
                }





                    }


                    private Sprite createSprite(int resouce, boolean target) {

                        Bitmap bmp = BitmapFactory.decodeResource(getResources(), resouce);

                        return new Sprite(this, bmp,-1, level);

                    }

                    /*private Shoot createBullet() {
                        return new Shoot(this, bullet);
                    }*/

                    private Sprite createSpritegood(int resouce, boolean target) {

                        Bitmap bmp = BitmapFactory.decodeResource(getResources(), resouce);

                        return new Sprite(this, bmp,+2, level);

                    }


                    protected void update() {

                        bg.setVector(-xSpeed);

                        bg.update();



                            for (Sprite sp : spritesbad) {
                                int x2 = sp.getX(), y2 = sp.getY();

                                if (player.getDetectCollision().intersects(x2, y2, x2+sp.getBmp().getWidth(), y2+sp.getBmp().getHeight())) {

                                    spritesbad.remove(sp);

                                    if (bossVisible==1){
                                        playerHealth-=getWidth()/130;
                                    }
                                    else {
                                        life--;

                                        if(life<=0){
                                            bossVisible=0;
                                            gameover();

                                        }

                                    }




                                    if (flag == 0) {
                                        killedEnemy.start();
                                    }
                                    spritesbad.add(new Sprite(this, sp.getBmp(),-1, level));

                                    break;
                                }
                            }

                            for (Sprite spi : spritesgood) {
                                int x2 = spi.getX(), y2 = spi.getY();



                               if (player.getDetectCollision().intersects(x2, y2, x2+spi.getBmp().getWidth(), y2+spi.getBmp().getHeight())) {
                                    spritesgood.remove(spi);

                                   if (spi.getTarget()){
                                       HASH = rand.nextInt(100);
                                       Bodyscore+=2;
                                       if (flag == 0) {
                                           ScoreUp.start();
                                       }

                                   }


                                    spritesgood.add(new Sprite(this, spi.getBmp(),+2, level));
                                    break;
                                }
                            }


                        projectiles = player.getBullets();

                        if (level == 2) {
                                if (write.isEmpty()) {
                                    for (FireSprite f : fs) {

                                        if (Rect.intersects(f.getDetectCollision(), player.getDetectCollision())) {

                                            bossVisible=0;
                                            gameover();

                                            break;
                                        }


                                    }

                                }

                                if (bossVisible == 1) {


                                    bossProjectiles = b.getBullets();

                                    for (int i = 0; i < bossProjectiles.size(); i++) {
                                        Shoot bs = (Shoot) bossProjectiles.get(i);
                                        if (bs.isVisible() == false) {
                                            bossProjectiles.remove(i);
                                        }
                                    }

                                    for (int i = 0; i < bossProjectiles.size(); i++) {

                                        Shoot bs = (Shoot) bossProjectiles.get(i);


                               if (bs.getDetectCollision().intersects( player.getX(), player.getY(), player.getX()+player.getWidth(), player.getY()+player.getHeight())) {
                                        bossProjectiles.remove(i);
                                        //gameover();
                                        //life = 3;
                                   //bossVisible=0;

                                   playerHealth-=getWidth()/18;

                                    break;

                                }
                                    }



                                    for (int i = 0; i < projectiles.size(); i++) {

                                        Shoot p = (Shoot) projectiles.get(i);

                                        if (Rect.intersects(p.getDetectCollision(), b.getDetectCollision())) {
                                            projectiles.remove(i);


                                            bossHealth-=getWidth()/26;

                                            //bossLife--;

                                            /*if (bossLife<=0) {

                                                if (flag == 0) {
                                                    killedEnemy.start();
                                                }
                                                win();
                                                bossVisible=0;

                                            }*/

                                            break;
                                        }

                                    }
                                }


                            }


                        for (int i = 0; i < projectiles.size(); i++) {
                            Shoot p = (Shoot) projectiles.get(i);
                            if (p.isVisible() == false) {
                                projectiles.remove(i);
                            }
                        }





                       Outer: for (Sprite sp : spritesbad) {
                            for (int i = 0; i < projectiles.size(); i++) {

                                Shoot p = (Shoot) projectiles.get(i);

                                int x2 = sp.getX(), y2 = sp.getY();

                                if (p.getDetectCollision().intersects(x2, y2, x2+sp.getBmp().getWidth(), y2+sp.getBmp().getHeight())) {

                                    spritesbad.remove(sp);
                                    projectiles.remove(i);

                                    //Bodyscore = Bodyscore + 1;

                                    if (flag == 0) {
                                       killedEnemy.start();
                                    }

                                    spritesbad.add(new Sprite(this, sp.getBmp(),-1, level));

                                    break Outer;
                                }
                            }


                        }

                        shoot++;

                        if (bossVisible == 1) {
                            if (shoot %13 == 0) {
                                b.shoot();
                            }

                        }


                    }


                    protected void onDraw(Canvas canvas) {


                        bg.draw(canvas);



                        projectiles = player.getBullets();
                        for (int i = 0; i < projectiles.size(); i++) {
                            Shoot p = (Shoot) projectiles.get(i);

                            p.onDraw(canvas);
                        }


                        Paint p = new Paint();
                        p.setColor(Color.BLACK);
                        p.setTypeface(typeface);
                        p.setTextSize(getWidth()/40);

                        canvas.drawBitmap(scaledShootButton, getWidth()/2+getWidth()/3, getHeight()/2, null);


                        if (level==1){
                            if (Bodyscore>=10){
                                win();
                            }
                        }


                        if (level == 2) {


                            for (int i=0; i< 25;++i) {
                                fs[i].onDraw(canvas);
                            }

                            if (Bodyscore >= 60) {

                                bossVisible = 1;

                                bossProjectiles = b.getBullets();
                                for (int i = 0; i < bossProjectiles.size(); i++) {
                                    Shoot bs = (Shoot) bossProjectiles.get(i);

                                    bs.onDraw(canvas);
                                }

                                b.onDraw(canvas);



                            }




                        }





                            player.setxSpeed(getHeight()/25);


                        if(write.isEmpty()){


                            for (Sprite sp : spritesbad) {

                            sp.onDraw(canvas);


                        }


                        for (Sprite spi : spritesgood) {


                            spi.onDraw(canvas);

                        }

                        if (bossVisible==1){
                            p.setColor(Color.BLACK);

                            if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP){
                                canvas.drawRect(getWidth()/130, getWidth()/130, getWidth()/2-getWidth()/12+getWidth()/120,getHeight()/18+getWidth()/40, p);
                                canvas.drawRect(getWidth()/2+getWidth()/12, getWidth()/130, getWidth(), getHeight()/18+getWidth()/40, p);
                            } else{
                                canvas.drawRoundRect(getWidth()/130, getWidth()/130, getWidth()/2-getWidth()/12+getWidth()/120,getHeight()/18+getWidth()/40, getWidth()/8, getWidth()/8, p);
                                canvas.drawRoundRect(getWidth()/2+getWidth()/12, getWidth()/130, getWidth(), getHeight()/18+getWidth()/40, getHeight()/8,getHeight()/8, p);
                            }


                            if (playerHealth>getWidth()/130) {
                                p.setColor(Color.RED);

                                if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP){
                                    canvas.drawRect(getWidth()/80, getWidth()/80, playerHealth, getHeight()/18+getWidth()/50, p);
                                } else{
                                    canvas.drawRoundRect(getWidth()/80, getWidth()/80, playerHealth, getHeight()/18+getWidth()/50,  getWidth()/8, getWidth()/8, p);
                                }
                            }
                            else {

                                life = 3;
                                bossVisible=0;
                                gameover();


                            }

                            if (bossHealth > getWidth()/2+getWidth()/12){
                                p.setColor(Color.RED);
                                if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP) {
                                    canvas.drawRect(getWidth() / 2 + getWidth() / 12 + getWidth() / 120, getWidth() / 80, bossHealth, getHeight() / 18 + getWidth() / 50, p);

                                }
                                else {
                                    canvas.drawRoundRect(getWidth() / 2 + getWidth() / 12 + getWidth() / 120, getWidth() / 80, bossHealth, getHeight() / 18 + getWidth() / 50, getHeight() / 8, getHeight() / 8, p);

                                }
                            }
                            else {
                                bossVisible=0;
                                win();
                            }

                        }
                        else {
                            p.setColor(Color.BLACK);
                            p.setAlpha(100);

                            if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP) {
                                canvas.drawRect(getWidth() / 150, getHeight() / 150, getWidth() / 10 + getWidth() / 6, getHeight() / 18 + getWidth() / 40, p);
                                canvas.drawRect(getWidth() - 3 * Scaledmute.getWidth() - Scaledmute.getWidth() / 2, getHeight() / 150, getWidth(), Scaledmute.getHeight() + getHeight() / 40, p);



                            }

                            else {

                                canvas.drawRoundRect(getWidth() / 150, getHeight() / 150, getWidth() / 10 + getWidth() / 6, getHeight() / 18 + getWidth() / 40, getHeight() / 8, getHeight() / 8, p);
                                canvas.drawRoundRect(getWidth() - 3 * Scaledmute.getWidth() - Scaledmute.getWidth() / 2, getHeight() / 150, getWidth(), Scaledmute.getHeight() + getHeight() / 40, getHeight() / 8, getHeight() / 8, p);


                            }

                            p.setColor(Color.WHITE);



                            canvas.drawText("SCORE: " + Bodyscore, getWidth()/30, getHeight()/20+getHeight()/50, p);
                            canvas.drawText("LIFE: "+life, getWidth()/6, getHeight()/20+getHeight()/50, p);

                            if (flag == 0) {
                                canvas.drawBitmap(Scaledplay, getWidth() - Scaledplay.getWidth()-Scaledmute.getWidth()/2,  getHeight()/65, null);
                            } else {
                                canvas.drawBitmap(Scaledmute, getWidth() - Scaledmute.getWidth()-Scaledmute.getWidth()/2,  getHeight()/65, null);
                            }
                            if (gameflag == 0) {
                                canvas.drawBitmap(Scaledpause, getWidth() - 3 * Scaledpause.getWidth(), getHeight()/65, null);
                            } else {

                            canvas.drawBitmap(Scaledresume, getWidth() - 3*Scaledresume.getWidth(),  getHeight()/65, null);

                                gameLoopThread.onpause();
                            }

                        }


                            p.setColor(Color.BLACK);
                            p.setAlpha(100);
                            if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.LOLLIPOP) {

                                canvas.drawRoundRect(getWidth()/2 - getWidth()/8, getWidth()/120, getWidth()/2+getWidth()/8,getHeight()/8, getHeight() / 8, getHeight() / 8, p);
                            }
                            else {
                                canvas.drawRect(getWidth()/2 - getWidth()/8, getWidth()/120, getWidth()/2+getWidth()/8,getHeight()/8, p);

                            }
                                p.setColor(Color.WHITE);

                            canvas.drawText("Hash Value: "+HASH, getWidth()/2 - getWidth()/8 + getWidth()/30, getHeight()/15, p);



                        }


                        player.onDraw(canvas);
                        for (int i = write.size() - 1; i >= 0; i--) {
                            write.get(i).onDraw(canvas);
                        }




                    }




                    public boolean onTouchEvent(MotionEvent event) {


                        if (System.currentTimeMillis() - lastClick > 500) {

                            lastClick = System.currentTimeMillis();

                            synchronized (getHolder()) {
                                int x = (int) event.getX(), y = (int) event.getY();


                                if (bossVisible==0) {

                                    if ((x > getWidth() - 3*Scaledplay.getWidth()) &&(x < getWidth() -  2*Scaledplay.getWidth())&& (y < Scaledplay.getHeight())) {
                                        if (gameflag == 0) {
                                            gameflag = 1;
                                            // Toast.makeText(getContext(),"GAMEFLAG SET 1",Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            gameflag = 0;
                                            //  Toast.makeText(getContext(),"GAMEFLAG SET 0",Toast.LENGTH_SHORT).show();


                                            gameLoopThread.onresume();
                                            // gameLoopThreadBody.run();

                                        }
                                    }

                                    if ((x > getWidth() - Scaledplay.getWidth() - Scaledplay.getWidth() / 2) && (y < Scaledplay.getHeight())) {
                                        if (flag == 0) {
                                           gameOn.pause();
                                            flag = 1;

                                        } else {
                                           gameOn.start();
                                            gameOn.setLooping(true);
                                            flag = 0;

                                        }


                                    }
                                }


                                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                                    case MotionEvent.ACTION_DOWN://Screeen Pressed
                                        // y = (int) event.getY();


                                        if (x > getWidth() / 2 + getWidth() / 3 && x < getWidth() / 2 + getWidth() / 3 + scaledShootButton.getWidth() && y > getHeight() / 2 && y < getHeight() / 2 + scaledShootButton.getHeight()) {
                                            player.shoot();
                                        } else if (y < player.getY()) {


                                            player.stopBoosting();
                                        } else if (y > player.getY() + player.getBmp1().getHeight()) {
                                            player.setBoosting();
                                        }


                                        break;

                                    case MotionEvent.ACTION_MOVE:
                                        // y = (int) event.getY();

                                        if (x > getWidth() / 2 + getWidth() / 3 && x < getWidth() / 2 + getWidth() / 3 + scaledShootButton.getWidth() && y > getHeight() / 2 && y < getHeight() / 2 + scaledShootButton.getHeight()) {
                                            player.shoot();
                                        } else if (y < player.getY()) {


                                            player.stopBoosting();
                                        } else if (y > player.getY() + player.getBmp1().getHeight()) {

                                            player.setBoosting();
                                        }

                                        break;
                                }



                                }
                            }


                        return true;

                    }


                    public void speak() {

                        player.setxSpeed(0);

                        s1 = "Click up to move up";
                        s2 = "Catch the fairies with correct hash values";
                        s3 = "Avoid the ghosts";
                        s4 = "click down to move down";
                     write.add(new Alert(write, this, t, s1, s2, s3, s4,1));
                    }
                    public void gameover() {
                        player.stopBoosting();
                        player.setY(0);
                        player.setxSpeed(0);
                        int Score = Bodyscore;

                        s1 = "GAME OVER";
                        s2 = "Press back button to go to the main menu";
                        s3 = "Total Score is "+Score;
                        s4 = "Your game will start again in 5 seconds";
                        write.add(new Alert(write, this, t, s1, s2, s3, s4,2));

                        Bodyscore=0;
                        if (level == 1) {
                            life=5;
                        }
                        else {
                            life=3;
                        }


                        playerHealth=getWidth()/2-getWidth()/12;
                        bossHealth=getWidth()-getWidth()/120;
                    }

                    public void win() {
                        player.stopBoosting();
                        player.setY(0);
                        player.setxSpeed(0);
                        int Score = Bodyscore;
                        int bonus=life;

                        bonus=bonus*10;

                        LauncherActivity.REWARD+=10;


                        s1 = "YOU WON";
                        s2 = "Press back button to go to the main menu";
                        s3 = "Total Score is "+(Score+bonus);
                        s4 = "Your game will start again in 5 seconds";
                        write.add(new Alert(write, this, t, s1, s2, s3, s4,2));

                        Bodyscore=0;
                        if (level == 1) {
                            life=5;
                        }
                        else {
                            life=3;
                        }


                        playerHealth=getWidth()/2-getWidth()/12;
                        bossHealth=getWidth()-getWidth()/120;

                    }

                    public void stopView(){
                        gameLoopThread.setRunning(false);
                    }

                }