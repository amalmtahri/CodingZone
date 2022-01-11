<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 08/01/2022
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <meta charset="utf-8">
    <title>Add Category</title>
    <style>
        body {
            font-family: 'Montserrat';
        }
    </style>
</head>
<body>
<h2 class="text-center">Add Category</h2>
<div class="container">
    <form action="insert" method="post" >
        <div>
            <label>Name category: </label>
            <input type="text" name="name" class="form-control">
        </div>
        <div>
            <label>Image category: </label>
            <input type="file" name="image" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary mt-5">Add</button>
    </form>
</div>
</body>
</html>
