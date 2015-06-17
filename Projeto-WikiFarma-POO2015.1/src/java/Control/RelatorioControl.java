/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.ClienteCRUD;
import Dao.ProdutoCRUD;
import Dao.VendaCRUD;
import Model.Cliente;
import Model.Produto;
import Model.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrea
 */
//Controlador de relatorios
public class RelatorioControl extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("cmd");
        PrintWriter out = resp.getWriter();
        //verifica se o comando get passado pela o url representa cliente, para retorna o relatorio do cliente
        if (action.equalsIgnoreCase("cliente")) {
            //istancia varios objetos Cruds necessarios para a geração do relatorio
            ClienteCRUD cRUD = new ClienteCRUD();
            ProdutoCRUD cRUD2 = new ProdutoCRUD();
            VendaCRUD vcrud = new VendaCRUD();

            try {
                //instancia Listas e arrays para serem enviadas ao jsp e exibidas no relatorio
                List<Cliente> temp = cRUD.listaCliente();
                Produto[] produTemp = new Produto[temp.size()];
                float[] precosFinais = new float[temp.size()];
                float[] valorUtimaComp = new float[temp.size()];
                int[] id_cli = new int[temp.size()];
                Date[] datasFinais = new Date[temp.size()];
                //utilizado para contar a pocisão dos arrays de acordo com as listas.
                int i = 0;
                //varre alista de clientes existentes que foi resgatada do banco
                for (Cliente cliente : temp) {
                    //istancia alguns valores q seram reiniciados para cada cliente verificado
                    float totalCompra = 0;
                    float valorUltiComp = 0;
                    //istancia uma data com o valor de 1 de janeiro de 1970 para verificar
                    //qual foi a ultima data de compra do cliente
                    Date uDataCompra = new Date(0);
                    int id_pro = 0;
                    //puxa a lista de vendas realizadas para um determinado cliente
                    List<Venda> temp2 = vcrud.listaVendaCliente(cliente.getId_cli());
                    //varre a lista de vendas do determinado cliente
                    for (Venda venda : temp2) {
                        //verifica o valor total que o cliente ja gastou na farmacia
                        totalCompra = venda.getTotal_ven() + totalCompra;
                        //verifica se a data da venda em questão é maior q a utima
                        //se for essa sera a utima compra realizada pelo cliente
                        if (venda.getData_ven().after(uDataCompra)) {
                            //caso seja a utima data salva os valores a baixo seram enviados para exibição 
                            uDataCompra = venda.getData_ven();
                            id_pro = venda.getId_pro_ven();
                            valorUltiComp = venda.getPreco_venda_pro_ven()*venda.getQtde_pro_ven();
                        }
                    }
                    //repassa os valores para os listes e arrays para semrem enviados para a tela
                    produTemp[i] = cRUD2.readID(id_pro);
                    precosFinais[i] = totalCompra;
                    datasFinais[i] = uDataCompra;
                    valorUtimaComp[i] = valorUltiComp;
                    //linha usada para teste id_cli[i] = cliente.getId_cli();
                    //incrementa o contador para que siga para a varredura do proximo cliente
                    i++;
                }
                //envia os dados coletados para a tela do relatorio jsp
                //Linha usada para teste req.setAttribute("id_cli", id_cli);
                req.setAttribute("precosFinais", precosFinais);
                req.setAttribute("datasFinais", datasFinais);
                req.setAttribute("valorUtimoProdu", valorUtimaComp);
                req.setAttribute("produtos", produTemp);
                req.setAttribute("clientes", temp);
                //redireciona para o usuario para a tela de relatorio do cliente
                RequestDispatcher view = req.getRequestDispatcher("RelatorioCliente.jsp");
                view.forward(req, resp);
            } catch (SQLException ex) {
                Logger.getLogger(VendaControl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
