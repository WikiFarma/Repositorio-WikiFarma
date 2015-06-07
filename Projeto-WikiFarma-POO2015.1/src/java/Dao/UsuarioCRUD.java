/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import static Dao.Conexao.abrirConexao;
import static Dao.Conexao.fecharConexao;
import Model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class UsuarioCRUD extends Conexao {

    public Boolean login(String user, String pass) throws SQLException {
        boolean existe = false;
        String comando = "SELECT * FROM usuario WHERE nome_usu = ? AND senha_usu = ?";

        PreparedStatement prep = getCon().prepareStatement(comando);
        prep.setString(1, user);
        prep.setString(2, pass);

        if (prep.execute()) {
            fecharConexao();
            return false;
        } else {
            fecharConexao();
            return true;

        }

    }

    public String insetir(Usuario usuario) throws SQLException {

        abrirConexao();

        String comando = "INSERT INTO usuario(nome_usu,senha_usu) VALUES(?,?)";

        try {
            PreparedStatement prep = getCon().prepareStatement(comando);

            prep.setString(1, usuario.getLogin_usu());
            prep.setString(2, usuario.getSenha_usu());

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

    public String delet(String login) throws SQLException {
        abrirConexao();
        String comando = "DELETE FROM usuario WHERE nome_usu = ?";

        try {
            PreparedStatement prep = getCon().prepareStatement(comando);

            prep.setString(1, login);

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

    public String update(Usuario usuario) throws SQLException {
        abrirConexao();

        String comando = "UPDATE usuario SET senha_usu = ? WHERE nome_usu = ?";

        try {
            PreparedStatement prep = getCon().prepareStatement(comando);

            prep.setString(1, usuario.getSenha_usu());
            prep.setString(2, usuario.getLogin_usu());

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

    public Usuario read(String login) throws SQLException {

        abrirConexao();

        String comando = "SELECT * FROM usuario WHERE nome_usu = ?";

        ResultSet rs;

        try {
            PreparedStatement prep = getCon().prepareStatement(comando);
            prep.setString(1, login);

            rs = prep.executeQuery();
            Usuario temp = new Usuario();
            while (rs.next()) {

                // pega todos os atributos da pessoa  
                temp.setLogin_usu(rs.getString("nome_usu"));
                temp.setSenha_usu(rs.getString("senha_usu"));
            }
            fecharConexao();
            return temp;
        } catch (SQLException e) {
            fecharConexao();
            Logger.getLogger(ClienteCRUD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }

    }

    public List<Usuario> listaUsuario() throws SQLException {
        abrirConexao();

        List<Usuario> listaTemp = new ArrayList<Usuario>();
        String comando = "SELECT * FROM usuario";

        ResultSet rs;
        try {
            PreparedStatement prep = getCon().prepareStatement(comando);

            rs = prep.executeQuery();

            while (rs.next()) {
                Usuario temp = new Usuario();

                // pega todos os atributos da pessoa  
                temp.setLogin_usu(rs.getString("nome_usu"));
                temp.setSenha_usu(rs.getString("senha_usu"));

                listaTemp.add(temp);
            }
            fecharConexao();
            return listaTemp;
        } catch (SQLException e) {
            fecharConexao();
            return null;
        } 
    }

}
