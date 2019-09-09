function dispmsg(){
	

var msg= "Testing external javascript file, display function- no return...";
document.write(msg);
}
function returnmsg(){
	var msg="Returning message to display in form....";
	return msg;
}
function customname(mname){
	var msg="Hello,"+ mname +" welcome to this website";
	return msg;
}
function averagewithinput(fquiz1, fquiz2, fquiz3){
	var avg=(parseInt(fquiz1)+ parseInt(fquiz2)+ parseInt(fquiz3))/3;
	avg=Math.round(avg);
	var output = "Average of " + fquiz1+ ", " + fquiz2 + ", " + fquiz3 +" is " + avg;
	return output; 
}