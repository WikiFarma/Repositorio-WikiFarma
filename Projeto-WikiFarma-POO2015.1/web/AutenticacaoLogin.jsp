<%-- 
    Document   : AutenticacaoLogin
    Created on : 29/04/2015, 22:14:16
    Author     : Thayse
--%>
<%@page import="CRUD.*, Classes.*, java.sql.*, java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <script language = "Javascript">
            function Validate(){
                var user=document.frm.user;
                var pass=document.frm.pass; 
                if ((user.value==null)||(user.value=="")){
                alert("INSIRA UM LOGIN")
                user.focus()
                return false
                }
                if ((pass.value==null)||(pass.value=="")){
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
        <form name="frm" action="Classes.AutenticacaoDeLogin" method="Post" onSubmit="return Validate()" >
        Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="user" value=""/><br>
        Password:<input type="password" name="pass" value=""/><br>
                <td colspan="2" align="center">
                <br><input type="submit" value="LOGAR" name="btEnviar" />
                </td> <td colspan="2" align="center">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="RESET" />
                </td> 
</form>
    </body>
</html>