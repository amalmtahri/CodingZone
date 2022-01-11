<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 11/01/2022
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <meta charset="utf-8">
    <title>Add Test</title>
    <style>
        body {
            font-family: 'Montserrat';
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-center">Add Test</h2>
    <form action="insertTest" method="post">
        <div>
            <label>Test Name :</label>
            <input type="text" name = "nameTest" class="form-control">
        </div>
        <div>
            <button type="submit" class="mt-5 btn btn-success">Add</button>
        </div>
    </form>
</div>
</body>
</html>
