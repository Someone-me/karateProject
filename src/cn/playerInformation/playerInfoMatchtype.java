package cn.playerInformation;

public class playerInfoMatchtype {

    private int id;
    private String matchtype;
    private String category;

    @Override
    public String toString() {
        return "playerInfoMatchtype{" +
                "id=" + id +
                ", matchtype='" + matchtype + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatchtype() {
        return matchtype;
    }

    public void setMatchtype(String matchtype) {
        this.matchtype = matchtype;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



}
