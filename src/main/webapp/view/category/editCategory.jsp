<%@ page import="com.coding.codingzone.model.Category" %><%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 09/01/2022
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <meta charset="utf-8">
    <title>Edit Category</title>
    <style>
        body {
            font-family: 'Montserrat';
        }
    </style>
</head>
<body>
<h2>Edit Category</h2>
<form action="update" method="post">
    <%
        Category data = (Category) request.getAttribute("data");
    %>
    <div>
        <input type="hidden" name="id" value="<%=data.getId()%>">
    </div>
    <div>
        <label>Name category: </label>
        <input type="text" name="name" value="<%=data.getName()%>">
    </div>
    <div>
        <label>Image category: </label>
        <input type="file" name="image" class="form-control" value="<%=data.getImage()%>">
    </div>
    <button type="submit">save</button>
</form>
</body>
</html>
