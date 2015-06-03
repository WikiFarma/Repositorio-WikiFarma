/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Cliente;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Marco Andrea : classe alterada de pacote para melhor compreenssão agr
 * ela extende a classe conexão p não ter que criar toda vez uma conexão e sim
 * somente abrir e fechar ajuste no codigo de inserção, pois faltava passar os
 * dados do nome no comando sql troquei o comando prep.executeUpdata pois não
 * estava conseguindo p fazer pegar
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
            java.sql.Date sqlDate = new java.sql.Date(cliente.getData_cad_cli().getTime());
            prep.setDate(5, sqlDate);

            if (prep.execute()) {
                fecharConexao();
                return "Erro ao insetir";
            } else {
                fecharConexao();
                return "Inserido com Sucesso";
                
            }

        } catch (SQLException e) {
            fecharConexao();
            return e.getMessage();

        }
    }

    public String delet(int cpf_cli) throws SQLException {
        abrirConexao();
        String comando = "DELETE FROM cliente WHERE cpf_cli = ?";

        try {
            PreparedStatement prep = getCon().prepareStatement(comando);

            prep.setInt(1, cpf_cli);

            if (prep.execute()) {
                fecharConexao();
                return "Erro ao Deletar";
                
            } else {
                fecharConexao();
                return "Excluido com Sucesso";
            }
        } catch (SQLException e) {
            fecharConexao();
            return e.getMessage();
        }

    }

    public String update(Cliente cliente) throws SQLException {
        abrirConexao();

        String comando = "UPDATE cliente SET cpf_cli = ?, nome_cli = ?, endereco_cli = ?, telefone_cli = ? WHERE id_cli = ?";

        try {
            PreparedStatement prep = getCon().prepareStatement(comando);

            prep.setInt(1, cliente.getCpf_cli());
            prep.setString(2, cliente.getNome());
            prep.setString(3, cliente.getEndereco_cli());
            prep.setInt(4, cliente.getTelefone_cli());
            prep.setInt(5, cliente.getId_cli());

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

    public Cliente read() throws SQLException {

        abrirConexao();

        String comando = "SELECT * FROM cliente WHERE cpf_cli = ?";
        ResultSet rs;

        try {
            PreparedStatement prep = getCon().prepareStatement(comando);

            rs = prep.executeQuery(comando);
            Cliente temp = new Cliente();
            while (rs.next()) {

                // pega todos os atributos da pessoa  
                temp.setCpf_cli(rs.getInt("cpf_cli"));
                temp.setNome(rs.getString("nome_cli"));
                temp.setEndereco_cli(rs.getString("endereco_cli"));
                temp.setTelefone_cli(rs.getInt("telefone_cli"));
                //temp.setData_cad_cli(rs.getString("data_cad_cli"));
            }
            return temp;
        } catch (SQLException e) {
            fecharConexao();
            return null;

        }

    }

    public List<Cliente> listaCliente() throws SQLException {
        abrirConexao();
        List<Cliente> listaTemp = new ArrayList<Cliente>();
        String comando = "SELECT * FROM cliente WHERE cpf_cli = ?";
        ResultSet rs;
        try {
            PreparedStatement prep = getCon().prepareStatement(comando);

            rs = prep.executeQuery(comando);

            while (rs.next()) {
                Cliente temp = new Cliente();
                // pega todos os atributos da pessoa  
                temp.setCpf_cli(rs.getInt("cpf_cli"));
                temp.setNome(rs.getString("nome_cli"));
                temp.setEndereco_cli(rs.getString("endereco_cli"));
                temp.setTelefone_cli(rs.getInt("telefone_cli"));
                //temp.setData_cad_cli(rs.getString("data_cad_cli"));
                listaTemp.add(temp);
            }
            return listaTemp;
        }  catch (SQLException e) {
            fecharConexao();
            return null;

        }

    }
}
