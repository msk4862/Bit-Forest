package gamedevelopers.funcandi.taskworkflow.Intro.model;

/**
 * Created by msk on 04-07-2017.
 */

import android.content.Context;

import gamedevelopers.funcandi.taskworkflow.Intro.ui.MainActivity;
import gamedevelopers.funcandi.taskworkflow.R;

public class Quiz2 {

    String name;
    private Page[] pages;
    private String[] dialo;


    // set this to true for analysis part
    public boolean analysis=false;


    Context context;

    int happy, shocked, thinking, nervous;

    public Quiz2(String name, Context context) {

        if (MainActivity.gender == 'B') {
            happy = R.drawable.episode_happyboy;
            shocked = R.drawable.episode_shockedboy;
            thinking = R.drawable.episode_thinkingboy;
            nervous = R.drawable.episode_nervousboy;

        }
        else  {
            happy = R.drawable.school_happygirl;
            shocked = R.drawable.school_shockedgirl;
            thinking = R.drawable.school_thinkinggirl;
            nervous = R.drawable.school_nervousgirl;
        }

        this.context=context;


        this.name = name;
        pages = new Page[50];

        dialo = new String[1];

        dialo[0]="Let's check what you have learnt. ";
        pages[0] = new Page(2, R.drawable.episode_classroom, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 1), new Choice("NEXT", 1), false);


        dialo = new String[1];

        dialo[0]="The situation where two hash points to the same block?";
        pages[1] = new Page(2, R.drawable.episode_classroom, R.drawable.school_happyfriend,
                dialo, new Choice("Collision", 2), new Choice("Folding", 3), false);

        dialo = new String[1];
        dialo[0]= "Very Good!! It's a correct answer.";
        pages[2] = new Page(2, R.drawable.episode_classroom, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 4), new Choice("NEXT", 4), false);

        dialo = new String[1];
        dialo[0]="It's a wrong answer.\nTry again";                           //r0h!n!cbs

        pages[3] = new Page(2, R.drawable.episode_classroom, R.drawable.school_sadfriend,
                dialo, new Choice("NEXT", 0), new Choice("NEXT", 0), false);




        dialo = new String[1];

        dialo[0]="Which of these is a simple hash function?";
        pages[4] = new Page(2, R.drawable.episode_classroom, R.drawable.school_happyfriend,
                dialo, new Choice("Folding Method", 3), new Choice("Peer to Peer Method", 5), false);

        dialo = new String[1];
        dialo[0]= "Very Good!! It's a correct answer.";
        pages[5] = new Page(2, R.drawable.episode_classroom, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 6), new Choice("NEXT", 6), false);




        dialo = new String[1];
        dialo[0]="Which of these is an efficient way to overcome collision?";                           //r0h!n!cbs
        pages[6] = new Page(2, R.drawable.episode_classroom, R.drawable.school_happyfriend,
                dialo, new Choice("Reconstruction", 3), new Choice("Chaining", 7), false);


        dialo = new String[1];
        dialo[0]= "Great!! You have completed this level.";
        pages[7] = new Page(2, R.drawable.episode_classroom, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 5), new Choice("NEXT", 5), true);






    }



    public Page getPage(int pageNumber) {


        if (pageNumber >= pages.length) {
            pageNumber = 0;
        }
        return pages[pageNumber];
    }


}
