<%@ page import="com.coding.codingzone.model.Staff" %><%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 12/01/2022
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <meta charset="utf-8">
    <title>Dashboard</title>
    <style>
        body {
            font-family: 'Montserrat';
        }
    </style>
</head>
<body>
<div class="d-flex container mt-5">
    <a href="CategoryServlet" class="btn btn-primary">list category</a>&nbsp;
    <a href="QuestionServlet" class="btn btn-primary">list question</a>&nbsp;
    <a href="newTest" class="btn btn-primary">add test</a>&nbsp;
    <a href="affectQst" class="btn btn-primary">add question test</a>&nbsp;
    <a href="NewQuiz" class="btn btn-primary">Affect quiz</a>&nbsp;
    <a href="QuizServlet" class="btn btn-primary">Passer Quiz</a>
</div>
</body>
</html>
