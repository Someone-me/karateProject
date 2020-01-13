package cn.refereeWindows;

public class refereeWindows {

    private String refereeNumber;
    private String type;
    private String level;
    private String typeNumber;
    private String playerName;
    private String typeName;
    private float technicalPoints;
    private float motionScore;

    @Override
    public String toString() {
        return "refereeWindows{" +
                "refereeNumber='" + refereeNumber + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", typeNumber='" + typeNumber + '\'' +
                ", playerName='" + playerName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", technicalPoints=" + technicalPoints +
                ", motionScore=" + motionScore +
                '}';
    }

    public String getRefereeNumber() {
        return refereeNumber;
    }

    public void setRefereeNumber(String refereeNumber) {
        this.refereeNumber = refereeNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(String typeNumber) {
        this.typeNumber = typeNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public float getTechnicalPoints() {
        return technicalPoints;
    }

    public void setTechnicalPoints(float technicalPoints) {
        this.technicalPoints = technicalPoints;
    }

    public float getMotionScore() {
        return motionScore;
    }

    public void setMotionScore(float motionScore) {
        this.motionScore = motionScore;
    }
}
