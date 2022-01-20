<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/01/2022
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
        <meta charset="utf-8">
        <title>CodeQuiz</title>
        <style>
            body {
                font-family: 'Montserrat';
            }
        </style>
    </head>
</head>
<body>

<div class="container h-100">
    <div class="row h-100 justify-content-center align-items-center">
        <div class="col-10 col-md-6 col-lg-6">
            <div class="text-center my-5">
                <img src="logo.png" alt="logo">
                <p class="description my-5">Enter the vérification code sent to your email adress!</p>
            </div>
            <div class="card-deck my-5">
                <div class="card">
                    <div class="card-body bg-light ">
                        <form class="form-example" action="PassQuiz" method="post">
                            <div class="form-group m-5">
                                <input type="number" class="form-control" id="code" placeholder="Code du test" name="code">
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary col-10    font-weight-bold  ">Valider</button>
                            </div>
                            <c:if test="${data != null}">
                                <div class="text-center form-group m-5"> <%=  request.getAttribute("data") %> </div>
                            </c:if>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="footer">
    <div class="container-fluid">
        <div class="row text-center">
            <div class="col-12">Conditions d'utilisation      |      Confidentialité </div>
        </div>
    </div>
</footer>
</body>
</html>