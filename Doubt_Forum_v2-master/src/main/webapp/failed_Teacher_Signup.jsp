<%-- 
    Document   : failed_Teacher_Signup
    Created on : May 21, 2020, 7:46:56 PM
    Author     : adesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Failed Sign Up</title>
          <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Main CSS-->
    <link href="CSS/main_1.css" rel="stylesheet" media="all">
    
     <style>
        body  {
          background-image: url("images/sad.jpg");
        }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        
        <form action="teacher_signup.jsp">
            
            <form action="signup.jsp">
             <div class="page-wrapper bg-light p-t-100 p-b-50">
            <div class="wrapper wrapper--w900">
            <div class="card card-6">
                <div class="card-heading">
                    <h2 class="title">INVALID CREDENTIALS</h2>
                </div>
                <div class="card-body">
                    <form method="POST">
                       
                    
                </div>
                <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit">CLICK HERE TO RETRY  </button>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>


    <!-- Main JS-->
    <script src="js/global.js"></script>
           
            
           
            
        </form>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
