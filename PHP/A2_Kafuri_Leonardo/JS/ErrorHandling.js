//Name : Leonardo Kafuri 
//Student id: 300265732
//Assignment 2
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
