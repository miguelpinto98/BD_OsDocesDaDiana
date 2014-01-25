$(document).ready(function() {
	
	var fullUrl = location.href.split("index.html");
	var url = fullUrl[3].split("?");
	if((url[0] == '') || (url[0] == 'index-2.html')){

		//Media Scroller
		mediaScroller('');
		
		//Format Comments
		formatComments();
	
	}else if((url[0] == 'movies.html') || (url[0] == 'series.html') || (url[0] == 'animes.html') || (url[0] == 'index-2.html') || (url[0] == 'index-2.html')){
		
		//Format Checkbox
		formatCheckb('');
		
	}else if((url[0] == 'index-2.html') || (url[0] == 'index-2.html')){
		
		rateStars();
		
		if(url[0] == 'index-2.html'){
			episodeSlide();
			seasonsList();
		}
		
		mediaScroll();
		showPlayer();
		
		
	}else if(url[0] == 'account.html'){
	
		//Format Checkbox
		formatCheckb('');
		
		// faved or cliped? then scroll to account-box
		favedOrCliped(url);
	
	}
	
	
});

/* General */

function loginRedirect(){
	window.location = "login.html";
}

function vfocus(id,str){
	if(id.value==str){
		id.value = '';
		id.focus();
	}
}

function vblur(id,str){
	if(id.value=='')
		id.value=str;
}

function ajaxRequestGET(url, container){
	$.ajax({
		type: "GET",
		url: url,
		success: function(msg){
			container.html(msg);
		}
	});
}

function moviesList(url, container){
	$.ajax({
		type: "GET",
		url: url,
		success: function(msg){
			container.html(msg);
		}
	});
}

function moviesSearch(mediaType, url, container){
	highLightsHeaderBtns(mediaType, '');
	cleanGenresAndYears();
	
	if($('input#'+mediaType+'-order').val() != '')
		url += '&order='+$('input#'+mediaType+'-order').val();
	else
		url += '&order=date';
		
	if($('input#searchBox').attr('defaultText') != $('input#searchBox').val())
		url += '&words='+$('input#searchBox').val();
	
	moviesList(url, container);
}

function cleanGenresAndYears(){
	var main = document.getElementById('genres-list'),
	item = main.getElementsByClassName('item');
	
	for(i=0; i < item.length; i++){
		span = item[i].getElementsByTagName('span');
		input = item[i].getElementsByTagName('input');
		input[0].checked = false;
		span[0].setAttribute('style', 'background-position: 0px 0px;');
		$('#selectedGenres').val('');
	}
	$('div#genres-list div.item label').removeClass('slctd');
	
	var main = document.getElementById('years-list'),
	item = main.getElementsByClassName('item');
	
	for(i=0; i < item.length; i++){
		span = item[i].getElementsByTagName('span');
		input = item[i].getElementsByTagName('input');
		input[0].checked = false;
		span[0].setAttribute('style', 'background-position: 0px 0px;');
		$('#selectedYears').val('');
	}
	$('div#years-list div.item label').removeClass('slctd');
}

function scrollToDiv(div){
	var pOffset = $(div).offset().top;
	$('html,body').animate({scrollTop: pOffset}, 1000);
}

function paginationScroll(){
		var pOffset = $('#content .content-box').offset().top;
		$('html,body').animate({scrollTop: pOffset}, 1000);
}

/* Movies Genres */

function moviesGenres(genreID, mode){
	var slctdG = $('#selectedGenres').val(),
	input = document.getElementById('genre'+genreID);
	$('#genre'+genreID+'Label').removeClass('slctd');
	if(input.checked == false){
		if(mode == 0){
			$('#selectedGenres').val(slctdG + genreID+",");
			$('#genre'+genreID+'Label').addClass('slctd');
		}else
			$('#selectedGenres').val(slctdG.replace(genreID+",", ""));
	}else{
		if(mode == 0)
			$('#selectedGenres').val(slctdG.replace(genreID+",", ""));
		else{
			$('#selectedGenres').val(slctdG + genreID+",");
			$('#genre'+genreID+'Label').addClass('slctd');
		}
	}
	cleanSearchField('movies');
	var url = 'pagination.ajaxe84e.html?genres=' + $('#selectedGenres').val() + '&years='+$('input#selectedYears').val()+'&order='+$('div.movies-order input#'+$('#box-media').val()+'-order').val()+'&mediaType='+$('#box-media').val();
	
	if(($('div.box-header input#boxheaderBtnSlctd').val() == 'moviesfeatured') || ($('div.box-header input#boxheaderBtnSlctd').val() == 'moviesrecommended') || ($('div.box-header input#boxheaderBtnSlctd').val() == 'seriesrunning') || ($('div.box-header input#boxheaderBtnSlctd').val() == 'seriesrecommended') || ($('div.box-header input#boxheaderBtnSlctd').val() == 'seriescompleted'))
		url += '&btn='+$('div.box-header input#boxheaderBtnSlctd').val();
	
	//alert(url);
	moviesList(url, $('#media-right-content'));
}

function moviesYears(yearID, mode){
	var slctdY = $('#selectedYears').val(),
	input = document.getElementById('year'+yearID);
	$('#year'+yearID+'Label').removeClass('slctd');
	if(input.checked == false){
		$('#selectedYears').val(slctdY.replace(yearID+",", ""));
	}else{
		$('#selectedYears').val(slctdY + yearID+",");
		$('#year'+yearID+'Label').addClass('slctd');
	}
	cleanSearchField('movies');
	var url = 'pagination.ajax7764.html?years=' + $('#selectedYears').val() + '&genres='+$('input#selectedGenres').val() + '&order='+$('div.movies-order input#'+$('#box-media').val()+'-order').val()+'&mediaType='+$('#box-media').val();
	
	if(($('div.box-header input#boxheaderBtnSlctd').val() == 'moviesfeatured') || ($('div.box-header input#boxheaderBtnSlctd').val() == 'moviesrecommended') || ($('div.box-header input#boxheaderBtnSlctd').val() == 'seriesrunning') || ($('div.box-header input#boxheaderBtnSlctd').val() == 'seriesrecommended') || ($('div.box-header input#boxheaderBtnSlctd').val() == 'seriescompleted'))
		url += '&btn='+$('div.box-header input#boxheaderBtnSlctd').val();
	
	moviesList(url, $('#media-right-content'));
}

function myAccountActions(moID, mode){
	var slctdMO = $('#selectedmediaOptions').val();
	
	if(moID != slctdMO){
		
		$('div#mediaHeaderOptions span.option-box').removeClass('slctd');
		$('div#mediaHeaderOptions div.opt label').removeClass('slctd');
		$('div#mediaHeaderOptions div.opt label#mediaOption'+moID+'Label').addClass('slctd');
		$('div#mediaHeaderOptions span#mediaOption'+moID).addClass('slctd');
		var action = '';
		switch($('input#selectedCat').val()){
			case 'movies':
				if(moID == 2)
					action = 'faved';
				else
					action = 'cliped';
				break;
			
			case 'series':
				if(moID == 1)
					action = 'subscribed';
				else
					action = 'faved';
				break;
			
			case 'episodes':
				action = 'cliped';
				break;
			
			default:
				if(moID == 1)
					action = 'faved';
				else
					action = 'cliped';
				break;
		}
		
		var url = 'index-2.html?p=1&amp;order='+$('input#account-order').val()+'&cat='+$('input#selectedCat').val()+'&action='+action;
		myAccount(url, $('#accountMediaChangeContent'));
	}
}



function setOrderBy(mediaType, order){
	$('input#'+mediaType+'-order').val(order);
}

/* Scroll Bar */

function mediaScroller(type){
	if(type == ''){
		var scrollerM  = null;
		var scrollerS  = null;
		var scrollerA  = null;
		var scrollbarM = null;
		var scrollbarS = null;
		var scrollbarA = null;
		window.onload = function () {
			//scrollerM  = new jsScroller(document.getElementById("movies-list"), 736, 633);
			//scrollerS  = new jsScroller(document.getElementById("series-list"), 736, 583);
			scrollerM  = new jsScroller(document.getElementById("movies-list"), 736, 633);
			scrollerS  = new jsScroller(document.getElementById("series-list"), 736, 420);
			scrollerA  = new jsScroller(document.getElementById("animes-list"), 736, 420);
			scrollbarM = new jsScrollbar('movies', document.getElementById("movies-list-scrollbar"), scrollerM, false);
			scrollbarS = new jsScrollbar('series', document.getElementById("series-list-scrollbar"), scrollerS, false);
			scrollbarA = new jsScrollbar('animes', document.getElementById("animes-list-scrollbar"), scrollerA, false);
			if(($('input#movies-lcID').val() > 0) && ($('input#series-lcID').val() > 0) && ($('input#animes-lcID').val() > 0)){
				var refreshTimer;
				refreshTimer = setInterval(function() {
					updateComments('movies');
					updateComments('series');
					updateComments('animes');
				}, 300000);
			}
		}
	}else{
		var scroller  = null;
		var scrollbar = null;
		if(type == 'movies')
			height = 633;
		else
			height = 420;
		scroller  = new jsScroller(document.getElementById(type+"-list"), 736, height);
		scrollbarM = new jsScrollbar(type, document.getElementById(type+"-list-scrollbar"), scroller, false);
	}
}

/* Comments */

function formatComments(){
	var moviesDiv = document.getElementById('movies-comments-list');
	var seriesDiv = document.getElementById('series-comments-list');
	var animesDiv = document.getElementById('animes-comments-list');
	maxHeightM = 993;
	maxHeightS = 780;
	maxHeightA = 470;
	//maxHeightM = 660;
	//maxHeightS = 625;
	
	
	for(mD=0;mD<2;mD++){
		totalHeight = 0;
		for(i=0;i<10;i++){
			thisItemM = moviesDiv.getElementsByClassName('item');
			totalHeight += thisItemM[i].offsetHeight;
			if(totalHeight > maxHeightM){
				thisItemM[i].style.display = 'none';
				thisItemM[i-1].className += ' last';
			}
		}
	}
	
	for(mD=0;mD<2;mD++){
		totalHeight = 0;
		for(i=0;i<10;i++){
			thisItemS = seriesDiv.getElementsByClassName('item');
			totalHeight += thisItemS[i].offsetHeight;
			if(totalHeight > maxHeightS){
				thisItemS[i].style.display = 'none';
				thisItemS[i-1].className += ' last';
			}
		}
	}
	
	for(mD=0;mD<2;mD++){
		totalHeight = 0;
		for(i=0;i<10;i++){
			thisItemS = animesDiv.getElementsByClassName('item');
			totalHeight += thisItemS[i].offsetHeight;
			if(totalHeight > maxHeightA){
				thisItemS[i].style.display = 'none';
				thisItemS[i-1].className += ' last';
			}
		}
	}
}

function updateComments(mediaType){
	var lcID = $('input#'+mediaType+'-lcID').val();
	/*$.ajax({
		type: "GET",
		url: 'updateComments.ajax.php?mediaType='+mediaType+'&mode=1&lcID='+lcID,
		success: function(msg){
			if(msg != 'error'){
				$("div#"+mediaType+"-box-comments div#"+mediaType+"-comments-list").html(msg);
				formatComments();
			}
		}
	});*/
}

/* HighLights */

function changeHighLightsContent(mediaType, button){
	highLightsHeaderBtns(mediaType, button);
	cleanSearchField(mediaType);
	setLoading(1, mediaType);
	$.ajax({
		type: "GET",
		url: 'highLights.ajax.php?mediaType='+mediaType+'&button='+button,
		success: function(msg){
			setLoading(0, mediaType);
			$("div#"+mediaType+"-box div#"+mediaType+"-list div.list-aux").html(msg);
			mediaScroller(mediaType);
		}
	});
}

function highLightsHeaderBtns(mediaType, button){
	var btns = "div#"+mediaType+"-box div.box-header ul.movies-box-btn li";
	$(btns).removeClass('slctd');
	$('div.box-header input#boxheaderBtnSlctd').val('');
	if(button != ''){
		$(btns+'#'+button).addClass('slctd');
		$('div.box-header input#boxheaderBtnSlctd').val(button);
	}
}

function setLoading(mode, mediaType){
	if(mode == 1)
		$("div#"+mediaType+"-box div#"+mediaType+"-list").addClass('loading');
	else
		$("div#"+mediaType+"-box div#"+mediaType+"-list").removeClass('loading');
}

/* Search */

function cleanSearchField(mediaType){
	$('#'+mediaType+'-searchForm input#searchBox').val($('#'+mediaType+'-searchForm input#searchBox').attr('defaultText'));
}

function search(type, mode){
	if(mode == 0)
		setLoading(1, type);
	var words = $('#'+type+'-searchForm input#searchBox').val();
	$.ajax({
		type: "GET",
		url: 'search.ajax.php?type='+type+'&mode='+mode+'&words='+words,
		success: function(msg){
			if(mode == 0){
				setLoading(0, type);
				$("div#"+type+"-list div.list-aux").html(msg);
				mediaScroller(type);
			}else
				$("div#media-right-content").html(msg);
			highLightsHeaderBtns(type, '');
		}
	});
}

function readMore(mediaType, mediaID){
	$('#movie'+mediaID+' div.movie-info span#movie-synopsis').css('display', 'none');
	$('#movie'+mediaID+' div.movie-info span#movie-synopsis-aux').removeClass('movie-synopsis-aux');
	$('#movie'+mediaID+' div.movie-info span#movie-synopsis-aux').addClass('movie-synopsis');
}

function movieUserAction(mediaType, mediaID, action){
	if($("form#logoutForm").length){
		$.ajax({
			type: "GET",
			url: 'fave.ajax.php?mediaType='+mediaType+'&mediaID='+mediaID+'&action='+action,
			success: function(msg){
				$('div#movie'+mediaID+' .movie-actions a#'+action).replaceWith(msg);
			}
		});
	}else
		loginRedirect();
}

function playerMovieAction(mediaType, mediaID, action){
	if($("form#logoutForm").length){
		$.ajax({
			type: "GET",
			url: 'fave.ajax.php?mediaType='+mediaType+'&mediaID='+mediaID+'&action='+action+'&mode=1',
			success: function(msg){
				$('div#player-box div#movie-actions a#'+action).replaceWith(msg);
			}
		});
	}else
		loginRedirect();
}

function playerSerieAction(mediaType, mediaID, action){
	if($("form#logoutForm").length){
		$.ajax({
			type: "GET",
			url: 'fave.ajax.php?mediaType='+mediaType+'&mediaID='+mediaID+'&action='+action+'&mode=2',
			success: function(msg){
				$('div#episodes-slide div.serie-actions a#'+action).replaceWith(msg);
			}
		});
	}else
		loginRedirect();
}

function playerEpisodeAction(mediaType, mediaID, action){
	if($("form#logoutForm").length){
		$.ajax({
			type: "GET",
			url: 'fave.ajax.php?mediaType='+mediaType+'&mediaID='+mediaID+'&action='+action+'&mode=3',
			success: function(msg){
				$('div#episodes-slide div#episodeInfo'+mediaID+' div.episode-actions a#'+action).replaceWith(msg);
			}
		});
	}else
		loginRedirect();
}

/* Login */

function loginFields(mode, label){
	if((mode == 1) && ($('#loginForm #'+label).val() == '')){
		$('#loginForm span#'+label+'Label').css('display', 'none');
		$('#loginForm input#'+label).css('background-color', '#fff');
	}else{
		if($('#loginForm #'+label).val() == ''){
			$('#loginForm span#'+label+'Label').css('display', 'block');
			$('#loginForm input#'+label).css('background-color', 'transparent');
		}else
			$('#loginForm input#'+label).css('background-color', '#fff');
	}
}

function validateLogin(){
	$('#loginForm #nickname').removeClass('error-input');
	$('#loginForm #nicknameLabel').css('color', '#727272');
	$('#loginForm #password1').removeClass('error-input');
	$('#loginForm #password1Label').css('color', '#727272');
	var error = 0;
	
	if($('#loginForm #nickname').val() == '' || $('#loginForm #nickname').val() == $('#loginForm #nickname').attr('defaulttext')){
		$('#loginForm #nicknameLabel').css('color', 'red');
		$('#loginForm #nickname').addClass('error-input');
		error = 1;
	}
	if($('#loginForm #password1').val() == '' || $('#loginForm #password1').val() == $('#loginForm #password1').attr('defaulttext')){
		$('#loginForm #password1Label').css('color', 'red');
		$('#loginForm #password1').addClass('error-input');
		error = 1;
	}
	
	if(error == 0){
		$.ajax({
			type: "GET",
			url: 'login.ajax.php?nickname='+$('#loginForm #nickname').val()+'&password='+$('#loginForm #password1').val(),
			success: function(msg){
				switch(msg){
					case '0':
						window.location = 'hello.blade.php';
						break;
					
					case '1':
						//$('#loginForm #usernameLabel').css('color', 'red');
						$('#loginForm #nickname').addClass('error-input');
						break;
					
					case '2':
						//$('#loginForm #passwordLabel').css('color', 'red');
						$('#loginForm #password1').addClass('error-input');
						break;
					
					case '3':
						//$('#loginForm #usernameLabel').css('color', 'red');
						$('#loginForm #nickname').addClass('error-input');
						break;
				}
			}
		});
	}
}

function validateRegister(){
	$('#loginForm #name').removeClass('error-input');
	$('#loginForm #nameL').css('color', '#727272');
	$('#loginForm #username').removeClass('error-input');
	$('#loginForm #usernameL').css('color', '#727272');
	$('#loginForm #email').removeClass('error-input');
	$('#loginForm #emailL').css('color', '#727272');
	$('#loginForm #password').removeClass('error-input');
	$('#loginForm #passwordL').css('color', '#727272');
	$('#loginForm #password confirmation').removeClass('error-input');
	$('#loginForm #password confirmationL').css('color', '#727272');
	var error = 0;
	
	if($('#loginForm #name').val() == $('#loginForm #name').attr('defaulttext')){
		$('#loginForm #nameL').css('color', 'red');
		$('#loginForm #name').addClass('error-input');
		error = 1;
	}

	if($('#loginForm #username').val() == $('#loginForm #username').attr('defaulttext')){
		$('#loginForm #usernameL').css('color', 'red');
		$('#loginForm #username').addClass('error-input');
		error = 1;
	}

	if($('#loginForm #email').val() == $('#loginForm #email').attr('defaulttext')){
		$('#loginForm #emailL').css('color', 'red');
		$('#loginForm #email').addClass('error-input');
		error = 1;
	}
	if($('#loginForm #password').val() == $('#loginForm #password').attr('defaulttext')){
		$('#loginForm #passwordL').css('color', 'red');
		$('#loginForm #password').addClass('error-input');
		error = 1;
	}
	if($('#loginForm #password confirmation').val() == $('#loginForm #password confirmation').attr('defaulttext')){
		$('#loginForm #password confirmationL').css('color', 'red');
		$('#loginForm #password confirmation').addClass('error-input');
		error = 1;
	}
	
	if(error == 0){
		$.ajax({
			type: "GET",
			url: 'register.ajax.php?username='+$('#loginForm #username').val()+'&name='+$('#loginForm #name').val()+'&email='+$('#loginForm #email').val()+'&password='+$('#loginForm #password').val()+'&password confirmation='+$('#loginForm #password confirmation').val(),
			success: function(msg){
				
				
				
				switch(msg){
					case '0':
						window.location = 'hello.blade.php';
						break;
					
					case '1':
						$('#loginForm #usernameL').css('color', 'red');
						$('#loginForm #username').addClass('error-input');
						break;
					
					case '2':
						$('#loginForm #nameL').css('color', 'red');
						$('#loginForm #name').addClass('error-input');
						break;

					case '3':
						$('#loginForm #emailL').css('color', 'red');
						$('#loginForm #email').addClass('error-input');
						break;
					
					case '4':
						$('#loginForm #passwordL').css('color', 'red');
						$('#loginForm #password').addClass('error-input');
						break;
					
					case '5':
						$('#loginForm #password confirmationL').css('color', 'red');
						$('#loginForm #password confirmation').addClass('error-input');
						break;
					
					case '5':
						$('#loginForm #usernameL').css('color', 'red');
						$('#loginForm #username').addClass('error-input');
						usernameLabel = $('#loginForm #usernameL').html().split(' já existente');
						$('#loginForm #usernameL').html(usernameLabel[0] + ' já existente');
						break;
					
					case '6':
						$('#loginForm #emailL').css('color', 'red');
						$('#loginForm #email').addClass('error-input');
						emailLabel = $('#loginForm #emailL').html().split(' já existente');
						$('#loginForm #emailL').html(emailLabel[0] + ' já existente');
						break;
				}
			}
		});
	}
}

/* Wish List */

function wishList(serieID, mode){
	var slctdS = $('div#wishlist-items input#itemsSlctd').val(),
	input = document.getElementById('serie'+serieID);
	if(input.checked == false){
		if(mode == 0)
			$('div#wishlist-items input#itemsSlctd').val(slctdS + serieID+",");
		else
			$('div#wishlist-items input#itemsSlctd').val(slctdS.replace(serieID+",", ""));
	}else{
		if(mode == 0)
			$('div#wishlist-items input#itemsSlctd').val(slctdS.replace(serieID+",", ""));
		else
			$('div#wishlist-items input#itemsSlctd').val(slctdS + serieID+",");
	}
}

function addViews(movieID, mediaType){
	$.ajax({
		type: "GET",
		url: 'addViews.ajax.php?id='+movieID+'&type='+mediaType,
		success: function(msg){
			//
		}
	});
}

/* Comments */

function textareaLabel(mode){
	if((mode == 1) && ($('div.post-comment textarea#commentBox').val() == '')){
		if($("form#logoutForm").length){
			$('div.post-comment span#comment-box-label').css('display', 'none');
		}else{
			$('div.post-comment span#comment-box-label').css('display', 'none');
			loginRedirect();
		}
	}else{
		if($('div.post-comment textarea#commentBox').val() == '')
			$('div.post-comment span#comment-box-label').css('display', 'block');
	}
}

function reloadComments(mediaType, mediaID, page){
	$.ajax({
		type: "GET",
		url: 'getComments.ajax.php?mediaType='+mediaType+'&mediaID='+mediaID+'&p='+page,
		success: function(msg){
			$("div#comments-box div#comments-list").html(msg);
		}
	});
}

function putComment(mediaType, mediaID, canComment){
	if($("form#logoutForm").length){
		
		if(canComment == 0){
			$('div#comments-box div.post-comment div.rules').html('<span>Sem permissões</span> para efectuar comentários.');
		}else{
			var comment = encodeURIComponent($('textarea#commentBox').val());
			if(comment != ''){
				$('a#comment-submit').attr('onclick', '');
				url = 'comment.ajax7427.html?mediaType='+mediaType+'&mediaID='+mediaID;
				$.ajax({
					type: "POST",
					url: url,
					data: "comment="+comment,
					success: function(msg){
						if(msg != ''){
							$('div#comments-box div.post-comment div.rules').html(msg);
							$('a#comment-submit').attr('onclick', 'putComment("'+mediaType+'", '+mediaID+', 1)');
						}else{
							$("textarea#commentBox").val("");
							$("div.post-comment span#comment-box-label").css('display', 'block');
							$('a#comment-submit').attr('onclick', 'putComment("'+mediaType+'", '+mediaID+', 1)');
							reloadComments(mediaType, mediaID, 1);
						}
					}
				});	
			}
		}
	}else
		loginRedirect();
}

function commentsLikes(commentID){
	if($("form#logoutForm").length){
		$.ajax({
			type: "GET",
			url: 'commentsLikes.ajax.php?commentID='+commentID,
			success: function(msg){
				$("div#comment"+commentID+" div#comment-likes").html(msg);
			}
		});
	}else
		loginRedirect();
}

/* Player */

function getFilehosts(){
	var mediaID = $('div#play-now-box input#mediaID').val();
	var mediaType = $('div#play-now-box input#mediaType').val();
	$.ajax({
		type: "GET",
		url: 'getFilehosts.ajax.php?mediaID='+mediaID+'&mediaType='+mediaType,
		success: function(msg){
			$('div#play-now-box div#fhChoose').html(msg);
			$('div#play-now-box div#fhChoose').removeClass('loadingFh');
		}
	});
	
}

function playNow(){
	if($("form#logoutForm").length){
		var is_chrome = navigator.userAgent.toLowerCase().indexOf('chrome') > -1;
		var is_firefox = navigator.userAgent.toLowerCase().indexOf('firefox') > -1
		mainDiv = document.getElementById('play-now-box');
		if(mainDiv.getElementsByClassName('no-plugin')[0].style.display == 'none'){
			if(is_chrome || is_firefox){
				$('div#play-box div#playNow').fadeOut('fast');
				$('div#play-box div#fhChoose').addClass('loadingFh');
				$('div#play-box div#fhChoose').fadeIn('slow');
				getFilehosts();
			}
		}else{
			if(!is_chrome && !is_firefox){
				$('div#play-box div#playNow').fadeOut('fast');
				$('div#play-box div.no-plugin').fadeOut('fast');
				$('div#play-box div#installBrowser').fadeIn('slow');
			}else{
				if(is_firefox){
					$('#pluginDl').attr('href', 'plugindl.php');
					$('#pluginDl').attr('onclick', '');
				}
				$('div#play-box div#playNow').fadeOut('fast');
			}
		}
	}else
		loginRedirect();

	
		//check if browser is chrome/firefox
		
		/*if(!is_chrome && !is_firefox)
			alert('instala o chrome ou o firefox.');
		else{*/
			//plug-in installed?
			
			
			//everything is ok :D
			/*$('div#play-box div#play-now-box').html('<span class="loading"></span>');
			$('div#play-box div#movie-stats').html('<span class="loading"></span>');
			$('div#play-box div#play-now-box').fadeOut('slow');
			$('div#play-box div#movie-stats').fadeOut('slow');
			$('div#play-box').animate({height: '955px'}, 1500);
			$.ajax({
				type: "GET",
				url: 'playNow.ajax.php?mediaType='+mediaType+'&mediaID='+mediaID,
				success: function(msg){
					$('div#play-box').html(msg);
					$('div#play-now-aux').fadeIn('slow');
					scrollToDiv('#media-player');
				}
			});*/
		/*}*/
}

function openPopUp(id){
	$('#popup-'+id+'-bg').css("height", $(document).height()+"px");
	$('#popup-'+id+'-bg').fadeIn('fast');
	$('#popup-'+id).fadeIn('fast');
	document.body.style.overflow="hidden";
	if(id == 'smsBtn'){
		gCID = $('div#episodes-slide input#googleCalendar').val();
		$('#popup-'+id+' div.ph-box a').attr('href', 'https://www.google.com/calendar/render?cid='+gCID);
		if($('#popup-'+id+' div.ph-box iframe').attr('src') == '')
			$('#popup-'+id+' div.ph-box iframe').attr('src', 'http://www.youtube.com/embed/9HnoNLRpT5s?rel=0');
	}
}

function closePopUp(id){
	$('#popup-'+id+'-bg').fadeOut('fast');
	$('#popup-'+id).fadeOut('fast');
	document.body.style.overflow="visible";
	if(id == 'smsBtn')
		$('#popup-'+id+' div.ph-box iframe').attr('src', '');
}

function showPlayer(){
	//check player mode
	var fullUrl = location.href.split("index.html");
	playerMode = fullUrl[3].split("&url=");
	success = 0;
	if(playerMode[1]){
		if(playerMode[1] != '' && $('#fakeplayer').css('display') != 'block'){
			$('#play-now-aux').fadeIn('slow');
			scrollToDiv('#play-now-aux #media-player');
		}
	}
}

function seasonsList(){
	var downTimer;
	
	$("div#seasonsLeftArrow").mousedown(function() {
		clearInterval(downTimer);
		container = $("div#seasons-list");
		downTimer = setInterval(function() {
			container.scrollLeft(container.scrollLeft()-5);
		}, 15);
		
	}).mouseup(function() {
		clearInterval(downTimer);
	});
	
	$("div#seasonsRightArrow").mousedown(function() {
		clearInterval(downTimer);
		container = $("div#seasons-list");
		downTimer = setInterval(function() {
			container.scrollLeft(container.scrollLeft()+5);
		}, 15);
		
	}).mouseup(function() {
		clearInterval(downTimer);
	});
	
	$("div#seasonsLeftArrow").click(function() {
		return false;
	});
	
	$("div#seasonsRightArrow").click(function() {
		return false;
	});
	
	/* scroll to selected season */
	var i = 0;
	var pos = 0;
	$('div#seasons-list div.season a').each(function(index) {
		i++;
		if($(this).hasClass('slctd'))
			pos = i;
	});
	
	if(i > 5)
		$("div#seasons-list").scrollLeft((pos-4)*40);
}

function episodeScroll(){
	//check player mode
	var fullUrl = location.href.split("index.html");
	playerMode = fullUrl[3].split("&ep=");
	success = 0;
	if(playerMode[1]){
		if(playerMode[1] != ''){
			success = 1;
			scrollToDiv('#player-box #episodes-slide');
		}
	}
	playerMode2 = fullUrl[3].split("&season=");
	if(success == 0){
		if(playerMode2[1]){
			if(playerMode2[1] != ''){
				success = 1;
				scrollToDiv('#player-box #episodes-slide');
			}
		}
	}
}

function episodeSlide(){
	
	
	
	//var downTimer;
	//Episodes Slide
	
	/*$("div#episodes-slide div#slide-left-arrow a").mousedown(function() {
		clearInterval(downTimer);
		container = $("div#episodes-list");
		downTimer = setInterval(function() {
			container.scrollLeft(container.scrollLeft()-7);
		}, 15);
		
	}).mouseup(function() {
		clearInterval(downTimer);
	});
	
	$("div#episodes-slide div#slide-right-arrow a").mousedown(function() {
		clearInterval(downTimer);
		container = $("div#episodes-list");
		downTimer = setInterval(function() {
			container.scrollLeft(container.scrollLeft()+7);
		}, 15);
		
	}).mouseup(function() {
		clearInterval(downTimer);
	});*/
	
	/* scroll to selected episode */
	var i = 0;
	var nS = 0;
	var pos = 0;
	$('div#episodes-list div.item').each(function(index) {
		i++;
		if($(this).hasClass('slctd'))
			pos = i;
		if((i > 1) && (pos == 0) && ((i % 5) == 0)){
			nS++;
		}	
	});
	
	if(i > 5){
		if(pos > 0){
			var val = (nS*5)*176;
			$("div#episodes-list").scrollLeft(val);
			$("input#visibleEpsGroup").val(nS);
		}
	}
	
	//slide arrows

	$("div#episodes-slide div#slide-left-arrow a").click(function() {
		var distanceToScrollLeft = (($("input#visibleEpsGroup").val() - 1) * 5)*176;
		container = $("div#episodes-list");
		container.animate({scrollLeft: distanceToScrollLeft}, 600);
		if($("input#visibleEpsGroup").val() > 0)
			$("input#visibleEpsGroup").val($("input#visibleEpsGroup").val() -1);
		return false;
	});
	
	$("div#episodes-slide div#slide-right-arrow a").click(function() {
		var distanceToScrollRight = ((($("input#visibleEpsGroup").val() - 1) + 2) * 5)*176;
		container = $("div#episodes-list");
		container.animate({scrollLeft: distanceToScrollRight}, 600);
		var maxS = Math.floor((i - 1) / 5);
		if($("input#visibleEpsGroup").val() < maxS)
			$("input#visibleEpsGroup").val(($("input#visibleEpsGroup").val() -1) + 2);
		return false;
	});
	
	//change episode info
	$("div#episodes-list div.item div.thumb").mouseover(function() {
		var episodeID = $(this).parent().attr('id').split('episode');
		episodeID = episodeID[1];
		$('div#slide-top-bar div.episode-info').css('display', 'none');
		$('div#slide-top-bar div#episodeInfo'+episodeID).css('display', 'block');
		
	}).mouseout(function() {
		var episodeID = $('div#episodes-slide input#episode-selected').val();
		$('div#slide-top-bar div.episode-info').css('display', 'none');
		$('div#slide-top-bar div#episodeInfo'+episodeID).css('display', 'block');
	});
	
	$("div#episodes-slide div#seasons-list div.slctd a").click(function() {
		return false;
	});
}

function openReport(){
	$('#report-problems-bg').css("height", $(document).height()+"px");
	$('#report-problems-bg').fadeIn('fast');
	$('#report-problems').fadeIn('fast');
	document.body.style.overflow="hidden";
}

function closeReport(defText){
	$('#report-problems').fadeOut('fast');
	$('#report-problems-bg').fadeOut('fast');
	document.body.style.overflow="visible";
	$('#reportBox').removeClass("error");
	$('#reportBox').val(defText);
	$('div#reports-msg').fadeOut("fast");
	$('div#reports-msg').html("");
}

function reportProblems(mediaType, mediaID, defText){
	if($("form#logoutForm").length){
		$('#reportBox').removeClass("error");
		if(($('#reportBox').val() == defText) || ($('#reportBox').val() == '')){
			$('#reportBox').addClass("error");
		}else{
			url = 'report.ajax7427.html?mediaType='+mediaType+'&mediaID='+mediaID;
			$.ajax({
				type: "POST",
				url: url,
				data: "problem="+$('#reportBox').val(),
				success: function(msg){
					$('div#reports-msg').html(msg);
					$('div#reports-msg').fadeIn("fast");
					setTimeout('closeReport("'+defText+'")', 3000);
				}
			});	
		}
	}else
		loginRedirect();
}

function notificationPreview(notificationID, show){
	if($("form#logoutForm").length){
		if(show == 1){
			$('div#notification'+notificationID+' div.notification-label').attr('onclick', 'notificationPreview('+notificationID+', 0);');
			$('div#notification'+notificationID+' div.notification-label').removeClass('unchecked');
			$('div#notifPrev'+notificationID).fadeIn("fast");
		}else{
			$('div#notification'+notificationID+' div.notification-label').attr('onclick', 'notificationPreview('+notificationID+', 1);');
			$('div#notifPrev'+notificationID).fadeOut("fast");
		}
	}else
		loginRedirect();
}

function notificationsList(type, mode){
	if($("form#logoutForm").length){
		var slctdG = $('#selectedNotificationType').val(),
		input = document.getElementById('type'+type);
		if(input.checked == false){
			if(mode == 0)
				$('#selectedNotificationType').val(slctdG + type+",");
			else
				$('#selectedNotificationType').val(slctdG.replace(type+",", ""));
		}else{
			if(mode == 0)
				$('#selectedNotificationType').val(slctdG.replace(type+",", ""));
			else
				$('#selectedNotificationType').val(slctdG + type+",");
		}
		
		var url = 'index-2.html';
		if($('#selectedNotificationType').val() != '')
			url += '?types=' + $('#selectedNotificationType').val();
		
		ajaxRequestGET(url, $('div#notifications-items'));
	}else
		loginRedirect();
}

function checkNotification(notificationID, mode, url){
	if($("form#logoutForm").length){
		$.ajax({
			type: "GET",
			url: 'checkNotification.ajax.php?notificationID='+notificationID,
			success: function(msg){
				if(mode == 1)
					window.location = url;
			}
		});
	}else
		loginRedirect();
}

function myAccount(url, container){
	if($("form#logoutForm").length){
		$.ajax({
			type: "GET",
			url: url,
			success: function(msg){
				container.html(msg);
				formatCheckb('accountMediaChangeContent');
			}
		});
	}else
		loginRedirect();
}

function setAccountCategory(cat){
	$('div.media-box div#mediaHeader div.media-header-option').removeClass('h-slctd');
	$('div.media-box div#mediaHeader div#mediaHeader-'+cat).addClass('h-slctd');
}

function favedOrCliped(url){
	if((url[1] == 'action=faved') || (url[1] == 'action=cliped')){
		scrollToDiv('#content #account-box');
	}
}

function accountSerieSubscribe(serieID){
	if($("form#logoutForm").length){
		$.ajax({
			type: "GET",
			url: 'serieSubscribe.ajax.php?mediaID='+serieID,
			success: function(msg){
				if(msg == '1'){
					$('#subscribeSerie'+serieID+'Label').html('Subscrita');
					$('#subscribeSerie'+serieID+'Label').addClass('subscribed');
				}else{
					$('#subscribeSerie'+serieID+'Label').html('Subscrever');
					$('#subscribeSerie'+serieID+'Label').removeClass('subscribed');
				}
			}
		});
	}else
		loginRedirect();
}

function openAccountSettings(setting){
	if($("form#logoutForm").length){
		$.ajax({
			type: "GET",
			url: 'accountSettingsWindow.ajax.php?setting='+setting,
			success: function(msg){
				$('div#settings-window').html(msg);
				$('div#settings-window #settings-bg').css("height", $(document).height()+"px");
				$('div#settings-window #settings-bg').fadeIn('fast');
				$('div#settings-window #settings').fadeIn('fast');
				document.body.style.overflow="hidden";
				if((setting == 'email') || (setting == 'pw'))
					$('div#settings-window #settings input#password').focus();
			}
		});
	}else
		loginRedirect();
}

function closeAccountSettings(){
	if($("form#logoutForm").length){
		$('#report-problems').fadeOut('fast');
		$('#report-problems-bg').fadeOut('fast');
		document.body.style.overflow="visible";
		$('div#settings-window').html('');
	}else
		loginRedirect();
}

function changeAvatar(){
	if($("form#logoutForm").length){
		var avatar = $('input#avatar').val();
		if(avatar != ''){
			if((avatar.substr(-3) != 'jpg') && (avatar.substr(-3) != 'JPG') && (avatar.substr(-4) != 'JPEG') && (avatar.substr(-4) != 'jpeg') && (avatar.substr(-3) != 'png') && (avatar.substr(-3) != 'PNG')){
				$('div#window-settings-msg').html('Seleccione uma imagem no formato jpg ou png.');
				$('div#window-settings-msg').fadeIn('fast');
			}else{
				//everything is ok:
				$('form#accountSettingsForm').submit();
			}
		}else{
			$('div#window-settings-msg').html('Seleccione uma imagem no formato jpg ou png.');
			$('div#window-settings-msg').fadeIn('fast');
		}
	}else
		loginRedirect();
}

function changeSettings(setting){
	if($("form#logoutForm").length){
		var error = 0;
		var textmsg = '';
		$('form#accountSettingsForm input').removeClass('error');
		$('div#window-settings-msg').fadeOut('fast');
		url = 'index-2.html?setting='+setting;
		
		if(setting == 'email'){
			if(($('form#accountSettingsForm input#password').val() == '') || ($('form#accountSettingsForm input#newemail').val() == ''))
				error = 1;
			else
				url += '&password='+$('form#accountSettingsForm input#password').val()+'&newemail='+$('form#accountSettingsForm input#newemail').val();
		}else if(setting == 'password'){
			if(($('form#accountSettingsForm input#password').val() == '') || ($('form#accountSettingsForm input#newpassword').val() == '') || ($('form#accountSettingsForm input#newpasswordconf').val() == ''))
				error = 1;
			else
				url += '&password='+$('form#accountSettingsForm input#password').val()+'&newpassword='+$('form#accountSettingsForm input#newpassword').val()+'&newpasswordconf='+$('form#accountSettingsForm input#newpasswordconf').val();
		}
		
		if(error == 0){
			$.ajax({
				type: "GET",
				url: url,
				success: function(msg){
					if(setting == 'email'){
						switch(msg){
							case '0':
								textmsg = 'Ocorreu um erro inesperado, tente novamente.';
								break;
								
							case '1':
								textmsg = 'Endereço de e-mail alterado com <b>sucesso</b>.';
								setTimeout('closeAccountSettings()', 3000);
								break;
							
							case '2':
								textmsg = 'Password actual incorrecta.';
								$('form#accountSettingsForm input#password').addClass('error');
								break;
							
							case '3':
								textmsg = 'E-mail inserido incorrectamente.';
								$('form#accountSettingsForm input#newemail').addClass('error');
								break;
							
							case '4':
								textmsg = 'O e-mail introduzido já se encontra em uso.';
								$('form#accountSettingsForm input#newemail').addClass('error');
								break;
						}
					}else if(setting == 'password'){
						switch(msg){
							case '0':
								textmsg = 'Ocorreu um erro inesperado, tente novamente.';
								break;
								
							case '1':
								textmsg = 'Password modificada com <b>sucesso</b>.';
								setTimeout('closeAccountSettings()', 3000);
								break;
							
							case '2':
								textmsg = 'Password actual incorrecta.';
								$('form#accountSettingsForm input#password').addClass('error');
								break;
							
							case '3':
								textmsg = 'A password tem que conter mais de 5 caracteres.';
								$('form#accountSettingsForm input#newpassword').addClass('error');
								$('form#accountSettingsForm input#newpasswordconf').addClass('error');
								break;
							
							case '4':
								textmsg = 'A nova password não coincide.';
								$('form#accountSettingsForm input#newpassword').addClass('error');
								$('form#accountSettingsForm input#newpasswordconf').addClass('error');
								break;
						}
					}
					$('div#window-settings-msg').html(textmsg);
					$('div#window-settings-msg').fadeIn('fast');
				}
			});
		}else{
			$('div#window-settings-msg').html('Preencha todos os campos em cima.');
			$('div#window-settings-msg').fadeIn('fast');
		}
	}else
		loginRedirect();
}

function changeSiteColor(color){
	if($("form#logoutForm").length){
		$('div#colors-list div.color-bg').removeClass('slctd');
		$('div#colors-list div#siteColor'+color).addClass('slctd');
		$.ajax({
			type: "GET",
			url: 'changeAccountSettings.ajax.php?setting=sitecolor&color='+color,
			success: function(msg){
				if(msg == '1')
					window.location = "account.html";
			}
		});
	}else
		loginRedirect();
}

function commentsReply(cID){
	if($("form#logoutForm").length){
		scrollToDiv('div#comments-box');
		var newString = "[c#"+cID+"]\n";
		$("#comment-box-label").css("display", "none");
		$("#commentBox").focus();
		$("#commentBox").val($("#commentBox").val() + newString);
	}else
		loginRedirect();
}

function rateStars(){
	//Rater
	$("div#movie-rate div.stars").mouseleave(function() {
		on = parseInt($("input#raterDefault").val())+1;
		for(var i = 1; i <= on; i++)
			$("a#rater"+i).addClass('full');
		for(var i = on; i <= 10; i++)
			$("a#rater"+i).removeClass('full');
	});
	
	$("div#movie-rate a").mouseover(function() {
		on = parseInt($(this).attr('id').substr(5, 2))+1;
		
		for(var i = 1; i <= on; i++)
			$("a#rater"+i).addClass('full');
		for(var i = on; i <= 10; i++)
			$("a#rater"+i).removeClass('full');
	});
}

function mediaRater(mediaType, mediaID, rate){
	if($("form#logoutForm").length){
		if(rate < 1)
			rate = 1;
		else if(rate > 10)
			rate = 10;
		$.ajax({
			type: "GET",
			url: 'mediaRater.ajax.php?mediaType='+mediaType+'&mediaID='+mediaID+'&rate='+rate,
			success: function(msg){
				$('div#movie-rate input#raterDefault').val(msg);
				
				on = parseInt($("div#movie-rate input#raterDefault").val())+1;
				for(var i = 1; i <= on; i++)
					$("a#rater"+i).addClass('full');
				for(var i = on; i <= 10; i++)
					$("a#rater"+i).removeClass('full');
			}
		});
	}else
		loginRedirect();
}

function mediaScroll(){
	var fullUrl = location.href.split("index.html");
	var playerMode = fullUrl[3].split("&comment=");
	var url = fullUrl[3].split("?");
	if(playerMode[1]){
		if(playerMode[1] != ''){
			scrollToDiv('div#comments-list div#comment'+playerMode[1]);			
		}else{
			if((url[0] == 'index-2.html') || (url[0] == 'index-2.html'))
				episodeScroll();
		}
	}else{
		if((url[0] == 'index-2.html') || (url[0] == 'index-2.html'))
			episodeScroll();
	}
	
	//Remove Filehosts by Browser
	/*var is_chrome = navigator.userAgent.toLowerCase().indexOf('chrome') > -1;
	var is_firefox = navigator.userAgent.toLowerCase().indexOf('firefox') > -1
	if(is_firefox){
		$('div#play-now-box div#fhChoose a.bayfiles').css('display', 'none');
		$('div#play-now-box div#fhChoose span#fhChoosePipe1').css('display', 'none');
	}*/
	//$('div#play-now-box div#fhChoose a.vidmega').css('display', 'none');
	//$('div#play-now-box div#fhChoose a.bayfiles').css('margin-left', '145px');
	//$('div#play-now-box div#fhChoose span#fhChoosePipe1').css('display', 'none');
	
	// Bayfiles unavailable?
		/*$('div#play-now-box div#fhChoose span#fhChoosePipe2').css('display', 'none');
		$('div#play-now-box div#fhChoose a.bayfiles').css('display', 'none');
		$('div#play-now-box div#fhChoose a.vidmega').css('margin-left', '145px');*/
	
	// Videomega unavailable?
		/*$('div#play-now-box div#fhChoose span#fhChoosePipe1').css('display', 'none');
		$('div#play-now-box div#fhChoose a.vidmega').css('display', 'none');
		$('div#play-now-box div#fhChoose a.bayfiles').css('margin-left', '145px');*/
}

function removeMediaContent(mediaType, mediaID, confirmQuestion){
	if(confirm(confirmQuestion) == true){
		var slctdMO = $('#selectedmediaOptions').val();
		switch(mediaType){
			case 'movies':
				if(slctdMO == 2)
					action = 'faved';
				else
					action = 'cliped';
				break;
			
			case 'series':
				if(slctdMO == 1)
					action = 'subscribed';
				else
					action = 'faved';
				break;
			
			case 'episodes':
				action = 'cliped';
				break;
			
			default:
				if(slctdMO == 1)
					action = 'faved';
				else
					action = 'cliped';
				break;
		}
		
		$('div#mediaAccountContent div#accmedia'+mediaID+' a').fadeOut('slow');
		$.ajax({
			type: "GET",
			url: 'fave.ajax.php?mediaType='+mediaType+'&mediaID='+mediaID+'&action='+action,
			success: function(msg){
				var url = 'index-2.html?p=1&amp;order='+$('input#account-order').val()+'&cat='+mediaType+'&action='+action;
				myAccount(url, $('#accountMediaChangeContent'));
				scrollToDiv('#content #account-box');
			}
		});
	}
}

function faqContent(answerID){
	if($('div#faq-box #answer'+answerID+' .answer-content').css('display') == 'none'){
		$('div#faq-box #answer'+answerID+' #questionStatus').addClass('hide-question');
		$('div#faq-box #answer'+answerID+' #questionStatus').removeClass('show-question');
		$('div#faq-box #answer'+answerID+' .answer-content').fadeIn('fast');
	}else{
		$('div#faq-box #answer'+answerID+' #questionStatus').addClass('show-question');
		$('div#faq-box #answer'+answerID+' #questionStatus').removeClass('hide-question');
		$('div#faq-box #answer'+answerID+' .answer-content').fadeOut('fast');
	}
}

function deleteComment(mediaType, mediaID, commentID, confirmQuestion, banUser, page){
	if(confirm(confirmQuestion) == true){
		$.ajax({
			type: "GET",
			url: 'deleteComment.ajax.php?commentID='+commentID+'&ban=0',
			success: function(msg){
				reloadComments(mediaType, mediaID, page);
			}
		});
	}
}

function serieStatus(serieID, actualStatus){
		var slctdStatus = new Array('', '', '', '');
		slctdStatus[actualStatus] = ' selected="selected"';
		var serieStatusHtml = '- <select id="selectSerieStatus" name="selectSerieStatus"><option id="serieStatus0" value="0"'+slctdStatus[0]+'>Concluída</option><option id="serieStatus1" value="1"'+slctdStatus[1]+'>Em Exibição</option><option id="serieStatus2" value="2"'+slctdStatus[2]+'>Completa</option><option id="serieStatus3" value="3"'+slctdStatus[3]+'>Em Pausa</option></select>';
		$('#movie'+serieID+' .movie-info #serieStatus').html(serieStatusHtml);
		selectS = document.getElementById('selectSerieStatus');
		$('#selectSerieStatus').attr('onchange', 'changeSerieStatus('+serieID+', document.getElementById(\'selectSerieStatus\').value);');
}

function changeSerieStatus(serieID, newStatus){
	$.ajax({
		type: "GET",
		url: 'changeSerieStatus.ajax.php?serieID='+serieID+'&newStatus='+newStatus,
		success: function(msg){
			$('#movie'+serieID+' .movie-info #serieStatus').html('- '+msg);
		}
	});
}

/* Password Recovery */

function openPasswordRecovery(){
	$('#pw-recovery-bg').css("height", $(document).height()+"px");
	$('#pw-recovery-bg').fadeIn('fast');
	$('#pw-recovery').fadeIn('fast');
	document.body.style.overflow="hidden";
	$('div#pw-recovery form#passwordRecoveryForm input#recoverEmail').focus();
}

function closePasswordRecovery(){
	$('#pw-recovery').fadeOut('fast');
	$('#pw-recovery-bg').fadeOut('fast');
	document.body.style.overflow="visible";
	$('div#pw-recovery div#pw-recovery-msg').html('');
}

function passwordRecovery(){
	$('div#pw-recovery div#pw-recovery-msg').fadeOut('fast');
	$.ajax({
		type: "GET",
		url: 'recover.php?mode=send&email='+$('input#recoverEmail').val(),
		success: function(msg){
			$('div#pw-recovery div#pw-recovery-msg').html(msg);
			$('div#pw-recovery div#pw-recovery-msg').fadeIn('fast');
			if(msg == 'Siga as instruções enviadas por email.')
				setTimeout('closePasswordRecovery()', 3000);
		}
	});
}

function expandPlayer(mediaType, mediaID){
	$('div#play-box div#play-now-box').html('<span class="loading"></span>');
	$('div#play-box div#movie-stats').html('<span class="loading"></span>');
	$('div#play-box div#play-now-box').fadeOut('slow');
	$('div#play-box div#movie-stats').fadeOut('slow');
	$('div#play-box').animate({height: '955px'}, 1500);
	$.ajax({
		type: "GET",
		url: 'playNow.ajax.php?mediaType='+mediaType+'&mediaID='+mediaID,
		success: function(msg){
			$('div#play-box').html(msg);
			$('div#play-now-aux').fadeIn('slow');
			scrollToDiv('#play-now-aux #media-player');
		}
	});
}

/* REQUESTS */

function requestsOrderBy(order){
	$('div#requests div.hmReq a').removeClass('slctd');
	$('div#requests div.hmReq a#'+order).addClass('slctd');
	requestsList($('div#requests input#reqsListTypeActive').val(), 'order', order);
}

function requestFormImdb(mode){
	if(mode == 1){
		$('form#reqForm input#imdb').removeClass('default');
	}else{
		if($('form#reqForm input#imdb').val() == '' || $('form#reqForm input#imdb').val() == $('form#reqForm input#imdb').attr('defaulttext'))
			$('form#reqForm input#imdb').addClass('default');
	}
}

function requestsListType(type){
	if(type == 'series' || type == 'movies'){
		$('div#requests div.listMediaType a.slctd').removeClass('slctd');
		$('div#requests div.listMediaType a#'+type+'TypeSlctd').addClass('slctd');
		requestsList(type, 'order', $('div#requests input#reqOrderValue').val());
	}else
		alert("I don't think so.");
}

function requestsList(type, action, value){
	if(type == 'movies' || type == 'series')
		var params = '?type='+type;
	
	if(action == 'pagination'){
		params += '&p='+value;
		if($('div#requests input#reqOrderValue').val() != '')
			params += '&order='+$('div#requests input#reqOrderValue').val();
	}else if(action == 'order'){
		if(value == '')
			value = 'date';
		params += '&order='+value;
	}else if(action == 'search'){
		if(type == 'movies' || type == 'series')
			params += '&search='+value;
		else
			params = '?search='+value;
	}
	
	scrollToDiv('div#requests-box');
	
	$.ajax({
		type: "GET",
		url: 'requestsList.ajax.php'+params,
		success: function(msg){
			$('div#requests').replaceWith(msg);
		}
	});
}

function myRequestsList(maxPage, page, side){
	if($("form#logoutForm").length){
		$.ajax({
			type: "GET",
			url: 'myRequestsList.ajax.php?p='+page,
			success: function(msg){
				
				hmReqs = $('div#myRequests input#howManyMyReqs').val();
				if(hmReqs == 0)
					$('div#myRequests').html($('div#myRequests').html() + '<span class="error">Ainda não efectuaste quaisquer pedidos.</span>');
				else
					$('div#myRequests span.error').remove();
				
				// Pagination
				if(page == 0)
					page = 1;
				$('div#myRequests a.myReqPrev').attr('href', 'javascript: myRequestsList('+maxPage+', '+(page-1)+', 1);');
				$('div#myRequests a.myReqNext').attr('href', 'javascript: myRequestsList('+maxPage+', '+((page-1)+2)+', 2);');
				if(page == 0 || page == 1)
					$('div#myRequests a.myReqPrev').css('display', 'none');
				else
					$('div#myRequests a.myReqPrev').css('display', 'block');
				if(page == maxPage)
					$('div#myRequests a.myReqNext').css('display', 'none');
				else
					$('div#myRequests a.myReqNext').css('display', 'block');
				
				if(side == 1 || side == 2){
					//Content
					var reqList = '<div id="myRequestList" class="myRequestList">'+$('div#myRequests div.myRequestList').html()+'</div>';
					var newReqList = '</div><div id="myRequestList2" class="myRequestList">'+msg+'</div>';
					
					if(side == 1){
						scrollDistance = '-19px';
						$('div#myRequests div.myRequestList').replaceWith(newReqList  + reqList);
						container = $('div#myRequests div#myRequestList2 div.myReq');
						container.css('margin-left', '-289px');
					}else if(side == 2){
						scrollDistance = '-289px';
						$('div#myRequests div.myRequestList').replaceWith(reqList  + newReqList);
						container = $('div#myRequests div#myRequestList div.myReq');
					}
					
					$('div#myRequests').css('overflow', 'hidden');
					$('div#myRequests div#myRequestList').fadeOut('slow');
					container.animate({marginLeft: scrollDistance}, 600, function(){
						$('div#myRequests div#myRequestList').attr('id', 'myRequestListTemp');
						$('div#myRequests div#myRequestListTemp').remove();
						$('div#myRequests').css('overflow', 'visible');
					});
				}else
					$('div#myRequests div.myRequestList').html(msg);
			}
		});
	}else
		loginRedirect();
}

function removeDiv(parent, child){
	var main = document.getElementById(parent);
	var oldReq = document.getElementById(child);
	main.removeChild(oldReq);
}

function addRequest(id, action){
	if($("form#logoutForm").length){
		var requests = $('div#requestsList div#req'+id+' div.reqInfo span.hmReqs span').html();
		$.ajax({
			type: "GET",
			url: 'requestsIncrement.ajax.php?reqID='+id+'&action='+action,
			success: function(msg){
				if(msg == 1){
					newLabel = 'Desejado';
					newValue = 0;
					newReqs = (requests - 1) + 2;
					$('div#myRequests input#howManyMyReqs').val(($('div#myRequests input#howManyMyReqs').val() - 1) + 2);
					$('div#requestsList div#req'+id+' div.reqInfo a').attr('onmouseover', 'removeReqBtn('+id+', 1, \'Desejado\', \'Remover Pedido\')');
					$('div#requestsList div#req'+id+' div.reqInfo a').attr('onmouseout', 'removeReqBtn('+id+', 0, \'Desejado\', \'Remover Pedido\')');
				}else{
					newLabel = 'Também desejo';
					newValue = 1;
					newReqs = (requests - 1);
					$('div#myRequests input#howManyMyReqs').val($('div#myRequests input#howManyMyReqs').val() - 1);
					$('div#requestsList div#req'+id+' div.reqInfo a').attr('onmouseover', '');
					$('div#requestsList div#req'+id+' div.reqInfo a').attr('onmouseout', '');
				}
				// Delete Request
				if(newReqs == 0){
					requestsList($('div#requests input#reqsListTypeActive').val(), '', '');
					
				// Modify Add Request Button
				}else{
					if(newReqs == 1)
						newCap = '<span>'+newReqs+'</span> PEDIDO';
					else
						newCap = '<span>'+newReqs+'</span> PEDIDOS';
						
					$('div#requestsList div#req'+id+' div.reqInfo span.hmReqs').html(newCap);
					$('div#requestsList div#req'+id+' div.reqInfo a').html(newLabel);
					$('div#requestsList div#req'+id+' div.reqInfo a').attr('href', 'javascript: addRequest('+id+', '+newValue+');');
				}
				refreshMyRequestsList();
			}
		});
	}else
		loginRedirect();
}

function refreshMyRequestsList(){
	hmReqs = $('div#myRequests input#howManyMyReqs').val();
	myReqsLimit = $('div#myRequests input#myReqsLimit').val();
	maxPage = Math.ceil($('div#myRequests input#howManyMyReqs').val() / myReqsLimit);
	myRequestsList(maxPage, 0, 0);
}

function requestValidation(){
	if($("form#logoutForm").length){
		$('form#reqForm input#imdb').removeClass('errorInput');
		$('div#makeAReq span#reqMsg').removeClass('error');
		if(($('form#reqForm input#imdb').val() != '') && ($('form#reqForm input#imdb').val() != $('form#reqForm input#imdb').attr('defaulttext'))){
			$('div#makeAReq span#reqMsg').html('Aguarde...');
			$('form#reqForm').attr('action', 'javascript: return false;');
			$.ajax({
				type: "GET",
				url: 'makeRequest.ajax.php?imdb='+encodeURIComponent($('form#reqForm input#imdb').val()),
				success: function(msg){
					var result = msg.split(' | ');
					switch(result[0]){
						case '0':
							$('div#makeAReq span#reqMsg').html(result[2]);
							$('div#makeAReq span#reqMsg').addClass('error');
							break;
						
						case '1':
							$('form#reqForm input#imdb').addClass('errorInput');
							$('div#makeAReq span#reqMsg').addClass('error');
							$('div#makeAReq span#reqMsg').html(result[2]);
							break;
						
						case '2':
							$('div#makeAReq span#reqMsg').html(result[2]);
							$('div#makeAReq span#reqMsg').addClass('error');
							requestsList(result[1], 'search', result[3]);
							break;
						
						case '3':
							$('div#makeAReq span#reqMsg').html(result[2]);
							$('form#reqForm input#imdb').val($('form#reqForm input#imdb').attr('defaulttext'));
							requestFormImdb(0);
							requestsList(result[1], 'search', result[3]);
							break;
						
						case '4':
							$('div#makeAReq span#reqMsg').html(result[2]);
							getRequestsMediaInfo(result[3]);
							break;
						
						case '5':
							$('div#makeAReq span#reqMsg').html(result[2]);
							$('form#reqForm input#imdb').val($('form#reqForm input#imdb').attr('defaulttext'));
							
							requestsList(result[1], 'order', 'date');
							$('div#myRequests input#howManyReqs').val(($('div#myRequests input#howManyReqs').val() - 1) + 2);
							requestFormImdb(0);
							refreshMyRequestsList();
							break;
						
						case '6':
							$('div#makeAReq span#reqMsg').html(result[2]);
							$('div#makeAReq span#reqMsg').addClass('error');
							break;
						
						case '7':
							$('div#makeAReq span#reqMsg').html(result[2]);
							$('div#makeAReq span#reqMsg').addClass('error');
							break;
						
						case '8':
							$('div#makeAReq span#reqMsg').html(result[2]);
							$('div#makeAReq span#reqMsg').addClass('error');
							break;
						
						case '9':
							$('div#makeAReq span#reqMsg').html(result[2]);
							$('div#makeAReq span#reqMsg').addClass('error');
							break;
						
						default:
							$('div#makeAReq span#reqMsg').html(result[2]);
							$('div#makeAReq span#reqMsg').addClass('error');
							break;
					}
					$('form#reqForm').attr('action', 'javascript: requestValidation();');
				}
			});
		}else{
			$('form#reqForm input#imdb').addClass('errorInput');
			$('form#reqForm input#imdb').focus();
		}
	}else
		loginRedirect();
}

function getRequestsMediaInfo(mediaID){
	$.ajax({
		type: "GET",
		url: 'requestsMediaInfo.ajax.php?mediaID='+encodeURIComponent(mediaID),
		success: function(msg){
			$('div#mediaPreview').html(msg);
			$('div#mediaPreview').fadeIn('fast');
		}
	});
}

function cancelRequestsPreview(){
	$('div#mediaPreview').fadeOut('slow');
}

function removeReqBtn(reqID, mode, label1, label2){
	if(mode == 0)
		$('div#requestsList div#req'+reqID+' div.reqInfo a').html(label1);
	else if(mode == 1)
		$('div#requestsList div#req'+reqID+' div.reqInfo a').html(label2);
}

















/* Scroller & Scrollbar */

function jsScroller (o, w, h) {
	var self = this;
	var list = o.getElementsByTagName("div");
	for (var i = 0; i < list.length; i++) {
		if (list[i].className.indexOf("list-aux") > -1) {
			o = list[i];
		}
	}
	
	//Private methods
	this._setPos = function (x, y) {
		if (x < this.viewableWidth - this.totalWidth) 
			x = this.viewableWidth - this.totalWidth;
		if (x > 0) x = 0;
		if (y < this.viewableHeight - this.totalHeight) 
			y = this.viewableHeight - this.totalHeight;
		if (y > 0) y = 0;
		this._x = x;
		this._y = y;
		with (o.style) {
			left = this._x +"px";
			top  = this._y +"px";
		}
	};
	
	//Public Methods
	this.reset = function () {
		this.content = o;
		this.totalHeight = o.offsetHeight;
		this.totalWidth	 = o.offsetWidth;
		this._x = 0;
		this._y = 0;
		with (o.style) {
			left = "0px";
			top  = "0px";
		}
	};
	this.scrollBy = function (x, y) {
		this._setPos(this._x + x, this._y + y);
	};
	this.scrollTo = function (x, y) {
		this._setPos(-x, -y);
	};
	this.stopScroll = function () {
		if (this.scrollTimer) window.clearInterval(this.scrollTimer);
	};
	this.startScroll = function (x, y) {
		this.stopScroll();
		this.scrollTimer = window.setInterval(
			function(){ self.scrollBy(x, y); }, 10
		);
	};
	this.swapContent = function (c, w, h) {
		o = c;
		var list = o.getElementsByTagName("div");
		for (var i = 0; i < list.length; i++) {
			if (list[i].className.indexOf("list-aux") > -1) {
				o = list[i];
			}
		}
		if (w) this.viewableWidth  = w;
		if (h) this.viewableHeight = h;
		this.reset();
	};
	
	//variables
	this.content = o;
	this.viewableWidth  = w;
	this.viewableHeight = h;
	this.totalWidth	 = o.offsetWidth;
	this.totalHeight = o.offsetHeight;
	this.scrollTimer = null;
	this.reset();
};

function jsScrollbar (type, o, s, a, ev) {
	var self = this;
	
	this.reset = function () {
		//Arguments that were passed
		this._parent = o;
		this._src    = s;
		this.auto    = a ? a : false;
		this.eventHandler = ev ? ev : function () {};
		//Component Objects
		this._up   = this._findComponent("scrollbar-up", this._parent);
		this._down = this._findComponent("scrollbar-down", this._parent);
		this._yTrack  = this._findComponent("scrollbar-bg", this._parent);
		this._yHandle = this._findComponent("scrollbar-btn", this._yTrack);
		
		if (this._src.totalHeight < this._src.viewableHeight) {
			this._disabled = true;
			this._yHandle.style.visibility = "hidden";
			if (this.auto) this._parent.style.visibility = "hidden";
			this._up.style.visibility  = "hidden";
			this._down.style.visibility  = "hidden";
			this._parent.style.display = "none";
		} else {
			this._disabled = false;
			this._yHandle.style.visibility = "visible";
			this._parent.style.visibility  = "visible";
			this._up.style.visibility  = "visible";
			this._down.style.visibility  = "visible";
			this._parent.style.display = "block";
		}
		
		//Height and position properties
		this._trackTop = findOffsetTop(this._yTrack);
		this._trackHeight  = this._yTrack.offsetHeight;
		this._handleHeight = this._yHandle.offsetHeight;
		this._x = 0;
		this._y = 0;
		//Misc. variables
		this._scrollDist  = 20;
		this._scrollTimer = null;
		this._selectFunc  = null;
		this._grabPoint   = null;
		this._tempTarget  = null;
		this._tempDistX   = 0;
		this._tempDistY   = 0;
		//this._disabled    = false;
		this._ratio = (this._src.totalHeight - this._src.viewableHeight)/(this._trackHeight - this._handleHeight);
				
		this._yHandle.ondragstart  = function () {return false;};
		this._yHandle.onmousedown = function () {return false;};
		//this._addEvent(this._src.content, "mousewheel", this._scrollbarWheel);
		this._removeEvent(this._parent, "mousedown", this._scrollbarClick);
		this._addEvent(this._parent, "mousedown", this._scrollbarClick);
		
		this._src.reset();
		with (this._yHandle.style) {
			top  = "0px";
			left = "0px";
		}
		this._moveContent();
	};
	this._addEvent = function (o, t, f) {
		if (o.addEventListener) o.addEventListener(t, f, false);
		else if (o.attachEvent) o.attachEvent('on'+ t, f);
		else o['on'+ t] = f;
	};
	this._removeEvent = function (o, t, f) {
		if (o.removeEventListener) o.removeEventListener(t, f, false);
		else if (o.detachEvent) o.detachEvent('on'+ t, f);
		else o['on'+ t] = null;
	};
	this._findComponent = function (c, o) {
		var kids = o.childNodes;
		for (var i = 0; i < kids.length; i++) {
			if (kids[i].className && kids[i].className == c) {
				return kids[i];
			}
		}
	};
	//Thank you, Quirksmode
	function findOffsetTop (o) {
		var t = 0;
		if (o.offsetParent) {
			while (o.offsetParent) {
				t += o.offsetTop;
				o  = o.offsetParent;
			}
		}
		return t;
	};
	this._scrollbarClick = function (e) {
		if (self._disabled) return false;
		
		e = e ? e : event;
		if (!e.target) e.target = e.srcElement;
		
		if (e.target.className.indexOf("scrollbar-up") > -1) self._scrollUp(e);
		else if (e.target.className.indexOf("scrollbar-down") > -1) self._scrollDown(e);
		else if (e.target.className.indexOf("scrollbar-bg") > -1) self._scrollTrack(e);
		else if (e.target.className.indexOf("scrollbar-btn") > -1) self._scrollHandle(e);
		
		self._tempTarget = e.target;
		self._selectFunc = document.onselectstart;
		document.onselectstart = function () {return false;};
		
		self.eventHandler(e.target, "mousedown");
		self._addEvent(document, "mouseup", self._stopScroll, false);
		
		return false;
	};
	this._scrollbarDrag = function (e) {
		e = e ? e : event;
		var t = parseInt(self._yHandle.style.top);
		var v = e.clientY + document.body.scrollTop - self._trackTop;
		with (self._yHandle.style) {
			if (v >= self._trackHeight - self._handleHeight + self._grabPoint)
				top = self._trackHeight - self._handleHeight +"px";
			else if (v <= self._grabPoint) top = "0px";
			else top = v - self._grabPoint +"px";
			self._y = parseInt(top);
		}
		
		self._moveContent();
	};
	this._scrollbarWheel = function (e) {
		e = e ? e : event;
		var dir = 0;
		if (e.wheelDelta >= 120) dir = -1;
		if (e.wheelDelta <= -120) dir = 1;
		
		self.scrollBy(0, dir * 20);
		e.returnValue = false;
	};
	this._startScroll = function (x, y) {
		this._tempDistX = x;
		this._tempDistY = y;
		this._scrollTimer = window.setInterval(function () {
			self.scrollBy(self._tempDistX, self._tempDistY); 
		}, 10);
	};
	this._stopScroll = function () {
		self._removeEvent(document, "mousemove", self._scrollbarDrag, false);
		self._removeEvent(document, "mouseup", self._stopScroll, false);
		
		if (self._selectFunc) document.onselectstart = self._selectFunc;
		else document.onselectstart = function () { return true; };
		
		if (self._scrollTimer) window.clearInterval(self._scrollTimer);
		self.eventHandler (self._tempTarget, "mouseup");
	};
	this._scrollUp = function (e) {this._startScroll(0, -this._scrollDist);};
	this._scrollDown = function (e) {this._startScroll(0, this._scrollDist);};
	this._scrollTrack = function (e) {
		var curY = e.clientY + document.body.scrollTop;
		this._scroll(0, curY - this._trackTop - this._handleHeight/2);
	};
	this._scrollHandle = function (e) {
		var curY = e.clientY + document.body.scrollTop;
		this._grabPoint = curY - findOffsetTop(this._yHandle);
		this._addEvent(document, "mousemove", this._scrollbarDrag, false);
	};
	this._scroll = function (x, y) {
		if (y > this._trackHeight - this._handleHeight) 
			y = this._trackHeight - this._handleHeight;
		if (y < 0) y = 0;
		
		this._yHandle.style.top = y +"px";
		this._y = y;
		
		this._moveContent();
	};
	this._moveContent = function () {
		this._src.scrollTo(0, Math.round(this._y * this._ratio));
	};
	
	this.scrollBy = function (x, y) {
		this._scroll(0, (-this._src._y + y)/this._ratio);
	};
	this.scrollTo = function (x, y) {
		this._scroll(0, y/this._ratio);
	};
	this.swapContent = function (o, w, h) {
		this._removeEvent(this._src.content, "mousewheel", this._scrollbarWheel, false);
		this._src.swapContent(o, w, h);
		this.reset();
	};
	
	this.reset();
};

/* Custom Checkbox */

function formatCheckb(divCB){
	
	var checkboxHeight = "16";
	var radioHeight = "16";
	
	var Custom = {
		init: function() {
			
			if(divCB != ''){
				var divTS = document.getElementById(divCB);
				var inputs = divTS.getElementsByTagName("input");
			}else
				var inputs = document.getElementsByTagName("input");
			
			var span = Array(), textnode, option, active;
			
			for(a = 0; a < inputs.length; a++) {
				if((inputs[a].type == "checkbox" || inputs[a].type == "radio") && inputs[a].className == "custom-checkbox") {
					span[a] = document.createElement("span");
					span[a].className = inputs[a].type;
					
					// Verify url
					var url = location.href.split("index.html");
					var url = url[3].split("?");
					
					if((url[0] == 'index-2.html') || (url[0] == 'index-2.html')){
						cbID = parseInt(inputs[a].id.replace('serie', ''));
						span[a].setAttribute('onclick', 'wishList('+cbID+', 1);');
					}else if(url[0] == 'index-2.html'){
						cbID = parseInt(inputs[a].id.replace('type', ''));
						span[a].setAttribute('onclick', 'notificationsList('+cbID+', 1);');
					}else if(url[0] == 'account.html'){
						accountEx = inputs[a].id.split('iaOption');
						if(accountEx[0] != 'med'){
							cbID = parseInt(inputs[a].id.replace('subscribeSerie', ''));
							span[a].setAttribute('onclick', 'accountSerieSubscribe('+cbID+');');
						}/*else{
							cbID = parseInt(inputs[a].id.replace('mediaOption', ''));
							span[a].setAttribute('onclick', 'myAccountActions('+cbID+', 1);');
						}*/
					}else{
						genreEx = inputs[a].id.split('nre');
						if(genreEx[0] == 'ge'){
							cbID = parseInt(inputs[a].id.replace('genre', ''));
							span[a].setAttribute('onclick', 'moviesGenres('+cbID+', 1);');
						}else{
							cbID = parseInt(inputs[a].id.replace('year', ''));
							span[a].setAttribute('onclick', 'moviesYears('+cbID+', 1);');
						}
					}

					if(inputs[a].checked == true) {
						if(inputs[a].type == "checkbox") {
							position = "0 -" + (checkboxHeight*2) + "px";
							span[a].style.backgroundPosition = position;
						} else {
							position = "0 -" + (radioHeight*2) + "px";
							span[a].style.backgroundPosition = position;
						}
					}
					inputs[a].parentNode.insertBefore(span[a], inputs[a]);
					inputs[a].onchange = Custom.clear;
					if(!inputs[a].getAttribute("disabled")) {
						span[a].onmousedown = Custom.pushed;
						span[a].onmouseup = Custom.check;
					} else {
						span[a].className = span[a].className += " disabled";
					}
				}
			}
			document.onmouseup = Custom.clear;
		},
		pushed: function() {
			element = this.nextSibling;
			if(element.checked == true && element.type == "checkbox") {
				this.style.backgroundPosition = "0 -" + checkboxHeight*3 + "px";
			} else if(element.checked == true && element.type == "radio") {
				this.style.backgroundPosition = "0 -" + radioHeight*3 + "px";
			} else if(element.checked != true && element.type == "checkbox") {
				this.style.backgroundPosition = "0 -" + checkboxHeight + "px";
			} else {
				this.style.backgroundPosition = "0 -" + radioHeight + "px";
			}
		},
		check: function() {
			element = this.nextSibling;
			if(element.checked == true && element.type == "checkbox") {
				this.style.backgroundPosition = "0 0";
				element.checked = false;
			} else {
				if(element.type == "checkbox") {
					this.style.backgroundPosition = "0 -" + checkboxHeight*2 + "px";
				} else {
					this.style.backgroundPosition = "0 -" + radioHeight*2 + "px";
					group = this.nextSibling.name;
					inputs = document.getElementsByTagName("input");
					for(a = 0; a < inputs.length; a++) {
						if(inputs[a].name == group && inputs[a] != this.nextSibling) {
							inputs[a].previousSibling.style.backgroundPosition = "0 0";
						}
					}
				}
				element.checked = true;
			}
		},
		clear: function() {
			inputs = document.getElementsByTagName("input");
			for(var b = 0; b < inputs.length; b++) {
				if(inputs[b].type == "checkbox" && inputs[b].checked == true && inputs[b].className == "custom-checkbox") {
					inputs[b].previousSibling.style.backgroundPosition = "0 -" + checkboxHeight*2 + "px";
				} else if(inputs[b].type == "checkbox" && inputs[b].className == "custom-checkbox") {
					inputs[b].previousSibling.style.backgroundPosition = "0 0";
				} else if(inputs[b].type == "radio" && inputs[b].checked == true && inputs[b].className == "custom-checkbox") {
					inputs[b].previousSibling.style.backgroundPosition = "0 -" + radioHeight*2 + "px";
				} else if(inputs[b].type == "radio" && inputs[b].className == "custom-checkbox") {
					inputs[b].previousSibling.style.backgroundPosition = "0 0";
				}
			}
		},
		choose: function() {
			option = this.getElementsByTagName("option");
			for(d = 0; d < option.length; d++) {
				if(option[d].selected == true) {
					document.getElementById("select" + this.name).childNodes[0].nodeValue = option[d].childNodes[0].nodeValue;
				}
			}
		}
	}
	
	Custom.init();
}

