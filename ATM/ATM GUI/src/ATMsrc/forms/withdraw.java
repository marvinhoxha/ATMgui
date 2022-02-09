package ATMsrc.forms;

import ATMsrc.Usersdata.UserDataManegment;
import ATMsrc.Usersdata.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class withdraw extends JFrame{
    private JButton xButton;
    private JButton button3;
    private JButton backButton;
    private JPanel panel1;
    private JPanel minimize;
    private JLabel BARICON;
    private JButton a10$Button;
    private JButton a200$Button;
    private JButton a50$Button;
    private JButton a500$Button;
    private JButton a100$Button;
    private JTextField textField1;
    private JButton enterButton;
    public ImageIcon image = new ImageIcon(".\\img.png");

    public user getUser1() {
        return user1;
    }

    public void setUser1(user user1) {
        this.user1 = user1;
    }

    private user user1;

    public withdraw(){
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
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userMenu backtoMenu= new userMenu();
                backtoMenu.setUser1(user1);
                backtoMenu.setVisible(true);
                dispose();
            }
        });
        a10$Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.withdraw(10);
                UserDataManegment transacion=new UserDataManegment();
                transacion.changebalance(user1.getEmail(), (int) user1.getBalance());
                System.out.println(String.valueOf(user1.getBalance()));

            }
        });
        a50$Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.withdraw(50);
                UserDataManegment transacion=new UserDataManegment();
                transacion.changebalance(user1.getEmail(), (int) user1.getBalance());
            }
        });
        a100$Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.withdraw(100);
                UserDataManegment transacion=new UserDataManegment();
                transacion.changebalance(user1.getEmail(), (int) user1.getBalance());
            }
        });
        a200$Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.withdraw(200);
                UserDataManegment transacion=new UserDataManegment();
                transacion.changebalance(user1.getEmail(), (int) user1.getBalance());
            }
        });
        a500$Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.withdraw(500);
                UserDataManegment transacion=new UserDataManegment();
                transacion.changebalance(user1.getEmail(), (int) user1.getBalance());
            }
        });
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer amount=Integer.parseInt(textField1.getText());
                user1.withdraw(amount);
                UserDataManegment transacion=new UserDataManegment();
                transacion.changebalance(user1.getEmail(), (int) user1.getBalance());
            }
        });
    }
}
