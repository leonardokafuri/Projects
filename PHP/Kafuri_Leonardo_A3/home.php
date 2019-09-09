<html>
<title>Assignment 3</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Used the google jquery library to use jquery to hide and show hints-->
<?php
require("header.php");
//requiring the header file
?>
<style>
	body{
		background-color: #fea524;
	}
	.hints{display:none;} /*created a class hints that will be hidden by default for the user */
</style>
<body>
	<form action="task1.php" method="post">
	<table>
	<tr>
		<td>Full Name</td>
		<td><input type="text" name="fullname" size="20" maxlength="20"/> </td>
	</tr>
	<tr>
		<td> Postal Code</td>
		<td><input type="text" name="postalcode" size="7" maxlength="7"/></td>
	</tr>
	<tr>
		<td>Username</td>
		<td> <input type="text" name="username" size="10" maxlength="10"/></td>
	</tr>
	<tr>
    		 <td colspan="2" style="text-align: center;"><input type="submit" value="Submit"/></td>
    		</tr>
	 </table>	
	</form>
	<button id="hints">Hints</button>
	<button class="hints" id="hide">Hide hints</button>
	<table class="hints">
		<tr>
			<td>
				Name :
			</td>
			<td>
				Should contain up to 20 characters and only have letters and one space between first and last name
			</td>
		</tr>
		<tr>
			<td>
				Postal code :
			</td>
			<td>
				 Should contain at least 7 characters including one space , and be of the format A0A 0A0
			</td>
		</tr>
		<tr>
			<td>
				Username :
			</td>
			<td>
				Should contain at least 6 characters and up to 10. It can't be entirely numeric, have any white spaces or start or end with a period or underscore.
			</td>
		</tr>
	</table>
</body>
<?php 
require("footer.php")
//requring the footer file 
?>
<script>
	$(document).ready(function()
	{
			//reference hitns button 
			$('#hints').click(function(){
			//call show method to show class 
			$('.hints').show();
			})
			
			//reference hide hints button 
			$('#hide').click(function(){
			//call hide method to hide class 
			$('.hints').hide();
			})	
	});	
</script>

</html>