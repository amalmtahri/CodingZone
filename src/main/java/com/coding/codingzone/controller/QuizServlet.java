package com.coding.codingzone.controller;

import com.coding.codingzone.daoImpl.CandidatImpl;
import com.coding.codingzone.daoImpl.QuizImpl;
import com.coding.codingzone.daoImpl.TestImpl;
import com.coding.codingzone.demo.SendMail;
import com.coding.codingzone.model.Candidat;
import com.coding.codingzone.model.Quiz;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "QuizServlet", value = "/QuizServlet")
public class QuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TestImpl test = new TestImpl();
        System.out.println(test.all());
        request.setAttribute("listTest", test.all());
        CandidatImpl candidat = new CandidatImpl();
        request.setAttribute("candidats", candidat.all());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/quizCandidats/affectQuiz.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id_test = request.getParameter("test_id");
        String[] items = request.getParameterValues("candidats");
        String id_stuff = request.getParameter("id_staff");
        for(int index = 0; index<items.length; index++){
            System.out.print(items[0] + "\n");
            Quiz quiz = new Quiz(id_test,items[index],id_stuff);
            QuizImpl quiz1 = new QuizImpl();
            quiz1.create(quiz);
            CandidatImpl candidat = new CandidatImpl();
            System.out.println(candidat.getDataCandidat(items[index]));
            String email = candidat.getDataCandidat(items[index]).getEmail();
            SendMail.send("codingzone.youcode@gmail.com","codingzone123",email,"test coding zone","hey");
        }
        System.out.println(id_test);
    }
}
