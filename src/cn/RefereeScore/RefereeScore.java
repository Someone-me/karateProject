package cn.RefereeScore;

public class RefereeScore {
    private String player1;
    private float firstReferee1;
    private float referee1;
    private float referee2;
    private float referee3;
    private float referee4;
    private float average1;

    private String player2;
    private float firstReferee2;
    private float referee5;
    private float referee6;
    private float referee7;
    private float referee8;
    private float average2;

    @Override
    public String toString() {
        return "RefereeScore{" +
                "player1='" + player1 + '\'' +
                ", firstReferee1=" + firstReferee1 +
                ", referee1=" + referee1 +
                ", referee2=" + referee2 +
                ", referee3=" + referee3 +
                ", referee4=" + referee4 +
                ", average1=" + average1 +
                ", player2='" + player2 + '\'' +
                ", firstReferee2=" + firstReferee2 +
                ", referee5=" + referee5 +
                ", referee6=" + referee6 +
                ", referee7=" + referee7 +
                ", referee8=" + referee8 +
                ", average2=" + average2 +
                '}';
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public float getFirstReferee1() {
        return firstReferee1;
    }

    public void setFirstReferee1(float firstReferee1) {
        this.firstReferee1 = firstReferee1;
    }

    public float getReferee1() {
        return referee1;
    }

    public void setReferee1(float referee1) {
        this.referee1 = referee1;
    }

    public float getReferee2() {
        return referee2;
    }

    public void setReferee2(float referee2) {
        this.referee2 = referee2;
    }

    public float getReferee3() {
        return referee3;
    }

    public void setReferee3(float referee3) {
        this.referee3 = referee3;
    }

    public float getReferee4() {
        return referee4;
    }

    public void setReferee4(float referee4) {
        this.referee4 = referee4;
    }

    public float getAverage1() {
        return average1;
    }

    public void setAverage1(float average1) {
        this.average1 = average1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public float getFirstReferee2() {
        return firstReferee2;
    }

    public void setFirstReferee2(float firstReferee2) {
        this.firstReferee2 = firstReferee2;
    }

    public float getReferee5() {
        return referee5;
    }

    public void setReferee5(float referee5) {
        this.referee5 = referee5;
    }

    public float getReferee6() {
        return referee6;
    }

    public void setReferee6(float referee6) {
        this.referee6 = referee6;
    }

    public float getReferee7() {
        return referee7;
    }

    public void setReferee7(float referee7) {
        this.referee7 = referee7;
    }

    public float getReferee8() {
        return referee8;
    }

    public void setReferee8(float referee8) {
        this.referee8 = referee8;
    }

    public float getAverage2() {
        return average2;
    }

    public void setAverage2(float average2) {
        this.average2 = average2;
    }




}
