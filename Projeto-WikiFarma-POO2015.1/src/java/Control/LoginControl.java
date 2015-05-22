/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Thayse
 */
public class LoginControl extends HttpServlet {

    private ServletConfig config;

    public void init(ServletConfig config)
            throws ServletException {
        this.config = config;

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String connectionURL = "jdbc:mysql://localhost:3306/farmaciadb";
        Connection connection = null;
        ResultSet rs;
        String nome = new String("");
        String senha = new String("");                
        response.setContentType("text/html");
        try {
// Load the database driver
            Class.forName("com.mysql.jdbc.Driver");
// Get a Connection to the database
            connection = DriverManager.getConnection(connectionURL, "root", "admin");
//Add the data into the database
            String sql = "select nome_usu,senha_usu from usuario";
            Statement s = connection.createStatement();
            s.executeQuery(sql);
            rs = s.getResultSet();
            while (rs.next()) {                                
                nome = rs.getString("nome_usu");
                senha = rs.getString("senha_usu");                
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }
        if (nome.equals(request.getParameter("user"))
                && senha.equals(request.getParameter("pass"))) {
            out.println("WELCOME " + nome);
        } else {
            out.println("POR FAVOR ENTRE COM O LOGIN E A SENHA CORRETA");
            out.println("<a href='AutenticacaoLogin.jsp'><br>VOLTAR PARA LOGIN</a>");
        }
    }
}
