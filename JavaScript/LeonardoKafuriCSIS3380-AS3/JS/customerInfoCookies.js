/*
  Name:Leonardo Kafuri
  StudentId : 300365732
*/
function setCookie(name, value)
{
	 document.cookie = name+"="+value+";expires=Sun,30 Dec 2018 00:00:00 UTC; path:/customerInfo.html;";
	
}
function storedValues()
{
	var events = document.getElementsByName('Event_type');
	var eventsel;
	for(var i = 0; i < events.length; i++)
	{
    		if(events[i].checked)
    		{
        		eventsel = events[i].value;
        		setCookie("Event Type",eventsel);
    		}
	}
	
	var eventdate = document.getElementById("eventdate").value;
	setCookie("Event date", eventdate);
	
	var location = document.getElementById("eventvenue").value;
	setCookie("Event venue",location);
	
	var name = document.getElementById("name").value;
	setCookie("Customer name", name);
	
	var email = document.getElementById("email").value;
	setCookie("Customer Email", email);
	
	var phone = document.getElementById("phone").value;
	setCookie("Customer Phone", phone);
	
	var cardType = document.getElementsByName('Payment_card');
	var cardsel;
	//will get the value for the card number so it can apply the regular expresions to it 
	var cardReg = document.getElementById("cardNum").value;
	for(var x = 0; x<cardType.length; x++)
	{
		if(cardType[x].checked)
		{
			cardsel = cardType[x].value;
			if (cardsel== "Visa")
			{
				
				// RegExp for visa on the cardnumber textbox 
				cardReg = new RegExp(/\d{16}$/);
				//set the cookie after the card number is verifed 
				setCookie("Card Type", cardsel);
				
			}else if(cardsel =="Master Card")
			{
				// RegExp for master 
				cardReg = new RegExp(/\d{16}$/);
				
				setCookie("Card Type", cardsel);
			}else if(cardsel=="Discover")
			{
				// RegExp for discover 
				cardReg = new RegExp(/\d{15}$/);
				
				setCookie("Card Type", cardsel);
			}else if(cardsel =="American Express")
			{
				// RegExp for american
				cardReg = new RegExp(/\d{15}$/); 
				setCookie("Card Type", cardsel);
			}
			
		}
	}
	
	var cardNumb = document.getElementById("cardNum").value;
	//used a regular expression so will get the user value for the card number and only display the last 4 digitis
	cardNumb = cardNumb.replace(/.(?=.{4})/g, '*');
	setCookie("Card Number",cardNumb);
	
	var cardexpireYear = document.getElementById("cardExpiryYear").value;
	var cardExpireMonth = document.getElementById("cardExpiryMonth").value + "/";
	var cardexpire = cardExpireMonth + cardexpireYear;
	setCookie("Card expiry date", cardexpire);
	
	
}
document.getElementById("customerInfo").onsubmit = function(){storedValues();}