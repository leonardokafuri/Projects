<?php 
$fullname = $_POST['fullname'];
$postalcode = $_POST['postalcode'];
$username = $_POST['username'];
//getting user input

$NameBoolean=true;
$PostalcodeBoolean=true;
$UsernameBoolean=true;
//boolean variable
?>

<html>
<?php
require('header.php');
//requiring the header file
?>
<style>
	body{
		background-color: #fea524;
	}
</style>
<body>
<?php 
require('validate.php');
$testinput = new Validate();
echo "<table>";
echo "<tr> <td>";
$testinput->checkName($fullname,$NameBoolean);
echo "<tr> <td>";
$testinput->checkzip($postalcode,$PostalcodeBoolean);
echo "<tr> <td>";
$testinput->checkusername($username,$UsernameBoolean);
echo "</table>";
?>
</body>
<?php 
require('footer.php')
//requring the footer file 
?>
</html>