/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Marco
 */
public class AutenticacaoLogin {
    
    public Boolean login(String user, String pass) throws SQLException{  
     boolean existe = false;  
     PreparedStatement stm = Conexao.prepareStatement("SELECT * FROM usuario WHERE nome_usu = ? AND senha_usu = ?");  
     stm.setString(1, user);  
     stm.setString(2, pass);  
     ResultSet rs = stm.executeQuery();  
     if(rs.next()){  
         existe = true;  
     }  
     return existe;  
}  
    
}
