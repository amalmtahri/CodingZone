<%@ page import="com.coding.codingzone.model.GroupByCategory" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 18/01/2022
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>

    <title>Document</title>
</head>
<style>
    body {
        font-family: 'Montserrat';
    }
    .ctn {
        background-color: #FBFBFB;
        /* height: 530px; */
        margin: 80px;
        padding-top: 40px;
        padding-bottom: 40px;
        padding-left: 50px;

    }

    .card{
        border-radius: 61px;
        width: 473px;
        height: 220px;
        padding-top: 25px;
        box-shadow: 0px 6px 12px -6px #878787;
    }
    .nbr{
        background-color: #058DFE;
        border-radius: 0px 61px 0px 50px;
        color: white;
        width: 236px;
        height: 56px;
        text-align: center;
        padding-top: 15px;
    }
    .btn{
        background-color: #058DFE;
        border-radius: 43px;
        color: white;
        width: 180px;
        height: 53px;
        padding-top: 13px;
    }
    .btn:hover{
        background-color: white;
        border: 1px solid #058DFE;
        color: #058DFE;
    }
    .category{
        display: flex !important;
        flex-direction: row !important;
        flex-wrap: wrap !important;
    }
</style>
<body>
<div class="container-fluid">
    <div class="ctn">
        <div class="category">
            <%
                ArrayList<GroupByCategory> std =
                        (ArrayList<GroupByCategory>)request.getAttribute("data");
                for(GroupByCategory gbc:std){
            %>
            <div class="card border-0 me-5 mb-5 ">
                <img src="<%=gbc.getImage()%>" class="ms-2" alt="img" width="150px">
                <p class="position-absolute top-0 end-0 nbr"><%=gbc.getNbrQuestions()%> Questions</p>
                <p class="text-end pe-5 ">Time : <%= String.format("%.2f", gbc.getMinutes())   %> s</p>
            </div>
            <%}%>
        </div>
        <div class="d-flex justify-content-center">
            <a class="btn" href="nextQuestion"><i class="fa fa-play pe-4" aria-hidden="true"></i>Start Quiz</a>
        </div>
    </div>

</div>
</body>
<script src="https://use.fontawesome.com/b9f85c081e.js"></script>

</html>
