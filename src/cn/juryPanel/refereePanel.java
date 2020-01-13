package cn.juryPanel;

public class refereePanel {
    private int id;
    private String position;
    private int refereenumber;
    private int status;

    @Override
    public String toString() {
        return "refereePanel{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", refereenumber=" + refereenumber +
                ", status=" + status +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getRefereenumber() {
        return refereenumber;
    }

    public void setRefereenumber(int refereenumber) {
        this.refereenumber = refereenumber;
    }
}
