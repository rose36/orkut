<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar usuários</title>
</head>
<body>

<div id="header">
	<h1>Listar Usuários</h1>
	</div>
	
	<table border="1">
		<c:forEach var="usuario" items="${usuarios}">
			<tr>
				<td>${usuario.usuid}</td>
				<td>${usuario.nome}</td>
				<td> <img width="100" height="70" src ="<c:url value="/resources/usuario/${usuario.login}.png" />"/> </td>
				<td><a href="alterarUsuarioFormulario?usuid=${usuario.usuid}">ALTERAR</a></td>
				
			</tr>
		
		
		</c:forEach>
	
	</table>
	

    
</body>
</html>