<%-- 
    Document   : MenuPrincipal
    Created on : 18/05/2015, 22:17:15
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
        * {
        font-family:Verdana, Geneva, sans-serif;
        <!--font-size:12px;-->
        }
        ul {    
        height:40px;
        margin: 0;
        padding:0;
        }
        li {
        list-style: none; 
        margin: 10px;
        display: inline;
        }
        li a {
            width:99%;
        padding: 5px 10px; /*LARGURA E TAMANHANO MENU*/
        margin:0;
        border: 0px solid #f00; 
        background: #903;
        text-decoration: none;
        color:#FFF;
        /* cantos arredondados */
        -webkit-border-radius:5px; /*chrome */
        -moz-border-radius:5px; /*mozila*/ 
        border-radius:5px;
        }
        li a:hover {
        background: #CCC;
        color: #000; 
        border-color: #000;
        height:27px;
        }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>    
        <img align="right" src="WF.png"> 
        <br><h1 align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; WIKIFARMA </h1><br>
        <h2 align="center"> <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ESCOLHA UMA DAS OPÇOES ABAIXO </b> </h2> <br> <br>
        <div class="menu" align="center">
        <ul>            
            <li> <a href="venda.do?cmd=realizar" > VENDA </a> </li>          
            <li> <a href="Cliente.jsp"> CLIENTE </a> </li>
            <li> <a href="Produto.jsp"> PRODUTO </a> </li>
            <li> <a href="Relatorios.jsp"> RELATORIO </a> </li>
            <li> <a href="Usuario.jsp">USUARIO</a></li>
            <li> <a href="SobreWikifarma.jsp">SOBRE WIKIFARM</a></li>
        </ul>
        </div>
    </body>
</html>
