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
public class ClasseConexao {
    
    public static void abrirConexao(String[] args) throws SQLException
    {
       Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmaciadb","root","");
       System.out.println("Conectado");       
    }

    public static void fecharConexao(Connection conexao) throws SQLException
    {
    conexao.close();
    System.out.println("Conexão Fechada");       
    }    
}
