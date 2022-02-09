package ATMsrc.forms;


import ATMsrc.Usersdata.user;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class userMenu extends JFrame{
    private JPanel panel1;
    private JButton xButton;
    private JButton button3;
    private JButton logOutButton;
    private JPanel minimize;
    private JLabel BARICON;
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton checkBalanceButton;
    private JButton transactionHistoryButton;
    private JButton changePasswordButton;
    public ImageIcon image = new ImageIcon(".\\img.png");

    public user getUser1() {
        return user1;
    }

    public void setUser1(user user1) {
        this.user1 = user1;
    }

    private  user user1;


    public userMenu(){
        panel1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
        setContentPane(panel1);
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
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LOGin newlogin=new LOGin();
                newlogin.setVisible(true);
                dispose();
            }
        });
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PassChange newpass=new PassChange();
                newpass.setUser1(user1);
                newpass.setVisible(true);
                dispose();
            }
        });
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Balance newBalance = new Balance();
                newBalance.setNewuser(user1);
                newBalance.setVisible(true);
                dispose();
            }
        });
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw newwithdraw = new withdraw();
                newwithdraw.setUser1(user1);
                newwithdraw.setVisible(true);
                dispose();
            }
        });
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deposit newdeopsit = new Deposit();
                newdeopsit.setUser1(user1);
                newdeopsit.setVisible(true);
                dispose();
            }
        });

        transactionHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransactionDataList transactionDataList = new TransactionDataList(user1);
                transactionDataList.setVisible(true);
            }
        });
    }


}
