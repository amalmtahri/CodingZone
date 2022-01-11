<%@ page import="com.coding.codingzone.model.Category" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 08/01/2022
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <meta charset="utf-8">
    <title>List category</title>
    <style>
        body {
            font-family: 'Montserrat';
        }
    </style>
</head>
<body>
<div class="container">
    <a class="btn btn-success mt-5 mb-5" href="new">Add</a>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Category Name</th>
            <th scope="col">Image</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Category> std =
                (ArrayList<Category>)request.getAttribute("data");
            for(Category c:std){
        %>
        <tr>
            <td><%=c.getName()%></td>
            <td><%=c.getImage()%></td>
            <td class="d-flex">
                <form action="CategoryServlet/edit" method="post">
                    <input type="hidden" value="<%=c.getId()%>" name="id">
                    <button class="btn btn-sm btn-primary" type="submit"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></button>
                </form>&nbsp; &nbsp;
                <form action="CategoryServlet/delete" method="post">
                    <input type="hidden" value="<%=c.getId()%>" name="id_category">
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
