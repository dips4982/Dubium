<%-- 
    Document   : index
    Created on : May 22, 2020, 7:37:44 AM
    Author     : adesh
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
<%@page import="classes.Doubts" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Doubt Forum</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script src="js/load.js"></script>
        <style>
            .col-sm-4{
                background-color: black;
                color: white;
            }
            body {
                background-image: url('laptop.jpeg');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
            }
            h1{
                background-color: whitesmoke
            }
            .center{
                margin: auto;
            }
            img {
                display: block;
                margin-left: auto;
                margin-right: auto;
            }
            .name{
                text-align: center;
            }


        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <!--<div class="jumbotron text-center" style="margin-bottom:0">
          <h1>DOUBT FORUM</h1>
          <p>Here you can ask your Doubt regarding any subject</p> 
        </div>-->
        <br>
        <h1 align="center"><b>WELCOME TO THE DOUBT FORUM</b></h1>

        <div class="container" style="margin-top:30px">
            <div class="row">
                <div class="col-sm-4">
                    <div class="fakeimg">
                        <br><br><br><br>

                        <form action="verify_user.jsp">

                            <button type="submit"><h5> Click Here to Answer a Public Doubt </h5></button>

                        </form>
                        <br><br>
                        <form action="verify_q_user.jsp">

                            <button type="submit"> <h4>Click Here to Ask a Doubt</h4> </button>

                        </form>     
                    </div>
                    <br><br><br><br> 
                    <h3><u>Contact Us</u></h3>
                    <br>
                    <ul class="nav nav-pills flex-column">
                        <li class="nav-item">
                            +91 9785432410
                        </li>
                        <li class="nav-item">
                            +91 9654342108
                        </li>
                        <li class="nav-item">
                            <!-- <a class="nav-link" href="#">service@gmail.com</a>-->
                            service@gmail.com
                        </li>
                        <li class="nav-item">
                            doubtforumservices@gmail.com
                        </li>
                    </ul>
                    <br><br><br>
                    <img src="vnit.jpeg" alt="logo" style="width:50%">
                    <br><br>
                    <hr class="d-sm-none">
                </div>
                <div class="col-sm-8">
                    <div class="fakeimg">

                        <br>
                        <div class="name">
                            <h3 style="background-color:whitesmoke"><u>Showing All Posted Question</u></h3>
                        </div>
                        <br>
                        <table border="1" align="center">
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
                    </div>

                    <div class="fakeimg">   
                        <br><br><br>
                        <div class="name">
                            <h3 style="background-color: whitesmoke"><u>Showing Available Answers</u></h3>  
                        </div>
                        <br>         
                        <table border="1" align="center" >
                            <tr>
                                <th>Question</th>
                                <th>Answer</th>
                            </tr>
                            <c:forEach items="${answerList}" var="item">

                                <tr>
                                    <td>${item.getQuestion()}</td>
                                    <td>${item.getAnswer()}</td>
                                </tr> 
                            </c:forEach>
                        </table>     
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="footer.jsp"/>

    </body>
</html>