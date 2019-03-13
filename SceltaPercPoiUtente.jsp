<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Scelta Percorso</title>

<style type="text/css">
body, td, th {
 font-family: Trebuchet MS;
 font-size: 10pt;
}
</style>
</head>


<body>
 <h2>Seleziona Percorso</h2>
 <sql:setDataSource driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@DESKTOP-60DB11V:1521/XE" user="corso_java" password="admin" />
 
 <form id="frmOrdina" name="frmOrdina" method="get" action="SceltaPercPoiUtente.jsp">
 <label>Scegli 
 <select name="p">
 <sql:query var="result">
     SELECT nome_percorso FROM nome_percorsi
   </sql:query>
   <c:forEach items="${result.rows}" var="row">
     <option value="<c:out value="${row.nome_percorso}" />"><c:out value="${row.nome_percorso}" /></option>
   </c:forEach>
   </select>
 </label> 
 <input type="submit" value="Invio" name="btnInvio" />
 </form>
 <c:choose>
 <c:when test="${!empty param.btnInvio}">
   <sql:query var="result">
     SELECT nome_poi FROM poi JOIN percorsi ON poi.id_poi = percorsi.id_poi JOIN nome_percorsi ON nome_percorsi.id_percorsi = percorsi.id_percorsi WHERE nome_percorso='${param.p}' AND percorsi.stato='s'
   </sql:query>
    </c:when>
 </c:choose>
 

 <table border="0">
 <tr>
 <th>Nome punto d'interesse</th>
 </tr>
 
 <c:forEach items="${result.rows}" var="row">
 <tr>
 <td><c:out value="${row.nome_poi}" /></td>
 </tr>
 </c:forEach>
 
 </table>
 
</body>
</html>