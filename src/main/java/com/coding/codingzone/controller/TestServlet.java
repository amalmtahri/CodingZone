package com.coding.codingzone.controller;

import com.coding.codingzone.daoImpl.CategoryImpl;
import com.coding.codingzone.daoImpl.QuestionImpl;
import com.coding.codingzone.daoImpl.QuestionsTestImpl;
import com.coding.codingzone.daoImpl.TestImpl;
import com.coding.codingzone.model.QuestionsTest;
import com.coding.codingzone.model.Test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TestServlet", value = {"/TestServlet","/newTest","/insertTest","/listTest","/deleteTest","/insertQstTest","/affectQst"})
public class TestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/newTest":
                    showForm(request, response);
                    break;
                case "/insertTest":
                    addTest(request, response);
                    break;
                case "/deleteTest":
                    deleteTest(request, response);
                    break;
                case "/insertQstTest":
                    addQstTest(request, response);
                case "/affectQst":
                    affectQst(request, response);
                default:
                    listTest(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/test/addTest.jsp");
        dispatcher.forward(request, response);
    }
    private void listTest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        TestImpl test = new TestImpl();
        System.out.println(test.all());
        request.setAttribute("data", test.all());
        this.getServletContext().getRequestDispatcher("/view/test/index.jsp").forward(request,response);
    }
    private void addTest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("nameTest");
        Test test = new Test(name);
        TestImpl test1 = new TestImpl();
        test1.create(test);
        response.sendRedirect("listTest");
    }
    private void deleteTest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String id = request.getParameter("id");
        TestImpl test = new TestImpl();
        test.delete(id);
        response.sendRedirect("listTest");
    }
    private void addQstTest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String test_id = request.getParameter("test_id");
        String[] items = request.getParameterValues("selectQst");
        for(int index = 0; index<items.length; index ++){
            System.out.println(items[index]);
            QuestionsTest questions = new QuestionsTest(test_id,items[index]);
            QuestionsTestImpl questionsTest = new QuestionsTestImpl();
            questionsTest.create(questions);
        }

    }
    private void affectQst(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        QuestionImpl question = new QuestionImpl();
        System.out.println(question.all());
        request.setAttribute("data", question.all());
        TestImpl test = new TestImpl();
        System.out.println(test.all());
        request.setAttribute("listTest", test.all());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/test/addQuestionTest.jsp");
        dispatcher.forward(request, response);
    }

}
