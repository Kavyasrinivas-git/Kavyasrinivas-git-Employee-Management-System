package employee;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteEmployee extends JFrame implements ActionListener {

    JTextField code;
    JButton delete;

    DeleteEmployee() {

        code = new JTextField();
        delete = new JButton("Delete");

        add(new JLabel("Code")).setBounds(50, 60, 100, 30);
        add(code).setBounds(150, 60, 150, 30);

        add(delete).setBounds(120, 150, 100, 40);

        delete.addActionListener(this);

        setSize(350, 250);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM employees WHERE emp_code=?");

            ps.setString(1, code.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Deleted");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
}