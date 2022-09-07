<?php
session_start();
 
require_once "connection.php";
 
if(isset($_SESSION['user_id'])!="") {
    header("Location: dashboard.php");
}
 
if (isset($_POST['login'])) {
    $email = mysqli_real_escape_string($conn, $_POST['email']);
    $password = mysqli_real_escape_string($conn, $_POST['pass']);
 
    if(!filter_var($email,FILTER_VALIDATE_EMAIL)) {
        $email_error = "Please Enter Valid Email ID";
    }
    if(strlen($password) < 6) {
        $password_error = "Password must be minimum of 6 characters";
    }  
 
    $result = mysqli_query($conn, "SELECT * FROM users WHERE email = '" . $email. "' and pass = '" . md5($password). "'");
   if(!empty($result)){
        if ($row = mysqli_fetch_array($result)) {
            //$_SESSION['user_id'] = $row['uid'];
            $_SESSION['user_name'] = $row['name'];
            $_SESSION['user_email'] = $row['email'];
            //$_SESSION['user_mobile'] = $row['mobile'];
            header("Location: dashboard.html");
        } 
    }else {
        $error_message = "Incorrect Email or Password!!!";
    }
}
?>

<html>
<head>
<title>
Main Page
</title>
<link rel="stylesheet" href="styles.css"/>
</head>
<body>
<!--The center tag needs to be removed for a more efficient method"-->

<center>
<h1 class="main-title">
Welcome to Lifeline
</h1>

<form action="/action.php">
<input type="text" placeholder="E-mail" class="input-class" name="email"/>
<br><br>
<input type="password" placeholder="Password" class="input-class" name="pass"/>

<br><br>
<!--<input type="submit" class="submit-class" name="signup" value="Submit">-->
<button class = "submit-class">
    <a href="dashboard.html">
    Sign in

</a>
</button>
<br><br>
<button class="submit-class">
<a href="registration.php">
Sign-up
</a>
</button>
</form>

</center>
</body>
</html>