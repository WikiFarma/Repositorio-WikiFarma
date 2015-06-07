<%-- 
    Document   : ProdutoBuscar
    Created on : 06/06/2015, 21:09:47
    Author     : Andrea
--%>

<%@page import="Model.Produto"%>
<%@page import="java.text.SimpleDateFormat"%>
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
        <title>Buscar Produto</title>
    </head>
    <body>
        <h1>Busca do Produto</h1>
        <table class="tabela">
            <tr>
                <td class="tabela">Descrição</td>
                <td class="tabela">Código de barra</td>
                <td class="tabela">Tipo</td>
                <td class="tabela">Preço de custo</td>
                <td class="tabela">Preço de venda</td> 
                <td class="tabela">Preço com desconto</td> 
                <td class="tabela">Quantidade</td> 
                <td class="tabela">Data de registro</td> 
            </tr>
            <%
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Produto p = (Produto) request.getAttribute("produto");
                out.print("<tr>"
                        + "<td class='tabela'>"
                        + p.getDescricao_pro()
                        + "</td>"
                        + "<td class='tabela'>"
                        + p.getCod_barra_pro()
                        + "</td>"
                        + "<td class='tabela'>"
                        + (p.getTipo_pro() == 1 ? "Rémedio":"Outros") 
                        + "</td>"
                        + "<td class='tabela'>"
                        + p.getPreco_custo_pro()
                        + "</td>"
                        + "<td class='tabela'>"
                        + p.getPreco_venda_pro()
                        + "</td class='tabela'>"
                        + "<td class='tabela'>"
                        + p.getPreco_venda_pro_cli()
                        + "</td class='tabela'>"
                        + "<td class='tabela'>"
                        + p.getQtde_pro()
                        + "</td class='tabela'>"
                        + "<td class='tabela'>"
                        + formatter.format(p.getData_cad_pro())
                        + "</td class='tabela'>"
                        + "</tr>");

            %>
        </table>
        <br>
        <br>
        <ul>            
            <li> <a href="Produto.jsp"> Produto </a> </li>
        </ul>
    </body>
</html>
