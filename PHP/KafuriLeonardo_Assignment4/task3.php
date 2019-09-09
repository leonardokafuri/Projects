<html>
<title>Update Records </title>
<h1>Update Record</h1>
<?php
 session_start(); // i am starting a session in order to save the member ID of user to be updated 
require('header.php');
echo "<h2>Task 3</h2>";
$member;
if(isset($_POST['updatebtn']))//when the user submits the form the page will be reset and will run if statement
{
	if(isset($_SESSION['MemberID'])) // if the MemeberID session was set to a MemberID variable
	{
		$member = $_SESSION['MemberID']; //save the id to a variable
		updateRecord($member); // run the function and pass the variable as an paramenter to the function
		unset($_SESSION['MemberID']); // unsetting the session value 
 		session_destroy(); // destroying the session 
	}else{
		echo "<p>Something went wrong</p>";
		echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
        echo "<a href='task3.html'>Try again </a>";
    	exit;
	}
	echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
    echo "<a href='task3.html'>Update a new record</a>";
	exit;
}
$userID = $_POST['id'];//getting the user id from the html form

  if(!$userID)
	{
		 echo "<p>You have not entered all the required details.<br />
             Please go back and try again.</p>";
        echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
        echo "<a href='task3.html'>Try again </a>";
    exit;
	}
 @$db = new mysqli('localhost', 'event', 'event123', 'member'); //connecting to the database 
 
 	if (mysqli_connect_errno()) {
       echo "<p>Error: Could not connect to database.<br/>
             Please try again later.</p>"; // if can't connect to the databse, show an error message will show
        echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
        echo "<a href='task3.html'>Try again </a>";
       exit;
    }
    
    $query = "SELECT * FROM Member WHERE MemberID = $userID"; // selecting all the information from the user
    //based on their unique ID
    $stmt = $db->prepare($query);
    $stmt->execute();
    $stmt->store_result();
     
     if($stmt->num_rows > 0)
     {
		echo "<p>Number of users found: ".$stmt->num_rows."</p>";
	 }else{
		echo "<p>Member record not found </p> </br>"; 
		 echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
        echo "<a href='task3.html'>Try again </a>";
        exit;
	}
    
	echo "<form method='POST' >"; //Creating a from that will get the new input and update on the database
    $stmt->bind_result($id,$userFname,$userLname,$userEmail,$userPhone,$userPassword);
	 while($stmt->fetch()) {//displaying the infromation into input fields so they can be updated	
	  echo 'Member ID : <input type="text" name"memberid" size="3" value="'.htmlspecialchars($id).'"readonly> <br/>';
	  $_SESSION['MemberID']=$id; // while fetching the memberId save it on the session so it can be accessed 
	  echo 'First Name :  <input type="text" name="newFname" value="' . htmlspecialchars($userFname).'"> <br />';
	  echo 'Last Name : <input type="text" name="newLname" value="' . htmlspecialchars($userLname).'"> <br />';
	  echo 'Email : <input type="text" name="newEmail" value="' . htmlspecialchars($userEmail).'"> <br />';
	  echo 'Phone Number : <input type="text" name="newPhone" value="' . htmlspecialchars($userPhone).'"> <br />';
	  echo 'Password : <input type="password" name="NewPassword" value="' . htmlspecialchars($userPassword).'">';
    }
      echo "<br /> <br />";
	  echo '<input type="submit" value="Update Records" name ="updatebtn"/>';
	  echo "&nbsp; &nbsp;"; 
	  echo "<a href='task4.html'>Delete Record</a>"; // i just added a link to the delete page because
	  //othewise the insert and delete page would be pretty much the same functionality 
	  //so instead i created a specific page for each so you can see the differences for task 3 and 4
	  echo "</form>";
	  $stmt->free_result(); 
      $db->close(); // closing the database that was open to read the user data
        
     function updateRecord($id) 
     {
     	@$db = new mysqli('localhost', 'event', 'event123', 'member'); //connecting to the database 
 
	 	if (mysqli_connect_errno()) {
	       echo "<p>Error: Could not connect to database.<br/>
	             Please try again later.</p>"; // if can't connect to the databse, show an error message will show
	        echo "<a href='home.html'>Return to the home page </a> &nbsp; &nbsp;";
	        echo "<a href='task3.html'>Try again </a>";
	       exit;
	    }
     	
     	$newFname =$_POST['newFname'];
     	$newLname =$_POST['newLname'];
     	$newEmail =$_POST['newEmail'];
     	$newPhone =$_POST['newPhone'];
     	$newPass =$_POST['NewPassword']; // fetching the information from the form that is displayed
     	
	   $query = "Update Member SET FirstName=" . "'" .htmlspecialchars($newFname)."'" . ",
	   LastName=" . "'". htmlspecialchars($newLname)."'" . ",
	   Email=" . "'". htmlspecialchars($newEmail)."'" . ",
	   Cell=" . "'". htmlspecialchars($newPhone)."'" . ",
	   Password=" . "'". htmlspecialchars($newPass)."'" . "
	   WHERE MemberID= $id;"; // query to update each of the fields from specific user
       $stmt = $db->prepare($query);
       if(!$stmt->execute()) echo $stmt->error; 
       echo "Your Information was updated sucessfully <br /> <br />";
      $db->close();// closing the database that was open to update the information
	 }
?>
<a href="home.html">Return to home page</a> &nbsp; &nbsp;
<a href="task3.html">Update a different record</a>
</html>