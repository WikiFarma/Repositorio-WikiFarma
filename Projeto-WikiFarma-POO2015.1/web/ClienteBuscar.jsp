<%-- 
    Document   : ClienteBuscar
    Created on : 06/06/2015, 13:23:22
    Author     : Matheus
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Model.Cliente"%>
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
        <title>Busca do Cliente</title>
    </head>
    <body>
        <h1>Busca do Cliente</h1>
        <table class="tabela">
            <tr>
                <td class="tabela">CPF</td>
                <td class="tabela">Nome</td>
                <td class="tabela">Endereço</td>
                <td class="tabela">Telefone</td>
                <td class="tabela">Data de Cadastro</td> 
            </tr>
            <%
                 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Cliente c = (Cliente) request.getAttribute("clientes");
                out.print("<tr>"
                        + "<td class='tabela'>"
                        + c.getCpf_cli()
                        + "</td>"
                        + "<td class='tabela'>"
                        + c.getNome()
                        + "</td>"
                        + "<td class='tabela'>"
                        + c.getEndereco_cli()
                        + "</td>"
                        + "<td class='tabela'>"
                        + c.getTelefone_cli()
                        + "</td>"
                        + "<td class='tabela'>"
                        + formatter.format(c.getData_cad_cli())
                        + "</td class='tabela'>"
                        + "</tr>");

            %>
        </table>
        <br>
        <br>
        <ul>            
            <li> <a href="Cliente.jsp"> CLIENTE </a> </li>
        </ul>
    </body>
</html>
