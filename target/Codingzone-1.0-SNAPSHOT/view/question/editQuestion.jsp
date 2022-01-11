<%@ page import="com.coding.codingzone.model.Question" %>
<%@ page import="com.coding.codingzone.model.Category" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 10/01/2022
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <meta charset="utf-8">
    <title>Edit Question</title>
    <style>
        body {
            font-family: 'Montserrat';
        }
    </style>
</head>
<body>
<h2 class="text-center">Edit Question</h2>
<div class="container">
    <%
        Question data = (Question) request.getAttribute("data");
    %>
    <form action="updateQuestion" method="post">
        <div>
            <input type="hidden" name="id" class="form-control" value="<%=data.getId()%>">
        </div>
        <div>
            <label>Question :</label>
            <input type="text" name="question" class="form-control" value="<%=data.getQuestion()%>">
        </div>
        <div>
            <label>Response :</label>
            <input type="text" name="response" class="form-control" value="<%=data.getResponse()%>">
        </div>
        <div>
            <label>Choice 1 :</label>
            <input type="text" name="choice1" class="form-control" value="<%=data.getChoice1()%>">
        </div>
        <div>
            <label>Choice 2 :</label>
            <input type="text" name="choice2" class="form-control" value="<%=data.getChoice2()%>">
        </div>
        <div>
            <label>Choice 3 :</label>
            <input type="text" name="choice3" class="form-control" value="<%=data.getChoice3()%>">
        </div>
        <div>
            <label>Time Limit :</label>
            <input type="number" name="time" class="form-control" value="<%=data.getTimeLimit()%>">
        </div>
        <div>
            <label>Category :</label>
            <select name="category_id" class="form-control">
                <option value="<%=data.getId_category().getId()%>"><%=data.getId_category().getName()%></option>
                <%
                    ArrayList<Category> std =
                            (ArrayList<Category>)request.getAttribute("category");
                    for(Category c:std){
                %>
                <option value="<%=c.getId()%>"><%=c.getName()%></option>
                <%}%>
            </select>
        </div>
        <div>
            <label>Score :</label>
            <input type="text" name="score" class="form-control" value="<%=data.getScore()%>">
        </div>
        <div>
            <button type="submit" class="btn btn-primary mt-5">Add</button>
        </div>
    </form>
</div>
</body>
</html>
