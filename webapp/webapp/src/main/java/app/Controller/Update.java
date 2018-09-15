package app.Controller;

import app.Entities.Employee;
import app.Model.ManagementSystem;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class Update extends HttpServlet {

    ManagementSystem managementSystem = null;
    String page = "";

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        int i = Integer.parseInt(request.getParameter("i"));
        System.out.println(i);
        try {
            List <Employee> employees = (List<Employee>) managementSystem.getInstance().getEmployee();
            Employee employee = employees.get(i-1);
            request.setAttribute("Employee", employee);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Views/Update.jsp");
            requestDispatcher.forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            page = "Views/Update2.jsp";
        }
        RequestDispatcher requestDispatcher=request.getRequestDispatcher(page);
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
            managementSystem.getInstance().updateEmployee(employee);
            response.sendRedirect("/Views/Menu.jsp");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}