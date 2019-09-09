/*
  Name:Leonardo Kafuri
  StudentId : 300365732

*/
function displayOrderSummary()
{
	
	//decoding cookies
	var decodedCookie = decodeURIComponent(document.cookie);
	
	//spliting cookies 
	var sliptcookies = decodedCookie.split(';');
	
	//getting the ul element that will display the elements in a li element
	var ul = document.getElementsByTagName('ul')[0];
	var li;
	
	for(var i = 0; i < sliptcookies.length; i++)
	 {
	 	//setting each index of the array to 1 cookie 
        var c = sliptcookies[i];
        while (c.charAt(0) == ' ') 
        {
//retrive the cookie and add into an li item and add as an innerHTML to the li and finnaly append the li to ul and do that till the end of the array of cookies
            c = c.substring(1);
            li = document.createElement('li');
            li.innerHTML = c;
            ul.appendChild(li);
            
           
        }
        
    }
    
	
}
displayOrderSummary();
