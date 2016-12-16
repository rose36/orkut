<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<style>
<style type="text/css">
 {
   padding: 0;
   margin: 0;
   
}

    body{
    background-image: url(./resources/imagens/background.jpg);
    background-size: cover; /*Css padrão*/
    -webkit-background-size: cover; /*Css safari e chrome*/
    -moz-background-size: cover; /*Css firefox*/
    -ms-background-size: cover; /*Css IE não use mer#^@%#*/
    -o-background-size: cover; /*Css Opera*/
    
	}
	
	.logo{
    margin-left: 50px;
    margin-top: 0px;
    display: inline-block;
    float: left;
	
    }  
   
 	.logo{
   		position:absolute;
		left:50%;
		top:50%;
		
		margin-left:-600px;
		margin-top:-230px;
    }  
     
     #login-box-interno{
       width:330px;
       height:230px;
       background-color: white;
       margin-left:920px;
       margin-top:100px;
       border-radius:5px;
       box-shadow:0px 0px 5px black;
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

       border-bottom:1px solid #851944;
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
       width:210px;
       height:25px;
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
     
    
     
     #botoes{
       width:300px;
       margin-left:20px;
       
     }
     
     #botao{
       float:right;
       padding: 5px 15px;
       font: bold 12px sans-serif;
       border-radius:10px;
       text-shadow: 0px 1px 0x #851944;
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
     
     #botao:hover{
       cursor:pointer;
       
     }
     
     #cadastro{
       width:325px;
       height:50px;
       padding-left:5px;
       font: normal 13px sans-serif;
       color: #0c0c0c;
       border: 1px solid #bfc4c6;
       outline:none;
       margin-left:920px;
       margin-top:10px;
       backgroud-color:white;
       border-radius:5px;
       box-shadow:0px 0px 5px black;
       overflow:hidden;
       color:#555555;
       background-color: white;
     }
  
    
  </style>




</head>
<body>

<login-box>
<form action="login" method="post">
       <div id="login-box-interno">
         <div id="login-box-label"> Efetuar login</div>
      
         <div class="input-div" id="input-nome">
           Usuario: <input type="text" name="login">
         </div>
         
         <div class="input-div" id="input-senha">
           Senha: <input type="password" name="senha">
         </div>
   
         
        
         <div id="botoes">
           <div id="botao">
           <input type="submit" value="Entrar">
           </div>
           
         </div>
         
         </div>
         
        <div id="cadastro">
        <b>Não possui uma conta?</b>
        <a href="inserirUsuarioFormulario"><p>Cadastre-se</a>
        
        </div>


</form>
</login-box>

		
		<div class="logo">
            <img src="./resources/imagens/logo.png" width="400px"/>
        </div>


</body>
</html>






