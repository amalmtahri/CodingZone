package com.coding.codingzone.controller;

import com.coding.codingzone.daoImpl.StaffImpl;
import com.coding.codingzone.db.SingletonDB;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + SingletonDB.getInstance().getConnection() + "</h1>");
        out.println("</body></html>");
        System.out.println("im in");
        Connection connection = SingletonDB.getInstance().getConnection();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher ;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("session", "on");
        StaffImpl login = new StaffImpl();
        login.login(email,password);
        //this.getServletContext().getRequestDispatcher("/CategoryServlet").forward(request,response);
        //response.sendRedirect("/CategoryServlet");

    }


    public void destroy() {
    }
}