<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Fórum</title>
<style>

#topo{
width: 945px;
height:165px;
margin: 0 auto;
}

#logo{


width: 310px;
height:80px;
margin-top: 50px;
float:left;
}

#login{
width: 280px;
height:70px;
margin-top: 50px;
float:right;

}

#login p{
font-family:sans-serif;
font-size:16px;


}

#login a{
text-decoration: none;	
color: black;
}





.menu {
   background: #373737;
	width: 945px;
	height:65px;
	margin: 0 auto;
    
}
.clearfix:after{
    content: '.';
    display: block;
    clear: both;
    line-height: 0;
    font-size: 0;
    visibility: hidden;
    overflow: hidden;
    background: #373737;
	width: 230px;
	height:15px;
	margin-left:100px;
}
.menu,
.sub-menu {
    list-style: none;
    background: #373737;
}
.sub-menu {
    background: #444;
}
.menu a {
    text-decoration: none;
    display: block;
    padding: 10px;
    color: #fff;
    font-family: sans-serif;
    font-size: 14px;
    text-transform: uppercase;
    font-weight: 700;
}
.menu li {
    position: relative;
}
.menu > li {
    float: left;
}
.menu > li:hover {
    background: #444;
}
.menu li:hover > .sub-menu {
    display: block;
}
.sub-menu {
    display: none;
    position: absolute;
    min-width: 150px;
}
.sub-menu li:hover {
    background: #555;
}
.sub-menu .sub-menu {
    top: 0;
    left: 100%;
}

#principal{
width:945px;
height:327px;
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


<div id="topo">
			<div id="logo"><img src="./resources/imagens/logo.png" width="350" height="100"></div>
			<div id="login">
				<p>Olá ${usuario_logado.nome} | <a href="dadosUsuario">Dados do usuário</a> | <a href="logout">Logout</a>  </p>
			</div>		
		</div>

		
		
	<div class="menu-container">
		    <ul class="menu clearfix">
		    	
		        <li><a>Comunidade</a>
		            
		            <ul class="sub-menu clearfix">
		                <li><a href="inserirComunidadeFormulario">Cadastrar Comunidade</a></li>
		                <li><a href="listarComunidade">Listar Comunidade</a></li>
		               
		        
		            </ul><!-- submenu -->
		        </li>
		        <li><a>Fotos</a>
		        	<ul class="sub-menu clearfix">
		                <li><a href="inserirFotosFormulario">Cadastrar Fotos</a></li>
		               <li><a href="listarAlbum">Listar Fotos</a></li>
		            </ul><!-- submenu -->
		        </li>
		        <li><a>Álbuns</a>
		        	<ul class="sub-menu clearfix">
		                <li><a href="inserirAlbumFormulario">Cadastrar Álbuns</a></li>
		                <li><a href="listarAlbum">Meus Álbuns</a></li>
		                
		            </ul><!-- submenu -->
		        </li>
		        <li><a href="inserirAmizadeFormulario">Adicionar Amigos</a></li>
		        <li><a href="listarAmizade">Meus Amigos</a></li>
		        
		    </ul>
		</div>
	

<div id="principal">
	<h4>Fóruns</h4>
		
	
	<table>
		<tr>
			<th>Código</th>
			<th>Título</th>
			<th>Listar Mensagens</th>
			<th>Enviar Mensagem</th>
		</tr>
		<c:forEach var="forum" items="${foruns}">
			<tr>		
				<td>${forum.forid}</td>
				<td>${forum.titulo}</td>
				
		
				<td><a href="listarMensagem?id=${forum.forid}">Listar Mensagens</a></td>	
 			    <td><a href="inserirMensagemFormulario?id=${forum.forid}">Enviar Mensagem</a></td>				
 												
			</tr>
			
			
		
		
		</c:forEach>
	
	</table>
	

 </div>   
</body>
</html>