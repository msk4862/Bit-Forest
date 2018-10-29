package gamedevelopers.funcandi.taskworkflow.game1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

import gamedevelopers.funcandi.taskworkflow.R;

/**
 * Created by msk on 02-07-2017.
 */

public class Boss {

    private static final int BMP_ROWS = 2;
    private static final int BMP_COLUMNS = 3;
    private int x,y=0;
    private Rect detectCollision;
    private GameView gameView;
    private Bitmap bmp;
    private int currentFrame = 0;
    private int width;
    private int height;
    private int ySpeed;
    Bitmap bullet, resizedBullet;
    private ArrayList<Shoot> bullets = new ArrayList<Shoot>();


    public Boss(GameView view, Bitmap bmp, int screenH) {
        this.gameView = view;
        this.bmp = bmp;
        this.ySpeed = screenH/23;
        this.y = screenH/2;
        this.bmp = bmp;
        this.width = bmp.getWidth() / BMP_COLUMNS;
        this.height = bmp.getHeight() / BMP_ROWS;

        bullet = BitmapFactory.decodeResource(view.getResources(), R.drawable.underworld_fire);
        resizedBullet = Bitmap.createScaledBitmap(bullet, screenH/8-screenH/20, screenH/7-screenH/20, false);


    }


    public void update() {

        y = y + ySpeed;
        if(y>=gameView.getHeight()-width){
            ySpeed=-ySpeed;
            //shoot();
        }
        else if (y<0){
            ySpeed = gameView.getHeight()/22;
            //shoot();
        }

        currentFrame = ++currentFrame % BMP_COLUMNS;



    }

    public void onDraw(Canvas canvas) {

        update();

        x = gameView.getWidth()-width;

        //y = y + 20;

        int srcX = currentFrame * width;

        int srcY = 1* height;

        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);

        Rect dst = new Rect(x, y, x + width, y + height);

        Paint p = new Paint();

        p.setColor(Color.rgb(100,10,25));
        p.setTextSize(width/30);
        //canvas.drawText(""+this.value, srcX+ width/2,  srcY, p);
        canvas.drawBitmap(bmp, src, dst, null);

        detectCollision =  new Rect(x,y,x+width,y+height);
        //canvas.drawRect(detectCollision, p);

    }

    public void shoot() {
        Shoot p = new Shoot(gameView, resizedBullet, gameView.getWidth()-bmp.getWidth()/2, y+bmp.getHeight()/4, 2);
        bullets.add(p);
    }

    public Rect getDetectCollision() {
        return detectCollision;
    }
    public ArrayList getBullets() {
        return bullets;
    }

    public int getY() {
        return y;
    }


}
