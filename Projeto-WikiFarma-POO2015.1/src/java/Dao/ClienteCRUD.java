/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Classes.Cliente;
import Dao.Conexao;
import java.sql.*;
import java.util.*;

/**
 * 
 *  @author Marco
 * Andrea :
 * classe alterada de pacote para melhor compreenssão 
 * agr ela extende a classe conexão p não ter que criar  toda vez uma conexão e sim somente abrir e fechar
 * ajuste no codigo de inserção, pois faltava  passar os dados do nome no comando sql
 * troquei o comando prep.executeUpdata pois  não estava conseguindo p fazer pegar 
 */
public class ClienteCRUD extends Conexao {

    public String insetir(Cliente cliente) throws SQLException {

        abrirConexao();

        String comando = "INSERT INTO cliente(cpf_cli,nome_cli,endereco_cli,telefone_cli,data_cad_cli) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prep = getCon().prepareStatement(comando);

            prep.setInt(1, cliente.getCpf_cli());
            prep.setString(2, cliente.getNome());
            prep.setString(3, cliente.getEndereco_cli());
            prep.setInt(4, cliente.getTelefone_cli());
            prep.setString(5, cliente.getData_cad_cli());

             if (prep.execute()) {
             fecharConexao();
             return "Inserido com Sucesso";
             } else {
             fecharConexao();
             return "Erro ao insetir";
             }
             
        } catch (SQLException e) {
            fecharConexao();
            return e.getMessage();

        }
    }
}
