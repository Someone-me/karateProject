package cn.RefereeScore;

public class personalTypeRefereeScore {

    private int id;
    private String playerId;
    private String typenumber;
    private String typename;
    private String playerIdcard;
    private String type;
    private String level;
    private float Treferee1;
    private float Treferee2;
    private float Treferee3;
    private float Treferee4;
    private float Treferee5;
    private float Treferee6;
    private float Treferee7;
    private float Ttotal;

    private float referee1;
    private float referee2;
    private float referee3;
    private float referee4;
    private float referee5;
    private float referee6;
    private float referee7;
    private float total;
    private float result;
    private int status;

    @Override
    public String toString() {
        return "personalTypeRefereeScore{" +
                "id=" + id +
                ", playerId='" + playerId + '\'' +
                ", typenumber='" + typenumber + '\'' +
                ", typename='" + typename + '\'' +
                ", playerIdcard='" + playerIdcard + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", Treferee1=" + Treferee1 +
                ", Treferee2=" + Treferee2 +
                ", Treferee3=" + Treferee3 +
                ", Treferee4=" + Treferee4 +
                ", Treferee5=" + Treferee5 +
                ", Treferee6=" + Treferee6 +
                ", Treferee7=" + Treferee7 +
                ", Ttotal=" + Ttotal +
                ", referee1=" + referee1 +
                ", referee2=" + referee2 +
                ", referee3=" + referee3 +
                ", referee4=" + referee4 +
                ", referee5=" + referee5 +
                ", referee6=" + referee6 +
                ", referee7=" + referee7 +
                ", total=" + total +
                ", result=" + result +
                ", status=" + status +
                '}';
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

    public String getPlayerIdcard() {
        return playerIdcard;
    }

    public void setPlayerIdcard(String playerIdcard) {
        this.playerIdcard = playerIdcard;
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

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getTypenumber() {
        return typenumber;
    }

    public void setTypenumber(String typenumber) {
        this.typenumber = typenumber;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public float getTreferee1() {
        return Treferee1;
    }

    public void setTreferee1(float treferee1) {
        Treferee1 = treferee1;
    }

    public float getTreferee2() {
        return Treferee2;
    }

    public void setTreferee2(float treferee2) {
        Treferee2 = treferee2;
    }

    public float getTreferee3() {
        return Treferee3;
    }

    public void setTreferee3(float treferee3) {
        Treferee3 = treferee3;
    }

    public float getTreferee4() {
        return Treferee4;
    }

    public void setTreferee4(float treferee4) {
        Treferee4 = treferee4;
    }

    public float getTreferee5() {
        return Treferee5;
    }

    public void setTreferee5(float treferee5) {
        Treferee5 = treferee5;
    }

    public float getTreferee6() {
        return Treferee6;
    }

    public void setTreferee6(float treferee6) {
        Treferee6 = treferee6;
    }

    public float getTreferee7() {
        return Treferee7;
    }

    public void setTreferee7(float treferee7) {
        Treferee7 = treferee7;
    }

    public float getTtotal() {
        return Ttotal;
    }

    public void setTtotal(float ttotal) {
        Ttotal = ttotal;
    }

    public float getReferee1() {
        return referee1;
    }

    public void setReferee1(float referee1) {
        this.referee1 = referee1;
    }

    public float getReferee2() {
        return referee2;
    }

    public void setReferee2(float referee2) {
        this.referee2 = referee2;
    }

    public float getReferee3() {
        return referee3;
    }

    public void setReferee3(float referee3) {
        this.referee3 = referee3;
    }

    public float getReferee4() {
        return referee4;
    }

    public void setReferee4(float referee4) {
        this.referee4 = referee4;
    }

    public float getReferee5() {
        return referee5;
    }

    public void setReferee5(float referee5) {
        this.referee5 = referee5;
    }

    public float getReferee6() {
        return referee6;
    }

    public void setReferee6(float referee6) {
        this.referee6 = referee6;
    }

    public float getReferee7() {
        return referee7;
    }

    public void setReferee7(float referee7) {
        this.referee7 = referee7;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }
}
