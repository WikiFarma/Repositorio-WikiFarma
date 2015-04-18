/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Marco
 */
public class ClasseProduto {
    
    private int id_pro;
    private String descricao_pro;
    private int cod_barra_pro;
    private float preco_custo_pro;
    private int tipo_pro;
    private float preco_venda_pro;
    private float preco_venda_pro_cli;
    private int qtde_pro;
    private String data_cad_pro;

    public ClasseProduto() {
    }    
    
    public ClasseProduto(int id_pro, String descricao_pro, int cod_barra_pro, float preco_custo_pro, int tipo_pro, float preco_venda_pro, float preco_venda_pro_cli, int qtde_pro, String data_cad_pro) {
        this.id_pro = id_pro;
        this.descricao_pro = descricao_pro;
        this.cod_barra_pro = cod_barra_pro;
        this.preco_custo_pro = preco_custo_pro;
        this.tipo_pro = tipo_pro;
        this.preco_venda_pro = preco_venda_pro;
        this.preco_venda_pro_cli = preco_venda_pro_cli;
        this.qtde_pro = qtde_pro;
        this.data_cad_pro = data_cad_pro;
    }

    public int getId_pro() {
        return id_pro;
    }
    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    
    public String getDescricao_pro() {
        return descricao_pro;
    }
    public void setDescricao_pro(String descricao_pro) {
        this.descricao_pro = descricao_pro;
    }

    
    public int getCod_barra_pro() {
        return cod_barra_pro;
    }
    public void setCod_barra_pro(int cod_barra_pro) {
        this.cod_barra_pro = cod_barra_pro;
    }

    
    public float getPreco_custo_pro() {
        return preco_custo_pro;
    }
    public void setPreco_custo_pro(float preco_custo_pro) {
        this.preco_custo_pro = preco_custo_pro;
    }

    
    public int getTipo_pro() {
        return tipo_pro;
    }
    public void setTipo_pro(int tipo_pro) {
        this.tipo_pro = tipo_pro;
    }

    
    public float getPreco_venda_pro() {
        return preco_venda_pro;
    }
    public void setPreco_venda_pro(float preco_venda_pro) {
        this.preco_venda_pro = preco_venda_pro;
    }

    
    public float getPreco_venda_pro_cli() {
        return preco_venda_pro_cli;
    }
    public void setPreco_venda_pro_cli(float preco_venda_pro_cli) {
        this.preco_venda_pro_cli = preco_venda_pro_cli;
    }

    
    public int getQtde_pro() {
        return qtde_pro;
    }
    public void setQtde_pro(int qtde_pro) {
        this.qtde_pro = qtde_pro;
    }

    
    public String getData_cad_pro() {
        return data_cad_pro;
    }
    public void setData_cad_pro(String data_cad_pro) {
        this.data_cad_pro = data_cad_pro;
    }           
}
