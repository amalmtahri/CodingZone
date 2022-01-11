<%@ page import="com.coding.codingzone.model.Category" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 09/01/2022
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
  <meta charset="utf-8">
  <title>Add Question</title>
  <style>
    body {
      font-family: 'Montserrat';
    }
  </style>
</head>
<body>
<h2 class="text-center">Add Question</h2>
<div class="container">
  <form action="insertQuestion" method="post">
    <div>
      <label>Question :</label>
      <input type="text" name="question" class="form-control">
    </div>
    <div>
      <label>Response :</label>
      <input type="text" name="response" class="form-control">
    </div>
    <div>
      <label>Choice 1 :</label>
      <input type="text" name="choice1" class="form-control">
    </div>
    <div>
      <label>Choice 2 :</label>
      <input type="text" name="choice2" class="form-control">
    </div>
    <div>
      <label>Choice 3 :</label>
      <input type="text" name="choice3" class="form-control">
    </div>
    <div>
      <label>Time Limit :</label>
      <input type="number" name="time" class="form-control">
    </div>
    <div>
      <label>Category :</label>
      <select name="category_id" class="form-control">
        <%
          ArrayList<Category> std =
                  (ArrayList<Category>)request.getAttribute("data");
          for(Category c:std){
        %>
        <option value="<%=c.getId()%>"><%=c.getName()%></option>
        <%}%>
      </select>
    </div>
    <div>
      <label>Score :</label>
      <input type="text" name="score" class="form-control">
    </div>
    <div>
      <button type="submit" class="btn btn-primary mt-5">Add</button>
    </div>
  </form>
</div>

</body>
</html>
