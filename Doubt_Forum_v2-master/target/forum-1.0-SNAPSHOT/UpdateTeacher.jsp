<%-- 
    Document   : UpdateTeacher
    Created on : 13-Jun-2020, 4:17:23 pm
    Author     : Sanchita
--%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.util.List" %>
<%@page import="classes.Teacher" %>
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
        
       
        <form action="UpdateTeacher" method="POST">
            
            
            <div class="wrapper wrapper--w900">
            <div class="card card-6">
                <div class="card-heading">
                    
                    <h2 class="title">UPDATE INFORMATION</h2>
                    
                </div>
                <div class="card-body">                        
                        <div class="form-row">
                            <label for="id"><b>NAME</b></label>
                            <select name="id">
                                <c:forEach items="${tchList}" var="item">

                                 <option value="${item.getId()}">${item.getName()}</option>
                              </c:forEach>
                              </select>
                        </div>
                        <div class="form-row">
                            <div class="name">ENTER PASSWORD</div>
                            <div class="value">
                                <div class="input-group">
                                    <input type="password" placeholder="Password" name="psw" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">CONFIRM PASSWORD</div>
                            <div class="value">
                                <div class="input-group">
                                    <input type="password" placeholder="Password" name="psw" required>
                                </div>
                            </div>
                        </div>
                      
                </div>
                <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit">UPDATE</button>
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

