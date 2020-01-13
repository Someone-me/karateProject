package cn.playerInformation;

public class playerInformation {
    private int playerId;
    private int userId;
    private String playerName;
    private String playerSex;
    private String playerTel;
    private String playerIdCrad;
    private String playerLevel;
    private String playerPosition;
    private String playerTeam;
    private int playerStatus;
    private String playerStature;
    private String playerWeight;
    private String playerWeChatId;
    private String playerGroup;

    @Override
    public String toString() {
        return "playerInformation{" +
                "playerId=" + playerId +
                ", userId=" + userId +
                ", playerName='" + playerName + '\'' +
                ", playerSex='" + playerSex + '\'' +
                ", playerTel='" + playerTel + '\'' +
                ", playerIdCrad='" + playerIdCrad + '\'' +
                ", playerLevel='" + playerLevel + '\'' +
                ", playerPosition='" + playerPosition + '\'' +
                ", playerTeam='" + playerTeam + '\'' +
                ", playerStatus=" + playerStatus +
                ", playerStature='" + playerStature + '\'' +
                ", playerWeight='" + playerWeight + '\'' +
                ", playerWeChatId='" + playerWeChatId + '\'' +
                ", playerGroup='" + playerGroup + '\'' +
                '}';
    }

    public String getPlayerGroup() {
        return playerGroup;
    }

    public void setPlayerGroup(String playerGroup) {
        this.playerGroup = playerGroup;
    }
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerSex() {
        return playerSex;
    }

    public void setPlayerSex(String playerSex) {
        this.playerSex = playerSex;
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

    public String getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(String playerLevel) {
        this.playerLevel = playerLevel;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    public void setPlayerTeam(String playerTeam) {
        this.playerTeam = playerTeam;
    }

    public int getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(int playerStatus) {
        this.playerStatus = playerStatus;
    }

    public String getPlayerStature() {
        return playerStature;
    }

    public void setPlayerStature(String playerStature) {
        this.playerStature = playerStature;
    }

    public String getPlayerWeight() {
        return playerWeight;
    }

    public void setPlayerWeight(String playerWeight) {
        this.playerWeight = playerWeight;
    }

    public String getPlayerWeChatId() {
        return playerWeChatId;
    }

    public void setPlayerWeChatId(String playerWeChatId) {
        this.playerWeChatId = playerWeChatId;
    }
}
