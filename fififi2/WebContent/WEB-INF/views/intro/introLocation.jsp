<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0">
    <meta charset="utf-8">
    <style>
      #map {
        height: 50%;
      }
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
</head>
<body>

<section class="category-content col-sm-9">
    <h2 class="category-title">오시는길</h2>
	  <div id="map"></div>
	    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCoK6XX7OU6bIaAa_oeaPPZOynbIzmCpB0&callback=initMap"
	    async defer></script>
	 <script>    
	  function initMap() {
		  
	  var myLatLng = {lat:37.499001, lng: 127.032888};
	
	  var map = new google.maps.Map(document.getElementById('map'), {
	    zoom: 20,
	    center: myLatLng
	  });
	
	  var marker = new google.maps.Marker({
	    position: myLatLng,
	    map: map,
	    title: 'Hello World!'
	  });
	}
	 </script>
    
 </section>
 
</body>
</html>