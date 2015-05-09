<%-- 
    Document   : Produto
    Created on : 09/05/2015, 17:37:09
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> CADASTRAR PRODUTO </title>
    </head>
    <body>
        <script language = "Javascript">
            function ValidarProduto(){
                var textDesc=document.form_pro.textDesc;
                var textCod=document.form_pro.textCod;
                var textTipo=document.form_pro.textTipo;
                var textCusto=document.form_pro.textCusto;
                var textPreVenda=document.form_pro.textPreVenda;
                var textPreVendaCli=document.form_pro.textPreVendaCli;
                var textQtde=document.form_pro.textQtde;
                var textData=document.form_pro.textData;
                if ((textDesc.value==null)||(textDesc.value=="")){
                alert("INSIRA UMA DESCRÇÃO PARA O PRODUTO!")
                textDesc.focus()
                return false }
                if ((textCod.value==null)||(textCod.value=="")){
                alert("INSIRA UM CODIGO DE BARRAS!")
                textCod.focus()
                return false }
                if ((textTipo.value==null)||(textTipo.value=="")){
                alert("INSIRA UM TIPO '1-REMEDIO' '0-OUTRO'")
                textTipo.focus()
                return false }
                if ((textCusto.value==null)||(textCusto.value=="")){
                alert("INSIRA O VALOR DE COMPRA DO PRODUTO!")
                textCusto.focus()
                return false }
                if ((textPreVenda.value==null)||(textPreVenda.value=="")){
                alert("INSIRA UM PREÇO DE VENDA!")
                textPreVenda.focus()
                return false }
                if ((textPreVendaCli.value==null)||(textPreVendaCli.value=="")){
                alert("INSIRA UM PREÇO DE VENDA COM DESCONTO PARA CLEINTES CADASTRADOS!")
                textPreVendaCli.focus()
                return false }
                if ((textQtde.value==null)||(textQtde.value=="")){
                alert("INSIRA A QUANTIDADE DO PRODUTO EM ESTOQUE!")
                textQtde.focus()
                return false }
                if ((textData.value==null)||(textData.value=="")){
                alert("INSIRA A DATA DO CADASTRO")
                textData.focus()
                return false }
            return true }
        </script>        
        <h2> <b> Formulario Castrado de Produto </b> </h2>               
        <form name="form_pro" action="" method="post" onSubmit="return ValidarProduto()">  
            <table>
                <tr> <td>Descrição:</td> <td><input type="text" name="textDesc" value="" size="100" /></td> </tr>
                <tr> <td>Cód. Barras:</td> <td><input type="text" name="textCod" value="" size="50" /></td> </tr>
                <tr> <td>Tipo Produto:</td> <td><input type="text" name="textTipo" value="" size="10" /></td> </tr>
                <tr> <td>Custo:</td> <td><input type="text" name="textCusto" value="" size="15" /></td></tr>
                <tr> <td>Preço de Venda: </td> <td><input type="text" name="textPreVenda" value="" size="15" /></td> </tr>
                <tr> <td>Preço c/ Desconto :</td> <td><input type="text" name="textPreVendaCli" value="" size="15" /></td> </tr>
                <tr> <td>Quantidade:</td> <td><input type="text" name="textQtde" value="" size="15" /></td> </tr>
                <tr> <td>Data Cadastro:</td> <td><input type="text" name="textData" value="" size="20" /></td> </tr>
                <td colspan="2" align="center">
                <input type="submit" value="SALVAR" name="btEnviar" />
                <input type="button" value="ATUALIZAR" name="btAtualizar" />
                <input type="button" value="DELETAR" name="btDeletar" />
                <input type="reset" value="LIMPAR" name="btLimpar" /></td>
            </table>
        
    </body>
</html>
