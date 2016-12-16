<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta name="viewport" content="width=device-width">
  <title>Cadastrar Usuário</title>
  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./resources/css/style_inserir_#.css"/>

<style>
login-box{
    background-color:#e0f1fc;
    border-raius:5px;
    
    }
    
     
     #login-box-interno{
       width:500px;
       height:530px;
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

       border-bottom:1px solid  #F2FFFC;
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
       text-shadow: 0px 1px 0x  #e0f1fc;
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
width: 180px;
height:70px;
margin-top: 50px;
float:right;
}

#login p{
font-family:Verdana;
font-size:16px;
}

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


</style>

</head>
  
<body>


<div id="topo">
			

		<div id="menu">
			<a href="index">Efetuar Login</a>
		</div>
		
Usuário inserido com sucesso!!!

</div>
</body>
</html>