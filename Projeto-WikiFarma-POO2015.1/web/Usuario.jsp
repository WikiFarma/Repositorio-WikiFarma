<%-- 
    Document   : Usuario
    Created on : 06/06/2015, 22:30:59
    Author     : Andrea
--%>

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
        <title>Usuario</title>
    </head>
    <body>
        <h1> <b> Formulario Opções de Usuario </b> </h1>
        <form name="form_cli" method="post" onSubmit="return ValidarCliente()">  
                <table>
                    <tr> <td>LOGIN:</td> <td><input type="text" name="textLogin" value="" size="50" /></td> </tr>
                    <tr> <td>SENHA:</td> <td><input type="text" name="textSenha" value="" size="50" /></td> </tr>                                
                    <td colspan="2" align="center">
                        <input type="submit" value="SALVAR" name="btEnviar" class="Botoes2" formaction="usuario.do?cmd=cadastrar" />
                        <input type="submit" value="ATUALIZAR" name="btAtualizar" class="Botoes2" formaction="usuario.do?cmd=updata"/>
                        <input type="submit" value="DELETAR" name="btDeletar" class="Botoes2" formaction="usuario.do?cmd=deletar"/>
                        <input type="reset" value="LIMPAR" name="btLimpar" class="Botoes2"/></td>           
                </table>
            </form>
            <br>
            <br>
            <h1>Busca de Usuario</h1>
            <form name="form_cli_busca" method="post">
                <table>
                    <tr> <td>LOGIN:</td> <td><input type="text" name="textLoginBusca" value="" size="50" /></td> </tr>
                    <tr>
                        <td align="center">
                            <input type="submit" value="BUSCAR" name="btBuscar" class="Botoes2" formaction="usuario.do?cmd=find" />
                            <input type="submit" value="Listar" name="btBuscar" class="Botoes2" formaction="usuario.do?cmd=listar" />
                        </td>
                    </tr>
                </table>                
            </form>
    </body>
</html>
