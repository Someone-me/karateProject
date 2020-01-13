package cn.communityInfo;

public class AenlargePhoto {
    private String identityCardFrontPic;

    @Override
    public String toString() {
        return "AenlargePhoto{" +
                "identityCardFrontPic='" + identityCardFrontPic + '\'' +
                '}';
    }

    public String getIdentityCardFrontPic() {
        return identityCardFrontPic;
    }

    public void setIdentityCardFrontPic(String identityCardFrontPic) {
        this.identityCardFrontPic = identityCardFrontPic;
    }
}
