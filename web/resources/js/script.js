$(document).ready(function() {
	"use strict";


// ------------- Pre-loader--------------  

// makes sure the whole site is loaded

$(window).load(function() {
    // will first fade out the loading animation
    $(".preloader").fadeOut();
    //then background color will fade out slowly
    $("#faceoff").delay(200).fadeOut("slow");
});


  
  //-------scroll to top---------
  
 $('#go-to-top a').click(function(){
	$("html,body").animate({ scrollTop: 0 }, 750);
	return false;
  });
  
//--------------- SmoothSroll--------------------

var scrollAnimationTime = 1200,
    scrollAnimation = 'easeInOutExpo';
$('a.scrollto').bind('click.smoothscroll', function (event) {
    event.preventDefault();
    var target = this.hash;
    $('html, body').stop().animate({
        'scrollTop': $(target).offset().top
    }, scrollAnimationTime, scrollAnimation, function () {
        window.location.hash = target;
    });
});

// ------------- Owl Carousel--------------

 // $("#owl-demo").owlCarousel({
 //  navigation : true,
 //  slideSpeed : 300,
 //  pagination: false,
 //  autoPlay: 5000,
 //  items : 4,
 //  });

//--------------- for navigation---------------------
  
    $('.navbar-collapse ul li a').click(function() {
      $('.navbar-toggle:visible').click();
  });
  
//--------------- -Loading the map ------------------

 $(document).on('click','.contact-map',function(event){
	event.preventDefault();
	initialize();
 });

// ------------- Magnific--------------

    /*$('.test-popup-link').magnificPopup({
      type:'image',
      closeBtnInside:true,
      // Delay in milliseconds before popup is removed
      removalDelay: 300,

      // Class that is added to popup wrapper and background
      // make it unique to apply your CSS animations just to this exact popup
      mainClass: 'mfp-fade',
      gallery: {
          enabled: true, // set to true to enable gallery

          preload: [0,2], // read about this option in next Lazy-loading section

          navigateByImgClick: true,

          //arrowMarkup: '<button title="%title%" type="button" class="mfp-arrow mfp-arrow-%dir%"></button>', // markup of an arrow button

          closeMarkup: '<button title="%title%" class="mfp-close"><i class="mfp-close-icn">&times;</i></button>',

          tPrev: 'Previous (Left arrow key)', // title for left button
          tNext: 'Next (Right arrow key)', // title for right button
          //tCounter: '<span class="mfp-counter">%curr% of %total%</span>' // markup of counter
        }
   });*/
 
// ------------------Carousel-------------- 

$('#myCarousel, #myCarousel2').carousel({
  interval: 4000,
  pause: "null"
})


// --------------Contact Form Ajax request-----------------------

    $('.form-horizontal').on('submit', function(event){
    event.preventDefault();

    $this = $(this);

    var data = {
      first_name: $('#first_name').val(),
      last_name: $('#last_name').val(),
      email: $('#email').val(),
      subject: $('#subject').val(),
      message: $('#message').val()
    };

    $.ajax({
      type: "POST",
      url: "email.php",
      data: data,
      success: function(msg){
	     $('.contact-success').fadeIn().delay(3000).fadeOut();
      }
    });
  });
  
});


var fullScreenHome = function() {
    if(matchMedia( "(min-width: 992px) and (min-height: 500px)" ).matches) {
      "use strict"; //RUN JS IN STRICT MODE
    var height = $(window).height();
      contH = $(".banner .col-sm-12").height(),
      contH = $(".banner-carousel .col-sm-12").height(),
      contMT = (height / 2) - (contH / 2);
    $(".banner-carousel").css('min-height', height + "px");
    $(".trans-bg").css('min-height', height + "px");
    $(".banner .col-sm-12").css('margin-top', (contMT - 270) + "px");
    $(".banner-carousel .col-sm-12").css('margin-top', (contMT - 10) + "px");
  }
}

$(document).ready(fullScreenHome);
$(window).resize(fullScreenHome);

/*
=========================================================
  script para definicion de banner de celular
=========================================================
*/

$(document).ready(function() {
    $('#myCarousel').carousel({
      interval: 5000
  });
    
    $('#myCarousel').on('slide.bs.carousel', function () {
      console.log('slide');
    });
    
    $('#myCarousel').on('slid.bs.carousel', function () {
      console.log('slid');
    });
});


/*
=========================================================
  SCRIPT PARA COLOCAR-QUITAR CLASES Y ESTILOS CSS
=========================================================
*/



 // div #1
 $(document).ready(function(){

    //INICIALIZADOR DE EVENTO FADE IN
   $(function() { 
          $('.ef-info' ).fadeOut(); 
      });
   

   $('#ef-1').hover(function() { 
        $('#cont-1').fadeIn( 400 , function(){
           $('#cont-1').css('display','block')
         });      
    }, function() { 
        $('#cont-1').fadeOut(15); 
    });


   $('#ef-2').hover(function() { 
        $('#cont-2').fadeIn( 400 , function(){
           $('#cont-2').css('display','block')
         });      
    }, function() { 
        $('#cont-2').fadeOut(15); 
    });


   $('#ef-3').hover(function() { 
        $('#cont-3').fadeIn( 400 , function(){
           $('#cont-3').css('display','block')
         });      
    }, function() { 
        $('#cont-3').fadeOut(15); 
    });


   $('#ef-4').hover(function() { 
        $('#cont-4').fadeIn( 400 , function(){
           $('#cont-4').css('display','block')
         });      
    }, function() { 
        $('#cont-4').fadeOut(15); 
    });
   

});


