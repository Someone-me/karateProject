package cn.groupInformation;

public class grouping {
    private String playername;
    private String playerId;
    private int group;

    @Override
    public String toString() {
        return "grouping{" +
                "playername='" + playername + '\'' +
                ", playerId='" + playerId + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
