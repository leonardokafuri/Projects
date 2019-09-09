<!--Name : Leonardo Kafuri 
Student id: 300265732
Assignment 1-->
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
$drink = $_POST['dcheck']; // will check for fries and drink ordered 

$paymentType = $_POST['pay'];
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
    echo  'Fries : ' , $fries , "<br/ >";
    echo  'Drink : ' , $drink , "<br/ >";
    // will display all the basic information about the order made


	define('dbdbPriceCheese', 7.25);
	define('dbdbPriceNoCheese',6.25);
	define('ChesseburguerPrice', 5.75);
	define('HambugerPrice', 4.75);
	define('ComboPrice', 2.50);

	define('FriesSmall', 1.50);
	define ('FriesMedium', 1.75);
	define ('FriesLarge', 2.00);
	
	define ('DrinkSmall', 1.50);
	define ('DrinkMedium' ,1.75);
	define ('DrinkLarge', 2.00);  // Define the values for the menu items prices 
	
	$taxrate = 0.07; // tax is 7% of total
	
	$totalamount = 0.00;
	$dbdbpricet = 0.00;
	$chsbgpricet=0.00;
	$hambgpricet= 0.00;
	$friespricet= 0.00;
	$drinkpricet = 0.00; // created variables to hold the total price of each item and will add them later to achieve the subtotal
    
    // calculate the price with the combos and cheese for double doubles  
    if ($doublecb == "nocheese")
    {
   		$dbdbpricet = $dbdb * dbdbPriceNoCheese; // getting the amount of burgers and mutiplying by the price 
   		
   		
   	}else if ($doublecb == "Chesse")
   	{
		$dbdbpricet = $dbdb * dbdbPriceCheese;
		
	}else if ($doublecb == "Cheesecb")
	{
		$dbdbpricet = ($dbdb * dbdbPriceCheese) + (ComboPrice*$dbdb);
		// since all the burgers will be the same, i am mutiplying how many burgers times price and adding with the amount of burguers
		// mutipled by the price of combos ,if combo selected.
		if ($dbdbpricet == 2.50)
		{
			$dbdbpricet = 0;
			//Created a if statment that in case a user has selected 0 burguers 
			//and the combo option was selected by mistake the price for the burguer would still count as 0
			// and not add an extra 2.50 charge on the total
			// did this for every combo option
		}
	}
	else if($doublecb == "nocheesecb")
	{
		$dbdbpricet = ($dbdb * dbdbPriceNoCheese) + (ComboPrice* $dbdb);
		if($dbdbpricet == 2.50)
		{
			$dbdbpricet = 0;
		}
		
	}
    //end of doube double check 
    
    //cheeseburguer check
    if ($cheesecb == "chesseNocombo")
    {
    	$chsbgpricet = $chsbg *ChesseburguerPrice ;
   	
   	}else if ($cheesecb == "cheeseCombo")
   	{
		$chsbgpricet = ($chsbg * ChesseburguerPrice) + (ComboPrice *$chsbg); ;
		if($chsbgpricet == 2.50)
		{
			$chsbgpricet = 0;
		}
			
	}
	// end of cheeseburguer check 
	
	//hamburguer check
	if($hamcb == "hamNoCombo")
	{
		$hambgpricet = $hambg * HambugerPrice;
		
	}else if ($hamcb == "hamCombo")
	{
		$hambgpricet = ($hambg * HambugerPrice) + (ComboPrice * $hambg);
		if($hambgpricet == 2.50)
		{
			$hambgpricet = 0;
		}	
		
	}
	// end of hambuger check 
    
    //fries check
    if($fries == "No Fries")
    {
    	$friespricet = 0;
   		
   	}else if($fries =="Small")
   	{
		$friespricet = FriesSmall;
		
	}else if($fries == "Medium")
	{
		$friespricet = FriesMedium;
	}else if($fries == "Large")
	{
		$friespricet = FriesLarge;
	}
	//end of fries check 
	
	//drink check
	if($drink == "No Drink")
    {
   		$drinkpricet = 0;
   	}else if($drink == "Small")
   	{
		$drinkpricet = DrinkSmall;
		
	}else if($drink == "Medium")
	{
		$drinkpricet = DrinkMedium;
	}else if($drink == "Large")
	{
		$drinkpricet = DrinkLarge;
	}  
	// end of drink check 

    
    $totalamount = $dbdbpricet + $chsbgpricet + $hambgpricet + $friespricet + $drinkpricet; // added the total for each item and get the subtotal of the order
    
    echo "<br />";
    echo "Subtotal : $".number_format($totalamount,2)."<br />"; // display subtotal in number format with 2 zeros after the comma 
    
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
	?>
	<br />
	<a href="orderform.html">Click here to make another order!</a> <!-- Link to orderform.html -->
</body>
</html>