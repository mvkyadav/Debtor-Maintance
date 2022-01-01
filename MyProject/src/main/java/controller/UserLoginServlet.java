package controller;

import dao.UserDao;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserLoginServlet", value = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            validation(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void validation (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        User u = new User();
        UserDao userDao = new UserDao();
        u.setUsername(request.getParameter("username"));
        u.setPassword(request.getParameter("password"));
        if(userDao.validate(u)==1) {
            System.out.println("Checking User");
            request.getRequestDispatcher("RegistrationPage.jsp").forward(request, response);
        }
        else if(userDao.validate(u) == 10){
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
