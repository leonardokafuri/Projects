<!DOCTYPE html>
<html>
<head>
  <title>Memeber Insert Results</title>
</head>
<h1>Insert Record</h1>
<body>
<?php
require('header.php'); // requiring the header and background of the webpage 
echo "<h2>Task 1</h2>";
$userFname = $_POST['fname'];
$userLname = $_POST['lname'];
$userEmail= $_POST['Email'];
$userPhone = $_POST['phone'];
$userPassword =$_POST['password'];
//getting the user input that will be inserted into the database 

	if (!$userFname || !$userLname  || !$userEmail || !$userPhone || !$userPassword)
	{
       echo "<p>You have not entered all the required details.<br />
             Please go back and try again.</p>";
        echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
        echo "<a href='task1.html'>Try again </a>";   
        // if any of the fields are not set, show error message and exit the program  
    exit;
    }
    
    @$db = new mysqli('localhost', 'event', 'event123', 'member'); //connecting to the database 
    
    if (mysqli_connect_errno()) {
       echo "<p>Error: Could not connect to database.<br/>
             Please try again later.</p>"; // if can't connect to the databse, show an error message will show' 
             echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
             echo "<a href='task1.html'>Try again </a>";
       exit;
    }
 	  $query = "INSERT INTO Member(FirstName,LastName,Email,Cell,Password) VALUES("."'".$userFname."',"."'".$userLname."',"."'".$userEmail."',"."'".$userPhone."',"."'".$userPassword."'".");";
     $stmt = $db->prepare($query);
      //query will insert the data into the database and assign an unique Member ID for the user
    $checkRepeat = "SELECT Email  FROM Member"; // i am using the email as an foreign key in order to check if 
    // the email entered has already being registerd 
    $stmt2 = $db->prepare($checkRepeat);
    $stmt2->execute();
    $stmt2->store_result();
    
    $stmt2->bind_result($dbEmail);
	 while($stmt2->fetch()) {
      if($dbEmail==$userEmail)
      {
	 	echo "Email already registered <br /> <br />";
	 	echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
        echo "<a href='task1.html'>Try again </a>";
        //each user will have their own email and wont be able to register the same email twice, if they try 
        //show an error message and exit the program
        exit;
	  }
    }
      if(!$stmt->execute()) echo $stmt->error;
      //if the email is not on the database, execute the query and insert user data into the database
    
    if ($stmt->affected_rows > 0) {
        echo  "<p>User inserted into the database.</p>"; 
       $query2 = "SELECT MemberID FROM Member WHERE Email ='$userEmail'and Password ='$userPassword';";
        $stmt = $db->prepare($query2);
        if(!$stmt->execute()) echo $stmt->error;
        $stmt->store_result();
        $stmt->bind_result($uniqueID);
		while($stmt->fetch())
		{
	      echo "<p>Your unique MemberID is : <strong>".$uniqueID."</strong> <br/> Please dont forget it! </p>";
	      //after the user is inserted, the page will display an message saying it was inserted 
	      // and display their unique id so they can add, update or delete their record based on it
    	}
    } else {
        echo "<p>An error has occurred.<br/>
              The user was not added.</p>";
    }
    
    $db->close();
    
?>
</body>
<a href="home.html">Return to home page</a> &nbsp; &nbsp; 
<a href="task1.html">Add another record</a>
</html>