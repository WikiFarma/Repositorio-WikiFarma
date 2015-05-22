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
        margin: 0;
        padding:0;
        }
        li {
        list-style: none; 
        margin: 10px;
        display: inline;
        }
        li a {
        padding: 5px 10px; 
        margin:0;
        border: 0px solid #f00; 
        background: #903;
        text-decoration: none;
        color:#FFF;
        /* cantos arredondados */
        -webkit-border-radius:5px;
        -moz-border-radius:5px;
        border-radius:5px;
        }
        li a:hover {
        background: #CCC;
        color: #000; 
        border-color: #000;
        }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <img src="WF.png"> 
        <h1> WIKIFARMA </h1> <br>
        <h2> <b> DIGITE UM DOS MENUS </b> </h2> <br>
        <ul>
            <li> <a href="Produto.jsp"> PRODUTO </a> </li>
            <li><a href="#">link 2</a></li>
            <li><a href="#">link 3</a></li>
            <li><a href="#">link 4</a></li>
            <li><a href="#">link 5</a></li>
        </ul>
    </body>
</html>
