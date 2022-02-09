package ATMsrc.forms;

import ATMsrc.Usersdata.UserDataManegment;
import ATMsrc.Usersdata.user;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TransactionDataList extends JFrame {
    public user getNewUser() {
        return newUser;
    }

    public void setNewUser(user newUser) {
        this.newUser = newUser;
    }

    private user newUser;
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane scroll;
    public ImageIcon image = new ImageIcon(".\\img.png");
    String[] headers = {"Amount", "Type", "Date"};

    public TransactionDataList(user user) {
        this.newUser = user;
        setIconImage(image.getImage());
        model.setColumnIdentifiers(headers);
        Object[] row = new Object[3];

        for (int i = 0; i < getNewUser().getTransactions().size(); i++) {
            if(newUser.getEmail().equals(getNewUser().getTransactions().get(i).getEmail())) {
                row[0] = getNewUser().getTransactions().get(i).getAmount() + "$";
                row[1] = getNewUser().getTransactions().get(i).getType();
                row[2] = getNewUser().getTransactions().get(i).getDate();
                model.addRow(row);
            }
        }
        table.setModel(model);
        scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);
        setSize(500, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        table.setEnabled(false);
    }


}