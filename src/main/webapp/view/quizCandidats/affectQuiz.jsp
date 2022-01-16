<%@ page import="com.coding.codingzone.model.Test" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.coding.codingzone.model.Candidat" %><%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 12/01/2022
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <meta charset="utf-8">
    <title>Affect Quiz</title>
    <style>
        body {
            font-family: 'Montserrat';
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-center">Affect Quiz</h2>
    <form action="AffectQuiz" method="post">
        <div>
            <label>Test Name :</label>
            <select name="test_id" class="form-control">
                <%
                    ArrayList<Test> test =
                            (ArrayList<Test>)request.getAttribute("listTest");
                    for(Test t:test){
                %>
                <option value="<%=t.getId()%>"><%=t.getName()%></option>
                <%}%>

            </select>
        </div>
        <input type="hidden" value="<%= session.getAttribute("id_staff")%>" name="id_staff">
        <div>
            <label>Candidats :</label>
            <select class="form-control" name="candidats" multiple>
                <%
                    ArrayList<Candidat> candidats =
                            (ArrayList<Candidat>)request.getAttribute("candidats");
                    for(Candidat c:candidats){
                %>
                <option value="<%=c.getId_candidat()%>"><%=c.getFirstname()%> <%=c.getLastname()%></option>
                <%}%>
            </select>
        </div>
        <div>
            <button class="btn btn-success mt-5" type="submit">Add</button>
        </div>
    </form>
</div>
</body>
</html>
