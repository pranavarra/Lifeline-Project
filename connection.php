<?php
	$hostname="localhost";
	$username="root";
	$password="";
	$dbname="users";
	$conn=mysqli_connect($hostname,$username,$password,"$dbname");
      if(!$conn){
          die('Could not Connect MySql Server:' .mysql_error());
        }
	else{
		//echo("Success");
	}
?>