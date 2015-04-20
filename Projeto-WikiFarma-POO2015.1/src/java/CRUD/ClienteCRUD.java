/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import Classes.ClasseCliente;
import Classes.ClasseConexao;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Marco
 */
public class ClienteCRUD 
{    
    private Connection conexao;

    public ClienteCRUD(Connection conexao) {
        setConexao(conexao);
    }

    public Connection getConexao() {
        return conexao;
    }
    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }    

public String insetir (ClasseCliente cliente)
    {    
    String comando = "insert into cliente "
            + "(cpf_cli,nome_cli,endereco_cli,telefone_cli,data_cad_cli) values (?,?,?,?,)";
    
    try{    
    PreparedStatement prep = getConexao().prepareStatement(comando);
    
    prep.setInt(1, cliente.getCpf_cli());
    prep.setString(2, cliente.getEndereco_cli());
    prep.setInt(3, cliente.getTelefone_cli());
    prep.setString(4, cliente.getData_cad_cli());
    
    if(prep.executeUpdate() > 0){
        return "Inserido com Sucesso";
    } else {
        return "Erro ao insetir";
    }    
    } catch (SQLException e){
        return e.getMessage();
    }
    }
}
