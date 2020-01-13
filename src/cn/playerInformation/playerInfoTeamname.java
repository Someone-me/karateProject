package cn.playerInformation;

public class playerInfoTeamname {

//    private String groupId;
//    private String userId;
//    private String groupName;
//    private String status;
//    private String createTime;

    private String groupName;

    @Override
    public String toString() {
        return "playerInfoTeamname{" +
                "groupName='" + groupName + '\'' +
                '}';
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
