package cn.communityInfo;

public class communityInfo {
    private int userId;
    private String userName;
    private String userPsd;
    private String userType;
    private String userNames;
    private String userOrganizationName;
    private String userTel;
    private String userIdCard;
    private String identityCardFrontPic;
    private String identityCardReversePic;
    private String userEmail;

    @Override
    public String toString() {
        return "communityInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPsd='" + userPsd + '\'' +
                ", userType='" + userType + '\'' +
                ", userNames='" + userNames + '\'' +
                ", userOrganizationName='" + userOrganizationName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userIdCard='" + userIdCard + '\'' +
                ", identityCardFrontPic='" + identityCardFrontPic + '\'' +
                ", identityCardReversePic='" + identityCardReversePic + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsd() {
        return userPsd;
    }

    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserNames() {
        return userNames;
    }

    public void setUserNames(String userNames) {
        this.userNames = userNames;
    }

    public String getUserOrganizationName() {
        return userOrganizationName;
    }

    public void setUserOrganizationName(String userOrganizationName) {
        this.userOrganizationName = userOrganizationName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public String getIdentityCardFrontPic() {
        return identityCardFrontPic;
    }

    public void setIdentityCardFrontPic(String identityCardFrontPic) {
        this.identityCardFrontPic = identityCardFrontPic;
    }

    public String getIdentityCardReversePic() {
        return identityCardReversePic;
    }

    public void setIdentityCardReversePic(String identityCardReversePic) {
        this.identityCardReversePic = identityCardReversePic;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
