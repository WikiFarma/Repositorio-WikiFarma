<%-- 
    Document   : AutenticacaoLogin
    Created on : 29/04/2015, 22:14:16
    Author     : Thayse
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <script language = "Javascript">
            function ValidarLogin() {
                var user = document.form_login.user;
                var pass = document.form_login.pass;
                if ((user.value == null) || (user.value == "")) {
                    alert("INSIRA UM LOGIN")
                    user.focus()
                    return false
                }
                if ((pass.value == null) || (pass.value == "")) {
                    alert("POR FAVOR INSIRA UMA SENHA!")
                    pass.focus()
                    return false
                }
                return true
            }
        </script>
    </head>
    <body>
        <h1>Login<br></h1>
        <form name="frm" action="Control.AutenticacaoDeLogin" method="Post" onSubmit="return ValidarLogin()" >
            <table>
                <tr> <td>LOGIN:</td> <td><input type="text" name="user" value=""/></td> </tr>
                <tr> <td>SENHA:</td> <td><input type="password" name="pass" value=""/></td> </tr>
                <td colspan="2" align="center">
                <input type="submit" value="LOGAR" name="btEnviar" />            
                <input type="reset" value="LIMPAR" /> </td>
            </table>
        </form>
    </body>
</html>