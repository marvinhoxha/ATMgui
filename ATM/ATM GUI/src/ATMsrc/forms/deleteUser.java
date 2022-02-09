package ATMsrc.forms;

import ATMsrc.Usersdata.UserDataManegment;
import ATMsrc.Usersdata.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class deleteUser extends JFrame{
    private JPasswordField passwordField2;
    private JButton deleteUserButton;
    private JButton backButton;
    private JPanel minimize;
    private JButton xButton;
    private JLabel BARICON;
    private JButton button3;
    private JTextField textField1;
    private JPanel top;
    public ImageIcon image = new ImageIcon(".\\img.png");

    public deleteUser() {
        setContentPane(top);
        setVisible(false);
        setUndecorated(true);
        setIconImage(image.getImage());
        setSize(450, 200);
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
                String email = textField1.getText();
                String password = String.valueOf(passwordField2.getPassword());
                File file = new File(UserDataManegment.filename);
                if (file.exists() && !file.isDirectory()) {
                    UserDataManegment fileUsers = new UserDataManegment();
                    user Usermoment = fileUsers.checkUser(email, password);
                    if (Usermoment != null) {
                        fileUsers.rm(Usermoment.getEmail());
                    }
                    else JOptionPane.showMessageDialog(null, "Wrong password\nor email!");
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminMenu adminMenu = new adminMenu();
                adminMenu.setVisible(true);
                dispose();
            }
        });
    }
}
