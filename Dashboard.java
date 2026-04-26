package employee;

import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton addBtn, viewBtn, updateBtn, deleteBtn;

    Dashboard() {

        setTitle("Employee Management System");

        addBtn = new JButton("Add Employee");
        viewBtn = new JButton("View Employees");
        updateBtn = new JButton("Update Salary");
        deleteBtn = new JButton("Delete Employee");

        addBtn.setBounds(100, 50, 180, 40);
        viewBtn.setBounds(100, 110, 180, 40);
        updateBtn.setBounds(100, 170, 180, 40);
        deleteBtn.setBounds(100, 230, 180, 40);

        addBtn.addActionListener(this);
        viewBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);

        add(addBtn);
        add(viewBtn);
        add(updateBtn);
        add(deleteBtn);

        setSize(400, 350);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) new AddEmployee();
        if (e.getSource() == viewBtn) new ViewEmployees();
        if (e.getSource() == updateBtn) new UpdateEmployee();
        if (e.getSource() == deleteBtn) new DeleteEmployee();
    }
}