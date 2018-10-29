package gamedevelopers.funcandi.taskworkflow.Intro.model;

/**
 * Created by msk on 04-07-2017.
 */

import android.content.Context;

import gamedevelopers.funcandi.taskworkflow.Intro.ui.MainActivity;
import gamedevelopers.funcandi.taskworkflow.R;

public class Story {

    String name;
    private Page[] pages;
    private String[] dialo;


    // set this to true for analysis part
    public boolean analysis=false;


    Context context;

    int happy, shocked, thinking, nervous;

    public Story(String name, Context context) {

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

        dialo[0]="  Hi Zayn ";
        pages[0] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 1), new Choice("NEXT", 1), false);

        dialo = new String[2];
        dialo[0]= "Hey "+name;
        dialo[1]="How is your study going?";
        pages[1] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 2), new Choice("NEXT", 2), false);

        dialo = new String[1];
        dialo[0]="  They are going well";                           //r0h!n!cbs


        pages[2] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 3), new Choice("NEXT", 3), false);

        dialo = new String[1];
        dialo[0]="Oh! thats great! ";

        pages[3] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 4), new Choice("NEXT", 4), false);


        dialo = new String[4];
        dialo[0]=" I heard about Blockchain and I  found it interesting.";
        dialo[1]=" Do you know anything about Blockchain? ";
        dialo[2]=" I want to learn it ";
        dialo[3]=" Can you help me?";
        pages[4] = new Page(1, R.drawable.school_school, thinking,
                dialo, new Choice("NEXT", 5), new Choice("NEXT", 5), false);


        dialo = new String[1];
        dialo[0]="Yeah sure";

        //Buddy Constructor called
        pages[5] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 6), new Choice("NEXT", 6), false);

        dialo = new String[1];
        dialo[0]="What is the whole blockchain thing?";
        pages[6] = new Page(1, R.drawable.school_school, thinking,
                dialo, new Choice("NEXT", 7), new Choice("NEXT", 7), false);


        dialo = new String[3];
        dialo[0]="Okay, A blockchain, is a growing list of records, called blocks.";

        dialo[1] ="And each block contains a unique hash of the previous block.\n";
        dialo[2] ="By design, we can't alter the content of the block.";
        pages[7] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 8), new Choice("NEXT", 8), false);


        dialo = new String[2];
        dialo[0] = "Oh I see,I think I get it";
        dialo[1] = "It's pretty interesting";
        pages[8] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 9), new Choice("NEXT", 9), false);




        dialo = new String[1];

        dialo[0]="Yeah it is";

        pages[9] = new Page( 2, R.drawable.school_school,R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 10), new Choice("NEXT", 10), false);

        //_______________________END ___________________________

        dialo = new String[1];
        dialo[0] = "So, Please tell me more about this Blockchain ...";
        pages[10] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 11), new Choice("NEXT", 11), false);

         dialo = new String[3];
        dialo[0] = "So, a Blockchain is like a distributed database which means it is public";
        dialo[1] = "Many copies of the data are spread across all over the world ";
        dialo[2] = "These copies are called nodes";
        pages[11] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend, dialo, new Choice("NEXT", 12), new Choice("NEXT", 12), false);


        dialo = new String[1];
        dialo[0] = "Ohh...";
        pages[12] = new Page(true, 1, R.drawable.school_school, thinking, dialo, new Choice("NEXT", 13), new Choice("NEXT", 13), false);

        dialo = new String[1];
        dialo[0] = "Can't someone change the data of a node?";

        pages[13] = new Page(1, R.drawable.school_school, thinking,
                dialo, new Choice("NEXT", 14), new Choice("NEXT", 14), false);

        dialo = new String[3];
        dialo[0] = "That's a good question";
        dialo[1] = "Blockchain data is permanent, or 'immutable'";

        dialo[2] = "So no one can change existing data in the blockchain";
        pages[14] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend, dialo, new Choice("NEXT", 15), new Choice("NEXT", 15), false);

        dialo = new String[1];
        dialo[0] = "So I can't erase anything in put in there";

        pages[15] = new Page(1, R.drawable.school_school, thinking,
                dialo, new Choice("NEXT", 16), new Choice("NEXT", 16), false);

        dialo = new String[1];
        dialo[0] = "That's right";

        pages[16] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend, dialo,
                new Choice("NEXT", 17), new Choice("NEXT", 17), false);

        dialo = new String[1];
        dialo[0] = "Thank you Zayn";

        pages[17] = new Page(1, R.drawable.school_school, happy, dialo,
                new Choice("NEXT", 16), new Choice("NEXT", 16), true);


    }



    public Page getPage(int pageNumber) {


        if (pageNumber >= pages.length) {
            pageNumber = 0;
        }
        return pages[pageNumber];
    }


}
