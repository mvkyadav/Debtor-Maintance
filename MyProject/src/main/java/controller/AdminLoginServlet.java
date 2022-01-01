package controller;

import dao.AdminDao;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
    }
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            adminValidation(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void adminValidation (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        User u = new User();
        AdminDao adminDao = new AdminDao();
        u.setUsername(request.getParameter("username"));
        u.setPassword(request.getParameter("password"));
        if(adminDao.validate(u)==1) {
            System.out.println("Checking User");
            request.getRequestDispatcher("Success.jsp").forward(request, response);
        }
        else if(adminDao.validate(u) == 10){
            request.setAttribute("IncorrectPassword", "error");
            doGet(request, response);
        }
        else {
            System.out.println("User Not Found");
            request.setAttribute("exception", "UserNotFound");
            doGet(request, response);
        }
    }

}
