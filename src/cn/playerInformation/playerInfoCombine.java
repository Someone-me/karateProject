package cn.playerInformation;

public class playerInfoCombine {

    private String playerSex;
    private String levelType;
    private String playerName;
    private String playerTel;
    private String playerIdCrad;
    private String level;
    private String playerPosition;
    private String playerGroup;

    @Override
    public String toString() {
        return "playerInfoCombine{" +
                "playerSex='" + playerSex + '\'' +
                ", levelType='" + levelType + '\'' +
                ", playerName='" + playerName + '\'' +
                ", playerTel='" + playerTel + '\'' +
                ", playerIdCrad='" + playerIdCrad + '\'' +
                ", level='" + level + '\'' +
                ", playerPosition='" + playerPosition + '\'' +
                ", playerGroup='" + playerGroup + '\'' +
                '}';
    }

    public String getPlayerGroup() {
        return playerGroup;
    }

    public void setPlayerGroup(String playerGroup) {
        this.playerGroup = playerGroup;
    }

    public String getPlayerSex() {
        return playerSex;
    }

    public void setPlayerSex(String playerSex) {
        this.playerSex = playerSex;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerTel() {
        return playerTel;
    }

    public void setPlayerTel(String playerTel) {
        this.playerTel = playerTel;
    }

    public String getPlayerIdCrad() {
        return playerIdCrad;
    }

    public void setPlayerIdCrad(String playerIdCrad) {
        this.playerIdCrad = playerIdCrad;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }
}
