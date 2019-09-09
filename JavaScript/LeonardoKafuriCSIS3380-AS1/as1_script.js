/*INSERT YOUR NAME HERE 
START OF STUDENT INFORMATION

STUDENT NAME: Leonardo Kafuri
STUDENT ID: 300265732
DATE COMPLETED: 05/10/2018

END OF STUDENT INFORMATION*/ 

	var emptyList = true;
	var emptyString = "Your team 1 roster  is empty";
	//variable to track index of bowler1 table
	var Bowler1Indx = 0;
	function addTeam1Bowler(Bowler1Indx)
	{
		var numRows = document.getElementById("team1Roster").rows.lentgh;
		if(emptyList){
		document.getElementById("team1Roster").deleteRow(0);
		}
		//get player name from textbox
		var player1 = document.getElementById("tm1BowlerName").value;
		
		//dynamically insert player item to the list
        var tblbowler1 = document.getElementById("team1Roster");
        
        //create new player row
		var playerRow = document.createElement("tr") ;
		playerRow.setAttribute("id",Bowler1Indx);

		//create row data cells
		var tdPlayer1 = document.createElement("td");
		var tdBtn1 = document.createElement("td");

		//create textnode for first cell
		var txt = document.createTextNode(player1);

		//create a button for the second cell
		var btn1 = document.createElement("input");
		
		
		//set attributes for the button
		//input type
		btn1.setAttribute("type", "button");

		//set name
		btn1.setAttribute("name","remove");

		//set value
		btn1.setAttribute("value","Remove Player");

		//associate the button element with the player to be removed
		//using onclick event
		btn1.setAttribute("onclick", "removeTeam1Bowler(this.parentElement.parentElement)");
		
		//append player and button to td elements
		tdPlayer1.appendChild(txt);
		tdBtn1.appendChild(btn1);
		
		//append td  elements to tr element
		playerRow.appendChild(tdPlayer1);
		playerRow.appendChild(tdBtn1);
		
		
		//append row element to table
		tblbowler1.appendChild(playerRow);

		//increment index
		Bowler1Indx++;
		emptyList=false;	
		
	}
	document.getElementById("addTm1Bowler").onclick = function(){addTeam1Bowler(Bowler1Indx);}
	
	function removeTeam1Bowler(trlPlayer1)
	{
		trlPlayer1.parentElement.removeChild(trlPlayer1);
		
		//display default Text
		if(document.getElementById("team1Roster").rows.length==0){
			emptyList=true;
			var trow=document.createElement('tr');
			var tdR=document.createElement('td');
			tdR.appendChild(document.createTextNode(emptyString));
			trow.appendChild(tdR);
			document.getElementById("team1Roster").appendChild(trow);
		}
	}
	
	var emptyList2 = true;
	var emptyString2 = "Your team 2 roster is empty";
	//variable to track index of bowler2 table
	var Bowler2Indx = 0;
			
	function addTeam2Bowler(Bowler2Indx)
	{
		var numRows2 = document.getElementById("team2Roster").rows.lentgh;
		if(emptyList2)
		{
		document.getElementById("team2Roster").deleteRow(0);
		}
		//get player name from textbox
		var player2 = document.getElementById("tm2BowlerName").value;
		
		//dynamically insert player item to the list
        var tblbowler2 = document.getElementById("team2Roster");
        
        //create new player row
		var playerRow2 = document.createElement("tr") ;
		playerRow2.setAttribute("id",Bowler2Indx);

		//create row data cells
		var tdPlayer2 = document.createElement("td");
		var tdBtn2 = document.createElement("td");

		//create textnode for first cell
		var txt2 = document.createTextNode(player2);

		//create a button for the second cell
		var btn2 = document.createElement("input");
		
		
		//set attributes for the button
		//input type
		btn2.setAttribute("type", "button");

		//set name
		btn2.setAttribute("name","remove");

		//set value
		btn2.setAttribute("value","Remove Player");

		//associate the button element with the player to be removed
		//using onclick event
		btn2.setAttribute("onclick", "removeTeam2Bowler(this.parentElement.parentElement)");
		
		//append player and button to td elements
		tdPlayer2.appendChild(txt2);
		tdBtn2.appendChild(btn2);
		
		//append td  elements to tr element
		playerRow2.appendChild(tdPlayer2);
		playerRow2.appendChild(tdBtn2);
		
		
		//append row element to table
		tblbowler2.appendChild(playerRow2);

		//increment index
		Bowler2Indx++;
		emptyList2=false;
	}	
	document.getElementById("addTm2Bowler").onclick = function(){addTeam2Bowler(Bowler2Indx);}

	function removeTeam2Bowler(trlPlayer2)
	{
		
		trlPlayer2.parentElement.removeChild(trlPlayer2);
		
		//display default Text
		if(document.getElementById("team2Roster").rows.length==0){
			emptyList2=true;
			var trow=document.createElement('tr');
			var tdR=document.createElement('td');
			tdR.appendChild(document.createTextNode(emptyString2));
			trow.appendChild(tdR);
			document.getElementById("team2Roster").appendChild(trow);
		}
		
	}
	
	function genranInt(min, max)
	{ // generation of a random number
		return Math.floor((Math.random()*(max-min)+min));
	}
  
	function ChangePageColor()
	{
		var curBackground = 0;
        var backgroundcolor = new Array ('#5CDB95','#AFD275','#66FCF1','#A8D0E6','#F5E6CC','#FAED26','#86C232');
      	var min = 0;
        var max = backgroundcolor.length;
        var rancolor = genranInt(min,max);
		curBackground += rancolor;
		document.getElementById("setbgcolor").style.backgroundColor = backgroundcolor[curBackground] ;
		//console.log(curBackground);
		if (curBackground == backgroundcolor.length)
		 {
		 	//reseting the backgroud 
		 	 curBackground = 0; 
		 }

	}


	var arrSlogan = new Array("Try it, you will strike it.", "Bowling is fun in your spare time.", "Bowling is right up my alley.", "Bowlers do it in alleys", "Bowlers always have time to spare.", "12 strikes and you're perfect", "Bowlers never die, they just end up in the gutter", "Bowlers: Keep your minds out of the Gutter.", "Bowling: An alley you can play in.", "Bowling - You can get 3 strikes, and you're no out", "If you don't get a strike - Spare me!", "It's noy how you bowl, its how you roll.", "It's about playing catch & throwing strikes.","Keep your balls out of the gutter", "knocking them down, one pin at a time.", "Leave no Pin Standing", "Let the pins fall where they may", "Let's knock em down", "Make your competitive juices overcome your excuses.", "My Bowling team rocks!", "Never a good time to clean thegutters", "No Smoking- Just a lucky strike!", "No splits too wide if you got the balls", "Teamwork makes the dream work.","What happens at the bowling alley, stays at the bowling alley");

      var slogan1;
      var slogan2;
      var slogan3;
      var slogan4;

	function DisplayBowlingSlogans()
	{
		var min = 0;
    	var max = arrSlogan.length;
	do{
		var slogan1 = genranInt(min,max);
		var slogan2 = genranInt(min,max);
		var slogan3 = genranInt(min,max);
		var slogan4 = genranInt(min,max);
	  }while(slogan1 == slogan2 || slogan1 == slogan3 || slogan1 == slogan4 || slogan2 == slogan3 || slogan2 == slogan4 || slogan3 == slogan4);   
    	
		document.getElementById("display").innerHTML = arrSlogan[slogan1]+ "<br />";
	    document.getElementById("display").innerHTML+= arrSlogan[slogan2]+ "<br />";
	    document.getElementById("display").innerHTML+= arrSlogan[slogan3]+ "<br />";
	    document.getElementById("display").innerHTML+= arrSlogan[slogan4]+ "<br />";
	}
	
	
	arrPins = new Array(8);
	//indentify the currently loaded image 
	var curPin = 0;
	for (var i=0; i<arrPins.length; i++)
	{
		//loading pins into the cache
		arrPins[i] = "Images/ball" + i + ".png";
	}
	function SpinPinBalls()
	{
		// test for current image 
		if(curPin==7)
		{
			// go to the first 
			curPin=0;
		}else {
			//keep loading next image 
			curPin++;
		}
		document.getElementById("pinBall").src = arrPins[curPin];
		
	}