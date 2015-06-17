<%-- 
    Document   : Cliente
    Created on : 20/04/2015, 11:16:56
    Author     : Marco
--%>
<%@page import="Model.Cliente"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<cms:template element="head">
    <html>
        <head>
            <style>
                .Botoes { font-family:Verdana, Geneva, sans-serif; font-size:12pt; background:#B0C4DE; color:#000; border-radius:5px; border-color: #000}
                .Botoes1 { font-family:Verdana, Geneva, sans-serif; font-size:22pt; background:#B0C4DE; color:#000}
                .Botoes2 {font-family:Verdana, Geneva, sans-serif; font-size:12pt; background:#903; color:#FFF; border-radius:5px; border-color: #000}
                .tabela {border: 1px solid black;border-collapse: collapse;}
            </style>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title> CADASTRAR CLIENTE</title>
        </head>
        <body>    
            <script language = "Javascript">
                function ValidarCliente() {
                    var textCpf = document.form_cli.textCpf;
                    var textNome = document.form_cli.textNome;
                    var textEndereco = document.form_cli.textEndereco;
                    var textTelefone = document.form_cli.textTelefone;
                    var textData = document.form_cli.textData;
                    if ((textCpf.value == null) || (textCpf.value == "")) {
                        alert("INSIRA UM CPF")
                        textCpf.focus()
                        return false
                    }
                    if ((textNome.value == null) || (textNome.value == "")) {
                        alert("POR FAVOR INSIRA UM NOME PARA O CLIENTE!")
                        textNome.focus()
                        return false
                    }
                    if ((textEndereco.value == null) || (textEndereco.value == "")) {
                        alert("INSIRA UM ENDERECO DO CLIENTE")
                        textEndereco.focus()
                        return false
                    }
                    if ((textTelefone.value == null) || (textTelefone.value == "")) {
                        alert("INSIRA UM NUMERO DE TELEFONE DO CLIENTE")
                        textTelefone.focus()
                        return false
                    }
                    if ((textData.value == null) || (textData.value == "")) {
                        alert("INSIRA A DATA DO CADASTRO")
                        textData.focus()
                        return false
                    }
                    return true
                }
            </script>        
            <h1> <b> Formulario Opções de Cliente </b> </h1>  
            <!--mudou o metodo p post,  e a ação  mapeada no web-inf passando o parametro cmd como cadastrar-->        
            <form name="form_cli" method="post" onSubmit="return ValidarCliente()">  
                <table>
                    <tr> <td>CPF:</td> <td><input type="text" name="textCpf" value="" size="50" /></td> </tr>
                    <tr> <td>Nome Completo:</td> <td><input type="text" name="textNome" value="" size="50" /></td> </tr>
                    <tr> <td>Endereco:</td> <td><input type="text" name="textEndereco" value="" size="100" /><br></td> </tr>
                    <tr> <td>Telefone:</td> <td><input type="text" name="textTelefone" value="" size="20" /><br></td> </tr>
                    <tr> <td>Data Cadastro:</td> <td><input type="date" name="textData" value="" size="20" /></td> </tr>                                 
                    <td colspan="2" align="center">
                        <input type="submit" value="SALVAR" name="btEnviar" class="Botoes2" formaction="cliente.do?cmd=cadastrar" />
                        <input type="submit" value="ATUALIZAR" name="btAtualizar" class="Botoes2" formaction="cliente.do?cmd=updata"/>
                        <input type="submit" value="DELETAR" name="btDeletar" class="Botoes2" formaction="cliente.do?cmd=deletar"/>
                        <input type="reset" value="LIMPAR" name="btLimpar" class="Botoes2"/>
                    </td>           
                </table>
            </form>
            <br>
            <br>
            <h1>Busca de Clientes</h1>
            <form name="form_cli_busca" method="post">
                <table>
                    <tr> <td>CPF:</td> <td><input type="text" name="textCpfBusca" value="" size="50" /></td> </tr>
                    <tr>
                        <td align="center">
                            <input type="submit" value="BUSCAR" name="btBuscar" class="Botoes2" formaction="cliente.do?cmd=find" />
                            <input type="submit" value="Listar" name="btBuscar" class="Botoes2" formaction="cliente.do?cmd=listar" />
                            <input type="submit" value="VOLTAR MENU-PRINCIPAL" name="btBuscar" class="Botoes2" formaction="MenuPrincipal.jsp" />
                        </td>
                    </tr>
                </table>                
            </form>
        </body>
    </html>
</cms:template>