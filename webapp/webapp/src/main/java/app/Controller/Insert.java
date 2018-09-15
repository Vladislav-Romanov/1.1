package app.Controller;

import app.Entities.Employee;
import app.Model.ManagementSystem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Insert extends HttpServlet {

    ManagementSystem managementSystem = null;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Views/Insert.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        Employee employee = new Employee();
        employee.setFull_name(request.getParameter("Full_Name"));
        employee.setDepartment(request.getParameter("Department"));
        employee.setPhone(Integer.parseInt(request.getParameter("Phone")));
        employee.setSalary(Integer.parseInt(request.getParameter("Salary")));
        try {
            managementSystem.getInstance().insertEmployee(employee);
            response.sendRedirect("/Views/Menu.jsp");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

