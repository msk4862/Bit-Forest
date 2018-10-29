package gamedevelopers.funcandi.taskworkflow.Intro.model;

/**
 * Created by msk on 04-07-2017.
 */

import android.content.Context;

import gamedevelopers.funcandi.taskworkflow.Intro.ui.MainActivity;
import gamedevelopers.funcandi.taskworkflow.R;

public class Story5 {

    String name;
    private Page[] pages;
    private String[] dialo;


    // set this to true for analysis part
    public boolean analysis=false;


    Context context;

    int happy, shocked, thinking, nervous;

    public Story5(String name, Context context) {

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

        dialo[0]="  Hi Zayn! Is blockchain is limited to cryptocurrency? ";
        pages[0] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 1), new Choice("NEXT", 1), false);

        dialo = new String[3];
        dialo[0]= " No, not at all...";
        dialo[1]=" Blockchain is much more than an instrument of finance.";
        dialo[2]=" It is an encrypted database of agreement ... once a deal is made, niether party can go back nor rewrite the terms.";
        pages[1] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 2), new Choice("NEXT", 2), false);

        dialo = new String[2];
        dialo[0]=" Okay!";
        dialo[1]=" But can you tell me the scenario where it is used?";                           //r0h!n!cbs
        pages[2] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 3), new Choice("NEXT", 3), false);

        dialo = new String[3];
        dialo[0]=" It is used for monitor supply chains, retail loyalty rewards programs,";
        dialo[1]=" preventing voter fraud, improving government efficiency, digital identity,";
        dialo[2]=" food safety, tax regulation, medical recordkeeping, and many more...";
        pages[3] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 4), new Choice("NEXT", 4), false);


        dialo = new String[1];
        dialo[0]=" Wow! that are way too many uses of Blockchain.";
        pages[4] = new Page(1, R.drawable.school_school, thinking,
                dialo, new Choice("NEXT", 5), new Choice("NEXT", 5), false);


        dialo = new String[1];
        dialo[0]="I told you, thats why its the next big thing of 21st Century!!";
        pages[5] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 6), new Choice("NEXT", 6), false);

        dialo = new String[1];
        dialo[0]="Okay !! bye my mom is calling!";
        pages[6] = new Page(1, R.drawable.school_school, thinking,
                dialo, new Choice("NEXT", 7), new Choice("NEXT", 7), true);


    }



    public Page getPage(int pageNumber) {


        if (pageNumber >= pages.length) {
            pageNumber = 0;
        }
        return pages[pageNumber];
    }


}
