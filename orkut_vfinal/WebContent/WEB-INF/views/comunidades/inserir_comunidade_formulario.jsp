<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Cadastrar Comunidade</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<style>

login-box{
    background-color:#e0f1fc;
    border-raius:5px;
    
    }
    
     
     #login-box-interno{
       width:500px;
       height:300px;
       background-color:white;
       margin:50px auto 0px;
       border-radius:5px;
       box-shaow:0px 0px 5px black;
       overflow:hidden;
      
     }
     
     #login-box-label{
       height:45px;
       text-align:center;
       font:bold 14px/45px sans-serif;
       border-top-left-radius:5px;
       border-top-right-radius:5px;
       
       
       
       /* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#f9fcf7+0,f5f9f0+100&0.01+100,1+100 */
       background: -webkit-linear-gradient(rgba(249,252,247,1) 0%, rgba(245,249,240,1) 100%);
       background: -moz-linear-gradient(rgba(249,252,247,1) 0%, rgba(245,249,240,1) 100%);
       background: -o-linear-gradient(rgba(249,252,247,1) 0%, rgba(245,249,240,1) 100%);
       background: linear-gradient(rgba(249,252,247,1) 0%, rgba(245,249,240,1) 100%); /* FF3.6-15 */ /* Chrome10-25,Safari5.1-6 */ /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
       filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f9fcf7', endColorstr='#f5f9f0',GradientType=0 ); /* IE6-9 */

       border-bottom:1px solid  #851944;
       box-shadow:1px 0px 3px black;
       color:#555555;
      
       
     }
     
     .input-div{
       margin:20px;
       padding:5px;
       background-color:#f2f5f7;
       border-radius:3px;
     }
     
     .input-div input{
       width:310px;
       height:35px;
       padding-left:5px;
       font: normal 13px sans-serif;
       color: #0c0c0c;
       border-radius:3px;
       border: 1px solid #bfc4c6;
       outline:none;
       
     }
     
     .input-div:hover{
       background-color:#e0f1fc
       
     }
     
     .input-div:hover input{
       border-color:#7dc6dd;
       
     }
     
     #input-senha{
       margin-top:10px;
     }
     
    
     
     botoes{
       width:300px;
       margin-left:20px;
       
     }
     
     botao{
       float:right;
       padding: 5px 15px;
       font: bold 12px sans-serif;
       border-radius:10px;
       text-shadow: 0px 1px 0x  #851944;
       border: 1px solid #9eb9c3;
       
       
        /* Permalink - use to edit and share this gradient: http://colorzilla.com/gradient-editor/#f9fcf7+0,f5f9f0+100&0.01+100,1+100 */
       background: -webkit-linear-gradient(rgba(249,252,247,1) 0%, rgba(245,249,240,1) 100%);
       background: -moz-linear-gradient(rgba(249,252,247,1) 0%, rgba(245,249,240,1) 100%);
       background: -o-linear-gradient(rgba(249,252,247,1) 0%, rgba(245,249,240,1) 100%);
       background: linear-gradient(rgba(249,252,247,1) 0%, rgba(245,249,240,1) 100%); /* FF3.6-15 */ /* Chrome10-25,Safari5.1-6 */ /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
       filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f9fcf7', endColorstr='#f5f9f0',GradientType=0 ); /* IE6-9 */

       color:#527988;
       box-shadow:0px 0px 10px #c9c9c9; 
     }
     
     botao:hover{
       cursor:pointer;
       
     }

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
<login-box>
       <div id="login-box-interno">
         <div id="login-box-label"> Cadastrar Comunidade </div>
         <form action="inserirComunidade" method="post" enctype="multipart/form-data">
           <div class="input-div" id="input-nome"> 
			Nome: <input type="text" name="nome" />
			
		  </div>
		  
		  <div class="input-div" id="input-categoria">	
			Categoria: 
			
			<select name="catid"> 
				<c:forEach var="c" items="${categoria}">
				<option  value="${c.catid}" > ${c.nome} </option>
 				</c:forEach> 
			</select>
			
		  </div>
		  
		  <div class="input-div" id="input-imagem">
			Imagem: <input type="file" name="imagem" /> <br />
		  </div>
				<div id="botoes">
	          	<div id="botao"> 
	          	<input type="submit" name="ok" value="Finalizar">
				</div>
		       </div> 
		  </form>          
	</div>
</login-box>
</div>
	
	
</body>
</html>