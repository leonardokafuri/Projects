//Name:Leonardo Kafuri , 300265732
$(document).ready(function(){
$("#toggle_container").find(".title").click(function()
{
	//getting the file to search for the title
	$(this).next().slideToggle(); // sliding the body_text class
	if($(this).find('i').hasClass(".fa fa-minus-circle"))
	{	
		// after the user clicks on the title or icon look if it has the class fafaminus if yes 
		// remove it 
		//when the user clicks on to slide the toggle up it will detected the class minus and remove it and add the plus class back
		$(this).find('i').removeClass(".fa fa-minus-circle");
		$(this).find('i').addClass(".fa fa-plus-circle");
	}else 
	{
		//since when the user clicks the icon it wont have the class minus I want to remove the plus class and add the minus class so when it clicks again it can be removed 
		$(this).find('i').removeClass(".fa fa-plus-circle");
		$(this).find('i').addClass(".fa fa-minus-circle");
	}		
});
});
	
