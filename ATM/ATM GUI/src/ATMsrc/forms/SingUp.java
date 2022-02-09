package ATMsrc.forms;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ATMsrc.Usersdata.UserDataManegment;
import ATMsrc.Usersdata.user;

public class SingUp extends JFrame{
    private JPanel minimize;
    private JButton xButton;
    private JLabel BARICON;
    private JButton button3;
    private JPasswordField passf;
    private JButton signUpButton;
    private JButton backButton;
    private JPanel panelx;
    private JTextField userf;
    private JTextField emailf;
    private JTextField amountf;
    private JTextField numberf;
    private String number;
    private String password;
    private String email;
    private int balance;
    private String name;
    public ImageIcon image = new ImageIcon(".\\img.png");

    public SingUp(){
        setContentPane(panelx);
        setVisible(false);
        setUndecorated(true);
        setIconImage(image.getImage());
        setSize(400,300);
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
                LOGin newlogin=new LOGin();
                newlogin.setVisible(true);
                dispose();
            }
        });

        signUpButton.addActionListener(new ActionListener() {
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
                    if(emailf.getText().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                        email = emailf.getText();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Invalid email format");
                        return;
                    }
                     balance = Integer.parseInt(amountf.getText());
                     name = userf.getText();
                     user newuser = new user(name, 0, email, password, balance,number);
                     UserDataManegment adduser = new UserDataManegment();
                        boolean verify = adduser.verifyUser(email);
                        if (!verify){
                            adduser.addUser(newuser);
                            JOptionPane.showMessageDialog(null, "User added");
                        }
                        else JOptionPane.showMessageDialog(null, "User already exists!");
                    }catch (Exception newx){ JOptionPane.showMessageDialog(null,"error");}

            }
        });

    }
}
