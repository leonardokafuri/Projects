<?php
$name = $_POST['name'];
$age = $_POST['age'];
$addrs = $_POST['addrs'];
$city = $_POST['city'];
$date = date('H:i, jS F Y');
?>

<!DOCTYPE html>
<html>
  <head>
    <title>Information Saving</title>
  </head>
  <body>
    <h1>Info processing</h1>
    <h2> Results</h2> 
    <img src="../ch03/steering_wheel.png" width="250" />
    
    <?php 
	echo "<p>Information processed at ";
    echo date('H:i, jS F Y');
    echo "</p>";
    
    
   $string = $date."\t".$name."\t".$age."\t".$city."\t".$addrs."\n";
   
    @$fp=fopen('information.txt', 'ab');
    if(!$fp)
    {
		echo "<p> <strong> Sorry we couldnt process your information, please try again later :( </strong> </p>";
		exit;
	}
    
    flock($fp, LOCK_EX);
    fwrite($fp,$string, strlen($string));
    flock($fp,LOCK_UN);
    fclose($fp);
    echo "<p> <strong> Information processed </strong> </p>";
    ?>
    <a href="Example3.php">Click here to read all informations saved!</a>
   </body> 
   
 </html>