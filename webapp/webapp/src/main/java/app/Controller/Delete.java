package app.Controller;

import app.Entities.Employee;
import app.Model.ManagementSystem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Delete extends HttpServlet {

    ManagementSystem managementSystem = null;

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        int i = Integer.parseInt(request.getParameter("i"));
        try {
            List <Employee> employees = (List<Employee>) managementSystem.getInstance().getEmployee();
            managementSystem.getInstance().deleteEmployee(employees.get(i-1).getFull_name());
            response.sendRedirect("/Views/Menu.jsp");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
