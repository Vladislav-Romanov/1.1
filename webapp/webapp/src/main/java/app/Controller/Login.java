package app.Controller;

import app.Entities.User;
import app.Model.ManagementSystem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import app.Entities.User;
import app.Model.ManagementSystem;

public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ManagementSystem managementSystem = null;
            User user = new User(request.getParameter("login"),request.getParameter("password"));
            String userRole = managementSystem.getInstance().checkUser(user);
            if (userRole.equals("user")) {
                response.sendRedirect("/Views/Menu.jsp");
            } else {
                response.sendRedirect("/Views/Error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
