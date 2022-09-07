<?php
   require_once "connection.php";
   if(isset($_SESSION['user_id'])!="") {
      header("Location: dashboard.php");
    }
    if (isset($_POST['signup'])) {
        $name = mysqli_real_escape_string($conn, $_POST['name']);
        $email = mysqli_real_escape_string($conn, $_POST['email']);
        $password = mysqli_real_escape_string($conn, $_POST['pass']);
        $cpassword = mysqli_real_escape_string($conn, $_POST['cpass']); 
        /*if(!filter_var($email,FILTER_VALIDATE_EMAIL)) {
            $email_error = "Please Enter Valid Email ID";
        }
        if(strlen($password) < 6) {
            $password_error = "Password must be minimum of 6 characters";
        }  */  
        if($password != $cpassword) {
            $cpassword_error = "Password and Confirm Password doesn't match";
        }
      
            if(mysqli_query($conn, "INSERT INTO users(Name, Email, Password) VALUES('" . $name . "', '" . $email . "', '" . md5($password) . "')")) {
             header("location: login.php");
             exit();
            } else {
               //echo "Error: " : "" . mysqli_error($conn);
            }
  
        mysqli_close($conn);
    }
?>

<html>
<head>
<title>
Sign Up
</title>
<link rel="stylesheet" href="styles.css"/>
</head>
<body>

<center>
<h2>
Register
</h2>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>"  method="POST">

<table>
<tr>
<td>
<h3>
Name
</h3>
</td>
<td>
<input type="text" class="input-class" name="name">
</td>
</tr>

<tr>
<td>
<h3>
E-mail
</h3>
</td>
<td>
<input type="text" class="input-class" name="email">
</td>
</tr>

<tr>
<td>
<h3>
Password
</h3>
</td>
<td>
<input type="password" class="input-class" id="p" name="pass">
</td>
</tr>

<tr>
<td>
<h3>
Confirm Password
</h3>
</td>
<td>
<input type="password" class="input-class" id="cp" name="cpass">
<br>
<span class="error-class"><?php if (isset($cpassword_error)) echo $cpassword_error; ?></span>
</td>
</tr>
</table>

<input type="submit" class="submit-class" name="signup" value="Submit">

</form>
</center>

<script>
	/*passTxt = document.getElementById("p");
	confPassTxt = document.getElementById("cp");
	function SignUp(){
		if(passTxt.value == confPassTxt.value){
			PCPCorrFunc();
		}else{
		alert("The password and its confirmatin do not match. Please try again.");
		}
	}
	
	function PCPCorrFunc(){
		
	}*/
</script>
</body>
</html>