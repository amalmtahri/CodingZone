
package com.coding.codingzone.controller;

        import com.coding.codingzone.dao.DAO;
        import com.coding.codingzone.dao.DAOFactory;
        import com.coding.codingzone.daoImpl.CandidatImpl;
        import com.coding.codingzone.daoImpl.QuizImpl;
        import com.coding.codingzone.daoImpl.TestImpl;
        import com.coding.codingzone.demo.SendMail;
        import com.coding.codingzone.model.Question;
        import com.coding.codingzone.model.Quiz;
        import com.coding.codingzone.model.ResultQuiz;

        import javax.servlet.*;
        import javax.servlet.http.*;
        import javax.servlet.annotation.*;
        import java.io.*;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.Base64;
        import java.util.List;
@WebServlet(name = "QuizServlet", value = {"/QuizServlet","/PassQuiz","/nextQuestion","/Quiz","/AffectQuiz","/NewQuiz","/tapezCode"})

public class QuizServlet extends HttpServlet {
    int i = 0;
    int b =0;
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

                case "/NewQuiz":
                    showFormQuiz(request, response);
                    break;
                case "/AffectQuiz":
                    addQuiz(request, response);
                    break;
                case "/QuizServlet":
                    showForm(request, response);
                    break;
                case "/tapezCode":
                    tapezCode(request, response);
                    break;
                case "/PassQuiz":
                    listQuestion(request, response);
                    break;
                case "/nextQuestion":
                    nextQuestion(request, response);
                default:
                    showError(request, response);
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
            SendMail.sendEmail(email,"test coding zone","hey");
        }
        response.sendRedirect("NewQuiz");
        System.out.println(id_test);
    }
    private void showError(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Exception/404.jsp");
        dispatcher.forward(request, response);
    }
    private void showForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/home.jsp");
        dispatcher.forward(request, response);
    }
    private void tapezCode(HttpServletRequest request, HttpServletResponse response)
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

        if( i==0){
            int nbrQuestions = questions.size();
            int timeLimit = questions.get(i).getTimeLimit();
            String  questionCrypte = enCode(questions.get(i));
            String qstContent = questions.get(i).getQuestion();
            int count = i + 1;
            String data =
                    "<input type = 'hidden' name='currentQuestion' value="+questionCrypte+" />"+
                            "<div class='inputGroup bg-white d-flex justify-content-between p-2 ' id='choice1'><input type='radio' id='option1' name='choice' value='"+questions.get(i).getResponse() +"'> <label for='option1'>"+questions.get(i).getResponse() + "</label></div>"+
                            "<div class='inputGroup bg-white d-flex justify-content-between p-2 ' id='choice2'><input type='radio' id='option2' name='choice' value='"+questions.get(i).getChoice1() +"'> <label for='option2'>"+questions.get(i).getChoice1() + "</label></div>"+
                            "<div class='inputGroup bg-white d-flex justify-content-between p-2 ' id='choice3'><input type='radio' id='option3' name='choice' value='"+questions.get(i).getChoice2() +"'> <label for='option3'>"+questions.get(i).getChoice2() + "</label></div>"+
                            "<div class='inputGroup bg-white d-flex justify-content-between p-2 ' id='choice4'><input type='radio' id='option4' name='choice' value='"+questions.get(i).getChoice3() +"'> <label for='option4'>"+questions.get(i).getChoice3() + "</label></div>";
            request.setAttribute("question",data);
            request.setAttribute("qstContent",qstContent);
            request.setAttribute("count",count);
            request.setAttribute("nbrQuestions",nbrQuestions);
            request.setAttribute("timeLimit",timeLimit);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/Quiz.jsp");
            dispatcher.forward(request, response);
            i++;
        }
        else if(i>=1 && i < questions.size() ){
            if(request.getParameter("currentQuestion")==null){
                request.setAttribute("data","<div class='alert alert-danger' role='alert'>Quiz finished, sorry!</div>");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/codeQuiz.jsp");
                dispatcher.forward(request, response);
                i=0;
            }
            else {
                int nbrQuestions = questions.size();
                int timeLimit = questions.get(i).getTimeLimit();
                String currentQuestion = request.getParameter("currentQuestion");
                String choice = request.getParameter("choice");
                Question question = deCode(currentQuestion);
                quiz.checkResponse(question, choice, code);
                String questionCrypte = enCode(questions.get(i));
                String qstContent = questions.get(i).getQuestion();
                int count = i + 1;
                String data =
                        "<input type = 'hidden' name='currentQuestion' value=" + questionCrypte + " />" +
                                "<div class='inputGroup bg-white d-flex justify-content-between p-2 ' id='choice1'><input type='radio' id='option1' name='choice' value='" + questions.get(i).getResponse() + "'> <label for='option1'>" + questions.get(i).getResponse() + "</label></div>" +
                                "<div class='inputGroup bg-white d-flex justify-content-between p-2 ' id='choice2'><input type='radio' id='option2' name='choice' value='" + questions.get(i).getChoice1() + "'> <label for='option2'>" + questions.get(i).getChoice1() + "</label></div>" +
                                "<div class='inputGroup bg-white d-flex justify-content-between p-2 ' id='choice3'><input type='radio' id='option3' name='choice' value='" + questions.get(i).getChoice2() + "'> <label for='option3'>" + questions.get(i).getChoice2() + "</label></div>" +
                                "<div class='inputGroup bg-white d-flex justify-content-between p-2 ' id='choice4'><input type='radio' id='option4' name='choice' value='" + questions.get(i).getChoice3() + "'> <label for='option4'>" + questions.get(i).getChoice3() + "</label></div>";
                request.setAttribute("question", data);
                request.setAttribute("qstContent", qstContent);
                request.setAttribute("count", count);
                request.setAttribute("nbrQuestions", nbrQuestions);
                request.setAttribute("timeLimit", timeLimit);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/Quiz.jsp");
                dispatcher.forward(request, response);
                i++;
            }
        }
        else if(i == questions.size()) {
            String currentQuestion = request.getParameter("currentQuestion");
            String choice = request.getParameter("choice");
            Question question = deCode(currentQuestion);
            quiz.checkResponse(question,choice,code);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/endQuiz.jsp");
            dispatcher.forward(request, response);
            System.out.println("quiz finished");
            i++;
        }
        else{
            request.setAttribute("data","<div class='alert alert-danger' role='alert'> You have already passed the quiz !</div>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/codeQuiz.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void listQuestion(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        code = Integer.parseInt(request.getParameter("code"));
        if(quiz.checkTestPassed(code))
        {
            request.setAttribute("data","<div class='alert alert-danger' role='alert'> You have already passed the quiz !</div>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/codeQuiz.jsp");
            dispatcher.forward(request, response);
        }
        else {
            if(quiz.checkTestExist(code)){
                ResultQuiz rq =new ResultQuiz();
                quiz.insertResultQuiz(code,rq);
                questions = quiz.findTestQuestions(code);
                i=0;
                request.setAttribute("data", quiz.CategoriesOfTest(code));
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/startQuiz.jsp");
                dispatcher.forward(request, response);
            }else {
                request.setAttribute("data","<div class='alert alert-danger' role='alert'> Code quiz invalide !</div>");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/Candidat/codeQuiz.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}

