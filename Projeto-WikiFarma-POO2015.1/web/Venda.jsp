<%-- 
    Document   : Venda
    Created on : 07/06/2015, 00:31:18
    Author     : Andrea
--%>

<%@page import="Model.Produto"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .Botoes { font-family:Verdana, Geneva, sans-serif; font-size:12pt; background:#B0C4DE; color:#000; border-radius:5px; border-color: #000}
            .Botoes1 { font-family:Verdana, Geneva, sans-serif; font-size:22pt; background:#B0C4DE; color:#000}
            .Botoes2 {font-family:Verdana, Geneva, sans-serif; font-size:12pt; background:#903; color:#FFF; border-radius:5px; border-color: #000}
            .tabela {border: 1px solid black;border-collapse: collapse;}
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda</title>
    </head>
    <body>
        <h1> <b> Formulario Opções de Venda </b> </h1>  
        <!--mudou o metodo p post,  e a ação  mapeada no web-inf passando o parametro cmd como cadastrar-->        
        <form name="form_venda" method="post" onSubmit="return ValidarCliente()">  
            <table>
                <tr> <td>
                        <select name="textTipo">
                            <option value="1">Cartão</option>
                            <option value="2">A vista</option>
                        </select> 
                    </td>
                </tr>
                <tr> <td><select name="textIdCliente">
                            <option value="">Não possui cadastro</option>
                            <%
                                List<Cliente> clientes = (List) request.getAttribute("clientes");
                                Iterator itc = clientes.iterator();
                                while (itc.hasNext()) {
                                    Cliente c = (Cliente) itc.next();
                                    out.print("<option value=" + c.getId_cli() + ">" + c.getNome() + "</option>");
                                }
                            %>
                        </select></td> </tr>
                <tr> <td><select name="textIdProd">
                            <%
                                List<Produto> produtos = (List) request.getAttribute("produtos");
                                Iterator itp = produtos.iterator();
                                while (itp.hasNext()) {
                                    Produto p = (Produto) itp.next();
                                    out.print("<option value=" + p.getId_pro() + ">" + p.getDescricao_pro() + "</option>");
                                }
                            %>
                        </select></td> </tr>
                <tr> <td>QUANTIDA PRODUTO VENDIDO</td> <td><input type="number" min="0" name="textQuanTProVen" size="20" /><br></td> </tr>
                <tr> <td>DATA</td> <td><input type="date" name="textData" value="" size="20" /></td> </tr>                                 
                <td colspan="2" align="center">
                    <input type="submit" value="SALVAR" name="btEnviar" class="Botoes2" formaction="venda.do?cmd=cadastrar" />
                    <input type="reset" value="LIMPAR" name="btLimpar" class="Botoes2"/>
                    <input type="submit" value="LISTAR" name="btBuscar" class="Botoes2" formaction="venda.do?cmd=listar" />
                    <input type="submit" value="VOLTAR MENU-PRINCIPAL" name="btBuscar" class="Botoes2" formaction="MenuPrincipal.jsp" />
                </td>           
            </table>
        </form>
    </body>
</html>
