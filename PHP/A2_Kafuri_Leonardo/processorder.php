<!--Name : Leonardo Kafuri 
Student id: 300265732
Assignment 2-->
<?php
//variables for the inputs on orderform 
$cname = $_POST['cname'];
$phone = $_POST['phone'];
$dbdb = $_POST['doubledouble'];
$chsbg = $_POST['cheesebg'];
$hambg = $_POST['hambug']; // will hold the values for amount of each item ordered 

$doublecb = $_POST['dbcheck'];
$cheesecb = $_POST['chscheck'];
$hamcb = $_POST['hcheck']; // Will hold the value of the dropdown list to check if users selected for a combo or not

$fries = $_POST['fchceck'];
$drink = $_POST['dcheck']; 
$ffordered = $_POST['fries'];
$drordered = $_POST['drink'];// will check for fries and drink ordered 

$paymentType = $_POST['pay'];
$time = date('H:i, jS F Y');
//$document_root = $_SERVER['DOCUMENT_ROOT']; //windowns 
?>
<!DOCTYPE html>
<html>
<head>
	<title>In-N-Out Burger Order Confirmation</title> 
</head>
<style>
		body {background-color: coral;}
</style>
	<img src="Images/banner.jpg">
<body>
	<h2>Order Summary</h2>
	<?php 
	echo "<p>Order processed at ";
	echo $test;
    echo date('H:i, jS F Y'); // will display the time that the order was processed
    echo "</p>";
    
    echo '<p><strong>Your information is as follows: </strong></p>';
    echo 'Name : ', $cname , '<br />';
    echo 'Phone : ' , $phone ," <br />";
    echo 'Payment Type: ', $paymentType , "<br />"; 
    echo "<br />";

	
	echo '<p><strong>Your order is as follows:</strong> </p>';
    echo 'Double double : ' ,$dbdb , "<br />";
    echo 'Cheeseburgers : ' , $chsbg, "<br />";
    echo 'Hambugers : ' , $hambg, "<br />";
    
    if ($fries == "One size")
    {
   	echo  'Fries : ',$ffordered , "<br/ >";
   	//if the user selects one size fries it will display the amount of it ordered 
   	}else
   	{
		echo  'Fries : ',$fries , "<br/ >";
		// if user chooses No fries will display no fries even if they have put a number on the form
	}
    
    if($drink == "One size")
    {
   		echo  'Drinks : ',$drordered,"<br/ >";
   		//if the user selects one size drinks it will display the amount of it ordered 
   	}else
   	{
		echo  'Drinks : ', $drink , "<br/ >";
		// if user chooses No drink will display no drink even if they have put a number on the form
	}    
    // will display all the basic information about the order made
    # *******************************************************************************************************************************************
	$taxrate = 0.07; // tax is 7% of total
	$totalamount = 0.00;
	$dbdbpricet = 0.00;
	$chsbgpricet=0.00;
	$hambgpricet= 0.00;
	$friespricet= 0.00;
	$drinkpricet = 0.00; // created variables to hold the total price of each item and will add them later to achieve the subtotal
		
	$menu= file("files/menu.txt"); // read the file data to a var
	$menuitems = count($menu); //cont each line of the file 
	for($i=0; $i<$menuitems; $i++) // loop through the file
	{
		$line = explode(",", $menu[$i]);// explode the file with the comma dilimiter
		
        $line[1] = doubleval($line[1]); // getting all the double variables written into the menu.txt file 
        
      	if($i==0)
     	  {
     	  	if($dbdb>0)
	  	 	$dbdbpricet = $line[1] * $dbdb; 
	  	 	else
	  	 	$dbdb=0;
	  	 	//When its on the 1st line of the file , the $line[1] will hold the value for the double double price, so i will get the price and mutiply by 
	  	 	// the quatity ordered 
	  	  } 
	  	if($i==1)
	  	  {
	  	  	if($chsbg>0)
			$chsbgpricet = $line[1] * $chsbg;
			else
			$chsbg=0;	
			// when its one the 2nd line of the file  $line[1] will hold the cheesebuger price, which will be multiplied by the amount of it ordered
		  }
	   if($i==2)
	      {
	      	if($hambg>0)
		  	$hambgpricet =  $line[1] * $hambg;
		  	else
		  	$hambg =0;
		  	//when its on the 3rd line of the file  $line[1] will hold the value for the hamburger price, which will be mutiplied by the amount of it ordered 
		  }
	   if($i==3)
	      {
	      	//when the file reaches the 4th line and has the price for fries, the php will check if the user has selected the one size fries 
	      	//if they did, they price will be mutiplied by the amount of fries they wanted to order 
	      		if($fries == "One size")
					$friespricet = $line[1] *$ffordered;
				else
					$ffordered =0;
					// if not the amount of fries will be set to 0  so when the file is written it contains 0 fries on it
		  }
	   if($i==4)
	      {
	      	// when the file has reached the last line and has the drink price, php will check if the user has selected a one size drink 
	      	// if they did will multiply the price of the drink with the amount of drinks ordered
		  	if($drink =="One size")
				$drinkpricet = $line[1] * $drordered;
			else
				$drordered =0;
				// if not will set the price of the drinks to 0
		  }
		
	}
	
    $discount= 0;
    $totalamount = $dbdbpricet + $chsbgpricet + $hambgpricet + $friespricet + $drinkpricet; // added the total for each item and get the subtotal of the order
    if($paymentType =="Cash")
    {
		$discount = $totalamount *0.05;
		$totalamount = $totalamount - $discount;
		// if user is paying in cash will receive 5% off before tax
	}else
	{
		$discount = 0;
		
	}
    echo "<br />";
    echo "Subtotal : $".number_format($totalamount,2)."<br />"; // display subtotal in number format with 2 zeros after the comma 
    echo "Discount: $".number_format($discount,2)."<br />";
    $totalamount = $totalamount *(1+$taxrate); // get the subtotal and mutiply by the tax rate to get the total
    echo "Total including taxes is : $".number_format($totalamount,2)."<br />"; 
    
    
    $date = date('H:i, jS F Y');
	$date = strtotime($date);
	$date = strtotime("+15 minute", $date);
	echo "<p> Your order will be available to pick up at : " , "<br/>";
	echo date('H:i, jS F Y', $date);
	echo "</p>";

	// read about how to use the strtotime on https://www.w3schools.com/php/func_date_strtotime.asp
	// the strtotime will take the current time that is allocated on the variable $date and will add +15 minutes to it , since its syntax is "strtotime(time,now);"  
	# *******************************************************************************************************************************************
	
    	$outputstring = $time.", Name: ".$cname.","." phone: ".$phone.", paymentType: ".$paymentType.",".$dbdb." double-double ,".$chsbg." cheeseburger,"
                      .$hambg." hamburger ,\$".number_format($totalamount,2)
                      ." ,".$ffordered." fries,".$drordered." drinks\n";
    	// the outputstring will hold all the variables and save as a string that will be written into the file
	

	@$fp = fopen("files/orders.txt", 'ab'); // macOS
    //@$fp = fopen("$document_root/../files/orders.txt", 'ab'); //windowns 
    //opening the file from the folder that will be written on
       if (!$fp) {
         echo "<p><strong> Your order could not be processed at this time.
               Please try again later.</strong></p>";
         exit;
         //if the file can't be written give an error message'
       }
       flock($fp, LOCK_EX);//lock the file exclusive 
       fwrite($fp, $outputstring, strlen($outputstring)); // write into the file
       flock($fp, LOCK_UN);//unlock the file
       fclose($fp); // close the file 
       echo "<p>Order Processed.</p>"; // have a order Processed message so user knows the file has been written	
    # *******************************************************************************************************************************************
       
       echo "<p> <strong> Your order contains </strong> </p>";
       echo "<table> <tr>";
      for($i=0; $i<$menuitems; $i++) // loop through the file
		{
    	$img = explode(",", $menu[$i]);// explode the file with the comma dilimiter
    	// on the menu.txt i have the pictures as "Images/imgName.png"  instead of "imgName.png" because i saved other images  into this folder i originally had from assigment 1 
    	//so all file types are organized as such
    	
		if($i==0)
		{ 
			if($dbdb >0)
			{
				echo "<td style=\"width: 33%; text-align: center\">";
       	   		echo '<img src="' . $img[2] . '" width="250" height="250" />';
       	   		echo "</td>";
       	   		/*
       	   		If the order has at least 1 double double the picture of it  will be shown on the webpage 
       	   		if it doesnt have any the double double picture wont be shown 
       	   		I did this for each item on the menu and checked if their value was bigger than 0 to display the pictures of only items that were ordered
       	   		*/
			}
		}
		if($i==1)
		{
			if($chsbg >0)
			{
				echo "<td style=\"width: 33%; text-align: center\">";
       	   		echo '<img src="' . $img[2] . '" width="250" height="250" />';
       	   		echo "</td>";
			}
		}
		if($i==2)
		{
			if($hambg>0)
			{
				echo "<td style=\"width: 33%; text-align: center\">";
       	   		echo '<img src="' . $img[2] . '" width="250" height="250" />';
       	   		echo "</td>";
			}
		}
		if($i==3)
		{
			if($ffordered>0)
			{
				echo "<td style=\"width: 33%; text-align: center\">";
       	   		echo '<img src="' . $img[2] . '" width="250" height="250" />';
       	   		echo "</td>";
			}
		}
		if($i==4)
		{
			if($drordered>0)
			{
				echo "<td style=\"width: 33%; text-align: center\">";
       	  		echo '<img src="' . $img[2] . '" width="250" height="250" />';
       	   		echo "</td>";
			}
		}
	} 
	echo "</tr> </table>";
	?>
	<br />
	<a href="orderform.php">Click here to make another order!</a> <!-- Link to orderform.php -->
</body>
</html>