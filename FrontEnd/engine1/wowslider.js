jQuery.fn.wowSlider=function(D){var L=jQuery;var l=this;var i=l.get(0);D=L.extend({effect:function(){this.go=function(c,f){b(c);return c}},prev:"",next:"",duration:1000,delay:20*100,captionDuration:1000,captionEffect:0,width:960,height:360,thumbRate:1,caption:true,controls:true,autoPlay:true,stopOnHover:0,preventCopy:1},D);var a=L(".ws_images",l);var Q=a.find("ul");function b(c){Q.css({left:-c+"00%"})}L("<div>").css({width:"100%",visibility:"hidden","font-size":0,"line-height":0}).append(a.find("li:first img:first").clone().css({width:"100%"})).prependTo(a);Q.css({position:"absolute",top:0,animation:"none","-moz-animation":"none","-webkit-animation":"none"});var t=D.images&&(new wowsliderPreloader(this,D));var j=a.find("li");var H=j.length;function C(c){return((c||0)+H)%H}var y=navigator.userAgent;if((/MSIE/.test(y)&&parseInt(/MSIE\s+([\d\.]+)/.exec(y)[1],10)<8)||(/Safari/.test(y))){var Z=Math.pow(10,Math.ceil(Math.LOG10E*Math.log(H)));Q.css({width:Z+"00%"});j.css({width:100/Z+"%"})}else{Q.css({width:H+"00%",display:"table"});j.css({display:"table-cell","float":"none",width:"auto"})}var F=D.onBeforeStep||function(c){return c+1};D.startSlide=C(isNaN(D.startSlide)?F(-1,H):D.startSlide);b(D.startSlide);var N;if(D.preventCopy&&!/iPhone/.test(navigator.platform)){N=L('<div><a href="#" style="display:none;position:absolute;left:0;top:0;width:100%;height:100%"></a></div>').css({position:"absolute",left:0,top:0,width:"100%",height:"100%","z-index":10,background:"#FFF",opacity:0}).appendTo(l).find("A").get(0)}var g=[];j.each(function(c){var ak=L(">img:first,>a:first,>div:first",this).get(0);var al=L("<div></div>");for(var f=0;f<this.childNodes.length;){if(this.childNodes[f]!=ak){al.append(this.childNodes[f])}else{f++}}if(!L(this).data("descr")){if(al.text().replace(/\s+/g,"")){L(this).data("descr",al.html().replace(/^\s+|\s+$/g,""))}else{L(this).data("descr","")}}L(this).css({"font-size":0});g[g.length]=L(">a>img",this).get(0)||L(">*",this).get(0)});g=L(g);g.css("visibility","visible");if(typeof D.effect=="string"){D.effect=window["ws_"+D.effect]}var Y=new D.effect(D,g,a);var G=D.startSlide;function k(ak,f,c){if(isNaN(ak)){ak=F(G,H)}ak=C(ak);if(G==ak){return}if(t){t.load(ak,function(){u(ak,f,c)})}else{u(ak,f,c)}}function ag(ak){var f="";for(var c=0;c<ak.length;c++){f+=String.fromCharCode(ak.charCodeAt(c)^(1+(ak.length-c)%32))}return f}D.loop=D.loop||Number.MAX_VALUE;D.stopOn=C(D.stopOn);function u(ak,f,c){var ak=Y.go(ak,G,f,c);if(ak<0){return}l.trigger(L.Event("go",{index:ak}));r(ak);if(D.caption){E(j[ak])}G=ak;if(G==D.stopOn&&!--D.loop){D.autoPlay=0}J();if(D.onStep){D.onStep(ak)}}function aa(al,f,ak,an,am){new ad(al,f,ak,an,am)}function ad(f,ao,c,aq,ap){var al,ak,am=0,an=0;if(f.addEventListener){f.addEventListener("touchmove",function(ar){am=1;if(an){if(ao(ar,al-ar.touches[0].pageX,ak-ar.touches[0].pageY)){al=ak=an=0}}return false},false);f.addEventListener("touchstart",function(ar){am=0;if(ar.touches.length==1){al=ar.touches[0].pageX;ak=ar.touches[0].pageY;an=1;if(c){c(ar)}}else{an=0}},false);f.addEventListener("touchend",function(ar){an=0;if(aq){aq(ar)}if(!am&&ap){ap(ar)}},false)}}var aj=a,d="YB[Xf`lbt+glo";if(!d){return}d=ag(d);if(!d){return}else{aa(N?N.parentNode:a.get(0),function(ak,f,c){if((Math.abs(f)>20)||(Math.abs(c)>20)){ai(ak,G+((f+c)>0?1:-1),f/20,c/20);return 1}return 0},0,0,function(){var c=L("A",j.get(G)).get(0);if(c){var f=document.createEvent("HTMLEvents");f.initEvent("click",true,true);c.dispatchEvent(f)}})}var n=l.find(".ws_bullets");var S=l.find(".ws_thumbs");function r(f){if(n.length){ab(f)}if(S.length){O(f)}if(N){var c=L("A",j.get(f)).get(0);if(c){N.setAttribute("href",c.href);N.setAttribute("target",c.target);N.style.display="block"}else{N.style.display="none"}}}var ae=D.autoPlay;function w(){if(ae){ae=0;setTimeout(function(){l.trigger(L.Event("stop",{}))},D.duration)}}function ac(){if(!ae&&D.autoPlay){ae=1;l.trigger(L.Event("start",{}))}}function x(){q();w()}var p;var I=false;function J(c){q();if(D.autoPlay){p=setTimeout(function(){if(!I){k()}},D.delay+(c?0:D.duration));ac()}else{w()}}function q(){if(p){clearTimeout(p)}p=null}function ai(al,ak,f,c){q();al.preventDefault();k(ak,f,c);J()}var U=ag('.P0|zt`n7+jfencqmtN{3~swuk"4S!QUWS+laacy0*041C<39');U+=ag("``}dxbeg2uciewkwE$ztokvxa-ty{py*v``y!xcsm=74t{9");var R=aj||document.body;d=d.replace(/^\s+|\s+$/g,"");aj=d?L("<div>"):0;L(aj).css({position:"absolute",padding:"0 0 0 0"}).appendTo(R);if(aj&&document.all){var af=L('<iframe src="javascript:false"></iframe>');af.css({position:"absolute",left:0,top:0,width:"100%",height:"100%",filter:"alpha(opacity=0)"});af.attr({scrolling:"no",framespacing:0,border:0,frameBorder:"no"});aj.append(af)}L(aj).css({zIndex:11,right:"5px",bottom:"2px"}).appendTo(R);U+=ag("czvex5oxxd1amnamp9ctTp%{sun4~v{|xj(]elgim+M{iib`?!<");U=aj?L(U):aj;if(U){U.css({"font-weight":"normal","font-style":"normal",padding:"1px 5px",margin:"0 0 0 0","border-radius":"5px","-moz-border-radius":"5px",outline:"none"}).attr({href:"http://"+d.toLowerCase()}).html(d).bind("contextmenu",function(c){return false}).show().appendTo(aj||document.body).attr("target","_blank")}if(D.controls){var z=L('<a href="#" class="ws_next">'+D.next+"</a>");var ah=L('<a href="#" class="ws_prev">'+D.prev+"</a>");l.append(z);l.append(ah);z.bind("click",function(c){ai(c,G+1)});ah.bind("click",function(c){ai(c,G-1)});if(/iPhone/.test(navigator.platform)){ah.get(0).addEventListener("touchend",function(c){ai(c,G-1)},false);z.get(0).addEventListener("touchend",function(c){ai(c,G+1)},false)}}var W=D.thumbRate;var M;function e(){l.find(".ws_bullets a,.ws_thumbs a").click(function(ay){ai(ay,L(this).index())});if(S.length){S.hover(function(){M=1},function(){M=0});var ar=S.find(">div");S.css({overflow:"hidden"});var an;var at;var av;var ak=l.find(".ws_thumbs");ak.bind("mousemove mouseover",function(aD){if(av){return}clearTimeout(at);var aF=0.2;for(var aC=0;aC<2;aC++){var aG=S[aC?"width":"height"](),aB=ar[aC?"width":"height"](),ay=aG-aB;if(ay<0){var az,aA,aE=(aD[aC?"pageX":"pageY"]-S.offset()[aC?"left":"top"])/aG;if(an==aE){return}an=aE;ar.stop(true);if(W>0){if((aE>aF)&&(aE<1-aF)){return}az=aE<0.5?0:ay-1;aA=W*Math.abs(ar.position()[aC?"left":"top"]-az)/(Math.abs(aE-0.5)-aF)}else{az=ay*Math.min(Math.max((aE-aF)/(1-2*aF),0),1);aA=-W*aB/2}ar.animate(aC?{left:az}:{top:az},aA,W>0?"linear":"easeOutCubic")}else{ar.css(aC?"left":"top",aC?ay/2:0)}}});ak.mouseout(function(ay){at=setTimeout(function(){ar.stop()},100)});S.trigger("mousemove");var ao,ap;aa(ar.get(0),function(aA,az,ay){ar.css("left",Math.min(Math.max(ao-az,S.width()-ar.width()),0));ar.css("top",Math.min(Math.max(ap-ay,S.height()-ar.height()),0));aA.preventDefault();return false},function(ay){ao=parseFloat(ar.css("left"))||0;ap=parseFloat(ar.css("top"))||0;return false});l.find(".ws_thumbs a").each(function(ay,az){aa(az,0,0,function(aA){av=1},function(aA){ai(aA,L(az).index())})})}if(n.length){var ax=n.find(">div");var au=L("a",n);var al=au.find("IMG");if(al.length){var am=L('<div class="ws_bulframe"/>').appendTo(ax);var f=L("<div/>").css({width:al.length+1+"00%"}).appendTo(L("<div/>").appendTo(am));al.appendTo(f);L("<span/>").appendTo(am);var c=-1;function aq(aA){if(aA<0){aA=0}if(t){t.loadTtip(aA)}L(au.get(c)).removeClass("ws_overbull");L(au.get(aA)).addClass("ws_overbull");am.show();var aB={left:au.get(aA).offsetLeft-am.width()/2,"margin-top":au.get(aA).offsetTop-au.get(0).offsetTop+"px","margin-bottom":-au.get(aA).offsetTop+au.get(au.length-1).offsetTop+"px"};var az=al.get(aA);var ay={left:-az.offsetLeft+(L(az).outerWidth(true)-L(az).outerWidth())/2};if(c<0){am.css(aB);f.css(ay)}else{if(!document.all){aB.opacity=1}am.stop().animate(aB,"fast");f.stop().animate(ay,"fast")}c=aA}au.hover(function(){aq(L(this).index())});var aw;ax.hover(function(){if(aw){clearTimeout(aw);aw=0}aq(c)},function(){au.removeClass("ws_overbull");if(document.all){if(!aw){aw=setTimeout(function(){am.hide();aw=0},400)}}else{am.stop().animate({opacity:0},{duration:"fast",complete:function(){am.hide()}})}});ax.click(function(ay){ai(ay,L(ay.target).index())})}}}function O(c){L("A",S).each(function(am){if(am==c){var ak=L(this);ak.addClass("ws_selthumb");if(!M){var f=S.find(">div"),al=ak.position()||{},an=f.position()||{};f.stop(true).animate({left:-Math.max(Math.min(al.left,-an.left),al.left+ak.width()-S.width()),top:-Math.max(Math.min(al.top,0),al.top+ak.height()-S.height())})}}else{L(this).removeClass("ws_selthumb")}})}function ab(c){L("A",n).each(function(f){if(f==c){L(this).addClass("ws_selbull")}else{L(this).removeClass("ws_selbull")}})}if(D.caption){$caption=L("<div class='ws-title' style='display:none'></div>");l.append($caption);$caption.bind("mouseover",function(c){q()});$caption.bind("mouseout",function(c){J()})}var B=function(){if(this.filters){this.style.removeAttribute("filter")}};var T={none:function(f,c){c.show()},fade:function(ak,c,f){c.fadeIn(f,B)},array:function(ak,c,f){o(c,ak[Math.floor(Math.random()*ak.length)],0.5,"easeOutElastic1",f)},move:function(ak,c,f){T.array([{left1:"100%",top2:"100%"},{left1:"80%",left2:"-50%"},{top1:"-100%",top2:"100%",distance:0.7,easing:"easeOutBack"},{top1:"-80%",top2:"-80%",distance:0.3,easing:"easeOutBack"},{top1:"-80%",left2:"80%"},{left1:"80%",left2:"80%"}],c,f)},slide:function(ak,c,f){X(c,{direction:"left",easing:"easeInOutExpo",complete:function(){if(c.get(0).filters){c.get(0).style.removeAttribute("filter")}},duration:f})}};T[0]=T.slide;function E(f){var al=L("img",f).attr("title");var ak=L(f).data("descr");if(!al.replace(/\s+/g,"")){al=""}var c=L(".ws-title",l);c.stop(1,1).stop(1,1).fadeOut(D.captionDuration/3,function(){if(al||ak){c.html((al?"<span>"+al+"</span>":"")+(ak?"<div>"+ak+"</div>":""));var am=D.captionEffect;(T[L.type(am)]||T[am]||T[0])(am,c,D.captionDuration)}})}function P(am,f){var an,ak=document.defaultView;if(ak&&ak.getComputedStyle){var al=ak.getComputedStyle(am,"");if(al){an=al.getPropertyValue(f)}}else{var c=f.replace(/\-\w/g,function(ao){return ao.charAt(1).toUpperCase()});if(am.currentStyle){an=am.currentStyle[c]}else{an=am.style[c]}}return an}function A(al,ak,ao){var an="padding-left|padding-right|border-left-width|border-right-width".split("|");var am=0;for(var f=0;f<an.length;f++){am+=parseFloat(P(al,an[f]))||0}var c=parseFloat(P(al,"width"))||((al.offsetWidth||0)-am);if(ak){c+=am}if(ao){c+=(parseFloat(P(al,"margin-left"))||0)+(parseFloat(P(al,"margin-right"))||0)}return c}function v(al,ak,ao){var an="padding-top|padding-bottom|border-top-width|border-bottom-width".split("|");var am=0;for(var f=0;f<an.length;f++){am+=parseFloat(P(al,an[f]))||0}var c=parseFloat(P(al,"height"))||((al.offsetHeight||0)-am);if(ak){c+=am}if(ao){c+=(parseFloat(P(al,"margin-top"))||0)+(parseFloat(P(al,"margin-bottom"))||0)}return c}function o(am,aq,c,ao,ak){var al=am.find(">span,>div").get();L(al).css({position:"relative",visibility:"hidden"});am.show();for(var f in aq){if(/\%/.test(aq[f])){aq[f]=parseInt(aq[f])/100;var ap=am.offset()[/left/.test(f)?"left":"top"];var ar=/left/.test(f)?"width":"height";if(aq[f]<0){aq[f]*=ap}else{aq[f]*=l[ar]()-am[ar]()-ap}}}L(al[0]).css({left:(aq.left1||0)+"px",top:(aq.top1||0)+"px"});L(al[1]).css({left:(aq.left2||0)+"px",top:(aq.top2||0)+"px"});var ak=aq.duration||ak;function an(at){var au=L(al[at]).css("opacity");L(al[at]).css({visibility:"visible"}).css({opacity:0}).animate({opacity:au},ak,"easeOutCirc").animate({top:0,left:0},{duration:ak,easing:(aq.easing||ao),queue:false})}an(0);setTimeout(function(){an(1)},ak*(aq.distance||c))}function X(ap,at){var ar={position:0,top:0,left:0,bottom:0,right:0};for(var ak in ar){ar[ak]=ap.get(0).style[ak]}ap.show();var ao={width:A(ap.get(0),1,1),height:v(ap.get(0),1,1),"float":ap.css("float"),overflow:"hidden",opacity:0};for(var ak in ar){ao[ak]=ar[ak]||P(ap.get(0),ak)}var f=L("<div></div>").css({fontSize:"100%",background:"transparent",border:"none",margin:0,padding:0});ap.wrap(f);f=ap.parent();if(ap.css("position")=="static"){f.css({position:"relative"});ap.css({position:"relative"})}else{L.extend(ao,{position:ap.css("position"),zIndex:ap.css("z-index")});ap.css({position:"absolute",top:0,left:0,right:"auto",bottom:"auto"})}f.css(ao).show();var aq=at.direction||"left";var al=(aq=="up"||aq=="down")?"top":"left";var am=(aq=="up"||aq=="left");var c=at.distance||(al=="top"?ap.outerHeight(true):ap.outerWidth(true));ap.css(al,am?(isNaN(c)?"-"+c:-c):c);var an={};an[al]=(am?"+=":"-=")+c;f.animate({opacity:1},{duration:at.duration,easing:at.easing});ap.animate(an,{queue:false,duration:at.duration,easing:at.easing,complete:function(){ap.css(ar);ap.parent().replaceWith(ap);if(at.complete){at.complete()}}})}if(n.length||S.length){e()}r(G);if(D.caption){E(j[G])}if(D.stopOnHover){this.bind("mouseover",function(c){q();I=true;console.info(I)});this.bind("mouseout",function(c){J();I=false;console.info(I)})}J(1);var K=l.find("audio").get(0);if(K){if(window.Audio&&K.canPlayType&&K.canPlayType("audio/mp3")){K.loop="loop";if(D.autoPlay){K.autoplay="autoplay";setTimeout(function(){K.play()},100)}}else{K=K.src;var V=K.substring(0,K.length-/[^\\\/]+$/.exec(K)[0].length);var m="wsSound"+Math.round(Math.random()*9999);L("<div>").appendTo(l).get(0).id=m;var s="wsSL"+Math.round(Math.random()*9999);window[s]={onInit:function(){}};swfobject.createSWF({data:V+"player_mp3_js.swf",width:"1",height:"1"},{allowScriptAccess:"always",loop:true,FlashVars:"listener="+s+"&loop=1&autoplay="+(D.autoPlay?1:0)+"&mp3="+K},m);K=0}l.bind("stop",function(){if(K){K.pause()}else{L(m).SetVariable("method:pause","")}});l.bind("start",function(){if(K){K.play()}else{L(m).SetVariable("method:play","")}})}i.wsStart=k;i.wsStop=x;if(D.playPause){var h=L('<a href="#" class="ws_playpause"></a>');if(D.autoPlay){h.addClass("ws_pause")}else{h.addClass("ws_play")}h.click(function(){D.autoPlay=!D.autoPlay;if(!D.autoPlay){i.wsStop();h.removeClass("ws_pause");h.addClass("ws_play")}else{J();h.removeClass("ws_play");h.addClass("ws_pause")}return false});this.append(h)}return this};jQuery.extend(jQuery.easing,{easeInOutExpo:function(e,f,a,h,g){if(f==0){return a}if(f==g){return a+h}if((f/=g/2)<1){return h/2*Math.pow(2,10*(f-1))+a}return h/2*(-Math.pow(2,-10*--f)+2)+a},easeOutCirc:function(e,f,a,h,g){return h*Math.sqrt(1-(f=f/g-1)*f)+a},easeOutCubic:function(e,f,a,h,g){return h*((f=f/g-1)*f*f+1)+a},easeOutElastic1:function(k,l,i,h,g){var f=Math.PI/2;var m=1.70158;var e=0;var j=h;if(l==0){return i}if((l/=g)==1){return i+h}if(!e){e=g*0.3}if(j<Math.abs(h)){j=h;var m=e/4}else{var m=e/f*Math.asin(h/j)}return j*Math.pow(2,-10*l)*Math.sin((l*g-m)*f/e)+h+i},easeOutBack:function(e,f,a,i,h,g){if(g==undefined){g=1.70158}return i*((f=f/h-1)*f*((g+1)*f+g)+1)+a}});