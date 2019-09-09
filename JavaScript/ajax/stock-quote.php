<?php
//HTTP header attributes
header("cache-control: no-cache"); //don't cache content
header("content-type: text/json");

//key
$key ="OHKP48GM5VYS7P8W";
$ticker = "AAPL";
$quote = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=$ticker&apikey=$key";

//get url contents
//use file_get_contents to read all the content from the source
$quoteData = file_get_contents($quote);

//return/display it
print $quoteData; // print or echo 



?>