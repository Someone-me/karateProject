package cn.competitonInfo;

public class competitonInfo {
    private int teamId;
    private String teamName;
    private String teamOrganizer;
    private String teamUndertake;
    private String teamCoOrganizer;
    private String teamPavilion;
    private String TeamStartTime;
    private String TeamEndTime;
    private String TeamLevel;
    private String TeamFormat;

    @Override
    public String toString() {
        return "competitonInfo{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", teamOrganizer='" + teamOrganizer + '\'' +
                ", teamUndertake='" + teamUndertake + '\'' +
                ", teamCoOrganizer='" + teamCoOrganizer + '\'' +
                ", teamPavilion='" + teamPavilion + '\'' +
                ", TeamStartTime='" + TeamStartTime + '\'' +
                ", TeamEndTime='" + TeamEndTime + '\'' +
                ", TeamLevel='" + TeamLevel + '\'' +
                ", TeamFormat='" + TeamFormat + '\'' +
                '}';
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamOrganizer() {
        return teamOrganizer;
    }

    public void setTeamOrganizer(String teamOrganizer) {
        this.teamOrganizer = teamOrganizer;
    }

    public String getTeamUndertake() {
        return teamUndertake;
    }

    public void setTeamUndertake(String teamUndertake) {
        this.teamUndertake = teamUndertake;
    }

    public String getTeamCoOrganizer() {
        return teamCoOrganizer;
    }

    public void setTeamCoOrganizer(String teamCoOrganizer) {
        this.teamCoOrganizer = teamCoOrganizer;
    }

    public String getTeamPavilion() {
        return teamPavilion;
    }

    public void setTeamPavilion(String teamPavilion) {
        this.teamPavilion = teamPavilion;
    }

    public String getTeamStartTime() {
        return TeamStartTime;
    }

    public void setTeamStartTime(String teamStartTime) {
        TeamStartTime = teamStartTime;
    }

    public String getTeamEndTime() {
        return TeamEndTime;
    }

    public void setTeamEndTime(String teamEndTime) {
        TeamEndTime = teamEndTime;
    }

    public String getTeamLevel() {
        return TeamLevel;
    }

    public void setTeamLevel(String teamLevel) {
        TeamLevel = teamLevel;
    }

    public String getTeamFormat() {
        return TeamFormat;
    }

    public void setTeamFormat(String teamFormat) {
        TeamFormat = teamFormat;
    }
}
