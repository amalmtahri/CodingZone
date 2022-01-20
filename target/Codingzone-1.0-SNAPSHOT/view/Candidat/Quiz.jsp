<%@ page import="com.coding.codingzone.model.Question" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/01/2022
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <meta charset="utf-8">
    <title>Passer quiz</title>
</head>
<style>
    body {
        font-family: 'Montserrat';
    }

    progress {
        width: 700px;
    }

    .ctn {
        background-color: #FBFBFB;
        height: 478px;
    }

    .title {
        color: #A2A9C3;
    }

    hr {
        color: #A2A9C3;
    }

    .inputGroup {
        border: 1px solid #E9ECEF;
        margin-bottom: 30px;
        background-color: #fff;
        display: block;
        margin: 10px 0;
        position: relative;
    }

    label {
        color: #8590AE;
        font-size: 13px;
        top: 0;
        font-weight: bold;
        padding: 7px 20px;
        width: 100%;
        display: block;
        cursor: pointer;
        position: relative;
        z-index: 2;
        transition: color 200ms ease-in;
        overflow: hidden;
    }

    label::after {
        width: 29px;
        height: 29px;
        content: '';
        border: 2px solid #2C3E50;
        background-image: url("data:image/svg+xml,%3Csvg width='32' height='32' viewBox='0 0 32 32' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath d='M5.414 11L4 12.414l5.414 5.414L20.828 6.414 19.414 5l-10 10z' fill='%23fff' fill-rule='nonzero'/%3E%3C/svg%3E ");
        border-radius: 50%;
        z-index: 2;
        position: absolute;
        right: 30px;
        top: 50%;
        transform: translateY(-50%);
        cursor: pointer;
        transition: all 200ms ease-in;
    }

    input {
        width: 32px;
        height: 32px;
        order: 1;
        z-index: 2;
        position: absolute;
        right: 30px;
        top: 50%;
        transform: translateY(-50%);
        cursor: pointer;
        visibility: hidden;
    }

    input:checked~label {
        color: #2C3E50;
    }

    input:checked~label::before {
        opacity: 1;
    }

    input:checked~label::after {
        background-color: #FCA82F;
        border-color: #FCA82F;
    }


    .btn {
        background-color: #058DFE;
        color: white;
        border-radius: 40px;
        height: 59px;
        width: 172px;
        margin-top: 30px;
    }

    .btn:hover {
        color: white;
    }

    .vl {
        border-left: 1px solid #A1A1A1;
        height: 70px;
        margin-left: 76px;
        padding-left: 69px;
    }

    .time {
        background-color: #058DFE;
        width: 62px;
        height: 61px;
        padding: 10px;
        border-radius: 50%;
        opacity: 0.5;
    }

    .fa-clock-o {
        position: relative;
        top: -47px !important;
        left: 16px;
        color: #058DFE;
        font-size: 34px !important;
    }

    .number-question {
        margin-left: 167px;
    }
    .ps-5{
        padding-left: 24px;
    }

    .MyClass {
        box-shadow: 4px 1px 16px -6px #FCA82F;
        border: 1px solid #E9ECEF;
        border-left: 6px solid #FCA82F;
        margin-bottom: 30px;
        background-color: #fff;
        display: block;
        margin: 10px 0;
        position: relative;
        padding: 0.5rem !important;
    }
    .fa-step-forward{
        padding-left: 24px;
    }
    progress{
        margin-left: 20px !important;
    }
    .text-start{
        font-weight: bold;
    }

</style>
<body>
<div class="container-fluid">
    <div class="p-5">
        <div class="d-flex">
            <div class="d-flex qst">
                    <span>
                        <p class="number-question">Question <%= request.getAttribute("count") %>/<%= request.getAttribute("nbrQuestions") %></p>
                        <p>Question Number : <progress id="file" max="<%= request.getAttribute("nbrQuestions") %>" value="<%= request.getAttribute("count") %>"> </progress></p>
                    </span>
            </div>
            <div class="vl d-flex">
                <div class="ms-5">
                    <div class="time">
                    </div>
                    <i class="fa fa-clock-o" aria-hidden="true"></i>
                </div>

                <span class="ps-5">
                        <p id="timer"></p>
                        <p class="ps-5">Time Left</p>
                    </span>
            </div>
        </div>
        <div class="ctn mt-4 p-5">
            <h5 class=" title">Question <%=  request.getAttribute("count") %></h5>
            <p class="text-start pt-3 pb-2"><%= request.getAttribute("qstContent")%></p>
            <hr>
            <form action="nextQuestion" method="post" id="formAnswer">
                <%=
                request.getAttribute("question")
                %>
        </div>
        <div class="d-flex justify-content-center">
            <button class="btn" type="submit">Next <i class="fa fa-step-forward text-white ps-4" aria-hidden="true"></i>
            </button>
        </div>
        </form>
    </div>
</div>
</body>
<script src="https://use.fontawesome.com/b9f85c081e.js"></script>
<script>

    let i = <%=request.getAttribute("timeLimit")%>;
    const x = setInterval(function () {
        i--;
        document.getElementById("timer").innerHTML = i + " s";
        if (i === 0) {
            clearInterval(x);
            document.getElementById("formAnswer").submit();
        }
    }, 1000);
</script>
</html>
