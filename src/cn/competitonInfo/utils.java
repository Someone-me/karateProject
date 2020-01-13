package cn.competitonInfo;

public class utils {
    private static competitonInfo pq=new competitonInfo();
    public static competitonInfo getPq() {
        return pq;
    }
    public static void setPq(competitonInfo pq) {
        utils.pq = pq;
    }

    private static saveId sq=new saveId();

    public static saveId getSq() {
        return sq;
    }

    public static void setSq(saveId sq) {
        utils.sq = sq;
    }


    private static competitonInfo p=new competitonInfo();
    public static competitonInfo getP() {
        return p;
    }
    public static void setP(competitonInfo p) {
        utils.p = p;
    }
}
