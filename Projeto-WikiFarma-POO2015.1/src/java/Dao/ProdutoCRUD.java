/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static Dao.Conexao.abrirConexao;
import static Dao.Conexao.fecharConexao;
import Model.Produto;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            prep.setFloat(4,  produto.getPreco_custo_pro());
            prep.setFloat(5,  produto.getPreco_venda_pro());
            prep.setFloat(6,  produto.getPreco_venda_pro_cli());
            prep.setInt(7, produto.getQtde_pro());
            java.sql.Date sqlDate = new java.sql.Date(produto.getData_cad_pro().getTime());
            prep.setDate(8, sqlDate);
            
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
    public String delet(int cod_bar_pro) throws SQLException {
        abrirConexao();
        String comando = "DELETE FROM produto WHERE cod_bar_pro = ?";

        try {
            PreparedStatement prep = getCon().prepareStatement(comando);

            prep.setInt(1, cod_bar_pro);

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

    public String update(Produto produto) throws SQLException {
        abrirConexao();

        String comando = "UPDATE produto SET desc_pro = ?, tipo_pro = ?, custo_pro = ?, preco_venda_pro = ?,"
                + "preco_venda_cli_pro = ?, qtde_pro = ? WHERE cod_bar_pro = ?";

        try {
            PreparedStatement prep = getCon().prepareStatement(comando);

            prep.setString(1, produto.getDescricao_pro());
            prep.setInt(2, produto.getTipo_pro());
            prep.setFloat(3, produto.getPreco_custo_pro());
            prep.setFloat(4, produto.getPreco_venda_pro());
            prep.setFloat(5, produto.getPreco_venda_pro_cli());
            prep.setInt(6, produto.getQtde_pro());
            prep.setInt(7, produto.getCod_barra_pro());

            if (prep.execute()) {
                fecharConexao();
                return "Erro ao atualizar";

            } else {
                fecharConexao();
                return "Atualizado com Sucesso";
            }

        } catch (SQLException e) {
            fecharConexao();
            return e.getMessage();

        }
    }

    public Produto read(int cod_bar_pro) throws SQLException {

        abrirConexao();

        String comando = "SELECT * FROM produto WHERE cod_bar_pro = ?";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        ResultSet rs;

        try {
            PreparedStatement prep = getCon().prepareStatement(comando);
            prep.setInt(1, cod_bar_pro);

            rs = prep.executeQuery();
            Produto temp = new Produto();
            while (rs.next()) {

                // pega todos os atributos da pessoa  
                temp.setCod_barra_pro(rs.getInt("cod_bar_pro"));
                temp.setId_pro(rs.getInt("id_pro"));
                temp.setDescricao_pro(rs.getString("desc_pro"));
                temp.setTipo_pro(rs.getInt("tipo_pro"));
                temp.setPreco_custo_pro(rs.getFloat("custo_pro"));
                temp.setPreco_venda_pro(rs.getFloat("preco_venda_pro"));
                temp.setPreco_venda_pro_cli(rs.getFloat("preco_venda_cli_pro"));
                temp.setQtde_pro(rs.getInt("qtde_pro"));
                temp.setData_cad_pro(formatter.parse(rs.getString("data_reg_pro")));
      
            }
            fecharConexao();
            return temp;
        } catch (SQLException e) {
            fecharConexao();
            Logger.getLogger(ClienteCRUD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } catch (ParseException ex) {
            fecharConexao();
            Logger.getLogger(ClienteCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public Produto readID(int id_pro) throws SQLException {

        abrirConexao();

        String comando = "SELECT * FROM produto WHERE id_pro = ?";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        ResultSet rs;

        try {
            PreparedStatement prep = getCon().prepareStatement(comando);
            prep.setInt(1, id_pro);

            rs = prep.executeQuery();
            Produto temp = new Produto();
            while (rs.next()) {

                // pega todos os atributos da pessoa  
                temp.setCod_barra_pro(rs.getInt("cod_bar_pro"));
                temp.setId_pro(rs.getInt("id_pro"));
                temp.setDescricao_pro(rs.getString("desc_pro"));
                temp.setTipo_pro(rs.getInt("tipo_pro"));
                temp.setPreco_custo_pro(rs.getFloat("custo_pro"));
                temp.setPreco_venda_pro(rs.getFloat("preco_venda_pro"));
                temp.setPreco_venda_pro_cli(rs.getFloat("preco_venda_cli_pro"));
                temp.setQtde_pro(rs.getInt("qtde_pro"));
                temp.setData_cad_pro(formatter.parse(rs.getString("data_reg_pro")));
      
            }
            fecharConexao();
            return temp;
        } catch (SQLException e) {
            fecharConexao();
            Logger.getLogger(ClienteCRUD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } catch (ParseException ex) {
            fecharConexao();
            Logger.getLogger(ClienteCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public List<Produto> listaProduto() throws SQLException {
        abrirConexao();

        List<Produto> listaTemp = new ArrayList<Produto>();
        String comando = "SELECT * FROM produto";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        ResultSet rs;
        try {
            PreparedStatement prep = getCon().prepareStatement(comando);

            rs = prep.executeQuery();

            while (rs.next()) {
                Produto temp = new Produto();
                  
                temp.setCod_barra_pro(rs.getInt("cod_bar_pro"));
                temp.setId_pro(rs.getInt("id_pro"));
                temp.setDescricao_pro(rs.getString("desc_pro"));
                temp.setTipo_pro(rs.getInt("tipo_pro"));
                temp.setPreco_custo_pro(rs.getFloat("custo_pro"));
                temp.setPreco_venda_pro(rs.getFloat("preco_venda_pro"));
                temp.setPreco_venda_pro_cli(rs.getFloat("preco_venda_cli_pro"));
                temp.setQtde_pro(rs.getInt("qtde_pro"));
                temp.setData_cad_pro(formatter.parse(rs.getString("data_reg_pro")));
                
                listaTemp.add(temp);
            }
            fecharConexao();
            return listaTemp;
        } catch (SQLException e) {
            fecharConexao();
            return null;
        } catch (ParseException ex) {
            fecharConexao();
            Logger.getLogger(ClienteCRUD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
}
