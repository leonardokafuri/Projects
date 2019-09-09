<?php
$email = "wongr10@douglascollege.ca";
$email_array = explode('@',$email);
echo $email_array[0].'<br />'. $email_array[1];
echo "<br />";

?>

<?php
$string = "This is\tan example\nstring";
/* Use tab and newline as tokenizing characters as well  */
$tok = strtok($string, " \n\t");

while ($tok !== false) {
    echo "Word=$tok<br />";
    $tok = strtok(" \n\t");
}
?>

<?php
$toaddress = 'feedback@example.com';  // the default value
$feedback = 'I have a question on billing.';
// Change the $toaddress if the criteria are met
if (strstr($feedback, 'shop')) {
  $toaddress = 'retail@example.com';
} else if (strstr($feedback, 'delivery')) {
  $toaddress = 'fulfillment@example.com';
} else if (strstr($feedback, 'bill')) {
  $toaddress = 'accounts@example.com';
}
?>


<?php
$mystring = 'abcdef abcdef';
$findme   = 'C';
$pos = strpos($mystring, $findme);

// Note our use of ===.  Simply == would not work as expected
// because the position of 'a' was the 0th (first) character.
if ($pos === false) {
    echo "The string '$findme' was not found in the string '$mystring'";
} else {
    echo "The string '$findme' was found in the string '$mystring'";
    echo " and exists at position $pos";
}
?>


<?php
// Provides: <body text='black'>
$bodytag = str_replace("%body%", "black", "<body text='%body%'>");
echo '<br />'.'$bodytag = '."$bodytag".'<br />';

// Provides: Hll Wrld f PHP
$vowels = array("a", "e", "i", "o", "u", "A", "E", "I", "O", "U");
$onlyconsonants = str_replace($vowels, "", "Hello World of PHP");
echo '$onlyconsonants = '."$onlyconsonants".'<br />';

// Provides: You should eat pizza, beer, and ice cream every day
$phrase  = "You should eat fruits, vegetables, and fiber every day.";
$healthy = array("fruits", "vegetables", "fiber");
$yummy   = array("pizza", "beer", "ice cream");

$newphrase = str_replace($healthy, $yummy, $phrase);
echo '$newphrase = '."$newphrase".'<br />';

// Provides: 2
$str = str_replace("ll", "", "good golly miss molly!", $count);
echo $count;
?>
