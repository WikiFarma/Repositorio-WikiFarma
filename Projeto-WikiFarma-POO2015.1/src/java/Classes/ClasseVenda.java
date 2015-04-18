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
public class ClasseVenda {
    
    private int id_ven;
    private int tipo_ven;
    private int id_cli_ven;
    private int id_pro_ven;
    private int qtde_pro_ven;
    private float preco_venda_pro_ven;
    private int qtde_ven;
    private float total_ven;
    private String data_ven;

    public ClasseVenda() {
    }    

    public ClasseVenda(int id_ven, int tipo_ven, int id_cli_ven, int id_pro_ven, int qtde_pro_ven, float preco_venda_pro_ven, int qtde_ven, float total_ven, String data_ven) {
        this.id_ven = id_ven;
        this.tipo_ven = tipo_ven;
        this.id_cli_ven = id_cli_ven;
        this.id_pro_ven = id_pro_ven;
        this.qtde_pro_ven = qtde_pro_ven;
        this.preco_venda_pro_ven = preco_venda_pro_ven;
        this.qtde_ven = qtde_ven;
        this.total_ven = total_ven;
        this.data_ven = data_ven;
    }

    public int getId_ven() {
        return id_ven;
    }
    public void setId_ven(int id_ven) {
        this.id_ven = id_ven;
    }

    
    public int getTipo_ven() {
        return tipo_ven;
    }
    public void setTipo_ven(int tipo_ven) {
        this.tipo_ven = tipo_ven;
    }

    
    public int getId_cli_ven() {
        return id_cli_ven;
    }
    public void setId_cli_ven(int id_cli_ven) {
        this.id_cli_ven = id_cli_ven;
    }

    
    public int getId_pro_ven() {
        return id_pro_ven;
    }
    public void setId_pro_ven(int id_pro_ven) {
        this.id_pro_ven = id_pro_ven;
    }

    
    public int getQtde_pro_ven() {
        return qtde_pro_ven;
    }
    public void setQtde_pro_ven(int qtde_pro_ven) {
        this.qtde_pro_ven = qtde_pro_ven;
    }

    
    public float getPreco_venda_pro_ven() {
        return preco_venda_pro_ven;
    }
    public void setPreco_venda_pro_ven(float preco_venda_pro_ven) {
        this.preco_venda_pro_ven = preco_venda_pro_ven;
    }

    
    public int getQtde_ven() {
        return qtde_ven;
    }
    public void setQtde_ven(int qtde_ven) {
        this.qtde_ven = qtde_ven;
    }

    
    public float getTotal_ven() {
        return total_ven;
    }
    public void setTotal_ven(float total_ven) {
        this.total_ven = total_ven;
    }

    
    public String getData_ven() {
        return data_ven;
    }
    public void setData_ven(String data_ven) {
        this.data_ven = data_ven;
    } 
}
