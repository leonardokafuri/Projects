//script for Ajax requests
function processAjaxRequest(){
		//create xmlHttpRequest Object
		var ajaxRequest = new XMLHttpRequest();
		
		//open the resource requested
		ajaxRequest.open("GET","stock-quote.php", true);
		
		//send the request to the server
		ajaxRequest.send();
		
		//check whether the request is ready, and if so, grab and display the content
		
		ajaxRequest.onreadystatechange = function(){
			if((ajaxRequest.readyState==4)&&(ajaxRequest.status==200)){
				//display the content
				//document.getElementById("display").innerHTML = ajaxRequest.responseText;
				//alert(ajaxRequest.responseText);
			//var arrJson = new Array();	
		//	var objJson; = ajaxRequest.responseText
		var objJson= JSON.parse(ajaxRequest.responseText);
			
//			alert(objJson["Global Quote"]["01. symbol"]);
				//	{	
					document.getElementById("ticker").innerHTML= objJson["Global Quote"]["01. symbol"];	
					document.getElementById("latestPrice").innerHTML= objJson["Global Quote"]["05. price"];
					document.getElementById("openingPrice").innerHTML= objJson["Global Quote"]["02. open"];
					document.getElementById("highPrice").innerHTML= objJson["Global Quote"]["03. high"];
					document.getElementById("lowPrice").innerHTML= objJson["Global Quote"]["04. low"];
					document.getElementById("volume").innerHTML= objJson["Global Quote"]["06. volume"];
					document.getElementById("lastTrade").innerHTML= objJson["Global Quote"]["07. latest trading day"];
					document.getElementById("previousClose").innerHTML= objJson["Global Quote"]["08. previous close"];
					document.getElementById("change").innerHTML= objJson["Global Quote"]["09. change"];
					document.getElementById("changePercent").innerHTML= objJson["Global Quote"]["10. change percent"];
				
			}
			
		}
		
		
	}
	function formatTable(){
		
		var rows = document.getElementsByTagName("tr");
		for(var i=0; i<rows.length; i +=2){
			
			rows[i].style.background = "#9FE098";
		}
	}
	//call Functions
	//starts by clearing the interval 
	
	//var intervalId = setTimeout('processAjaxRequest()',60000);
	//clearTimeout(intervalId);
	formatTable();