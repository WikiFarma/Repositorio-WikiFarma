/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marco
 */
public class Conexao 
{    
    public static void abrirConexao(String[] args) throws SQLException
    {
       try{ 
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmaciadb","root","");
       System.out.println("Conectado");                   
       } catch (SQLException e){
           System.out.println(e.getMessage());
       } catch (Exception e){
           System.out.println(e.getMessage());
       }       
    }

    public static void fecharConexao(Connection con) throws SQLException
    {
    try{        
    con.close();
    System.out.println("Conexão Fechada");       
       } catch (SQLException e){
           System.out.println(e.getMessage());
         } catch (Exception e){
           System.out.println(e.getMessage());
         }     
    }    
}
