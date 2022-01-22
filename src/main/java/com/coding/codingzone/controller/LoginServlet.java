package com.coding.codingzone.controller;

import com.coding.codingzone.daoImpl.*;
import com.coding.codingzone.db.SingletonDB;
import com.coding.codingzone.model.Staff;

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
    private String msgError = null;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html>" +
                "<body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + SingletonDB.getInstance().getConnection() + "</h1>");
        out.println("</body></html>");
        System.out.println("im in");
        Connection connection = SingletonDB.getInstance().getConnection();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        StaffImpl login = new StaffImpl();
        CategoryImpl ci = new CategoryImpl();
        QuestionImpl qi = new QuestionImpl();
        CandidatImpl cai = new CandidatImpl();
        TestImpl ti = new TestImpl();
        login.login(email,password);
        System.out.println(login.login(email,password));
        if(login.login(email,password) != null){
            String id_staff = login.login(email,password).getId_staff();
            session.setAttribute("id_staff",id_staff);
            session.setAttribute("nameStuff",login.login(email,password).getFirstname());
            request.setAttribute("countCat", ci.countCategories());
            request.setAttribute("countQuest", qi.countQuestions());
            request.setAttribute("perDay", ti.testPassedPerDay());
            request.setAttribute("perMonth", ti.testPassedPerMonth());
            request.setAttribute("perYear", ti.testPassedPerYear());
            request.setAttribute("countTest", ti.countTests());
            request.setAttribute("countCand", cai.countCandidats());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/dashboard.jsp");
            dispatcher.forward(request, response);
        }else{
            msgError = "Password or email incorrect";
            request.setAttribute("msg",msgError);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }
    }

    public void destroy() {
    }


}