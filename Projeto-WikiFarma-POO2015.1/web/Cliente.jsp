<%-- 
    Document   : Cliente
    Created on : 20/04/2015, 11:16:56
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> CADASTRAR CLIENTE</title>
    </head>
    <body>        
        <script langage="javascript">
            //Função Limpar campos
            function limpar(){
                with(document.form_cli){
                 textCpf.value = '';
                 textNome.value = '';                 
                }                
            }
            </script>        
        <h2> <b> Formulario Cadastro de Cliente </b> </h2>        
        <form name="form_cli" action="ClienteCRUD.java" method="get">          
            <table>
                <tr>
                    <td>CPF:</td>
                    <td><input type="text" name="textCpf" value="" size="50" /></td>
                </tr>
                <tr>
                    <td>Nome Completo: </td>
                    <td><input type="text" name="textNome" value="" size="50" /></td>                
                </tr>
                <tr>
                    <td>Endereco: </td>
                    <td><input type="text" name="textEndereco" value="" size="100" /><br></td>
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" name="textTelefone" value="" size="20" /><br></td>
                </tr>
                <tr>
                    <td>Data Cadastro:</td>
                    <td><input type="text" name="textData" value="" size="20" /></td>
                </tr>                                 
                <td colspan="2" align="center">
                <br><input type="submit" value="SALVAR" name="btEnviar" />
                </td>            
            </table>
    </body>
</html>
