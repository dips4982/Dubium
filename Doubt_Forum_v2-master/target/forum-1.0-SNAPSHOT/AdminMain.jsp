<%-- 
    Document   : AdminMain
    Created on : 13-Jun-2020, 4:10:52 pm
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
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body  {
                background-image: url("images/sad.jpg");
            }
            .name{
                text-align: center;
            }
            table, th, td {
                border: 3px solid black;
                padding: 20px;
            }
            table.center{
                text-align: center;
                margin-left: auto;
                margin-right: auto;
                background-color: whitesmoke;
                
            }
        </style>

    </head>
    <body>


        <div class="fakeimg">

            <br>
            <div class="name">
                <h1 style="background-color:whitesmoke"><u>ALL REGISTERED FACULTIES</u></h1>
            </div>
            <br>
            <table class="center">
                <tr>
                    <th>Name</th>
                    <th>ID</th>
                    <th>Email-id</th>
                </tr>
                <c:forEach items="${tchList}" var="item">

                    <tr>
                        <td>${item.getName()}</td>
                        <td>${item.getId()}</td>
                        <td>${item.getemail()}</td>
                    </tr> 
                </c:forEach>
            </table>     
        </div>





        <form action="Admin_Home.jsp" method="POST">

            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    <div class="card-heading">
                        <br>
                        <h2 class="title">CLICK TO REGISTER A FACULTY</h2>                      
                    </div>
                    <div class="card-footer">
                        <button class="btn btn--radius-2 btn--blue-2" type="submit">REGISTER </button>
                    </div>
                </div>
            </div>


            <!-- Jquery JS-->
            <script src="vendor/jquery/jquery.min.js"></script>


            <!-- Main JS-->
            <script src="js/global.js"></script>

        </form>

        <form  action="UpdateInfo" method="POST">
            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    <div class="card-heading">
                        <br>
                        <h2 class="title">CLICK TO UPDATE INFORMATION</h2>                      
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
        <form action="Deleteteacher.jsp" method="POST">
            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    <div class="card-heading">
                        <br>
                        <h2 class="title">CLICK TO DELETE A RECORD</h2>                      
                    </div>
                    <div class="card-footer">
                        <button class="btn btn--radius-2 btn--blue-2" type="submit">DELETE </button>
                    </div>
                </div>
            </div>

        </form>
        
    </body>
</html>

