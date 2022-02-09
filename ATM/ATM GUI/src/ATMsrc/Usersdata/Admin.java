package ATMsrc.Usersdata;

import java.util.Date;

public class Admin {
    private String email = "Admin@gmail.com";
    private String password = "Admin1admin";
    private Date dataCreated=new Date();

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public Date getDataCreated() {return dataCreated;}
    public void setDataCreated(Date dataCreated) {this.dataCreated = dataCreated;}
    public Admin(){
        email = "Admin@gmail.com";
        password = "Admin1admin";
    }
    public Admin(String email, String password){
        this.email=email;
        this.password=password;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dataCreated=" + dataCreated +
                '}';
    }
}
