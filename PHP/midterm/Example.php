<?php
$Xsqty = $_POST['iphonexsqty'];
$xsmax = $_POST['iphonexsmqty'];
$xr = $_POST['iphonexrqty'];
$find = $_POST['find'];
$string;
?>

<!DOCTYPE html>
<html>
  <head>
    <title>Bob's Auto Parts - Order Results</title>
  </head>
  <body>
    <h1>Bob's Auto Parts</h1>
    <h2>Order Results</h2> 
    
    <?php
    echo "<p>Order processed at ";
    echo date('H:i, jS F Y');
    echo "</p>";
    
    
    echo '<p>Your order is as follows: </p>';

    echo htmlspecialchars($Xsqty).' Iphone Xs<br />';
    echo htmlspecialchars($xsmax).' Iphone Xs Max<br />';
    echo htmlspecialchars($xr).' Iphone XR<br />'; 
    if($find == 'a')
    $string = "I am a regular Customer";
    if($find == 'b')
    $string = "TV advertising";
    if($find == 'c')
    $string = "Phone directory";
    if($find == 'd')
    $string = "Word of mouth";
    
    echo "And you know of us because : ". $string."<br />";
    
    
    $price1 = 999;
    $price2 = 1100;
    $price3 = 750;
    
    $total1 = $Xsqty * $price1;
    $total2 = $xsmax * $price2;
    $total3 = $xr * $price3;
    
    $total = $total1 + $total2 + $total3;
    $taxrate = 0.12;
    $totatax = $total *$taxrate; 
    $tt = $total + $totatax;
    $items = $xr + $xsmax + $Xsqty;
    echo "<br />";
    echo "Total items ordered : ".$items."<br />";
    echo "Your subtotal is $".number_format($total,2)."<br />";
    echo "Total taxes are $".number_format($totatax,2)."<br />";
    echo "Total $".number_format($tt,2);
    

?>    
</body>
</html>