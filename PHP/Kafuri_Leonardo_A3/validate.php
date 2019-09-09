<?php
class Validate
{
	function checkName($name,&$checkname)
	{	
		$checkname = preg_match("/^([a-zA-Z]*)\ {1}([a-zA-Z]*)$/",$name);
		//regular expression that only contains letters from a-z lowercase or A-Z uppercase then shold contain one space 
		//and then letters from a-z and no more than 20 characters
		if(strlen($name)>20)
		{
			echo "Your name input should not be longer than 20 characters </td>";
			echo '<td><a href="home.php">Try again</a> </td> </tr>';
		}else 
		{
			if($checkname == true)
			{
			  echo "Name is valid </td>";
			  echo '<td> <img src="correct.png" alt="Correct image" height="20" width="20" /> </td> </tr>';
			}
			else if ($checkname == false)
			{	
			  echo "The name field should only contain letters and one white space </td>";
		      echo '<td> <img src="error.png" alt="error image" height="28" width="28" /> </td>';
		      echo '<td><a href="home.php">Try again</a></td> </tr>'; 
			}
		}
	}

	function checkzip($zip, &$checkzip)
	{
		//function to check if postal code is valid
		$checkzip = preg_match("/^([A-Z]\d[A-Z])\ {1}(\d[A-Z]\d)$/",$zip);

		//regular expression that must contains A-Z caps, /d which is a digit 0-9, A-Z Caps again, then should contain one space 
		//and follow by a digit 0-9, a letter in caps and a digit
		if(strlen($zip)<7)
		{
			echo "Your postal code should be at least 7 characters </td>";
			echo '<td> <img src="error.png" alt="error image" height="28" width="28" /> </td>';
			echo '<td><a href="home.php">Try again</a></td> </tr>';
		}
		else
		{
			if($checkzip == true)
			{
			  echo "Postal Code is valid </td>";
			  echo '<td> <img src="correct.png" alt="Correct image" height="20" width="20" /> </td> </tr>';
			}
			else if ($checkzip == false)
			{	
			  echo "Your postal code should only contain numbers and upper case letters, and be of the format A0A 0A0 </td> "; 
		      echo '<td> <img src="error.png" alt="error image" height="28" width="28" /> </td>';
		      echo '<td><a href="home.php">Try again</a></td></tr>';
			}	
		}
		
	}

	function checkusername($usrname, &$checkusername)
	{
		//function to check if username is valid
		$checkusername = preg_match("/^([a-zA-Z])(\S\w*)$/",$usrname); 
		//User name must begin with a letter or number not contain any white spaces(\S) and after it can contain letters or periods and underscore (\w)
		
		if(strlen($usrname)<6 || strlen($usrname)>10)
		{
			echo "Your username should be at least 6 characters and maximum 10 characters </td>  ";
			echo '<td><a href="home.php">Try again</a></td>';
			echo '<td> <img src="error.png" alt="error image" height="28" width="28" /> </td> </tr>';
		}
		else{
			if($checkusername == true)
			{
			  echo "Username is valid </td>";
			  echo '<td> <img src="correct.png" alt="Correct image" height="20" width="20" /> </td> </tr>';
			}
			else if ($checkusername == false)
			{	
			  echo "Your username can't be entirely numeric, have any white spaces, start or end with period or underscore and it must  be at least 6 characters </td> "; 
			   echo '<td> <img src="error.png" alt="error image" height="28" width="28" /> </td>'; 
		      echo '<td><a href="home.php">Try again</a></td></tr>';
			}	
		}
	}
}

// read about use and more understading about regular expressions here: 
// https://www.tutorialspoint.com/php/php_regular_expression.htm


?>