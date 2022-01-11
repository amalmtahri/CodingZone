package com.coding.codingzone.controller;

import com.coding.codingzone.daoImpl.CategoryImpl;
import com.coding.codingzone.daoImpl.QuestionImpl;
import com.coding.codingzone.model.Category;
import com.coding.codingzone.model.Question;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "QuestionServlet", value = {"/QuestionServlet","/insertQuestion","/newQuestion","/deleteQuestion","/listQuestion","/editQuestion","/updateQuestion"})
public class QuestionServlet extends HttpServlet {
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

               case "/newQuestion":
                    showForm(request, response);
                    break;
                case "/insertQuestion":
                    addQuestion(request, response);
                    break;
                case "/deleteQuestion":
                    deleteQuestion(request, response);
                    break;
                case "/editQuestion":
                    showEditForm(request, response);
                    break;
                case "/updateQuestion":
                    updateQuestion(request, response);
                    break;
                default:
                    listQuestion(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryImpl category = new CategoryImpl();
        System.out.println(category.all());
        request.setAttribute("data", category.all());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/question/addQuestion.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        QuestionImpl question = new QuestionImpl();
        CategoryImpl category = new CategoryImpl();
        System.out.println(category.all());
        request.setAttribute("category", category.all());
        request.setAttribute("data", question.find(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/question/editQuestion.jsp");
        dispatcher.forward(request, response);

    }
    private void deleteQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String id = request.getParameter("id");
        QuestionImpl question = new QuestionImpl();
        question.delete(id);
        response.sendRedirect("listQuestion");
    }
    private void addQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String question = request.getParameter("question");
        String reponse = request.getParameter("response");
        String choice1 = request.getParameter("choice1");
        String choice2 = request.getParameter("choice2");
        String choice3 = request.getParameter("choice3");
        int time = Integer.parseInt(request.getParameter("time"));
        Category id_category = new Category(request.getParameter("category_id"),"name","img");
        int score = Integer.parseInt(request.getParameter("score"));
        Question question1 = new Question(question,reponse,choice1,choice2,choice3,time,id_category,score);
        System.out.println(question1);
        QuestionImpl questionImpl = new QuestionImpl();
        questionImpl.create(question1);
        response.sendRedirect("listQuestion");
    }
    private void updateQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String id = request.getParameter("id");
        String question = request.getParameter("question");
        String reponse = request.getParameter("response");
        String choice1 = request.getParameter("choice1");
        String choice2 = request.getParameter("choice2");
        String choice3 = request.getParameter("choice3");
        int time = Integer.parseInt(request.getParameter("time"));
        Category id_category = new Category(request.getParameter("category_id"),"name","img");
        int score = Integer.parseInt(request.getParameter("score"));
        Question question1 = new Question(id,question,reponse,choice1,choice2,choice3,time,id_category,score);
        System.out.println(question1);
        QuestionImpl questionImpl = new QuestionImpl();
        questionImpl.update(question1);
        response.sendRedirect("listQuestion");
    }
    private void listQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        QuestionImpl question = new QuestionImpl();
        System.out.println(question.all());
        request.setAttribute("data", question.all());
        this.getServletContext().getRequestDispatcher("/view/question/index.jsp").forward(request,response);
    }
}
