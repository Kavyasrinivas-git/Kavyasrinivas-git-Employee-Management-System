package employee;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField code, salary;
    JButton update;

    UpdateEmployee() {

        code = new JTextField();
        salary = new JTextField();
        update = new JButton("Update");

        add(new JLabel("Code")).setBounds(50, 50, 100, 30);
        add(code).setBounds(150, 50, 150, 30);

        add(new JLabel("Salary")).setBounds(50, 100, 100, 30);
        add(salary).setBounds(150, 100, 150, 30);

        add(update).setBounds(120, 180, 100, 40);

        update.addActionListener(this);

        setSize(350, 300);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE employees SET salary=? WHERE emp_code=?");

            ps.setDouble(1, Double.parseDouble(salary.getText()));
            ps.setString(2, code.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Updated");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
}
