<%-- 
    Document   : registration
    Created on : Apr 24, 2020, 4:32:42 PM
    Author     : adesh
--%>

<%-- 
    Tasks to be performed:
    Designing
    Bootstrap and css
    Form validation

--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
        
          <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

    <!-- Main CSS-->
    <link href="CSS/main_1.css" rel="stylesheet" media="all">
    
     <style>
        body  {
          background-image: url("images/sad.jpg");
        }
        .fg
        {
            display:inline-block;
            float:left;
            white-space: nowrap;
/*            overflow-x: auto;
            overflow-y: hidden;*/
        }
        </style>
         <script language = "Javascript">

function emailcheck(str) {

var at="@"
var dot="."
var lat=str.indexOf(at)
var lstr=str.length
var ldot=str.indexOf(dot)
if (str.indexOf(at)==-1){
alert("Invalid E-mail ID")
return false
}

if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr){
alert("Invalid E-mail ID")
return false
}

if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr){
alert("Invalid E-mail ID")
return false
}

if (str.indexOf(at,(lat+1))!=-1){
alert("Invalid E-mail ID")
return false
}

if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
alert("Invalid E-mail ID")
return false
}

if (str.indexOf(dot,(lat+2))==-1){
alert("Invalid E-mail ID")
return false
}

if (str.indexOf(" ")!=-1){
alert("Invalid E-mail ID")
return false
}
return true 
}

function ValidateEmail(){
var emailID=document.myForm.email
var password1 = myForm.psw; 
var password2 = myForm.cnfpsw; 
if ((emailID.value==null)||(emailID.value=="")){
alert("Please Enter your Email Address")
emailID.focus()
return false
}
if (emailcheck(emailID.value)==false){
emailID.value=""
emailID.focus()
return false
}
if (password1.value != password2.value) { 
                    password1.value="";
                    password2.value="";
                    alert ("\nPassword did not match: Please try again...") 
                    return false;
                } 
return true
}
</script>
<script>
function myFunction() {
  var x = document.getElementById("myInput");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
function myFunction1() {
  var x = document.getElementById("myInput1");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
    </head>
    <body>
 
<jsp:include page="header.jsp"/>
      <form  action="reg" method="POST" onsubmit="return ValidateEmail()" name="myForm">
          
          <div class="wrapper wrapper--w900">
            <div class="card card-6">
                <div class="card-heading">
                    <h2 class="title">SIGN UP</h2>
                    
                </div>
                <div class="card-body">
                    <form method="POST">
                       
                        <div class="form-row">
                            <div class="name">NAME</div>
                            <div class="value">
                                <input type="text" placeholder="Enter Name" name="name" required>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">EMAIL ADDRESS</div>
                            <div class="value">
                                <div class="input-group">
                                    <input type="text" placeholder="Enter Email" name="email" required>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">STUDENT ID</div>
                            <div class="value">
                                <div class="input-group">
                                     <input type="text" placeholder="Enter StudentID" name="id" required>
                                </div>
                            </div>
                        </div>
                            <div class="form-row">
                            <div class="name">PASSWORD</div>
                            <div class="value">
                                <input type="password" id="myInput" placeholder="Enter Password" name="psw" required><br><br>
                                <span class="fg"><input type="checkbox" onclick="myFunction()">Show Password </span>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="name">CONFIRM PASSWORD</div>
                            <div class="value">
                                <div class="input-group">
                                    <input type="password" id="myInput1" placeholder="Enter Password" name="cnfpsw" required><br><br>
                                    <span class="fg"><input type="checkbox" onclick="myFunction1()">Show Password </span>
                                </div>
                            </div>
                        </div>
                        
                         <div class="card-footer">
                             <p>By creating an account you agree to Doubt Forum's <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
                            
                </div>
                      
                </div>
                <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit">SIGN UP</button>
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
