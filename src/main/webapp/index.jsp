<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
    <meta charset="utf-8">
    <title>Login</title>
    <style>
        body {
            font-family: 'Montserrat';
        }
    </style>
</head>
<body>
<div class="container-fluid h-100">
    <div class="row h-100 ">
        <div class="col bg-white hidden-md-down d-flex h-100 ">
            <div class="row align-self-center w-100">
                <div class="col-xl-8 col-lg-6 col-md-8 col-sm-10 mx-auto  form p-4">
                    <div class="text-center">
                        <img src="logo.png" alt="logo">
                        <h3 class="display-6 font-weight-bold text-truncate">Welcome !</h3>
                        <h6 class="display-6 py-4 text-truncate text-secondary">Sign in by entering the information below</h6>
                    </div>
                    <form action="hello-servlet" class="justify-content-center" method="post">
                        <div class="form-group">
                            <label class="sr-only">Email</label>
                            <input type="text" class="form-control" placeholder="enter your email" name="email" >
                        </div>
                        <div class="form-group">
                            <label class="sr-only">password</label>
                            <input type="password" class="form-control" placeholder="enter your password" name="password">
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" id="autoSizingCheck2" >
                            <label class="form-check-label" for="autoSizingCheck2">
                                Remember me
                            </label>
                            <span class="float-right">! Forgotten password</span>
                        </div>
                        <button class="btn btn-primary col-12 my-2  font-weight-bold" type="submit">Login</button>
                        <% if(request.getAttribute("msg") != null) {%>
                        <div class="alert alert-danger"><%= request.getAttribute("msg") %></div>
                        <%}%>
                        <div class="text-center">
                            <h6 class="display-6 py-4 text-truncate text-secondary">Don't have account ? Create one here</h6>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col bg-primary hidden-md-down d-flex h-100 ">
            <div class="row justify-content-center align-items-center text-center">
                <div class="col-8">
                    <p class="h1 m-2 font-weight-bold text-white"> Make Learning <span class="text-warning">awesome</span>   with coding <span class="text-warning">&#60;zone/&#62;</span>   </p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
