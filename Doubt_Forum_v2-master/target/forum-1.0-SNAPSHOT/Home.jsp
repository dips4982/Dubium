<%-- 
    Document   : Teacher_Home
    Created on : 29-May-2020, 5:08:16 PM
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


        <%
            if (session.getAttribute("username") == null || session == null) {
                response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
                response.setHeader("Progrma", "no-cache");
                response.setHeader("Expiers", "0");
                response.sendRedirect("signup.jsp");

            }
        %>





        <form  action="askques" method="POST">
            <div class="wrapper wrapper--w900">
                <div class="card card-6">

                    <div class="card-heading">
                        <h2 align="center" class="title">WELCOME !!! ID NO. ${username}</h2>
                        <h2 class="title">POST YOUR QUESTION</h2>

                    </div>
                    <div class="card-body">
                        <form method="POST">

                            <div class="form-row">
                                <label for="id"><b>Faculty  </b></label>
                                <select name="teacher_id">
                                    <c:forEach items="${teacherList}" var="item">
                                        <option value="${item.id}">${item.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-row">
                                <label for="ques"><b>ENTER QUESTION</b></label>
                                <div class="value">
                                    <div class="input-group">
                                        <input type="text" placeholder= "   Enter Question" name="ques" required>
                                    </div>
                                </div>
                            </div>

                    </div>
                    <div class="card-footer">
                        <button class="btn btn--radius-2 btn--blue-2" type="submit">SUBMIT QUESTION</button>
                    </div>
                </div>
            </div>


            <!-- Jquery JS-->
            <script src="vendor/jquery/jquery.min.js"></script>


            <!-- Main JS-->
            <script src="js/global.js"></script>
        </form>


        <form action="showq" method="POST">
            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    <div class="card-heading">

                        <h2 class="title">Click to Show Question and Answer</h2>

                    </div>


                    <div class="card-footer">
                        <button class="btn btn--radius-2 btn--blue-2" type="submit">SHOW QUESTION AND ANSWERS</button>
                    </div>
                </div>
            </div>


            <!-- Jquery JS-->
            <script src="vendor/jquery/jquery.min.js"></script>


            <!-- Main JS-->
            <script src="js/global.js"></script>
        </form>

        <form  action="UpdatePass_std.jsp" method="POST">
            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    
                    <div class="card-footer">
                        <button class="btn btn--radius-2 btn--blue-2" type="submit">UPDATE PASSWORD</button>
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