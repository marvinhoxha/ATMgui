package ATMsrc.forms;

import ATMsrc.Usersdata.UserDataManegment;
import ATMsrc.Usersdata.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LOGin extends JFrame {
    private JPanel panel1;
    private JTextField EmailF;
    private JPasswordField passwordPasswordField;
    private JButton button1;
    private JButton button2;
    private JPanel panel2;
    private JLabel password;
    private JLabel accountLabel;
    private JButton button3;
    private JButton xButton;
    private JPanel minimize;
    private JLabel BARICON;
    private JButton Admin;
    public ImageIcon image = new ImageIcon(".\\img.png");

    public LOGin(){
        EmailF.setToolTipText("example@gmail.com");
        setIconImage(image.getImage());
        setContentPane(panel1);
        setSize(400,300);
        setVisible(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
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
        Admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminLogin adminlog=new AdminLogin();
                adminlog.setVisible(true);
                setVisible(false);
                dispose();

            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String email = EmailF.getText();
                    String password = String.valueOf(passwordPasswordField.getPassword());
                    File file = new File(UserDataManegment.filename);
                    boolean found = false;
                    if (file.exists() && !file.isDirectory()) {
                        UserDataManegment fileUsers = new UserDataManegment();
                        user Usermoment = fileUsers.checkUser(email, password);
                        if (Usermoment != null) {
                            System.out.println("Logged in");
                            userMenu newmenu = new userMenu();
                            newmenu.setUser1(Usermoment);
                            newmenu.setVisible(true);
                            dispose();
                        }
                        else JOptionPane.showMessageDialog(null, "Wrong password\nor email!");
                    }

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SingUp singUp=new SingUp();
                singUp.setVisible(true);
                dispose();
            }
        });
    }



}
