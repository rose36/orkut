<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="header">
	<h1>Listar Categorias</h1>
	</div>
	<div id="menu4">
	<table border="1">
		<c:forEach var="categoria" items="${categorias}">
			<tr>
				<td>${categoria.catid}</td>
				<td>${categoria.nome}</td>	
			</tr>
		
		
		</c:forEach>
	
	</table>
</div>
<div id="footer">	
        Trabalho de Desenvolvimento Web - UFC <br />Aluna: Juliana de Castro Rabelo.
    </div>
</body>
</html>