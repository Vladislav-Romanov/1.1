package app.Utils;

public class SQLConstants {
    public static final String CHEK_USERS = "SELECT userRole From hr.users "  +
                                            "Where EXISTS  ( SELECT * FROM hr.users " +
                                            "Where (userName = ? ) and (userPassword = ? ));";

    public static final String SELECT_EMPLOYEE =  "SELECT Full_name, Department, Phone, Salary " +
                                                  "FROM Employee";

    public static final String INSERT_EMPLOYEE = "INSERT INTO hr.employee " +
                                                 "(Full_name, Department, Phone, Salary) " +
                                                 "VALUES (?, ?, ?, ?)";

    public static final String DELETE_EMPLOYEE = "DELETE FROM Employee WHERE Full_name=?";

    public static final String UPDATE_EMPLOYEE = "UPDATE hr.employee SET " +
                                                 "Department=?, Phone=?, Salary=? " +
                                                 "WHERE Full_name=?";
}
