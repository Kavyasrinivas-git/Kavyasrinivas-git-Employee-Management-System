package employee;

import javax.swing.*;
import java.sql.*;

public class ViewEmployees extends JFrame {

    JTextArea area;

    ViewEmployees() {

        area = new JTextArea();
        add(new JScrollPane(area));

        loadData();

        setSize(500, 400);
        setVisible(true);
    }

    void loadData() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employees");

            while (rs.next()) {
                area.append(
                        rs.getInt("id") + " " +
                        rs.getString("emp_name") + " " +
                        rs.getString("emp_code") + " " +
                        rs.getString("department") + " " +
                        rs.getDouble("salary") + "\n"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
