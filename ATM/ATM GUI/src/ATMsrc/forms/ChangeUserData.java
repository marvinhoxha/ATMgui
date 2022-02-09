package ATMsrc.forms;

import ATMsrc.Usersdata.UserDataManegment;
import ATMsrc.Usersdata.user;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeUserData extends JFrame{
    private JPanel minimize;
    private JButton xButton;
    private JLabel BARICON;
    private JButton button3;
    private JButton changeButton;
    private JButton backButton;
    private JTextField emailf;
    private JTextField userf;
    private JTextField amountf;
    private JPasswordField passf;
    private JTextField numberf;
    private JPanel panelx;
    private String number;
    private String password;
    private String email;
    private int balance;
    private String name;
    public ImageIcon image = new ImageIcon(".\\img.png");

    public ChangeUserData() {
        setContentPane(panelx);
        setVisible(false);
        setUndecorated(true);
        setIconImage(image.getImage());
        setSize(400, 300);
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
                adminMenu adminMenu = new adminMenu();
                adminMenu.setVisible(true);
                dispose();
            }
        });
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(numberf.getText().matches("^\\+355\\s[6-9]{2}\\s[0-9]{2}\\s[0-9]{2}\\s[0-9]{3}$"))
                    {
                        number=numberf.getText();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid phonenumber format");
                        return;
                    }
                    if (String.valueOf(passf.getPassword()).matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$"))
                        password = String.valueOf(passf.getPassword());
                    else {
                        JOptionPane.showMessageDialog(null, "Invalid password format");
                        return;
                    }
                    email=emailf.getText();
                    balance = Integer.parseInt(amountf.getText());
                    name = userf.getText();
                    UserDataManegment userDataManegment = new UserDataManegment();
                    boolean verify = userDataManegment.verifyUser(email);
                    if (verify){
                        userDataManegment.changeUserData(email , password, name, balance, number);
                        JOptionPane.showMessageDialog(null, "User data changed!");
                    }
                    else JOptionPane.showMessageDialog(null, "User doesn't exist!");
                }catch (Exception newx){ JOptionPane.showMessageDialog(null,"error");}
            }
        });
    }
}
