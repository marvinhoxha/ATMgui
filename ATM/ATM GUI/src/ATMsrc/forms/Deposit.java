package ATMsrc.forms;

import ATMsrc.Usersdata.UserDataManegment;
import ATMsrc.Usersdata.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit extends JFrame{
    private JPanel minimize;
    private JButton xButton;
    private JLabel BARICON;
    private JButton button3;
    private JButton backButton;
    private JTextField textField1;
    private JButton enterButton;
    private JPanel panel1;
    public ImageIcon image = new ImageIcon(".\\img.png");

    public user getUser1() {
        return user1;
    }

    public void setUser1(user user1) {
        this.user1 = user1;
    }

    private user user1;

    public Deposit() {
        setContentPane(panel1);
        setVisible(false);
        setUndecorated(true);
        setIconImage(image.getImage());
        setSize(400, 150);
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
                userMenu backtoMenu = new userMenu();
                backtoMenu.setUser1(user1);
                backtoMenu.setVisible(true);
                dispose();
            }
        });
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user1.deposit(Integer.parseInt(textField1.getText()));
                UserDataManegment transacion=new UserDataManegment();
                transacion.changebalance(user1.getEmail(), (int) user1.getBalance());
            }
        });
    }
}
