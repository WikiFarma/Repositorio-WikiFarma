<%-- 
    Document   : Vendalista
    Created on : 15/06/2015, 21:53:54
    Author     : Andrea
--%>

<%@page import="Model.Produto"%>
<%@page import="Dao.ProdutoCRUD"%>
<%@page import="Model.Cliente"%>
<%@page import="Dao.ClienteCRUD"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Venda"%>
<%@page import="java.util.List"%>
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
        <title>Lista das Vendas</title>
    </head>
    <body>
       <h1>Lista do Vendas</h1>
        <table class="tabela">
            <tr>
                <td class="tabela">Tipo</td>
                <td class="tabela">Cliente</td>
                <td class="tabela">Produto</td>
                <td class="tabela">Quantidade vendida</td>
                <td class="tabela">Preço de venda</td> 
                <td class="tabela">Total</td> 
                <td class="tabela">Data de registro</td> 
            </tr>
            <%
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                List<Venda> listaProduto = (List) request.getAttribute("vendas");
                ClienteCRUD cRUD = new ClienteCRUD();
                ProdutoCRUD pcrud = new ProdutoCRUD();
                Iterator it = listaProduto.iterator();
                while (it.hasNext()) {
                Venda v = (Venda) it.next();
                Cliente cliente = cRUD.readID(v.getId_cli_ven());
                Produto produto = pcrud.readID(v.getId_pro_ven());
                out.print("<tr>"
                        + "<td class='tabela'>"
                        + (v.getTipo_ven() == 1 ? "Cartão":"A vista") 
                        + "</td>"
                        + "<td class='tabela'>"
                        + cliente.getNome()
                        + "</td>"
                        + "<td class='tabela'>"
                        + produto.getDescricao_pro()
                        + "</td>"
                        + "<td class='tabela'>"
                        + v.getQtde_pro_ven()
                        + "</td>"
                        + "<td class='tabela'>"
                        + v.getPreco_venda_pro_ven()
                        + "</td class='tabela'>"
                        + "<td class='tabela'>"
                        + v.getTotal_ven()
                        + "</td class='tabela'>"
                        + "<td class='tabela'>"
                        + formatter.format(v.getData_ven())
                        + "</td class='tabela'>"
                        + "</tr>");
                }
            %>
        </table>
        <br>
        <br>
        <ul>            
            <li> <a href="venda.do?cmd=realizar"> VOLTAR P/ VENDA </a> </li>
        </ul>
    </body>
</html>
