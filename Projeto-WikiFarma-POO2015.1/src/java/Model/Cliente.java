/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Dao.ClienteCRUD;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Marco
 */
public class Cliente extends Pessoa {

    public Cliente(){
        
    }
    
    public Cliente(String nome) {
        super(nome);
    }

    private int id_cli;
    private int cpf_cli;
    private String endereco_cli;
    private int telefone_cli;
    private Date data_cad_cli;

    public Cliente(int id_cli, int cpf_cli, String endereco_cli, int telefone_cli, Date data_cad_cli, String nome) {
        super(nome);
        this.id_cli = id_cli;
        this.cpf_cli = cpf_cli;
        this.endereco_cli = endereco_cli;
        this.telefone_cli = telefone_cli;
        this.data_cad_cli = data_cad_cli;
    }

     //Andrea :
    //metodo criado para cadastrar o cliente
    public void cadastrar() throws SQLException {
        ClienteCRUD crud = new ClienteCRUD();
        crud.insetir(this);
    }
    
    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public int getCpf_cli() {
        return cpf_cli;
    }

    public void setCpf_cli(int cpf_cli) {
        this.cpf_cli = cpf_cli;
    }

    public String getEndereco_cli() {
        return endereco_cli;
    }

    public void setEndereco_cli(String endereco_cli) {
        this.endereco_cli = endereco_cli;
    }

    public int getTelefone_cli() {
        return telefone_cli;
    }

    public void setTelefone_cli(int telefone_cli) {
        this.telefone_cli = telefone_cli;
    }

    public Date getData_cad_cli() {
        return data_cad_cli;
    }

    public void setData_cad_cli(Date data_cad_cli) {
        this.data_cad_cli = data_cad_cli;
    }
}
