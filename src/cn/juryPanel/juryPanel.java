package cn.juryPanel;

public class juryPanel {
    private int id;
    private String refereeName;
    private String refereeId;
    private int flag;
    private String phone;
    private int status;
    private int state;

    @Override
    public String toString() {
        return "juryPanel{" +
                "id=" + id +
                ", refereeName='" + refereeName + '\'' +
                ", refereeId='" + refereeId + '\'' +
                ", flag=" + flag +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", state=" + state +
                '}';
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefereeName() {
        return refereeName;
    }

    public void setRefereeName(String refereeName) {
        this.refereeName = refereeName;
    }


    public String getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(String refereeId) {
        this.refereeId = refereeId;
    }


    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
