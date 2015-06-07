/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    public void init(ServletConfig config)throws ServletException {
        this.config = config;

    }
    
        public String nome="";
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //String action = request.getParameter("cmd");
        //String user = request.getParameter("user");
        //String pass = request.getParameter("pass");
        PrintWriter out = response.getWriter();
        String connectionURL = "jdbc:mysql://localhost:3306/farmaciadb";
        Connection connection = null;
        ResultSet rs;
        String user = new String("");
        String pass = new String("");                
        response.setContentType("text/html");
        try {
// Load the database driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
// Get a Connection to the database
            connection = DriverManager.getConnection(connectionURL, "root", "");
//Add the data into the database
            String sql = "select nome_usu,senha_usu from usuario";
            Statement s = connection.createStatement();
            s.executeQuery(sql);
            rs = s.getResultSet();
            while (rs.next()) {                                
                user = rs.getString("nome_usu");
                pass = rs.getString("senha_usu");                
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }
        
        if (user.equals(request.getParameter("user"))
                && pass.equals(request.getParameter("pass"))) {
            out.println("WELCOME " + nome);
        } else {
            out.println("POR FAVOR ENTRE COM O LOGIN E A SENHA CORRETA");
            out.println("<a href='AutenticacaoLogin.jsp'><br>VOLTAR PARA LOGIN</a>");
        }
    }
        public Connection connection (){
            Connection conn = null;
            try{
                String connectionURL = "jdbc:mysql://localhost:3306/farmaciadb";
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                String sql = "select nome_usu,senha_usu from usuario";
                conn = DriverManager.getConnection(connectionURL, "root", "");
            }catch (Exception e) {
                
            }
            return conn;
        }
        public boolean result = false;
        public boolean verificarUsuario(String user, String pass){
            String sql = "";
            Connection conn = connection();
            sql += "select nome_usu,senha_usu from usuario";
            sql += "where nome_usu = " + "'" + user + "'";
            sql += "and senha_usu = " + "'" + pass + "'";
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()){
                    result = true;
                    nome = rs.getString("user");
                }
            }catch (Exception e) {
                
            }
            return result;
        }
}
