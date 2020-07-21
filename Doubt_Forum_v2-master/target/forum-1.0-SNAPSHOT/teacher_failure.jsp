<%-- 
    Document   : teacher_failure
    Created on : 13-Jun-2020, 1:28:22 am
    Author     : Sanchita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
        <style>
            body  {
                background-image: url("images/sad.jpg");
            }
            .wrapper--w900{
                height: 300px;
                text-align: center;
                background-color: black;
            }
        </style>
    </head>
    <body>

      <form  action="Admin_Home.jsp" method="POST">
          
        <!--  <h1>This student id is already present. Please enter the correct id"</h1>-->
          <div class="page-wrapper bg-light p-t-100 p-b-50">
            <div class="wrapper wrapper--w900">
                <br><br><br><br>
            <div class="card card-6">
                <div class="card-heading">
                    <h2 class="title">This faculty id is already present. Please enter the correct id</h2>
                </div>
                <div class="card-body">
                    <form method="POST">
                       
                    
                </div>
                <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit"><h2>CLICK HERE TO TRY AGAIN </h2></button>
                </div>
                <br><br><br><br>
            </div>
        </div>
    </div>
     
    </form>
 
    </body>
</html>
