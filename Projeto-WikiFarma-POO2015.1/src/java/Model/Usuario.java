/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Marco
 */
public class Usuario {
    
    private String id_usu;
    private String login_usu;
    private String senha_usu;

    public Usuario() {
    }    

    public Usuario(String id_usu, String login_usu, String senha_usu) {
        this.id_usu = id_usu;
        this.login_usu = login_usu;
        this.senha_usu = senha_usu;
    }

    /*public String getId_usu() {
        return id_usu;
    }
    public void setId_usu(String id_usu) {
        this.id_usu = id_usu;
    }
*/
    
    public String getLogin_usu() {
        return login_usu;
    }
    public void setLogin_usu(String login_usu) {
        this.login_usu = login_usu;
    }

    
    public String getSenha_usu() {
        return senha_usu;
    }
    public void setSenha_usu(String senha_usu) {
        this.senha_usu = senha_usu;
    }
    
    
    
}
