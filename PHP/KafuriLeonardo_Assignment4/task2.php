<!DOCTYPE html>
<html>
<head>
  <title>Memeber Search Results</title>
</head>
<h1>Search Record</h1>
<body>
<?php
require('header.php');
echo "<h2>Task 2</h2>";
$userID = $_POST['id']; // getting the memberid from the form in html

	if(!$userID)
	{
		 echo "<p>You have not entered all the required details.<br />
             Please go back and try again.</p>";
        echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
        echo "<a href='task2.html'>Try again </a>";
    exit;
	}
 @$db = new mysqli('localhost', 'event', 'event123', 'member'); //connecting to the database 
 
 	if (mysqli_connect_errno()) {
       echo "<p>Error: Could not connect to database.<br/>
             Please try again later.</p>"; // if can't connect to the databse, show an error message will show
        echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
        echo "<a href='task2.html'>Try again </a>";
       exit;
    }
    
    $query = "SELECT FirstName, LastName, Email , Cell, Password FROM Member WHERE MemberID = $userID";
    //in order to search for the user personal information, i am searching by their specific MemberID
    $stmt = $db->prepare($query);
    $stmt->execute();
    $stmt->store_result();
     
     if($stmt->num_rows > 0)
     {
		echo "<p>Number of users found: ".$stmt->num_rows."</p>";
	 }else{
		echo "<p>Member record not found </p> </br>"; 
		 echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
        echo "<a href='task2.html'>Try again </a>";
        exit;
	}
    
    
    $stmt->bind_result($userFname,$userLname,$userEmail,$userPhone,$userPassword);
	 while($stmt->fetch()) {
      echo "<p><strong>First Name: </strong>".$userFname;
      echo "<br /><strong>Last Name: </strong>".$userLname;
      echo "<br /><strong>Email: </strong>".$userEmail;
      echo "<br /><strong>Phone: </strong>".$userPhone;
      echo "<br /><strong>Password: </strong>".$userPassword ."</p>";
      //during after the query is executed and stored, the result will be bind and fetched in order to be
      //displayed, I am not displaying the memberID because in theory you need to know the id in order to open 
      //this page to see your information 
    }
      echo "<a href='task3.html'>Update Record</a> &nbsp; &nbsp;";
     echo "<a href='task4.html'>Delete Record</a> &nbsp; &nbsp; ";

    $stmt->free_result();
    $db->close();
?>		
<a href="home.html">Return to home page</a> &nbsp; &nbsp;
<a href="task2.html">Search for another record</a>
</body>
</html>