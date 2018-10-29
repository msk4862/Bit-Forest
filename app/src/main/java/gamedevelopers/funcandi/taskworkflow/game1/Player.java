            package gamedevelopers.funcandi.taskworkflow.game1;

            /**
             * Created by hrc on 15/3/17.
             */

            import android.graphics.Bitmap;
            import android.graphics.BitmapFactory;
            import android.graphics.Canvas;
            import android.graphics.Rect;

            import java.util.ArrayList;
            import java.util.Random;

            import gamedevelopers.funcandi.taskworkflow.R;


            public class Player {


                private boolean boosting;

                private Rect detectCollision;

                private int x = 0;

                private int y = 0;

                private int xSpeed,ySpeed;

                private GameView gameView;

                private Bitmap bmp1,bmp2,bmp3,bmp4, bmp5;

                private int currentFrame = 0,nofoframes=5;

                private int width,MAX_SPEED=50;

                private int height;
                Bitmap bullet, resizedBullet;

                private ArrayList<Shoot> bullets = new ArrayList<Shoot>();



                public Player(GameView view, Bitmap bmp1,Bitmap bmp2,Bitmap bmp3,Bitmap bmp4, Bitmap bmp5) {

                    this.gameView = view;


                   // MAX_SPEED=view.getWidth()/2;

                    height = bmp1.getHeight();

                    bullet = BitmapFactory.decodeResource(view.getResources(), R.drawable.underworld_kunai);
                    resizedBullet = Bitmap.createScaledBitmap(bullet, view.getHeight()/7, view.getHeight()/7, false);


                    Random rnd=new Random();
                    //if (level.equals("underworld_boy"))

                    this.xSpeed = view.getHeight()/25;
                    //Random rnd=new Random();
                    x = view.getWidth()/15;

                    y = view.getHeight()/2 - height;
                    Bitmap resizedBitmap = Bitmap.createScaledBitmap(bmp1, view.getWidth()/8, view.getHeight()/4, false);
                    this.bmp1=resizedBitmap;
                    Bitmap resizedBitmap2 = Bitmap.createScaledBitmap(bmp2, view.getWidth()/8, view.getHeight()/4, false);
                    this.bmp2=resizedBitmap2;
                    Bitmap resizedBitmap3 = Bitmap.createScaledBitmap(bmp3, view.getWidth()/8, view.getHeight()/4, false);
                    this.bmp3=resizedBitmap3;
                    Bitmap resizedBitmap4 = Bitmap.createScaledBitmap(bmp4, view.getWidth()/8, view.getHeight()/4, false);
                    this.bmp4=resizedBitmap4;
                    Bitmap resizedBitmap5 = Bitmap.createScaledBitmap(bmp5, view.getWidth()/8, view.getHeight()/4, false);
                    this.bmp5=resizedBitmap5;

                    this.width = this.bmp1.getWidth() ;

                    this.height = this.bmp1.getHeight();


                }




                private void update() {

                    if(boosting) {
                        y=y+xSpeed;
                    }else {
                        y = y - xSpeed;
                    }


            if((y> gameView.getHeight()-height)) {
                y = gameView.getHeight() - height;
            } else if (y < getHeight()/18+getHeight()/4){
                        y = getHeight()/18+getHeight()/4;
                    }


                    currentFrame = ++currentFrame % nofoframes;

                }



                public void onDraw(Canvas canvas) {

                    update();


            if(currentFrame==0) {
                canvas.drawBitmap(bmp1, x, y, null);
            }else if(currentFrame==1){

                canvas.drawBitmap(bmp2, x, y, null);
            }else if(currentFrame==2){

                canvas.drawBitmap(bmp3, x, y, null);
            }else if (currentFrame==3){
                canvas.drawBitmap(bmp4, x, y, null);
            }
            else {
                canvas.drawBitmap(bmp5, x, y, null);
            }

                    detectCollision =  new Rect(x,y,x+width,y+height);


                }


                public void shoot() {
                    Shoot p = new Shoot(gameView, resizedBullet, x+bmp1.getWidth()/3, y+bmp1.getHeight()/3, 1);
                    bullets.add(p);
                }


                public void setBoosting() {
                    boosting = true;
                }

                public void stopBoosting() {
                    boosting = false;
                }
                public int getX(){
                    return x;
                }
            public  int getY(){
                return y;
            }

                public void setY (int y) {
                    this.y=y;
                }

                public void setxSpeed (int speed) {
                    xSpeed= speed;
                }

                public int getWidth(){
                    return  this.width;
                }
                public  int getHeight(){
                    return  this.height;
                }

                public Bitmap getBmp1() {
                    return bmp1;
                }

                public Rect getDetectCollision() {
                    return detectCollision;
                }

                public ArrayList getBullets() {
                    return bullets;
                }


            }