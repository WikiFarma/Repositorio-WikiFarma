<%-- 
    Document   : Produto
    Created on : 09/05/2015, 17:37:09
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .Botoes { font-family:Verdana, Geneva, sans-serif; font-size:12pt; background:#B0C4DE; color:#000; border-radius:5px; border-color: #000}
            .Botoes1 { font-family:Verdana, Geneva, sans-serif; font-size:22pt; background:#B0C4DE; color:#000}
            .Botoes2 {font-family:Verdana, Geneva, sans-serif; font-size:12pt; background:#903; color:#FFF; border-radius:5px; border-color: #000}
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> CADASTRAR PRODUTO </title>
    </head>
    <body>
        <script language = "Javascript">
            function ValidarProduto() {
                var textDesc = document.form_pro.textDesc;
                var textCod = document.form_pro.textCod;
                var textTipo = document.form_pro.textTipo;
                var textCusto = document.form_pro.textCusto;
                var textPreVenda = document.form_pro.textPreVenda;
                var textPreVendaCli = document.form_pro.textPreVendaCli;
                var textQtde = document.form_pro.textQtde;
                var textData = document.form_pro.textData;
                if ((textDesc.value == null) || (textDesc.value == "")) {
                    alert("INSIRA UMA DESCRÇÃO PARA O PRODUTO!")
                    textDesc.focus()
                    return false
                }
                if ((textCod.value == null) || (textCod.value == "")) {
                    alert("INSIRA UM CODIGO DE BARRAS!")
                    textCod.focus()
                    return false
                }
                if ((textTipo.value == null) || (textTipo.value == "")) {
                    alert("INSIRA UM TIPO '1-REMEDIO' '0-OUTRO'")
                    textTipo.focus()
                    return false
                }
                if ((textCusto.value == null) || (textCusto.value == "")) {
                    alert("INSIRA O VALOR DE COMPRA DO PRODUTO!")
                    textCusto.focus()
                    return false
                }
                if ((textPreVenda.value == null) || (textPreVenda.value == "")) {
                    alert("INSIRA UM PREÇO DE VENDA!")
                    textPreVenda.focus()
                    return false
                }
                if ((textPreVendaCli.value == null) || (textPreVendaCli.value == "")) {
                    alert("INSIRA UM PREÇO DE VENDA COM DESCONTO PARA CLEINTES CADASTRADOS!")
                    textPreVendaCli.focus()
                    return false
                }
                if ((textQtde.value == null) || (textQtde.value == "")) {
                    alert("INSIRA A QUANTIDADE DO PRODUTO EM ESTOQUE!")
                    textQtde.focus()
                    return false
                }
                if ((textData.value == null) || (textData.value == "")) {
                    alert("INSIRA A DATA DO CADASTRO")
                    textData.focus()
                    return false
                }
                return true
            }

            function booleanTipo() {

                var radioTipo = document.form_pro.radioTipe;
                if (form_pro.radioTipe == 0) {
                    form_pro.radioTipe = 1;
                    return false;
                }
                if (form_pro.radioTipe == 1) {
                    form_pro.radioTipe = 1;
                    return false;
                }
                return true;
            }
        </script>        
        <h1> <b> Formulário Cadastro de Produto </b> </h1>
        <form name="form_pro" method="post" onSubmit="return ValidarProduto() return booleanTipe()">  
            <table>
                <tr> <td>Descrição:</td> <td><input type="text" name="textDesc" value="" size="100"/></td> </tr>
                <tr> <td>Cód. Barras:</td> <td><input type="text" name="textCod" value="" size="50"/></td> </tr>
                <tr> <td>Tipo Produto:</td> <td><input type="radio" name="radioTipe" value="remedio"/>Remédio<input type="radio" name="radioTipe" value="outros"/>Outros </td> </tr>
                <tr> <td>Custo:</td> <td><input type="text" name="textCusto" value="" size="15" /></td></tr>
                <tr> <td>Preço de Venda: </td> <td><input type="text" name="textPreVenda" value="" size="15" /></td> </tr>
                <tr> <td>Preço c/ Desconto :</td> <td><input type="text" name="textPreVendaCli" value="" size="15" /></td> </tr>
                <tr> <td>Quantidade:</td> <td><input type="text" name="textQtde" value="" size="15" /></td> </tr>
                <tr> <td>Data Cadastro:</td> <td><input type="date" name="textData" value=""/></td> </tr>
                <td colspan="2" align="center">
                    <input type="submit" value="SALVAR" name="btEnviar" class="Botoes2" formaction="produto.do?cmd=cadastrar"/>
                    <input type="submit" value="ATUALIZAR" name="btAtualizar" class="Botoes2" formaction="produto.do?cmd=updata"/>
                    <input type="submit" value="DELETAR" name="btDeletar" class="Botoes2" formaction="produto.do?cmd=deletar"/>
                    <input type="reset" value="LIMPAR" name="btLimpar" class="Botoes2" />
                    <input type="submit" value="VOLTAR MENU-PRINCIPAL" name="btBuscar" class="Botoes2" formaction="MenuPrincipal.jsp" />
                </td>
            </table>
        </form>
        <h1>Busca de Produto</h1>
        <form name="form_cli_busca" method="post">
            <table>
                <tr> <td>Codigo de Barra:</td> <td><input type="text" name="textCodBuscar" value="" size="50" /></td> </tr>
                <tr>
                    <td align="center">
                        <input type="submit" value="BUSCAR" name="btBuscar" class="Botoes2" formaction="produto.do?cmd=find" />
                        <input type="submit" value="LISTAR" name="btBuscar" class="Botoes2" formaction="produto.do?cmd=listar" />
                    </td>
                </tr>
            </table>                
        </form>
    </body>
</html>
