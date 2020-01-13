package cn.playerInformation;

public class playerInfoLookup {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "playerInfoLookup{" +
                "name='" + name + '\'' +
                '}';
    }
}
