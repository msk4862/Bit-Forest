package gamedevelopers.funcandi.taskworkflow.Intro.model;

/**
 * Created by msk on 04-07-2017.
 */

public class Choice {

    private String ch;
    private int nextPage;

    public Choice(String ch, int nextPage) {
        this.ch = ch;
        this.nextPage = nextPage;
    }

    public String getCh() {
        return ch;
    }



    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
}
