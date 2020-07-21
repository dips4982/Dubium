<%-- 
    Document   : showallques
    Created on : May 29, 2020, 8:53:51 PM
    Author     : adesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        
        <form action="Teacher_Home.jsp" method="POST">
            <div class="wrapper wrapper--w900">
            <div class="card card-6">
                <div class="card-heading">
                    
                    <h2 class="title">DOUBTS ASKED TO TEACHER</h2>
                    
                </div>
                <div class="card-body">
                     <div class="form-row">
                    <form method="POST"> 
                        
                <table border="1">
              <tr>
              <th>Question-ID</th>
              <th>Question</th>
              <th>Answer</th>
              </tr>
        <c:forEach items="${doubts}" var="item">
                
               <tr>
                   <td> ${item.getId()}</td>
                   <td> ${item.getQuestion()}</td>
                   <td> ${item.getAnswer()}</td>
               </tr> 
            </c:forEach>
               </table>
                         </div>
                <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit">GO TO HOME PAGE</button>
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
                <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit">LOGOUT</button>
                </div>
                </div>
                </div>
             </div>
          </form>
                
        <jsp:include page="footer.jsp"/>
    </body>
</html>
