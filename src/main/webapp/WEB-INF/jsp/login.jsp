<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
     <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
     <link rel="stylesheet" type="text/css" href="styles/lutostyle.css">
     <link rel="stylesheet" type="text/css" href="styles/animate.css">
        <title> Login to Luto Bank</title>
    </head>

    <body>
        <div class="container">
            <div class="center-screen">
                <div class="form-content">
                <h1 class="title-login">Welcome on Luto Bank </h1>
                <form class="form-signin" id="Login" method="POST" ACTION="index.htm">
                    <div class="form-group">
                        <input type=text name=login class="form-control" id="inputLogin" placeholder="Username" required autofocus>
                    </div>
                    <div class="form-group">
                        <input type=password name=mdp class="form-control" id="inputPassword" placeholder="Password" required>
                    </div>
                   <button type="submit" class="btn btn-primary">Login</button>
                </form>
            </div>
            </div>
        </div>
    </body>
</html>

