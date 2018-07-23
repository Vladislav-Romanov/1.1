package app.servlets;

import app.entities.Employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsm = null;
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Servlet Database Access</title></head><body>");
        out.println("<h2>Database Employee</h2>");


        try{
            //загрузжаем драйвер базы данных
            Class.forName("com.mysql.jdbc.Driver");
            //Url
            String url = "jdbc:mysql://localhost:3306/mytest?useSSL=false";
            //Создание соединения
            con = DriverManager.getConnection(url, "root", "root");
            //Создание оператора statement
            stmt = con.createStatement();
            //Выполняем запрос
            stmt = con.createStatement();
            rs = stmt.executeQuery(
                    "SELECT id, name, salary  FROM employee ");
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),rs.getString("name"),rs.getInt("salary"));
                employees.add(employee);
            }
            for(int i=0;i<employees.size();i++){
                out.println(employees.get(i).toString()+"<br>");
            }


        }catch (Exception e){
            throw new ServletException(e.getMessage());
        }finally {
            try {
                if(stmt != null);
                stmt.close();
                if(con != null);
                con.close();
            }catch (SQLException sqle){}
        }
        out.println("</table><br><br>");
        out.println("</body>");
        out.println("</html>");
    }

}
