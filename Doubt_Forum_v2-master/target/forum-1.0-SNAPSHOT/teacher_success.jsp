<%-- 
    Document   : teacher_success
    Created on : 13-Jun-2020, 1:19:40 am
    Author     : Sanchita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Succcessfull Registration</title>
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
         
               
        
        <form action="TeacherInfo">
            <div class="wrapper wrapper--w900">
            <div class="card card-6">
                <div class="card-heading">
                    <%String name = (String)request.getAttribute("name"); %>
                    <h2 class="title">Faculty successfully registered.</h2>
                 
                      
                </div>
                <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit">GO TO HOME</button>
                </div>
            </div>
        </div>
          

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>


    <!-- Main JS-->
    <script src="js/global.js"></script>
            
            
            
        </form>
        
   
        
        
    </body>
</html>

