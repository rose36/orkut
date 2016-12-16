<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./resources/css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Albuns</title>

<style>
#menu{
background: #373737;
width: 945px;
height:65px;
margin: 0 auto;

}

#menu a{
color:#fff;
font-family:Verdana;
font-size:16px;
text-decoration:none;
margin-top:20px;
margin-left:30px;
display:block;
float:left;

}

#menu a:hover{
color:#00c6c6;
}

#principal{
width:945px;
height:10px;
margin:0 auto;

}
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #50AC31;
    color: white;
}


</style>
</head>
<body>

<div id="principal">
	<h4>Bem-vindo(a) ${usuario_logado.nome}</h4>
	
	<table>
		<tr>
			<th>Imagem</th>
			<th>Cadastrar Fóruns</th>
			<th>Ver Fóruns</th>
		
		</tr>
	
	
		 		
		 <tr>	
		 		<td> <img width="100" height="70" src ="<c:url value="/resources/comunidade/${comunidade.nome}.png" />"/> </td>
				<td><a href="inserirForumFormulario?id=${comunidade.comid}">Cadastrar Fórum</a></td>
				<td><a href="listarForum?id=${comunidade.comid}">Ver fóruns</a></td>
		</tr>
			
		 								 		
		 	
	</table>

</div>    
</body>
</html>