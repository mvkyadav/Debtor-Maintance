package controller;

import dao.AdminDao;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminRegistrationServlet", value = "/AdminRegistrationServlet")
public class AdminRegistrationServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("AdminRegister.jsp").forward(request, response);
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            registerAdmin(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void registerAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        response.setContentType("text/html");
        User u = new User();
        AdminDao adminDao = new AdminDao();
        u.setUsername(request.getParameter("username"));
        u.setPassword(request.getParameter("password"));
        if(!request.getParameter("password").equals(request.getParameter("ConfirmPassword"))) {
            request.setAttribute("error", "error");
            doGet(request,response);
        }
        else if(adminDao.registerAdmin(u)>0){
            System.out.println("Inserted into database");
            doGet(request, response);
        }
        else {
            request.setAttribute("alreadyRegistered", "error");
            doGet(request,response);
        }
    }
}
