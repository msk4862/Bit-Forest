package gamedevelopers.funcandi.taskworkflow.Intro.model;

/**
 * Created by msk on 04-07-2017.
 */

public class Page {

    private int imageId;
    private int charId;
    private String[] dialo;
    private Choice choice1;
    private Choice choice2;
    private boolean isFinalPage = false;
    int mainChar;
    boolean isThinking;
    int isBuddy;


    public Page(boolean isThinking, int mainChar, int imageId, int charId, String[] dialo, Choice choice1, Choice choice2, boolean isFinalPage) {
        this.imageId = imageId;
        this.charId = charId;
        this.dialo = dialo;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.isFinalPage=isFinalPage;
        this.mainChar=mainChar;
        this.isThinking = isThinking;
    }

    public Page(int isBuddy, int mainChar, int imageId, int charId, String[] dialo, Choice choice1, Choice choice2, boolean isFinalPage) {
        this.imageId = imageId;
        this.charId = charId;
        this.dialo = dialo;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.isFinalPage=isFinalPage;
        this.mainChar=mainChar;
        this.isBuddy = isBuddy;
    }

    public Page(int mainChar, int imageId, int charId, String[] dialo, Choice choice1, Choice choice2, boolean isFinalPage) {
        this.imageId = imageId;
        this.charId = charId;
        this.dialo = dialo;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.isFinalPage=isFinalPage;
        this.mainChar=mainChar;
    }

    public boolean isThinking(){
        return isThinking;
    }

    public int getIsBuddy(){
        return isBuddy;
    }

    public int getMainChar() {
        return mainChar;
    }

    public boolean isFinalPage() {
        return isFinalPage;
    }

    public void setFinalPage(boolean finalPage) {
        isFinalPage = finalPage;
    }

    public int getImageId() {
        return imageId;
    }

    public int getCharId() {
        return charId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String[] getDialo() {
        return dialo;
    }
    public Choice getChoice1() {
        return choice1;
    }

    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }
}
