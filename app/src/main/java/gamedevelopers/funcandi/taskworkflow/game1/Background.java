package gamedevelopers.funcandi.taskworkflow.game1;

/**
 * Created by hp on 13-06-2017.
 */
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Background {

    private Bitmap image;
    private int x, y, dx;
    GameView view;

    public Background(GameView v,Bitmap res)
    {
        image = res;
        view=v;
    }
    public void update()
    {
        x+=dx;
        if(x<-view.getWidth()){
            x=0;
        }
    }
    public void draw(Canvas canvas)
    {
       Bitmap resizedBitmap = Bitmap.createScaledBitmap(image, view.getWidth(), view.getHeight(), false);
        canvas.drawBitmap(resizedBitmap, x, 0,null);

        if(x<0)
        {
            canvas.drawBitmap(resizedBitmap, x+view.getWidth(), 0, null);
        }
    }
    public void setVector(int dx)
    {
        this.dx = dx;
    }
}