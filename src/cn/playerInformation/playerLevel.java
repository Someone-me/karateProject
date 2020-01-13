package cn.playerInformation;

public class playerLevel {
    private int level_id;
    private String level;
    private String levelType;
    private String levelWeigth;

    @Override
    public String toString() {
        return "playerLevel{" +
                "level_id=" + level_id +
                ", level='" + level + '\'' +
                ", levelType='" + levelType + '\'' +
                ", levelWeigth='" + levelWeigth + '\'' +
                '}';
    }

    public int getLevel_id() {
        return level_id;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public String getLevelWeigth() {
        return levelWeigth;
    }

    public void setLevelWeigth(String levelWeigth) {
        this.levelWeigth = levelWeigth;
    }
}
