package controller;

import dao.UserDao;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserRegServlet", value = "/UserRegServlet")
public class UserRegServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/UserRegister.jsp").forward(request, response);
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            registerUser(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registerUser (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        response.setContentType("text/html");
        User u = new User();
        UserDao userDao = new UserDao();
        u.setUsername(request.getParameter("username"));
        u.setPassword(request.getParameter("password"));


        if (!request.getParameter("password").equals(request.getParameter("ConfirmPassword"))) {
            request.setAttribute("error", "Password mismatch");
            doGet(request, response);

        } else if (userDao.register(u) > 0) {
            System.out.println("Inserted into database");
            request.getRequestDispatcher("UserRegistered.jsp").forward(request, response);
        } else {
            request.setAttribute("userRegsitered", "error");
            doGet(request,response);
        }

    }
}
