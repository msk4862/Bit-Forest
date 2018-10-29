package gamedevelopers.funcandi.taskworkflow.game1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by msk on 21-06-2017.
 */

public class Shoot {

    private static final int BMP_ROWS = 2;
    private static final int BMP_COLUMNS = 3;
    private int x=0;
    private int y=0;
    private int xSpeed;
    private GameView gameView;
    private Bitmap bmp;
    private int currentFrame = 0;
    private Rect detectCollision;
    private int width;
    private int height;
    private boolean visible;
    private int level;

    public Shoot(GameView view, Bitmap bmp, int x, int y, int l) {

        this.gameView = view;
        this.bmp = bmp;
        this.x = x;
        this.y = y;
        //this.width = bmp.getWidth() / BMP_COLUMNS;
        //this.height = bmp.getHeight() / BMP_ROWS;

        level = l;
        this.width=bmp.getWidth();
        this.height=bmp.getHeight();

        visible=true;
        xSpeed = view.getWidth()/30;
    }

    private void update() {

        if (level == 2) {
            x = x - xSpeed;

            if (x<=-2*gameView.getWidth()) {
                visible = false;
            }
        }

        else {

            x = x + xSpeed;

            if (x>2*gameView.getHeight()) {
                visible = false;
            }
        }

    }

    public void onDraw(Canvas canvas) {
        update();


       canvas.drawBitmap(bmp, x, y, null);
       detectCollision =  new Rect(x,y,x+width,y+height);

    }

    public Rect getDetectCollision() {
        return detectCollision;
    }

    public boolean isVisible(){
        return visible;
    }


}
