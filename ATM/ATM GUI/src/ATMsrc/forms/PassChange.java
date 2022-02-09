package ATMsrc.forms;

import ATMsrc.Usersdata.UserDataManegment;
import ATMsrc.Usersdata.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassChange extends JFrame{
    private JPanel minimize;
    private JButton xButton;
    private JLabel BARICON;
    private JButton button3;
    private JPasswordField passwordField2;
    private JButton setPasswordButton;
    private JButton backButton;
    private JPanel x1;
    private JPasswordField passwordField1;
    private JTextField textField1;
    public ImageIcon image = new ImageIcon(".\\img.png");

    public user getUser1() {
        return User1;
    }

    public void setUser1(user user1) {
        User1 = user1;
    }
    private user User1;

    public PassChange() {
        setContentPane(x1);
        setVisible(false);
        setUndecorated(true);
        setIconImage(image.getImage());
        setSize(300,200);
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
                userMenu newusermenu=new userMenu();
                newusermenu.setUser1(getUser1());
                newusermenu.setVisible(true);
                dispose();
            }
        });
        setPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(String.valueOf(passwordField1.getPassword()).equals(User1.getPassword())) {
                    if (String.valueOf(passwordField2.getPassword()).matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
                        String password = String.valueOf(passwordField2.getPassword());
                        UserDataManegment newPassword = new UserDataManegment();
                        newPassword.changePassword(User1.getEmail(), password);
                        JOptionPane.showMessageDialog(null, "Password Changed!");
                    } else JOptionPane.showMessageDialog(null, "Invalid Password Format!");
                } else JOptionPane.showMessageDialog(null, "Old password is wrong!");
            }
        });
    }
}
