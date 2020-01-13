package cn.playerInformation;

public class playerInfoQuery {

    private String teamname;
    private String kilogram;
    private String matchtype;

//    @Override
    public String toString() {
        return "playerInfoQuery{" +
                "teamname='" + teamname + '\'' +
                ", kilogram='" + kilogram + '\'' +
                ", matchtype='" + matchtype + '\'' +
                '}';
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getKilogram() {
        return kilogram;
    }

    public void setKilogram(String kilogram) {
        this.kilogram = kilogram;
    }

    public String getMatchtype() {
        return matchtype;
    }

    public void setMatchtype(String matchtype) {
        this.matchtype = matchtype;
    }



}
