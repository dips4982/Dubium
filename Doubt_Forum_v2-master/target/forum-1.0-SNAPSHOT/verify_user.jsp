<%-- 
    Document   : verify_user
    Created on : May 22, 2020, 4:12:31 AM
    Author     : adesh
--%>


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

  
  <form  action="signup_public_ans" method="POST">
      
       <div class="wrapper wrapper--w900">
            <div class="card card-6">
                <div class="card-heading">
                    <h2 class="title">Login before Answering a Doubt</h2>
                </div>
                <div class="card-body">
                    <form method="POST">
                        <div class="form-row">
                            <div class="name">User ID</div>
                            <div class="value">
                                <input type="text" placeholder="Enter User-id" name="uname" required>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">PASSWORD</div>
                            <div class="value">
                                <div class="psw">
                                     <input type="password" placeholder="Enter Password" name="psw" required>
                                </div>
                            </div>
                        </div>
                    
                </div>
                <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit">LOGIN</button>
                    
                    </form>
                    
                </div>
                
            </div>
           
        </div>
      
      <form  action="regis.jsp" method="POST">
           <div class="wrapper wrapper--w900">
            <div class="card card-6">
                <div class="card-heading">
                    <h2 class="title">New User?? </h2>
                </div>
                
                <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit">SIGNUP</button>
                    </form>
                                       
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


