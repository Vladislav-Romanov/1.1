package app.Controller;

import app.Entities.Employee;
import app.Model.ManagementSystem;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class Read extends HttpServlet  {

    ManagementSystem managementSystem = null;

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        try {
            List <Employee> employees = managementSystem.getInstance().getEmployee();
            request.setAttribute("employees", employees);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Views/Menu.jsp");
            requestDispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

