package gamedevelopers.funcandi.taskworkflow;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by msk on 17-10-2017.
 */

public class LevelCompletedDialog {

    Dialog d;

    Button next;

    Context context;

    Class nextClass;

    public LevelCompletedDialog(final Context context, final Class nextClass) {


        this.context = context;
        this.nextClass = nextClass;

        d = new Dialog(context);
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view  = inflater.inflate(R.layout.level_dialog, null);
        view.setBackgroundColor(Color.TRANSPARENT);

        d.setCancelable(true);
        d.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        d.setContentView(view);

        Window window = d.getWindow();
        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);

        d.show();


        next = (Button) d.findViewById(R.id.next) ;

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
                CallActivity();
            }
        });
    }

    private void CallActivity() {
        Intent i = new Intent(context, nextClass);
        Log.e("mylog","in level1");
        context.startActivity(i);
    }
}
