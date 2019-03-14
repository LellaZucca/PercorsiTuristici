<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" import="percorsiTuristici.POI" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">
		<title>Geolocalizzazione</title>
	<% ArrayList<POI> poi = (ArrayList<POI>)session.getAttribute("listaPOI"); 
   String nomi [] = new String[poi.size()];
   String lati []= new String[poi.size()];
   String longi []= new String[poi.size()];
   int i = 0;
    /*for(int i = 0; i< poi.size(); i++){
        nomi.add(poi.get(i).getNome());
        lati.add(poi.get(i).getLati());
        longi.add(poi.get(i).getLongi());
        }*/
    for (i = 0; i<poi.size(); i++){
    	nomi[i] = (poi.get(i).getNome());
    	lati[i] = (poi.get(i).getLati());
    	longi[i] = (poi.get(i).getLongi());
        }
%>
	<script>
	navigator.geolocation.getCurrentPosition(localizzami);
	var arrayNomi[<%=nomi.length%>];
	var arrayLati[<%=lati.length%>];
	var arrayLongi[<%=longi.length%>];
	
	function pangeo(){
		compara();
		localizzami();
	}
	
	function localizzami(posizione){
		var latitudine;
		var longitudine;
		latitudine=posizione.coords.latitude;
		longitudine=posizione.coords.longitude;
		
		//alert('Latitudine:'+ latitudine+',Longitudine:'+longitudine)
		document.getElementById("mappa").src='http://maps.google.it/maps?q='+latitudine+','+longitudine+'&z=17&output=embed'
	}
	
	function getDistanceFromLatLonInKm(lat1,lon1,lat2,lon2) {
	    var R = 6371; // Radius of the earth in km
	    var dLat = deg2rad(lat2-lat1);  // deg2rad below
	    var dLon = deg2rad(lon2-lon1); 
	    var a = 
			Math.sin(dLat/2) * Math.sin(dLat/2) +
			Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
			Math.sin(dLon/2) * Math.sin(dLon/2); 
	    var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
	    var d = R * c; // Distance in km
		return d;
	}

	function deg2rad(deg) {
		return deg * (Math.PI/180)
	}
	
	function compara(){
		alert(<%=nomi.length%>);
		latitudine=posizione.coords.latitude;
		longitudine=posizione.coords.longitude;
		for (<%=i%> = 0; <%=i%> < <%=nomi.length%>; <%=i%>++) { 
		  alert(<%=nomi[i]%> + " "+  <%=lati[i]%> + " " + <%=longi[i]%>);
		}
		
		
	}
	
	
	
	window.setInterval("pangeo()",5000);
	</script>
	<style>
	#mappa{
		width:500px;
		height:500px;
	}</style>
</head>
<body>

<iframe id="mappa" />
</body>
</html>