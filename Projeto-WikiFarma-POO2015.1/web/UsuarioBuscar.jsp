<%-- 
    Document   : UsuarioBuscar
    Created on : 06/06/2015, 23:10:23
    Author     : Andrea
--%>

<%@page import="Model.Usuario"%>
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
            .tabela {border: 1px solid black;border-collapse: collapse;}
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Usuario</title>
    </head>
    <body>
         <h1>Busca do Usuario</h1>
        <table class="tabela">
            <tr>
                <td class="tabela">Login</td>
                <td class="tabela">Senha</td> 
            </tr>
            <%
                Usuario u = (Usuario) request.getAttribute("usuario");
                out.print("<tr>"
                        + "<td class='tabela'>"
                        + u.getLogin_usu()
                        + "</td>"
                        + "<td class='tabela'>"
                        + u.getSenha_usu()
                        + "</td>"
                        + "</tr>");

            %>
        </table>
        <br>
        <br>
        <ul>            
            <li> <a href="Usuario.jsp"> Usuario </a> </li>
        </ul>
    </body>
</html>
