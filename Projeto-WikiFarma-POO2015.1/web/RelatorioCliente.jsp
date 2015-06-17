<%-- 
    Document   : RelatorioCliente
    Created on : 16/06/2015, 13:44:00
    Author     : Andrea
--%>

<%@page import="java.util.Date"%>
<%@page import="Model.Produto"%>
<%@page import="Model.Cliente"%>
<%@page import="java.util.Iterator"%>
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
        <title>Realtorio Clientes</title>
    </head>
    <body>
        <h1>Relatorio de Clientes</h1>
        <table class="tabela">
            <tr>
                <td class="tabela">CPF</td>
                <td class="tabela">Nome</td>
                <td class="tabela">Endereço</td>
                <td class="tabela">Telefone</td>
                <td class="tabela">Data de Cadastro</td> 
                <td class="tabela">Valor total das compras já realizadas</td> 
                <td class="tabela">Utimo produto comprado</td> 
                <td class="tabela">Valor da utima compra</td> 
                <td class="tabela">Data da utima compra</td> 
            </tr>
            <%
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
                Produto[] produtos = (Produto[]) request.getAttribute("produtos");
                int[] id_cli = (int[]) request.getAttribute("id_cli");
                float[] precoTotal = (float[]) request.getAttribute("precosFinais");
                float[] valorUtimoProdu = (float[]) request.getAttribute("valorUtimoProdu");
                Date[] datafinal = (Date[]) request.getAttribute("datasFinais");
                //Iterator itp = produtos.iterator();
                int i = 0;
                for(Cliente c : clientes) {
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
                            + "</td>"
                            + "<td class='tabela'>"
                            + precoTotal[i]
                            + "</td>"
                            + "<td class='tabela'>"
                            + produtos[i].getDescricao_pro()
                            + "</td>"
                            + "<td class='tabela'>"
                            + valorUtimoProdu[i]
                            + "</td>"
                            + "<td class='tabela'>"
                            + (datafinal[i] == null? "Não Possui Compras":formatter.format(datafinal[i]))
                            + "</td>"
                            + "</tr>");
                    i++;
                }
            %>
        </table>
        <br>
        <br>
        <ul>            
            <li> <a href="Relatorios.jsp"> MENU-RELATORIOS </a> </li>
        </ul>
    </body>
</html>
