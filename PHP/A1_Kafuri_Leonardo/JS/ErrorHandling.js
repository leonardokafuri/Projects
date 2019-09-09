//Name : Leonardo Kafuri 
//Student id: 300265732
//Assignment 1
function errorhandling()
	{
		/*
			Created a function to handle the error on the client side so it would tell them  about the  maximum amount of burguers they could order...
			whenever the form is tried to be submitted, the function will run and check the user input to see if its valid, if its not valid, will return as false
			and tell the user the mistake made and get it to correct it 
		*/
		var doublebr = document.forms["foodForm"]["doubledouble"].value;
		if(doublebr>10)
		{
			window.alert("The maximum number of Double double per order is 10.");
			document.getElementById("dbdb").focus(); // will focus on the specified input box so the user knows where the mistake was made and user can correct it
			return false;
		}
		
		var chesseburg = document.forms["foodForm"]["cheesebg"].value;
		if(chesseburg>10)
		{
			window.alert("The maximum number of Chesseburgers per order is 10.");
			document.getElementById("chsb").focus();
			return false;
		}
		
		var hambugr = document.forms["foodForm"]["hambug"].value;
		if(hambugr>10)
		{
			window.alert("The maximum number of Hamburgers per order is 10.");
			document.getElementById("hb").focus();
			return false;
		}
		
	}	
	
function combocheck()
{
			/*
				Created a funtion to display a popup annoucement telling the user that if they select a combo for any of the burgers and they
				selected fries or drink option below they would be chargerd extra
			*/
			var popup = document.getElementById("Hcombo").value;
			var popup2 = document.getElementById("chesse").value;
			var popup3 = document.getElementById("chcombo").value;
			
				if(popup== "hamCombo")
				{
					window.alert("You have selected a combo meal that includes a medium fries and medium drink. Please be aware that unless you want another side of fries or another drink  you should select ' No fries ' and 'No Drink' on the lists below");
				}else if(popup2 == "Cheesecb") {
					
					window.alert("You have selected a combo meal that includes a medium fries and medium drink. Please be aware that unless you want another side of fries or another drink  you should select ' No fries ' and 'No Drink' on the lists below");
				}else if (popup2 == "nocheesecb")
				{
					window.alert("You have selected a combo meal that includes a medium fries and medium drink. Please be aware that unless you want another side of fries or another drink  you should select ' No fries ' and 'No Drink' on the lists below");
				}
				else if(popup3 == "cheeseCombo")
				{
					window.alert("You have selected a combo meal that includes a medium fries and medium drink. Please be aware that unless you want another side of fries or another drink  you should select ' No fries ' and 'No Drink' on the lists below");
				}
}
		document.getElementById("Hcombo").onchange = function(){combocheck()};
		document.getElementById("chesse").onchange = function() {combocheck()};
		document.getElementById("chcombo").onchange = function() {combocheck()};
		 // needs to call function whenever the dropdown list is changed
	
			  
// created a function using jQuery to show and hide the menu on a click of a button
$(document).ready(function()
	{
			//reference show image button 
			$('#show').click(function(){
			//call show method to show class 
			$('.menu').show();
			})
			
			//reference hide image button 
			$('#hide').click(function(){
			//call hide method to hide class 
			$('.menu').hide();
			})
			
	});	
