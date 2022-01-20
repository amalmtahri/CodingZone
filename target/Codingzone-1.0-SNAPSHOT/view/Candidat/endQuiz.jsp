<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 13/01/2022
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Congtas</title>
</head>
<link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
</head>
<style>
    body {
        text-align: center;
        padding: 40px 0;
    }
    h1 {
        color: #88B04B;
        font-family: 'Montserrat';
        font-weight: 900;
        font-size: 40px;
        margin-bottom: 10px;
    }
    p {
        color: #404F5E;
        font-family: 'Montserrat';
        font-size:20px;
        margin: 0;
    }
    i {
        color: #9ABC66;
        font-size: 100px;
        line-height: 200px;
        margin-left:-15px;
    }
    .card {
        background: white;
        padding: 60px;
        border-radius: 4px;
        box-shadow: 0 2px 3px #C8D0D8;
        display: inline-block;
        margin: 0 auto;
    }
</style>
<body>
<div class="card">
    <div style="border-radius:200px; height:200px; width:200px; background: #F8FAF5; margin:0 auto;">
        <i class="checkmark">✓</i>
    </div>
    <h1> Quiz passed <span></span>successfully </h1>
    <p>We received your quiz request;<br/> we'll be in touch shortly!</p>
</div>
</body>
</html>
