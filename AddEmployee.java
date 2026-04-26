package employee;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField name, code, dept, salary;
    JButton save;

    AddEmployee() {

        setTitle("Add Employee");

        name = new JTextField();
        code = new JTextField();
        dept = new JTextField();
        salary = new JTextField();

        save = new JButton("Save");

        name.setBounds(150, 50, 150, 30);
        code.setBounds(150, 90, 150, 30);
        dept.setBounds(150, 130, 150, 30);
        salary.setBounds(150, 170, 150, 30);
        save.setBounds(120, 230, 100, 40);

        add(new JLabel("Name")).setBounds(50, 50, 100, 30);
        add(new JLabel("Code")).setBounds(50, 90, 100, 30);
        add(new JLabel("Dept")).setBounds(50, 130, 100, 30);
        add(new JLabel("Salary")).setBounds(50, 170, 100, 30);

        add(name); add(code); add(dept); add(salary); add(save);

        save.addActionListener(this);

        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO employees(emp_name, emp_code, department, salary) VALUES (?, ?, ?, ?)");

            ps.setString(1, name.getText());
            ps.setString(2, code.getText());
            ps.setString(3, dept.getText());
            ps.setDouble(4, Double.parseDouble(salary.getText()));

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Employee Added");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
}