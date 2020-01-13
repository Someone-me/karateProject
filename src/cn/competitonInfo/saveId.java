package cn.competitonInfo;

public class saveId {
    private static String id;

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        saveId.id = id;
    }

    @Override
    public String toString() {
        return "saveId{" +
                "id='" + id + '\'' +
                '}';
    }


}
