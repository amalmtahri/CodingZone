<%@ page import="com.coding.codingzone.model.Test" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 11/01/2022
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <meta charset="utf-8">
    <title>List test</title>
    <style>
        body {
            font-family: 'Montserrat';
        }
    </style>
</head>
<body>
<div class="container">
    <a class="btn btn-success mt-5 mb-5" href="newTest">Add</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Test Name</th>
            <th scope="col">Date creation</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Test> std =
                    (ArrayList<Test>)request.getAttribute("data");
            for(Test t:std){
        %>
        <tr>
            <td><%=t.getName()%></td>
            <td><%=t.getCreationDate()%></td>
            <td>
                <form action="deleteTest" method="post">
                    <input type="hidden" value="<%=t.getId()%>" name="id">
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
