<!--Name : Leonardo Kafuri 
Student id: 300265732
Assignment 2-->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>In-N-Out Burger</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<!-- Used the google jquery library to use jquery to hide and show the menu as an image on the click of the button-->
	</head>
	<style>
		body {background-color: coral;}
		.menu{display:none;} /*Created the style for the class menu to be hidden on the opening of the webpage */ 
	</style>
	<body>
	<h1>Welcome to our new online order website</h1>
	<form action="processorder.php" name="foodForm" onsubmit="return errorhandling()" method="post">
	<table>
	<tr>
		<img src="Images/banner.jpg">
	</tr>
	<tr style="background: #cccccc;">
      <td style="width: 200px; text-align: center;">Provide us your information</td>
    </tr>
    <tr>
    		<td>Name:</td>
    		
    		<td>
    			<input type="text" name="cname" size="15" maxlength="15"/>
    		</td>
    </tr>
    <tr>
    		<td> Phone Number</td>
    		
    		<td>
    			<input type="number" name="phone" size="10" maxlength="10"/>
    		</td>
    </tr>
    <tr>
    			<td> Payment Type</td>
    			<td> 
    				<select id="payment" name="pay">
    					<optiongroup>
    						<option value="Cash">Cash</option>
    						<option value="Visa">Visa</option>
    						<option value="MasterCard">MasterCard</option>
    					</optiongroup>
    				</select>
    			</td>
    			
    		</tr>
    		
    <!-- end of user information and start of food order --> 
    <tr style="background: #cccccc;">
      <td style="width: 150px; text-align: center;">Item</td>
      <td style="width: 15px; text-align: center;">Quantity</td>
    </tr>
    <tr>
    		<td> Double-Double</td>
    		<td> 
    			<input type="number" id="dbdb" name="doubledouble" size="2" maxlength="2"/>
    		</td>
    		<td>
    			<select id="chesse" name="dbcheck" > 
    				<option value="dbdbcombo">Combo</option>
    			</select>
    		</td>
    		</tr>
    		<tr>
    		<td>
    			Cheeseburger
    		</td>
    		<td>
    			<input type="number" name="cheesebg" id="chsb" size="2" maxlength="2"/>
    		</td>
    		
    		<td>
    			<select id="chcombo" name="chscheck">
    				<option value="cheeseCombo">With Combo</option>
    			</select>
    		</td>
    		
    		</tr>
    		
    		<tr>
    		<td>
    			Hamburger
    		</td>
    		<td>
    			<input type="number" name="hambug" id="hb" size="2" maxlength="2"/>
    		</td>
    		<td>
    			<select id="Hcombo" name="hcheck">
    				<option name="combo"  value="hamCombo">With Combo</option>
    			</select>
    		</td>
    		
    		</tr>
    
    <tr>
    		<td>
    			Fries
    		</td>
    		<td>
    			<input type="number" name="fries" id="ff" size="2" maxlength="2"/>
    		</td>
    		<td>
    			<select id="friesize" name="fchceck">
    				<option value="No Fries">No Fries</option>
    				<option value="One size">One size</option>
    			</select>
    		</td>
    		</tr>
    		
    		 <tr>
    		<td>
    			Drinks
    		</td>
    		<td>
    			<input type="number" name="drink" id="dr" size="2" maxlength="2"/>
    		</td>
    		<td>
    			<select id="drinksize" name="dcheck"> 
    				<option value="No Drink"> No Drink </option>
    				<option value="One size">One Size</option>			
    			</select>
    		</td>
    		</tr>
    		<tr>
    		 <td colspan="2" style="text-align: center;"><input type="submit" value="Submit Order" /></td>
    		</tr>
    		</table>
    		</form>
    		
    		
    		<table>
		<tr>
    		 <td><button id="show" > Check out the menu and prices </button>
    		 <button id="hide" class="menu" >Hide Menu</button></td>
    			<!-- I put the picture of the menu and the hide button in a class that initiates as hidden 
    			but when the users clicks on the button the menu image should popup below with a hide menu button to hide the picture if users chooses
    		    to do so--> 
    		</tr>
    		
    		<tr>
    				<?php 
    				$menu= file("files/menu.txt"); // read the file data to a var
					$menuitems = count($menu); 
			for($i=0; $i<$menuitems; $i++) // loop through the file
			{
    			$hiddenmenu = explode(",", $menu[$i]);// explode the file with the comma dilimiter
    			// on the menu.txt i have the pictures as "Images/imgName.png"  instead of "imgName.png" because i saved other images  into this folder i originally had from assigment 1 
    			//so all file types are organized as such
			if($i==0)
			{ 
				echo "<td style=\"width: 33%; text-align: center\">";
       	   		echo '<img class="menu" src="' . $hiddenmenu[2] . '" width="250" height="250" />';
       	   		echo '<p class ="menu">' .$hiddenmenu[0]." $".$hiddenmenu[1].'</p>';
       	   		echo "</td>";
       	   		/*
       	   			I created a dynamic menu where when the user clicks to view menu all the items will have their images that has been written into the menu.txt file 
       	   			and i set it up using the <td> and <p> elemnts so the images will show side by side and the name of the item and price will be shown below each picture.
       	   			so going by the index of the array the [2] will be where the image location is [0] is the name and [1] is the price
       	   		*/
			}
			if($i==1)
			{
				echo "<td style=\"width: 33%; text-align: center\">";
       	   		echo '<img class="menu" src="' . $hiddenmenu[2] . '" width="250" height="250" />';
       	   		echo '<p class ="menu">' .$hiddenmenu[0]." $".$hiddenmenu[1].'</p>';
       	   		echo "</td>";
			}
			if($i==2)
			{
				echo "<td style=\"width: 33%; text-align: center\">";
       	   		echo '<img class="menu" src="' . $hiddenmenu[2] . '" width="250" height="250" />';
       	   		echo '<p class ="menu">' .$hiddenmenu[0]." $".$hiddenmenu[1].'</p>';
       	   		echo "</td>";
			}
			if($i==3)
			{
				echo "<td style=\"width: 33%; text-align: center\">";
       	   		echo '<img class="menu" src="' . $hiddenmenu[2] . '" width="250" height="250" />';
       	   		echo '<p class ="menu">' .$hiddenmenu[0]." $".$hiddenmenu[1].'</p>';
       	   		echo "</td>";
			
			}
			if($i==4)
			{
				echo "<td style=\"width: 33%; text-align: center\">";
       	  		echo '<img class="menu" src="' . $hiddenmenu[2] . '" width="250" height="250" />';
       	  		echo '<p class ="menu">' .$hiddenmenu[0]." $".$hiddenmenu[1].'</p>';
       	   		echo "</td>";
			}
	}				
    				?> 
    		</tr>
	</table>
	<script src="JS/ErrorHandling.js">
		// created an external JavaScript to handle the error on the client side
	</script>
	</body>

</html>