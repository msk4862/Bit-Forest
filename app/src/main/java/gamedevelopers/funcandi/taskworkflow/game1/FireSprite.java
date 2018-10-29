package gamedevelopers.funcandi.taskworkflow.game1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by msk on 20-06-2017.
 */

public class FireSprite {

    private static final int BMP_ROWS = 4;
    private static final int BMP_COLUMNS = 4;
    private int x,y;
    private Rect detectCollision;
    private GameView gameView;
    private Bitmap bmp;
    private int currentFrame = 0;
    private int width;
    private int height;

    public FireSprite(GameView view, Bitmap bmp, int x) {
        this.gameView = view;
        this.bmp = bmp;
        this.x = x;
        this.width = bmp.getWidth() / BMP_COLUMNS;
        this.height = bmp.getHeight() / BMP_ROWS;
    }



    public void onDraw(Canvas canvas) {
        y= gameView.getHeight()-height/2-height/4;
        currentFrame = ++currentFrame % BMP_COLUMNS;
        int srcX = currentFrame * width;
        int srcY = 1 * height;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        Rect dst = new Rect(x, y, x + width, y + height);

        canvas.drawBitmap(bmp, src, dst, null);

        detectCollision =  new Rect(x,gameView.getHeight()-3*height/4,x+width,y+height);

    }

    public Rect getDetectCollision() {
        return detectCollision;
    }

    public int getHeight() {
        return height;
    }


}

