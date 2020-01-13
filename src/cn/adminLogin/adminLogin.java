package cn.adminLogin;

public class adminLogin {
    private String phonenumber;
    private String password;

    @Override
    public String toString() {
        return "adminLogin{" +
                "phonenumber='" + phonenumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

}
