<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 20/01/2022
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <title>Title</title>
</head>
<style>
  body {
    font-family: 'Montserrat';
  }
  .ctn{
    margin-top: 180px;
    margin-left: 70px;
  }
  .coding{
    color: #058DFE !important;
  }
  .zone{
    color: #FCA82F !important;
  }
  h2{
    font-weight: bold;
  }
  .btn{
    color: #058DFE;
    border-radius: 38px;
    width: 151px;
    height: 50px;
    margin-top: 60px;
    padding-top: 12px;
  }
  .btn:hover{
    color: white;
    background-color: #058DFE;
  }
  .row{
    display: flex !important;
    flex-direction: row !important;
  }
  .img{
    margin-left: 200px;
    margin-top: 100px;

  }
</style>
<body>
<div class="container-fluid">
  <nav class="ms-5 mt-4">
    <img src="images/Groupe_7.png" alt="logo" width="130px">
  </nav>

  <div class="col-lg-12 row">
    <div class="col-lg-4 ctn">
      <h2>Welcome to <span class="coding">Coding </span><span class="zone">zone</span></h2>
      <p class="mt-4">
        Coding zone is the solution that allows <br>
        to meet your needs.<br>
        Whether it is to do an assessment, take a test, play a game or <br>
        a competition, the application is quick and easy to learn.
      </p>

      <a class="btn shadow" href="tapezCode"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-play-btn-fill" viewBox="0 0 16 16">
        <path d="M0 12V4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm6.79-6.907A.5.5 0 0 0 6 5.5v5a.5.5 0 0 0 .79.407l3.5-2.5a.5.5 0 0 0 0-.814l-3.5-2.5z"/>
      </svg> Let's begin</a>
    </div>
    <div class="col-lg-5 img" >
      <img src="images/zyro-image (3).png" alt="img" width="500px">
    </div>
  </div>
</div>
</body>

</html>
