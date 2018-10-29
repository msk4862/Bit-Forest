package gamedevelopers.funcandi.taskworkflow.Intro.model;

/**
 * Created by msk on 04-07-2017.
 */

import android.content.Context;

import gamedevelopers.funcandi.taskworkflow.Intro.ui.MainActivity;
import gamedevelopers.funcandi.taskworkflow.R;

public class Story3 {

    String name;
    private Page[] pages;
    private String[] dialo;


    // set this to true for analysis part
    public boolean analysis=false;


    Context context;

    int happy, shocked, thinking, nervous;

    public Story3(String name, Context context) {

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

        dialo[0]="  Hi Zayn! what the merkle tree is, its little tricky !! ";
        pages[0] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 1), new Choice("NEXT", 1), false);

        dialo = new String[1];
        dialo[0]=" Ya its little tricky but it is the most important aspect of Blockchain.";
        pages[1] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 2), new Choice("NEXT", 2), false);

        dialo = new String[1];
        dialo[0]="  So what is it?";                           //r0h!n!cbs
        pages[2] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 3), new Choice("NEXT", 3), false);

        dialo = new String[2];
        dialo[0]=" A Merkle Tree is a tree in which every leaf node is labelled with the hash of a data block.";
        dialo[1]=" And every non leaf node is labelled with the cryptographic hash of the labels of its child nodes.";

        pages[3] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 4), new Choice("NEXT", 4), false);


        dialo = new String[1];
        dialo[0]=" Okay but can you explain with an example?";
        pages[4] = new Page(1, R.drawable.school_school, thinking,
                dialo, new Choice("NEXT", 5), new Choice("NEXT", 5), false);


        dialo = new String[4];
        dialo[0]=" Yeah sure!!";
        dialo[1]=" Assume the two leafs 1 and 2 has hash value X and Y respectively";
        dialo[2]=" plus they are siblings then, because of the concept of the merkle tree";
        dialo[3]=" their parent will have hash XY ....";

        //Buddy Constructor called
        pages[5] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 6), new Choice("NEXT", 6), false);

        dialo = new String[1];
        dialo[0]="Oh! this is what happens in the merkle tree?";
        pages[6] = new Page(1, R.drawable.school_school, thinking,
                dialo, new Choice("NEXT", 7), new Choice("NEXT", 7), false);


        dialo = new String[1];
        dialo[0]="Ya! thats all.";
        pages[7] = new Page(2, R.drawable.school_school, R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 8), new Choice("NEXT", 8), false);


        dialo = new String[2];
        dialo[0] = "Thanks a lot for clearing my concept.";
        dialo[1] = "I'll meet you tommorow.";
        pages[8] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 9), new Choice("NEXT", 9), false);


        dialo = new String[1];
        dialo[0]="Cool, bye then!!";
        pages[9] = new Page( 2, R.drawable.school_school,R.drawable.school_happyfriend,
                dialo, new Choice("NEXT", 10), new Choice("NEXT", 10), false);



        dialo = new String[1];
        dialo[0] = "Bye!!!!";
        pages[10] = new Page(1, R.drawable.school_school, happy,
                dialo, new Choice("NEXT", 11), new Choice("NEXT", 11), true);


    }



    public Page getPage(int pageNumber) {


        if (pageNumber >= pages.length) {
            pageNumber = 0;
        }
        return pages[pageNumber];
    }


}
