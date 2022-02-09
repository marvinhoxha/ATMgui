package ATMsrc.forms;

import ATMsrc.Usersdata.ListData;
import ATMsrc.Usersdata.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminMenu extends JFrame{
    private JPanel minimize;
    private JButton xButton;
    private JLabel BARICON;
    private JButton button3;
    private JButton deleteUserButton;
    private JButton changeUserDataButton;
    private JButton userListButton;
    private JButton logOutButton;
    private JPanel toppanel;
    public ImageIcon image = new ImageIcon(".\\img.png");

    public user getUser1() {
        return user1;
    }

    public void setUser1(user user1) {
        this.user1 = user1;
    }

    private  user user1;
    public adminMenu(){
        toppanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
        setContentPane(toppanel);
        setVisible(false);
        setUndecorated(true);
        setIconImage(image.getImage());


        setSize(540,230);
        setLocationRelativeTo(null);
        xButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setState(JFrame.ICONIFIED);
            }
        });
        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteUser deleteUser = new deleteUser();
                deleteUser.setVisible(true);
                dispose();
            }
        });
        userListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListData listData = new ListData();
                listData.setVisible(true);
            }
        });
        changeUserDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChangeUserData changeUserData = new ChangeUserData();
                changeUserData.setVisible(true);
                dispose();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminLogin adminLogin = new AdminLogin();
                adminLogin.setVisible(true);
                dispose();
            }
        });
    }
}
