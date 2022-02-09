package ATMsrc.forms;


import ATMsrc.Usersdata.UserDataManegment;
import ATMsrc.Usersdata.user;

import javax.swing.*;
public class loading extends JFrame {
    private JPanel loadPanel;
    private JLabel loadLabel;
    private JProgressBar progressBarloading;

    public loading(){
        ImageIcon image = new ImageIcon(".\\img.png");
        setIconImage(image.getImage());
        setContentPane(loadPanel);
        setSize(300,300);
        setVisible(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws Exception {
        loading myLoad=new loading();
        myLoad.setVisible(true);
        myLoad.setResizable(false);

            for (int i=1;i<=100;i++)
            {
                Thread.sleep(15);
                myLoad.progressBarloading.setValue(i);
            }
        try {

            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (Exception e) {
            System.out.println("Look and Feel not set");
        }


        LOGin mylogin=new LOGin();
        mylogin.setVisible(true);
            myLoad.setVisible(false);
            myLoad.dispose();
    }
}
