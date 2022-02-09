package ATMsrc.Usersdata;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;


public class user implements Serializable {
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    private String phone;
    private int id;
    private int Balance;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return Balance;
    }
    public void setBalance(int balance) {
        Balance = balance;
    }

    public ArrayList<Transactions> getTransactions() {
        readF();
        return transactions;
    }

    public void setTransactions(ArrayList<Transactions> transactions) {
        this.transactions = transactions;
    }
    public static Date date = new Date();
    public final String filename = "Transaction.ser";
    private ArrayList<Transactions> transactions= new ArrayList<>();
    InputStream file, buffer;
    OutputStream bf, fl;
    ObjectInput input;
    ObjectOutput output;
    File uf = new File(filename);
    public user(){
        readF();
    }

    public user(String name, int id, String email, String password, int balance,String phone){
        this.phone=phone;
        this.email=email;
        this.id= id;
        this.name=name;
        this.password=password;
        this.Balance=balance;
    }
    public void withdraw(int withdrawamount){
        if (withdrawamount<=Balance){
            Transactions transaction = new Transactions(getEmail(),withdrawamount,"withdraw");
            transactions.add(transaction);
            writeF();
            readF();
            Balance-=withdrawamount;
            JOptionPane.showMessageDialog(null, "You successfully withdrawed "+withdrawamount+"$");
        }
        else JOptionPane.showMessageDialog(null, "You don't have enough money :(");
    }

    public void deposit(int depositamount) {
        Transactions transaction = new Transactions(getEmail(),depositamount,"deposit");
        transactions.add(transaction);
        writeF();
        readF();
        JOptionPane.showMessageDialog(null, "You successfuly deposited "+depositamount+"$.");
        Balance+=depositamount;
    }

    @Override
    public String toString() {
        return "user{" +
                "email='" + email + '\'' +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", Phonenumber='" + phone + '\'' +
                ", Balance=" + Balance +
                '}';
    }
    public void readF() {
        try {
            // use buffering
            file = new FileInputStream(uf);
            buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);
            // deserialize the List
            transactions = (ArrayList<Transactions>) input.readObject();
            // display its data
            for (Transactions transaction : transactions) {
                System.out.println("Data: " + transaction.toString());
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Not found. Creating new file"
                    + ex.toString());
        } catch (IOException ex) {
            System.out.println("Cannot perform input." + ex.toString());
        }
        closeFile();
    }

    private void writeF() {
        // TODO Auto-generated method stub
        // serialize the List
        try {
            fl = new FileOutputStream(uf);
            bf = new BufferedOutputStream(fl);
            output = new ObjectOutputStream(bf);
            output.writeObject(transactions);
        } catch (IOException ex) {
            System.out.println("Cannot perform output." + ex.toString());
        }
        closeFile();
    }

    public void closeFile() {
        try {
            if (input != null) {
                input.close();
                buffer.close();
                file.close();
            }
            if (output != null) {
                output.close();
                bf.close();
                fl.close();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
