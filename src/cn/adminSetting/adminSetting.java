package cn.adminSetting;

public class adminSetting {



    private int id;
    private String adminname;
    private String phonenumber;
    private String password;
    private String email;
    private String idCard;

    @Override
    public String toString() {
        return "adminSetting{" +
                "id=" + id +
                ", adminname='" + adminname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getUsername() {
        return adminname;
    }

    public void setUsername(String username) {
        this.adminname = username;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
