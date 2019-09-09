<!DOCTYPE html>
<html>
<head>
  <title>Memeber Delete  Results</title>
  <h1>Delete Record</h1>
</head>
<body>
<?php
session_start();//starting a session that will hold memberID 
require('header.php');
echo "<h2>Task 4</h2>";
$memberDel;
if(isset($_POST['deletebtn'])) // Running if statement when the form is submitted
{
	if(isset($_SESSION['MemberIDDel']))
	{
		$memberDel = $_SESSION['MemberIDDel']; //setting the session value to a variable
		deleteRecord($memberDel);//running the function passing the memeberid as an paramenter
		unset($_SESSION['MemberIDDel']); //unsetting the session
 		session_destroy();//destroying the session
	}else{//if the session wasn't set show error message and exit program 
		echo "<p>Something went wrong</p>";
		echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
        echo "<a href='task4.html'>Try again </a>";
   		exit;
	}
	echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
    echo "<a href='task4.html'>Delete a different record</a>";
	exit;
}
$userID = $_POST['id']; //getting the user id

	if(!$userID)
	{
		 echo "<p>You have not entered all the required details.<br />
             Please go back and try again.</p>";
         echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
         echo "<a href='task4.html'>Try again </a>";
    exit;
	}
 @$db = new mysqli('localhost', 'event', 'event123', 'member'); //connecting to the database 
 
 	if (mysqli_connect_errno()) {
       echo "<p>Error: Could not connect to database.<br/>
             Please try again later.</p>"; // if can't connect to the databse, show an error message will show
       echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
       echo "<a href='task4.html'>Try again </a>";        
       exit;
    }
    
    $query = "SELECT * FROM Member WHERE MemberID = $userID";// getting all the user information
    $stmt = $db->prepare($query);
    $stmt->execute();
    $stmt->store_result();
     
     if($stmt->num_rows > 0)
     {
		echo "<p>Number of users found: ".$stmt->num_rows."</p>";
	 }else{
		echo "<p>Member record not found </p>";
		echo "<a href='home.html'>Return to the home page </a>  &nbsp; &nbsp;";
        echo "<a href='task4.html'>Try again </a>";
        exit;
	}
    
    
    $stmt->bind_result($iddb,$userFname,$userLname,$userEmail,$userPhone,$userPassword);
    echo "<form method='POST'>";
	 while($stmt->fetch()) { // displaying the user information that can be deleted
	  echo "<p><strong>Member ID : </strong>".$iddb;	
      echo "<br /><strong>First Name: </strong>".$userFname;
      echo "<br /><strong>Last Name: </strong>".$userLname;
      echo "<br /><strong>Email: </strong>".$userEmail;
      echo "<br /><strong>Phone: </strong>".$userPhone;
      echo "<br /><strong>Password: </strong>".$userPassword ."</p>";
      $_SESSION['MemberIDDel']=$iddb;//setting the session value to the userid form the database
    }
	echo "<br />";
	echo '<input type="submit" value="Delete Record" name ="deletebtn"/> &nbsp; &nbsp;';
	echo "<a href='task3.html'>Update Record</a>";
	echo "</form>";
    $stmt->free_result();
    $db->close();//closing database from retriving the data
    
    function deleteRecord($id)
    {
    		@$db = new mysqli('localhost', 'event', 'event123', 'member'); //connecting to the database 
	 	if (mysqli_connect_errno()) {
	       echo "<p>Error: Could not connect to database.<br/>
	             Please try again later.</p>"; // if can't connect to the databse, show an error message will show
	       echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
	       echo "<a href='task4.html'>Try again </a>";        
	       exit;
	    }
	    
	    $query = "DELETE FROM Member WHERE MemberID = $id";//deleting all the records from the users that has
	    //the id passed on the parementer 
	    $stmt = $db->prepare($query);
	    $stmt->execute();
		echo "Record Deleted successfully <br /> <br />";
		$db->close();//closing database from deleteing record
    }
?>		
</body>
<br/ > <br />
<a href="home.html">Return to home page</a>	 &nbsp; &nbsp;
<a href="task4.html">Delete a different record</a>
</html>