package cn.test;

public class test {
    private String type;
    private String level;
    private String typenumber;

    @Override
    public String toString() {
        return "test{" +
                "type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", typenumber='" + typenumber + '\'' +
                '}';
    }

    public String getTypenumber() {
        return typenumber;
    }

    public void setTypenumber(String typenumber) {
        this.typenumber = typenumber;
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
}
