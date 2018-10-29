package gamedevelopers.funcandi.taskworkflow.game1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

import gamedevelopers.funcandi.taskworkflow.R;

/**
 * Created by hp on 25-03-2017.
 */

public class Alert implements View.OnTouchListener{
    private float x;
    private float y;
    int value;
    private int width, height, size;
    private String s1,s2,s3,s4;
    View v;

    private int life = 50;
    private Bitmap up,down,fairy,ghost,banner;

    private List<Alert> temps;
    Typeface typeface;

    public Alert(List<Alert> temps, View v, Typeface t, String s1, String s2, String s3, String s4,int value)
    {   this.typeface = t;
        this.width = v.getWidth();
        this.height = v.getHeight();
        this.value=value;
        this.v = v;
        this.x = (width / 4 + width / 2) / 2;
        this.y = (height / 4 + height / 4 + height / 2) / 2;
        this.temps = temps;
        this.size = temps.size();
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        this.s4=s4;
if(value==1) {
    this.up = BitmapFactory.decodeResource(v.getResources(), R.drawable.underworld_up);
    Bitmap resizedBitmap = Bitmap.createScaledBitmap(this.up, v.getWidth() / 10, v.getWidth() / 10, false);
    this.up = resizedBitmap;
    this.down = BitmapFactory.decodeResource(v.getResources(), R.drawable.underworld_down);
    Bitmap resizedBitmap1 = Bitmap.createScaledBitmap(this.down, v.getWidth() / 10, v.getWidth() /10, false);
    this.down = resizedBitmap1;
    this.fairy = BitmapFactory.decodeResource(v.getResources(), R.drawable.underworld_fairy);


    this.ghost = BitmapFactory.decodeResource(v.getResources(), R.drawable.underworld_ghost);
}



    }

    public void onDraw(Canvas canvas) {
        update();
        // canvas.drawColor(Color.WHITE);

        Paint p = new Paint();

        p.setColor(Color.BLACK);
        p.setAlpha(150);

        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP){
            canvas.drawRect(width/4-width/14,height/8,width-width/4+width/12,height-height/5+width/10, p);
        } else{
            canvas.drawRoundRect(width/4-width/14,height/8,width-width/4+width/12,height-height/5+width/10, v.getHeight()/8, v.getHeight()/8, p);
        }
        p.setAlpha(80);
        if (value == 1) {
            canvas.drawBitmap(up, width / 4, height / 8, null);
            canvas.drawBitmap(down, width / 4, height - height / 5, null);
        }

        if(value==2){
            canvas.drawRect(0,0,width,height,p);
        }

        p.setColor(Color.WHITE);
        if (value == 1) {
            p.setTextSize(width/30);
        }
        else{
            p.setTextSize(width/30);
        }

        p.setTypeface(typeface);


        //if((life>60)&(life<=80))
        if (value == 1) {
            canvas.drawText(s1, x / 2 + x / 8, y - y / 4, p);
            //if((life>40)&(life<=60))

            canvas.drawText(s2, x / 2 + x / 3, y, p);

            //if((life>20)&(life<=40)) canvas.drawBitmap(underworld_up, 0 + width / 4, 0 + height / 8 , null);
            canvas.drawBitmap(fairy, x / 2 + x / 3 + x / 3 + x / 3, y - y / 6, null);
            //p.setColor(Color.WHITE)


            canvas.drawText(s3, x / 2 + x / 3, y + y / 4, p);
            // if((life>0)&&(life<=20))

            canvas.drawBitmap(ghost, x / 2 + x / 2 + x/3+x/5 + x / 3, y + y / 10, null);
            //p.setColor(Color.WHITE);

            canvas.drawText(s4, x / 2 + x / 8, y + y / 2, p);
        }
        else{
            canvas.drawText(s1, x+x/7 , y - y / 2, p);

            canvas.drawText(s2, x / 2 , y, p);




            canvas.drawText(s3, x / 2, y +y/4, p);
            // if((life>0)&&(life<=20))


            canvas.drawText(s4, x / 2, y + y / 2, p);
        }



    }

    private void update() {
      if (--life < 1) {
            temps.remove(this);
        }
    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        v=this.v;

        return true;
    }
}