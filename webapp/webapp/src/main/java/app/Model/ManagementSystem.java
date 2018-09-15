package app.Model;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import app.Cache.EHCacheManger;
import app.Entities.*;
import app.Utils.SQLConstants;
import com.sun.webkit.network.URLs;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class ManagementSystem {

    private static Connection connection;
    private static ManagementSystem instance;

    public ManagementSystem() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/hr?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
            connection = DriverManager.getConnection(url, "root", "root");
        } catch (ClassNotFoundException e) {
            throw new Exception(e);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public static synchronized ManagementSystem getInstance() throws Exception {
        if (instance == null) {
            instance = new ManagementSystem();
        }
        return instance;
    }

    public String checkUser(User user) throws SQLException {
        PreparedStatement preparedStatement = null;
        String userRole = null;
        try {
            preparedStatement = connection.prepareStatement(SQLConstants.CHEK_USERS);
            preparedStatement.setString(1, user.getlogin());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userRole = resultSet.getString(1);
            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        if (userRole == null) {
            return "unknown";
        } else {
            return userRole;
        }
    }

    public List<Employee> getEmployee() throws SQLException {
        List<Employee> employees = new ArrayList<Employee>();
        Element element = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQLConstants.SELECT_EMPLOYEE);
            while (resultSet.next()) {
                Employee emp = createEmpoyeeFromResult(resultSet);
                employees.add(emp);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return  employees;
    }

    private Employee createEmpoyeeFromResult(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setFull_name(rs.getString(1));
        employee.setDepartment(rs.getString(2));
        employee.setPhone(rs.getInt(3));
        employee.setSalary(rs.getInt(4));
        return employee;
    }

    public void insertEmployee(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQLConstants.INSERT_EMPLOYEE);
            preparedStatement.setString(1, employee.getFull_name());
            preparedStatement.setString(2, employee.getDepartment());
            preparedStatement.setInt(3, employee.getPhone());
            preparedStatement.setInt(4, employee.getSalary());
            preparedStatement.execute();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void updateEmployee(Employee employee) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQLConstants.UPDATE_EMPLOYEE);
            preparedStatement.setString(1, employee.getDepartment());
            preparedStatement.setInt(2, employee.getPhone());
            preparedStatement.setInt(3, employee.getSalary());
            preparedStatement.setString(4, employee.getFull_name());
            preparedStatement.execute();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteEmployee(String Full_name) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(SQLConstants.DELETE_EMPLOYEE);
            stmt.setString(1, Full_name);
            stmt.execute();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    /*
    public Object getCache() throws SQLException {

        URL url = null;
        try {
            url = new URL(Paths.get("").toAbsolutePath().toString() +"\\ehcache.tld","UTF-8");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        CacheManager manager = new CacheManager(url);
        Cache cache = manager.getCache("newsCache");
        Object value = null;
        if (cache == null){
            cache.put(new Element("Employees",getEmployee()));
            value = cache.get("Employees").getObjectValue();
        }
        return value;
    }
    */
}
