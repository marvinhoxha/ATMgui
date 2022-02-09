package ATMsrc.forms;

import ATMsrc.Usersdata.UserDataManegment;
import ATMsrc.Usersdata.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Balance extends JFrame{
    private JPanel minimize;
    private JButton xButton;
    private JLabel BARICON;
    private JButton button3;
    private JTextField textField1;
    private JPanel panel1;
    private JButton backButton;
    private JButton a50$Button;
    public ImageIcon image = new ImageIcon(".\\img.png");


    public user getNewuser() {
        return newuser;
    }

    public void setNewuser(user newuser) {
        this.newuser = newuser;
    }

    private user newuser;

    public Balance() {
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
                backtoMenu.setUser1(newuser);
                backtoMenu.setVisible(true);
                dispose();
            }
        });
        a50$Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText(String.valueOf(newuser.getBalance())+"$");
            }
        });

    }
}
