/*
  Name:Leonardo Kafuri
  StudentId : 300365732

*/
function setCookie(name, value)
{
	document.cookie = name+"="+value+";expires=Sun,30 Dec 2018 00:00:00 UTC; path:/orderEstimate.html;";
	
}

function storedValues()
{
	//call the setCookie function to store each name = balue pair on the orderEstimate.html
	
	var numphoto = document.getElementById("photognum").value;
	setCookie("Photographers",numphoto);
	
	var hours = document.getElementById("photoghrs").value;
	setCookie("Photography hours",hours);
	
	var membook  = document.getElementById("membook").value;
	setCookie("Memory book",membook);
	
	var rights = document.getElementById("reprodrights").value;
	setCookie("Reproduction rights",rights);
	
	var distancep  = document.getElementById("distance").value + "km";
	setCookie("Distance",distancep);
	
	var total  = "$" + document.getElementById("estimate").value;
	setCookie("Total estimate",total);
	
	
}
document.getElementById("orderform").onsubmit=function(){storedValues();};
