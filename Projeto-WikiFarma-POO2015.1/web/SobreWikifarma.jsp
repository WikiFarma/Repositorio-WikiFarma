<%-- 
    Document   : SobreWikifarma
    Created on : 08/06/2015, 09:39:43
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
        <h2 align="center"> <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; PROJETO PARA DISCIPLINA DE POO </b> </h2> <br> <br>
        <h2 align="center"> <b>&nbsp;&nbsp; ERP PARA GERENCIAMENTO DE UMA FARMACIA </b> </h2> <br> <br>
        <h2 align="center"> <b>&nbsp;&nbsp; INTEGRANTES: </b> </h2> <br>
        <h3 align="center"> <b>&nbsp;&nbsp;&nbsp;&nbsp; ANDREA, DEBORA, MARCO, WILLANY </b> </h3> <br> <br>
        <div class="menu" align="center">
        <ul>                        
            <li> <a href="MenuPrincipal.jsp"> VOLTAR </a> </li>                                                
        </ul>
        </div>
    </body>
</html>