<%@ page import="com.coding.codingzone.model.Question" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 09/01/2022
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <meta charset="utf-8">
    <title>List Question</title>
    <style>
        body {
            font-family: 'Montserrat';
        }
    </style>
</head>
<body>
<div class="container">
    <a class="btn btn-success mt-5 mb-5" href="QuestionServlet/newQuestion">Add</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Question</th>
            <th scope="col">Response</th>
            <th scope="col">choice 1</th>
            <th scope="col">choice 2</th>
            <th scope="col">choice 3</th>
            <th scope="col">time limit</th>
            <th scope="col">category id</th>
            <th scope="col">score</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Question> data =
                    (ArrayList<Question>)request.getAttribute("data");
            for(Question q:data){
        %>
        <tr>
            <td><%=q.getQuestion()%></td>
            <td><%=q.getResponse()%></td>
            <td><%=q.getChoice1()%></td>
            <td><%=q.getChoice2()%></td>
            <td><%=q.getChoice3()%></td>
            <td><%=q.getTimeLimit()%></td>
            <td><%=q.getId_category()%></td>
            <td><%=q.getScore()%></td>
            <td class="d-flex">
                <form action="edit" method="post">
                    <input type="hidden" value="<%=q.getId()%>" name="id">
                    <button class="btn btn-sm btn-primary" type="submit"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                </form> &nbsp; &nbsp;
                <form action="deleteQuestion" method="post">
                    <input type="hidden" value="<%=q.getId()%>" name="id">
                    <button class="btn btn-sm btn-primary" type="submit"><i class="fa fa-trash" aria-hidden="true"></i></button>
                </form>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
<script src="https://use.fontawesome.com/b9f85c081e.js"></script>

</html>
