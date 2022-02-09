package ATMsrc.Usersdata;

import javax.swing.*;
import java.util.ArrayList;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class UserDataManegment {
    //
    public static final String filename = "Users.ser";
    private ArrayList<user> users = new ArrayList<user>();
    InputStream file, buffer;
    OutputStream bf, fl;
    ObjectInput input;
    ObjectOutput output;
    File uf = new File(filename);

    public UserDataManegment() {
        System.out.println("---------------------------------------------------------------");
        readF();
    }
    public int getPosition(user u)
    {
        for(int i=0; i<users.size(); i++)
        {
            if(users.get(i).toString().equals(u.toString()))
                return i;
        }
        return -1;
    }
    public int getPositionEmail(String email)
    {
        for(int i=0; i<users.size(); i++)
        {
            if(users.get(i).getEmail().equals(email))
                return i;
        }
        return -1;
    }

    public user checkUser(String user, String pass) {
        for (user x : users)
            if (x.getEmail().equals(user) && x.getPassword().equals(pass)) {
                return x;
            }
        return null;
    }
    public boolean verifyUser(String email) {
        for (user x : users)
            if (x.getEmail().equals(email)) {
                return true;
            }
        return false;
    }
    public void changebalance(String email,int amount) {
        for (user x : users)
            if (x.getEmail().equals(email)) {
                x.setBalance(amount);
                writeF();
                new UserDataManegment();
            }
    }
    public void changePassword(String email,String pass) {
        for (user x : users)
            if (x.getEmail().equals(email)) {
                x.setPassword(pass);
                writeF();
                new UserDataManegment();
            }
    }
    public void changeUserData(String email, String pass, String name, Integer balance, String phone) {
        for (user x : users)
            if (x.getEmail().equals(email)) {
                x.setPassword(pass);
                x.setName(name);
                x.setBalance(balance);
                x.setPhone(phone);
                writeF();
                new UserDataManegment();
            }
    }


    public void addUser(user user) {
        users.add(user);
        user.setId(getPosition(user));
        writeF();
        new UserDataManegment();
    }


    public ArrayList<user> getUsers()
    {
        this.readF();
        return this.users;
    }
    public user getUsersList(int i)
    {
        return this.users.get(i);
    }

    public void rm(String email) {
        boolean rm = false;
        for (user x : users) {
            if (x.getEmail().equals(email)) {
                rm = true;
                users.remove(x);
                writeF();
                new UserDataManegment();
                JOptionPane.showMessageDialog(null, "User Deleted");
            }
        }
        if (!rm)
            JOptionPane.showMessageDialog(null, "User not Found");
    }



    public void editUser(int pos, user u)
    {
        System.out.println(">>>>"+pos);
        if(pos < 0 || pos >= users.size())
        {
            System.out.println("Cannot find User");
            return;
        }
        else
        {
            users.set(pos, u);
            this.writeF();
        }
    }

    @SuppressWarnings("unchecked")
    public void readF() {
        try {
            // use buffering
            file = new FileInputStream(uf);
            buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);
            // deserialize the List
            users = (ArrayList<user>) input.readObject();
            // display its data
            for (user user : users) {
                System.out.println("Data: " + user.toString());
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
            output.writeObject(users);
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
