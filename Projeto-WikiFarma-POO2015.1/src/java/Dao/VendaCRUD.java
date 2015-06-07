/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static Dao.Conexao.abrirConexao;
import static Dao.Conexao.fecharConexao;
import Model.Cliente;
import Model.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrea
 */
public class VendaCRUD extends Conexao{
    public String insetir(Venda venda) throws SQLException {

        abrirConexao();

        String comando = "INSERT INTO venda(tipo_ven,id_cli_ven,id_pro_ven,qtde_pro_ven,preco_venda_pro_ven,"
                + "qtde_ven,total_ven,data_ven) VALUES(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement prep = getCon().prepareStatement(comando);

            prep.setInt(1, venda.getTipo_ven());
            prep.setInt(2, venda.getId_cli_ven());
            prep.setInt(3, venda.getId_pro_ven());
            prep.setInt(4, venda.getQtde_pro_ven());
            prep.setFloat(5, venda.getPreco_venda_pro_ven());
            prep.setInt(6, venda.getQtde_ven());
            prep.setFloat(7, venda.getTotal_ven());
                      
            java.sql.Date sqlDate = new java.sql.Date(venda.getData_ven().getTime());
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

    public Venda read(int id_cli_ven,int id_pro_ven) throws SQLException {

        abrirConexao();

        String comando = "SELECT * FROM venda WHERE id_cli_ven = ? AND id_pro_ven = ?";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        ResultSet rs;

        try {
            PreparedStatement prep = getCon().prepareStatement(comando);
            prep.setInt(1, id_cli_ven);
            prep.setInt(2, id_pro_ven);

            rs = prep.executeQuery();
            Venda temp = new Venda();
            while (rs.next()) {

                // pega todos os atributos da pessoa  
                temp.setTipo_ven(rs.getInt("tipo_ven"));
                temp.setId_cli_ven(rs.getInt("id_cli_ven"));
                temp.setId_pro_ven(rs.getInt("id_pro_ven"));
                temp.setQtde_pro_ven(rs.getInt("qtde_pro_ven"));
                temp.setPreco_venda_pro_ven(rs.getFloat("preco_venda_pro_ven"));
                temp.setQtde_ven(rs.getInt("qtde_ven"));
                temp.setTotal_ven(rs.getFloat("total_ven"));
                temp.setData_ven(formatter.parse(rs.getString("data_ven")));
      
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

    public List<Venda> listaCliente() throws SQLException {
        abrirConexao();

        List<Venda> listaTemp = new ArrayList<Venda>();
        String comando = "SELECT * FROM venda";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        ResultSet rs;
        try {
            PreparedStatement prep = getCon().prepareStatement(comando);

            rs = prep.executeQuery();

            while (rs.next()) {
                Venda temp = new Venda();
                
                // pega todos os atributos da pessoa  
                temp.setTipo_ven(rs.getInt("tipo_ven"));
                temp.setId_cli_ven(rs.getInt("id_cli_ven"));
                temp.setId_pro_ven(rs.getInt("id_pro_ven"));
                temp.setQtde_pro_ven(rs.getInt("qtde_pro_ven"));
                temp.setPreco_venda_pro_ven(rs.getFloat("preco_venda_pro_ven"));
                temp.setQtde_ven(rs.getInt("qtde_ven"));
                temp.setTotal_ven(rs.getFloat("total_ven"));
                temp.setData_ven(formatter.parse(rs.getString("data_ven")));
                
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
