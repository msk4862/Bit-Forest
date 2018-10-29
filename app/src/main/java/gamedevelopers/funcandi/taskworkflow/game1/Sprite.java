        package gamedevelopers.funcandi.taskworkflow.game1;

        /**
         * Created by hp on 13-06-2017.
         */


        import android.graphics.Bitmap;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Rect;

        import java.util.Random;

        import static android.R.attr.theme;
        import static android.R.attr.value;


        public class Sprite{

            private static final int BMP_ROWS = 2;
            private Rect detectCollision;

            private static final int BMP_COLUMNS = 2;

            private int x = 0;

            private int y = 0;

            private int xSpeed;

            private GameView gameView;

            private Bitmap bmp;

            private int currentFrame = 0;

            private int width,MAX_SPEED, MIN_SPEED;

            private int height, value, level;

            private boolean target;
            static int RandomTarget = 1;

            public Sprite(GameView gameView, Bitmap bmp,int value, int l) {

                this.gameView = gameView;
                level = l;

                if (value == 2) {
                    RandomTarget++;
                    if (RandomTarget % 4 == 0) {
                        this.target = true;
                    }
                }

                this.value=value;
                this.bmp = bmp;
                Random rnd=new Random();

                if (level == 1){
                    MAX_SPEED = gameView.getWidth()/80;
                    MIN_SPEED = gameView.getWidth()/90;
                }
                else {
                    MAX_SPEED = gameView.getWidth()/50;
                    MIN_SPEED = gameView.getWidth()/45;
                }


                xSpeed = MIN_SPEED + rnd.nextInt(MAX_SPEED);

                Bitmap resizedBitmap = Bitmap.createScaledBitmap(bmp,  gameView.getWidth()/6, gameView.getHeight()/4, false);
                this.bmp=resizedBitmap;

                this.width = this.bmp.getWidth() / BMP_COLUMNS;

                this.height = this.bmp.getHeight() / BMP_ROWS;
                x = (rnd.nextInt(gameView.getWidth()/2)+ gameView.getWidth());

                y = rnd.nextInt(gameView.getHeight()-2*height);;

            }


            private void update() {



                //  y=gameView.getHeight()/2-width;
                x = x - xSpeed;
                if(x<-width){
                    Random rnd=new Random();
                    x = rnd.nextInt(gameView.getWidth()/2)+ gameView.getWidth();

                    y = rnd.nextInt(gameView.getHeight()-2*height);
                }

                // detectCollision =  new Rect(x, y, width, height);
                currentFrame = ++currentFrame % BMP_COLUMNS;


            }



            public void onDraw(Canvas canvas) {

                update();

                int srcX = currentFrame * width;

                int srcY = 1* height;

                Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);

                Rect dst = new Rect(x, y, x + width, y + height);

               // canvas.drawBitmap(bmp, x, y, null);
                Paint p = new Paint();


                if(target) {
                    p.setColor(Color.BLACK);
                    p.setTextSize(gameView.getWidth()/40);

                    canvas.drawText(""+GameView.HASH,getX()+getY()/16+y/18, getY()+getY()/16-y/18, p);

                }
                //p.setColor(Color.GRAY);
                p.setColor(Color.rgb(100,10,25));
                p.setTextSize(width/30);
                //canvas.drawText(""+this.value, srcX+ width/2,  srcY, p);
                canvas.drawBitmap(bmp, src, dst, null);

                detectCollision =  new Rect(x,y,x+width,y+height);
                //canvas.drawRect(detectCollision, p);

            }
            public int getX(){
                return x;
            }
            public  int getY(){
                return y;
            }
            public boolean getTarget(){return target;}


            public Bitmap getBmp(){return bmp;}

            public Rect getDetectCollision() {
                return detectCollision;
            }

        }