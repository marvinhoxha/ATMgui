package ATMsrc.Usersdata;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListData extends JFrame {

    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane scroll;
    public ImageIcon image = new ImageIcon(".\\img.png");
    String[] headers = {"Email", "Name", "Password", "PhoneNumber", "Id", "Balacnce"};

    public ListData() {
        setIconImage(image.getImage());
        model.setColumnIdentifiers(headers);
        UserDataManegment data = new UserDataManegment();
        Object[] row = new Object[6];
        for (int i = 0; i < data.getUsers().size(); i++) {
            row[0] = data.getUsersList(i).getEmail();
            row[1] = data.getUsersList(i).getName();
            row[2] = data.getUsersList(i).getPassword();
            row[3] = data.getUsersList(i).getPhone();
            row[4] = data.getUsersList(i).getId();
            row[5] = data.getUsersList(i).getBalance() + "$";
            model.addRow(row);
        }
        table.setModel(model);
        scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);
        setSize(700, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        table.setEnabled(false);
    }

}
