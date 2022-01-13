<%@ page import="com.coding.codingzone.model.Question" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.coding.codingzone.model.Test" %><%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 12/01/2022
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <meta charset="utf-8">
    <title>Add question of test</title>
    <style>
        body {
            font-family: 'Montserrat';
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text center">Affecter des questions à un test</h2>
        <form method="post" action="insertQstTest">

            <div>
                <label>Test name :</label>
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
            <div>
                <label>question :</label>
                <select name="selectQst" class="form-control" multiple>
                    <%
                        ArrayList<Question> data =
                                (ArrayList<Question>)request.getAttribute("data");
                        for(Question q:data){
                    %>
                    <option value="<%=q.getId()%>"><%=q.getQuestion()%></option>
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
