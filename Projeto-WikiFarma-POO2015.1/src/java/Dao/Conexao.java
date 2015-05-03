/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Marco
 * 
 * Andrea : 
 * 
 * retirada dos parametros conection, receidos em abrirConecao e fecharConecao pois isso uma maneira
 * q eu vi de evitar a criação de varias conexões. n sei se esse é o melhor meio de fazer, temos q ver isso 
 */
public class Conexao {

    private static Connection con;

    public static void abrirConexao() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmaciadb", "root", "admin");
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fecharConexao() throws SQLException {
        try {
            con.close();
            System.out.println("Conexão Fechada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }
}
