package gamedevelopers.funcandi.taskworkflow.Intro.model;

/**
 * Created by msk on 04-07-2017.
 */

import android.content.Context;

import gamedevelopers.funcandi.taskworkflow.Intro.ui.MainActivity;
import gamedevelopers.funcandi.taskworkflow.R;

public class Story4 {

    String name;
    private Page[] pages;
    private String[] dialo;


    // set this to true for analysis part
    public boolean analysis=false;


    Context context;

    int happy, shocked, thinking, nervous;

    public Story4(String name, Context context) {

        if (MainActivity.gender == 'B' || MainActivity.gender == '\u0000') {
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

        dialo[0]="  Hi Zayn, you were telling me about something cryptocurrency yesterday... ";
        pages[0] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 1), new Choice("NEXT", 1), false);

        dialo = new String[5];
        dialo[0]=" Hmm!! Yes Yes..";
        dialo[1]=" So basically cryptocurrency is a digtal currency in which encryption techniques are used.";
        dialo[2]=" These techniques are used to regulate the generation of units of currency";
        dialo[3]=" And also verify the transfer of funds.";
        dialo[4]=" Do you want to a interesting fact about it?";
        pages[1] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 2), new Choice("NEXT", 2), false);

        dialo = new String[1];
        dialo[0]=" Ya! sure.";
        pages[2] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 3), new Choice("NEXT", 3), false);

        dialo = new String[1];
        dialo[0]="Cryptocurrency is independent and don't have any monitoring body.  ";

        pages[3] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 4), new Choice("NEXT", 4), false);


        dialo = new String[3];
        dialo[0]=" Oh! thats cool...";
        dialo[1]=" Thank you for telling me about this.";
        dialo[2]=" Bye! have a nice day..."    ;
        pages[4] = new Page(1, R.drawable.school_school, thinking,
                dialo, new Choice("NEXT", 5), new Choice("NEXT", 5), true);

    }



    public Page getPage(int pageNumber) {


        if (pageNumber >= pages.length) {
            pageNumber = 0;
        }
        return pages[pageNumber];
    }


}
