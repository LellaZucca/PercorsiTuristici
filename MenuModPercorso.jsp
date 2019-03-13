<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserimento dati percorso</title>
</head>


<body>
<h1>FUNZIONE MODIFICA PERCORSO</h1>
<h4>Inserimento id percorso e id P.O.I.</h4>
<h6>nb---> verifica se il P.o.i. scelto è già presente nel percorso desiderato</h6>
<form name="formPOST" action="/PercorsiTuristici/Mod_Poi_in_Percorso" method="post">
idpercorso:<input type="text"value=""name="idpercorso" required/>
idpoi:<input type="text"value=""name="idpoi" required/>
<input type="submit" value="INVIO">
</form>
 <br><br> <a href =\"http://localhost:8089/accesso/Informazioni\" >Torna al menù principale</a>
<br>
</body>
</html>