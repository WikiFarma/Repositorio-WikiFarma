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
        <script language = “Javascript”>
            function Validate(){
                var user=document.frm.user
                var pass=document.frm.pass 
                if ((user.value==null)||(user.value==””)){
                alert(“Please Enter user name”)
                user.focus()
                return false
                }
                if ((pass.value==null)||(pass.value==””)){
                alert(“Please Enter password”)
                pass.focus()
                return false
                }
            return true
            }
</script>
    </head>
    <body>
        <h1>Login<br></h1>
        <form name=”frm” action=”/JSPMultipleForms/LoginAuthentication” method=”Post” onSubmit=”return Validate()” >
        Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=”text” name=”user” value=””/><br>
        Password:<input type=”password” name=”pass” value=””/><br>
                <td colspan="2" align="center">
                <br><input type="submit" value="SALVAR" name="btEnviar" />
                </td> <td colspan="2" align="center">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="RESET" name="btEnviar" />
                </td> 
</form>
    </body>
</html>
