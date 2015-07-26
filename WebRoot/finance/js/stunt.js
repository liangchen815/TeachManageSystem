$(document).ready(function(){
	
	$('a').focus(function(){$(this).blur()});
	
    $('.navigatorBar li').mouseenter(function(){
    	$(this).children('ul').css('display','none');
    	$(this).children('ul').stop(true,true);
    	$(this).children('ul').slideDown('slow');
    });
    
    $('.navigatorBar li').mouseleave(function(){
    	$(this).children('ul').css('display','block');
    	$(this).children('ul').stop(true,true);
    	$(this).children('ul').slideUp('slow');
    });
    
      
    $('.navigatorList').mouseenter(function(){
    	
    	$(this).children('.listTitle').css('color','black');
    	$(this).children('.listTitle').css('background','url(./images/listTitle.png)');
    	$(this).children('.listTitle').css('border-right','none');
    	$(this).children('.listTitle').css('border-left','none');
    	$(this).children('.listTitle').stop(true,true);
    	$(this).children('.listTitle').css('color','white');
    	$(this).children('.listTitle').css('background','#5cadad');
    	$(this).children('.listTitle').css('border-right','white solid 1px');
    	$(this).children('.listTitle').css('border-left','white solid 1px');
    	
    });
    
    $('.navigatorList').mouseleave(function(){
    	
    	$(this).children('.listTitle').css('color','white');
    	$(this).children('.listTitle').css('background','#5cadad');
    	$(this).children('.listTitle').css('border-right','white solid 1px');
    	$(this).children('.listTitle').css('border-left','white solid 1px');
    	$(this).children('.listTitle').stop(true,true)
    	$(this).children('.listTitle').css('color','black');
    	$(this).children('.listTitle').css('background','url(./images/listTitle.png)');
    	$(this).children('.listTitle').css('border-right','none');
    	$(this).children('.listTitle').css('border-left','none');
    	
    });
    


});