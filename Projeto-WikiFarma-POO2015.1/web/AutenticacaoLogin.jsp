<%-- 
    Document   : AutenticacaoLogin
    Created on : 29/04/2015, 22:14:16
    Author     : Thayse
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- <%@page import="login.User"%> --%>
<html>
    <head>
        
        <style>
            *{
            font-family:Verdana, Geneva, sans-serif;
            <!--font-size:12px;-->
            }
            ul {
            margin: 0;
            padding:0;
            }
            li {
            list-style: none; 
            margin: 10px;
            display: inline;
            }
            li a {
            padding: 5px 10px; 
            margin:0;
            border: 0px solid #f00; 
            background: #903;
            text-decoration: none;
            color:#FFF;
            /* cantos arredondados */
            -webkit-border-radius:5px;
            -moz-border-radius:5px;
            border-radius:5px;
            }
            li a:hover {
            background: #CCC;
            color: #000; 
            border-color: #000;
            }
            
            .Botoes { font-family:Verdana, Geneva, sans-serif; font-size:12pt; background:#B0C4DE; color:#000; border-radius:5px; border-color: #000}
            .Botoes1 { font-family:Verdana, Geneva, sans-serif; font-size:22pt; background:#B0C4DE; color:#000}
            .Botoes2 {font-family:Verdana, Geneva, sans-serif; font-size:12pt; background:#903; color:#FFF; border-radius:5px; border-color: #000}
        </style>
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
            function LimparCampo(){
                var user = document.form_login.user;
                var pass = document.form_login.pass;
                user = null;
                pass = null;
            }
            function verificarSenha(){
                if (obj.value.length <= 3){
                    alert("Senha deve ter mais de 3 caracteres.");
                    return false;
                }
            }
            
        </script>
    </head>
    <body>
        <form name="frm" action="ValidarLogin.jsp" method="Post" onSubmit=" return ValidarLogin()" >
            <table align="center" class="Botoes">
                <tr> <td class="Botoes1" COLSPAN=4 ><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LOGIN</b></td></tr>
                <tr> <td>USUÁRIO:</td> <td><input type="text" name="user" value=""/></td> </tr>
                <tr> <td>SENHA:</td> <td><input type="password" name="pass" value=""/></td> </tr>
                <td colspan="2" align="center">
                <input type="submit" value="LOGAR" name="btEnviar" class="Botoes2" href="MenuPrincipal.jsp" onSubmit="return ValidarLogin()"/>            
                <input type="reset" value="LIMPAR" method="Post" class="Botoes2" onSubmit="return LimparCampo()"/> </td>
            </table>
        </form>
    </body>
</html>