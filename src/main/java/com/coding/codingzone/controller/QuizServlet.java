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


import com.coding.codingzone.daoImpl.QuizImpl;
import com.coding.codingzone.model.Candidat;
import com.coding.codingzone.model.Category;
import com.coding.codingzone.model.Question;


import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@WebServlet(name = "QuizServlet", value = {"/QuizServlet","/PassQuiz","/nextQuestion","/Quiz","/AffectQuiz","/NewQuiz"})
public class QuizServlet extends HttpServlet {
    int i = 0;
    List<Question> questions = new ArrayList<>();
    QuizImpl quiz = new QuizImpl();
    static  int code ;
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

                case "/QuizServlet":
                    showForm(request, response);
                    break;
                case "/NewQuiz":
                    showFormQuiz(request, response);
                case "/PassQuiz":
                    listQuestion(request, response);
                    break;
                case "/nextQuestion":
                    nextQuestion(request, response);
                case "/AffectQuiz":
                    addQuiz(request, response);
                default:
                    listQuestion(request, response);
                    break;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
    private void showFormQuiz(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TestImpl test = new TestImpl();
        System.out.println(test.all());
        request.setAttribute("listTest", test.all());
        CandidatImpl candidat = new CandidatImpl();
        request.setAttribute("candidats", candidat.all());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/quizCandidats/affectQuiz.jsp");
        dispatcher.forward(request, response);
    }
    private void addQuiz(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        response.sendRedirect("NewQuiz");
        System.out.println(id_test);
    }

    private void showForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/codeQuiz.jsp");
        dispatcher.forward(request, response);
    }
    public String enCode(Question q) throws IOException {

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(q);
        oos.flush();
        final String result = new String(Base64.getEncoder().encode(baos.toByteArray()));
        return  result;
    }
    public Question deCode(String res) throws IOException, ClassNotFoundException {
        final byte[] objToBytes = Base64.getDecoder().decode(res);
        ByteArrayInputStream bais = new ByteArrayInputStream(objToBytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (Question) ois.readObject();
    }

    private void nextQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException {

        Question question = deCode(request.getParameter("currentQuestion"));
        String choiceSelected = request.getParameter("choice");
        quiz.checkResponse(question,choiceSelected,code);
        i++;
        if( i != questions.size()){
            String  questionCrypte = enCode(questions.get(i));
            String data = "<div class='py-2 h5'><b>Q."+questions.get(i).getQuestion() +" </b></div>"+
                    "<input type = 'hidden' name='currentQuestion' value="+questionCrypte+" />"+
                    "<label class='option'>"+questions.get(i).getResponse() +" <input type='radio' name='choice' value='"+questions.get(i).getResponse() +"'> <span class='checkmark'></span> </label>"+
                    "<label class='option'>"+questions.get(i).getChoice1() +"<input type='radio' name='choice' value='"+questions.get(i).getChoice1() +"'> <span class='checkmark'></span> </label>"+
                    "<label class='option'>"+questions.get(i).getChoice2() +"<input type='radio' name='choice' value='"+questions.get(i).getChoice2() +"'> <span class='checkmark'></span> </label>"+
                    "<label class='option'>"+questions.get(i).getChoice3() +"<input type='radio' name='choice' value='"+questions.get(i).getChoice3() +"'> <span class='checkmark'></span> </label>" ;
            request.setAttribute("question",data);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/Quiz.jsp");
            dispatcher.forward(request, response);
        }else{
            String endQuiz = "Merci pour votre participation";
            request.setAttribute("end",endQuiz);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/endQuiz.jsp");
            dispatcher.forward(request, response);
            System.out.println("quiz finished");
        }
    }

    private void listQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        code = Integer.parseInt(request.getParameter("code"));
        questions = quiz.findTestQuestions(code);
        String questionCrypte = enCode(questions.get(i));
        String data = "<div class='py-2 h5'><b>Q."+questions.get(i).getQuestion() +" </b></div> " +
                "<input type = 'hidden' name='currentQuestion' value="+questionCrypte+" />"+
                "<label class='option'>"+questions.get(i).getResponse() +"<input type='radio' name='choice' value='"+questions.get(i).getResponse() +"'> <span class='checkmark'></span> </label>"+
                "<label class='option'>"+questions.get(i).getChoice1() +"<input type='radio' name='choice' value='"+questions.get(i).getChoice1() +"'> <span class='checkmark'></span> </label>"+
                "<label class='option'>"+questions.get(i).getChoice2() +"<input type='radio' name='choice' value='"+questions.get(i).getChoice2() +"'> <span class='checkmark'></span> </label>"+
                "<label class='option'>"+questions.get(i).getChoice3() +"<input type='radio' name='choice' value='"+questions.get(i).getChoice3() +"'> <span class='checkmark'></span> </label>";
        request.setAttribute("question",data);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/Quiz.jsp");
        dispatcher.forward(request, response);
    }

}
