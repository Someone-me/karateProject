package cn.communityInfo;

public class BenlargePhoto {
    @Override
    public String toString() {
        return "BenlargePhoto{" +
                "identityCardReversePic='" + identityCardReversePic + '\'' +
                '}';
    }

    public String getIdentityCardReversePic() {
        return identityCardReversePic;
    }

    public void setIdentityCardReversePic(String identityCardReversePic) {
        this.identityCardReversePic = identityCardReversePic;
    }

    private String identityCardReversePic;

}
