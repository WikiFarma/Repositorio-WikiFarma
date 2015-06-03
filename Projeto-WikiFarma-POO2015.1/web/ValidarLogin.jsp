<%-- 
    Document   : TelaLogin
    Created on : 01/06/2015, 13:13:07
    Author     : Thayse
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="Model.Usuario"%>
<%@page import="Control.LoginControl"%>
<%@page import="Dao.AutenticacaoLogin"%>

<!DOCTYPE html>
<html>
    <head>
        <%!
        String user;
        String pass;
        %>
    </head>
    <body>
        <%
            LoginControl us = new LoginControl();
        user =request.getParameter("user");
        pass =request.getParameter("pass");
       boolean status = us.verificarUsuario(user,pass);
        if (us.result== true) {
            response.sendRedirect("MenuPrincipal.jsp");
            out.print("Login"+ us.nome);
        }else {
            //response.sendRedirect("AutenticacaoLogin.jsp");
            out.print("Login ou senha invalidos");
        }  
        %>
    </body>
</html>
