/*
  Name:Leonardo Kafuri
  StudentId : 300365732
*/

function getOrderEstimate()
{
 	// calculates the total value of users choice in the orderEstimate.html
 	
 	//get the num of photographers 
 	var numOfPhotographers = document.getElementById("photognum").value;
 	
 	//get the amount of hours 
 	var hours = document.getElementById("photoghrs").value;
 	
 	//total price with photographers hours 
 	var photoPrices = numOfPhotographers * (hours * 100);
 	
 	
 	//get price for memory book
 	var memoryBook = document.getElementById("membook");
 	if(memoryBook.checked)
 	{
		memoryBook = 250;
		
	}else 
	{
		memoryBook = 0;
	}
 	//get price for rights of photos 
 	var rights = document.getElementById("reprodrights");
 	if(rights.checked)
 	{
		rights = 1250;
		
	}else
	{
		rights = 0;
		
	}
 	
 	//get price for distance traveled  which is 1$ km per photographer 
 	var distance = document.getElementById("distance").value; 
 	//get the distance price and mutiply per number of photographer
 	var distanceprice = distance * numOfPhotographers ;
 	
 	//total
 	var total  =  photoPrices + memoryBook + rights + distanceprice; 
 	
 	var price = document.getElementById("estimate").value= total;
	
	
}

function createEventListeners()
{
	// run the on change event for every element to update the price dynamically 
	
	//if user change the number of photographers change the price 
	document.getElementById("photognum").onchange =  function() {getOrderEstimate()};
	
	//if user change the hours of photgraphers change the price 
	document.getElementById("photoghrs").onchange = function() {getOrderEstimate()};
	
	//if user wants rights change add 1250
	document.getElementById("reprodrights").onchange = function() {getOrderEstimate()};
	
	//if users wants the memory book add 250
	document.getElementById("membook").onchange = function() {getOrderEstimate()};
	
	// if user change the distance update the price 
	document.getElementById("distance").onchange = function() {getOrderEstimate()};
	
}
createEventListeners();
