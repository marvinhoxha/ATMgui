package ATMsrc.Usersdata;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Transactions implements Serializable {


    private int amount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public Date getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
    private Date date;
    public Transactions(String email, int amount, String type){
        this.email = email;
        this.amount = amount;
        this.type = type;
        this.date = new Date();
    }
    public String toString() {
        return "Transaction{" +
                " email = '" + email +  '\'' +
                " amount = '" + amount + "$" + '\'' +
                " type = '" + type + '\'' +
                " date = '" + date + '\'' +
                '}';
    }


}
