<%-- 
    Document   : give_ans
    Created on : 10-May-2020, 10:33:20 PM
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
        
       
        <form action="add_ans" method="POST">
            
            
            <div class="wrapper wrapper--w900">
            <div class="card card-6">
                <div class="card-heading">
                    
                    <h2 class="title">POST YOUR ANSWERS</h2>
                    
                </div>
                <div class="card-body">
                    <form method="POST">
                       
                        <div class="form-row">
                            <table border="1">
                             <tr>
                             <th>Question</th>
                             <th>Question-Id</th>
                             </tr>
                          <c:forEach items="${doubtList}" var="item">

                              <tr>
                                  <td>${item.getQuestion()}</td>
                                  <td>${item.getId()}</td>
                              </tr> 
                           </c:forEach>
                         </table>
                            <br><br>
                            
                        </div>
                        
                        <div class="form-row">
                            <label for="question_id"><b>ENTER QUESTION</b></label>
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
