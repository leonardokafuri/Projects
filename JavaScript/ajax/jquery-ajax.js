//jquery
// refer to form
$(document).ready(function(){
$("#stock_form").submit(function(event){
	//prevent default action
	event.preventDefault();
	
	//get the path of the server script that will process request 
	var action_attr = $(this).attr("action");
	
	// get method used
	var method = $(this).attr("method");
	
	//encode form Data.
	//create new formdata object 
	var formdata =  new FormData();
	
	
	
});


	
});