<%-- 
    Document   : Admin_Home
    Created on : 12-Jun-2020, 11:50:43 pm
    Author     : Sanchita
--%>

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
return true
</script>

    </head>
    <body>

        <form action="InsertFacultyData" method="POST" onsubmit="return ValidateEmail()" name="myForm">

            <div class="wrapper wrapper--w900">
                <div class="card card-6">
                    <div class="card-heading">
                        <h2 class="title">ENTER FACULTY DATA</h2>                      
                    </div>
                    <div class="card-body">

                        <div class="form-row">
                            <div class="name">NAME</div>
                            <div class="value">
                                <input type="text" placeholder="Enter name" name="name" required>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="name">User ID</div>
                            <div class="value">
                                <input type="text" placeholder="Enter faculty-id" name="id" required>
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
                        <div class="form-row">
                            <div class="name">E-MAIL</div>
                            <div class="value">
                                <div class="psw">
                                    <input type="text" placeholder="Enter e-mail id" name="email" required>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn--radius-2 btn--blue-2" type="submit">SUBMIT </button>
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
