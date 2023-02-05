package Beans;

public class Login {
    private int usid;
    private String username ;
    private String passwd;

    public int getUsid() {
        return usid;
    }

    public void setUsid(int usid) {
        this.usid = usid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Login(int usid, String username, String passwd) {
        this.usid = usid;
        this.username = username;
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Login{" +
                "usid=" + usid +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
