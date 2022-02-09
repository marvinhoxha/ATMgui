package ATMsrc.forms;

import ATMsrc.Usersdata.Admin;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class AdminLogin extends JFrame{
    private JPanel panel1;
    private JPanel panel2;
    private JLabel accountLabel;
    private JButton button1;
    private JPasswordField passwordPasswordField;
    private JLabel password;
    private JPanel minimize;
    private JButton xButton;
    private JLabel BARICON;
    private JButton button3;
    private JButton Back;
    private JTextField textField1;
    public ImageIcon image = new ImageIcon(".\\img.png");
    public AdminLogin(){
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

       Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LOGin newLOG=new LOGin();
                newLOG.setVisible(true);
                setVisible(false);
                dispose();

            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin newadmin = new Admin();
                if(textField1.getText().equals(newadmin.getEmail()) && String.valueOf(passwordPasswordField.getPassword()).equals(newadmin.getPassword())){
                    adminMenu newMenu = new adminMenu();
                    newMenu.setVisible(true);
                    dispose();
                }else JOptionPane.showMessageDialog(null, "wrong credencials!");
            }
        });
    }

}
