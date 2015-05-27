/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.Conexao;
import Dao.AutenticacaoLogin;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
/**
 *
 * @author Thayse
 */
public class LoginControl extends HttpServlet {

    private ServletConfig config;
    private Object action;

    public void init(ServletConfig config)
            throws ServletException {
        this.config = config;

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //String action = request.getParameter("cmd");
        //String user = request.getParameter("user");
        //String pass = request.getParameter("pass");
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
