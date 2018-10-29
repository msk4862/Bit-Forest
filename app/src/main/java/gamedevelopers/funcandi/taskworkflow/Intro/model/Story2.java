package gamedevelopers.funcandi.taskworkflow.Intro.model;

/**
 * Created by msk on 04-07-2017.
 */

import android.content.Context;

import gamedevelopers.funcandi.taskworkflow.Intro.ui.MainActivity;
import gamedevelopers.funcandi.taskworkflow.R;

public class Story2 {

    String name;
    private Page[] pages;
    private String[] dialo;


    // set this to true for analysis part
    public boolean analysis=false;


    Context context;

    int happy, shocked, thinking, nervous;

    public Story2(String name, Context context) {


        if (MainActivity.gender == 'B' ||  MainActivity.gender == '\u0000') {
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

        dialo[0]="Hey!! Zayn, can you please help me out ?";
        pages[0] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 2), new Choice("NEXT", 2), false);

        dialo = new String[2];
        dialo[0]= "Hey "+name;
        dialo[1]="Ya sure but whats the matter?";
        pages[1] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 2), new Choice("NEXT", 2), false);

        dialo = new String[1];
        dialo[0]="  Yesterday I was reading about blockchain but couldn't understand about something called hashing.";                           //r0h!n!cbs


        pages[2] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 3), new Choice("NEXT", 3), false);

        dialo = new String[1];
        dialo[0]=" Oh!! Hashing... Firstly, a hash is a type of function. You give some input to it, it’ll give some output back";

        pages[3] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 4), new Choice("NEXT", 4), false);


        dialo = new String[2];
        dialo[0]=" okay!!";
        dialo[1]=" And where it is used in the blockchain?";
        pages[4] = new Page(1, R.drawable.school_school, thinking,
                dialo, new Choice("NEXT", 5), new Choice("NEXT", 5), false);


        dialo = new String[1];
        dialo[0]="It's basically used in management of cryptocurrency.";

        //Buddy Constructor called
        pages[5] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 6), new Choice("NEXT", 6), false);

        dialo = new String[2];
        dialo[0]="Okay!! Thank You!";
        dialo[1]="But what is cryptocurrency?";
        pages[6] = new Page(1, R.drawable.school_school, thinking,
                dialo, new Choice("NEXT", 7), new Choice("NEXT", 7), false);


        dialo = new String[2];
        dialo[0]="Actually I got to go somewhere at the moment. I will tell you tomorrow... ";
        dialo[1] ="Okay?";
        pages[7] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 8), new Choice("NEXT", 8), false);


        dialo = new String[2];
        dialo[0] = "Okay It's fine!!";
        dialo[1] = "Bye then.";
        pages[8] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 9), new Choice("NEXT", 9), true);

    }



    public Page getPage(int pageNumber) {


        if (pageNumber >= pages.length) {
            pageNumber = 0;
        }
        return pages[pageNumber];
    }


}
