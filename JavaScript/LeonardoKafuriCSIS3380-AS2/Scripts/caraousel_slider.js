//Name:Leonardo Kafuri , 300265732

function SearchActiveItem()
{
	
	for (var i = 1; i<5; i++)
	{
		if($("li.item"+i).hasClass("active"))
		{
			return i;
			
		}
		
	}
	
}

/*function AnimateImages()
{	
	$('.carousel-inner').find('div.item').eq(1).addClass('active');
	$('.carousel-inner').find('div.item').eq(2).addClass('active');
	$('.carousel-inner').find('div.item').eq(3).addClass('active');
	
	$(".carousel-inner").animate({marginLeft:800},1000,function()
		{
			//advance to the last div and after that go back to the first div
			$(this).find("div.item:last").after($(this).find("div.item:first"));
			
			//reset margin to zero
			$(this).css({marginLeft:0});
			
		});	
}
setInterval(AnimateImages,2300)

I am not sure if you wanted us to keep the images rotating in an interval, but if this code gets uncomented it rotates to the next image 
*/

function ChangePos(prev, next)
{
	$(".item" + prev).removeClass('active');
	$(".item" + next).addClass('active');
	//Changing the position of the button. removing from the previous button and adding the class active to the next clicked
}


$(document).ready(function(){

	var imgselc;
	
function ChangeImg()
{
	$(".item1").click(function()
	{
			imgselc = SearchActiveItem();
			//this function will search for the active button clicked and return the index of that button
			if(imgselc!=1)ChangePos(imgselc,1); // if the index is not equal to that button index change the position it to the button index 
			$('.carousel-inner').find('div.item').removeClass('active');
			$('.carousel-inner').find('div.item').eq(0).addClass('active');
			//i am removing the currently active div.item and moving to the div.item that has the index 0 to show the 1st picture 
			//i  used the same concept for the other buttons just changing the index to match the corresponding image 
	});
	
	$(".item2").click(function()
	{
			imgselc = SearchActiveItem();
			if(imgselc!=2)ChangePos(imgselc,2);
			$('.carousel-inner').find('div.item').removeClass('active');
			$('.carousel-inner').find('div.item').eq(1).addClass('active');
		
	});
	
	$(".item3").click(function()
	{
			imgselc = SearchActiveItem();
			if(imgselc!=3)ChangePos(imgselc,3);
			$('.carousel-inner').find('div.item').removeClass('active');
			$('.carousel-inner').find('div.item').eq(2).addClass('active');
		
	});
	
	$(".item4").click(function()
	{
			imgselc = SearchActiveItem();
			if(imgselc!=4)ChangePos(imgselc,4);
			$('.carousel-inner').find('div.item').removeClass('active');
			$('.carousel-inner').find('div.item').eq(3).addClass('active');
		
	});	
}
ChangeImg();


function NextImg()
{
	$('.right').click(function(){
		$('.carousel-inner').find('div.item').eq(1).addClass('active');
		$('.carousel-inner').find('div.item').eq(2).addClass('active');
		$('.carousel-inner').find('div.item').eq(3).addClass('active'); // activating images so they will show while sliding 
		 
		$(".carousel-inner").animate({marginLeft:800},1000,function()
		{
			//advance to the last div and after that go back to the first div
			$(this).find("div.item:last").after($(this).find("div.item:first"));
			//reset margin to zero
			$(this).css({marginLeft:0});
			
		});
		
	});
	
}
NextImg();

function PrevImg()
{
	
	$('.left').click(function(){
		$('.carousel-inner').find('div.item').eq(1).addClass('active');
		$('.carousel-inner').find('div.item').eq(2).addClass('active');
		$('.carousel-inner').find('div.item').eq(3).addClass('active');// activating images so they will show while sliding 
		 
		$(".carousel-inner").animate({marginLeft:-800},1000,function()
		{
			//advance to the last div and after that go back to the first div
			$(this).find("div.item:last").after($(this).find("div.item:first")); // this function "works" but not as required
			
			//$(this).find("div.item:first").after($(this).find("div.item:last"));
			//I tried to get the fisrt image and after the last so it could run backwards..
			// it worked but for some reason it was still showing the first image on top and the previous image was showing below 
			//the 1st image.. 
			//i couldnt figure out how to get to change correctly
			
			
			//reset margin to zero
			$(this).css({marginLeft:0});
			
		});
		
	});
	
}
PrevImg();
	
	
});