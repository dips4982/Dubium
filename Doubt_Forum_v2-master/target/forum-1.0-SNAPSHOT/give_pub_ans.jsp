<%-- 
    Document   : give_pub_ans
    Created on : May 22, 2020, 4:05:55 AM
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
    <p>hello user ${username}</p>
    <body>
        <jsp:include page="header.jsp"/>
       
        <form action="insert_public_answer" method="POST">
            <div class="wrapper wrapper--w900">
            <div class="card card-6">
                <div class="card-heading">
                    
                    <h2 class="title">Posting Answer in Public</h2>
                    
                </div>
                <div class="card-body">
                    <form method="POST">                     
                        
                        <div class="form-row">
                        <label for="question_id"><b> QUESTION </b></label>
                        <select name="question_id">
                        <c:forEach items="${doubtList}" var="item">

                        <option value="${item.getId()}">${item.getQuestion()}</option>
                        </c:forEach>
                        </select>

                        </div>
                        <div class="form-row">
                            <div class="name">ENTER ANSWER</div>
                            <div class="value">
                                <div class="input-group">
                                    <input type="text" placeholder="Answer" name="answer" required>
                                </div>
                            </div>
                        </div>
                      
                </div>
                <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit">CLICK TO POST</button>
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
