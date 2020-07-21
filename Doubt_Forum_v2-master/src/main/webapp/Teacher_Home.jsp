<%-- 
    Document   : Teacher_Home
    Created on : 10-May-2020, 5:08:16 PM
    Author     : adesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
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
         
          <form action="teacher_showq" method="POST">
              
            <div class="wrapper wrapper--w900">
            <div class="card card-6">
                <div class="card-heading">
                    <h2 class="title">CLICK TO VIEW QUESTION AND ANSWERS</h2>                      
                </div>
                <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit">SHOW QUESTION AND ANSWERS </button>
                </div>
            </div>
        </div>
          

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>


    <!-- Main JS-->
    <script src="js/global.js"></script>
           
    </form>
           
          <form  action="TeacherQuestion" method="POST">
              <div class="wrapper wrapper--w900">
            <div class="card card-6">
                <div class="card-heading">
                    <h2 class="title">CLICK TO ANSWER THE QUESTIONS</h2>                      
                </div>
                <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit">POST ANSWERS FOR THE QUESTIONS </button>
                </div>
            </div>
        </div>
          

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>


    <!-- Main JS-->
    <script src="js/global.js"></script>
    </form>
        <form action="Signout" method="POST">
            <div class="wrapper wrapper--w900">
            <div class="card card-6">
                <div class="card-heading">
                    <h2 class="title">GO BACK TO HOME PAGE</h2>                      
                </div>
                <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit">LOGOUT </button>
                </div>
            </div>
        </div>
                
     </form>
           <jsp:include page="footer.jsp"/>
    </body>
</html>
