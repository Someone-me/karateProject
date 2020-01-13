package cn.playerInformation;

public class utils {
    //筛选查询使用
    public static playerInfoQuery pq =new playerInfoQuery();
    public static playerInfoQuery getPq() {
        return pq;
    }

    public static void setPq(playerInfoQuery pq) {
        utils.pq = pq;
    }
    //模糊查询使用
    public static playerInfoLookup lp=new playerInfoLookup();
    public static playerInfoLookup getLp() {
        return lp;
    }

    public static void setLp(playerInfoLookup lp) {
        utils.lp = lp;
    }



}
