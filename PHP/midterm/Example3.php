<!DOCTYPE html>
<html>
  <head>
    <title>Information Saving</title>
  </head>
  <body>
    <h2> Results</h2> 

	<?php
		@$fp = fopen('information.txt','rb');
		flock($fp,LOCK_SH);
		
		if (!$fp) {
        echo "<p><strong>Information Can't be retrived,.<br />
              Please try again later.</strong></p>";
        exit;
      }
      
      while(!feof($fp))
      {
	  	$info = fgets($fp);
	  	
			echo htmlspecialchars($info)."<br />";
	  }
      	flock($fp,LOCK_UN);
      	fclose($fp);
	?>	

</body>
</html>