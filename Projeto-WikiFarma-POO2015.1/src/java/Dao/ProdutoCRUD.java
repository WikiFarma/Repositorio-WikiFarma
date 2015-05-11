/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Produto;
import Dao.Conexao;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Marco
 */
public class ProdutoCRUD extends Conexao {
    
    public String inserir (Produto produto) throws SQLException {
    
        abrirConexao();
        
        String comando = "INSERT INTO produto(desc_pro, cod_bar_pro, tipo_pro, custo_pro, preco_venda_pro, preco_venda_cli_pro, qtde_pro, data_reg_pro) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement prep = getCon().prepareStatement(comando);
            
            prep.setString(1, produto.getDescricao_pro());
            prep.setInt(2, produto.getCod_barra_pro());
            prep.setInt(3, produto.getTipo_pro());
            prep.setInt(4, (int) produto.getPreco_custo_pro());
            prep.setInt(5, (int) produto.getPreco_venda_pro());
            prep.setInt (6, (int) produto.getPreco_venda_pro_cli());
            prep.setInt(7, produto.getQtde_pro());
            prep.setString(8, produto.getData_cad_pro());
            
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
