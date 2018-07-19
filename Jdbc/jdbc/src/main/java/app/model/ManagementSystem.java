package app.model;

import app.entities.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;


public class ManagementSystem {

    private static Connection con;
    

    public ManagementSystem() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mytest?useSSL=false";
            con = DriverManager.getConnection(url, "root", "root");
        } catch (ClassNotFoundException e) {
            throw new Exception(e);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }


    public ArrayList<Employee> getAllStudents() throws SQLException {
        ArrayList<Employee> employees = new ArrayList<Employee>();

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "SELECT id, name, salary  FROM employee ");
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),rs.getString("name"),rs.getInt("salary"));
                employees.add(employee);
            }
            for(int i=0;i<employees.size();i++){
                System.out.println(employees.get(i).toString());
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return employees;
    }

    public void createEmployee() throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt.executeUpdate("CREATE TABLE `employee` ( `id` int(11) NOT NULL , " +
                    "`name` varchar(45) NOT NULL,`salary` int(11) NOT NULL,PRIMARY KEY (`id`) ) ");

        }finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public void insertEmployee(Employee employee) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(
                    "INSERT INTO employee " +
                            "(id, name, salary) " +
                            "VALUES (?, ?, ?)");
            stmt.setInt(1, employee.getId());
            stmt.setString(2, employee.getName());
            stmt.setInt(3, employee.getSalary());
            stmt.execute();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }


    public void deleteEmployee(Employee employee) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(
                    "DELETE FROM employee WHERE student_id=?");
            stmt.setInt(1, employee.getId());
            stmt.execute();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
