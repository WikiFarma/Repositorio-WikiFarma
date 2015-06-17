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
public class RelatorioControl extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("cmd");
        PrintWriter out = resp.getWriter();

        if (action.equalsIgnoreCase("cliente")) {
            ClienteCRUD cRUD = new ClienteCRUD();
            ProdutoCRUD cRUD2 = new ProdutoCRUD();
            VendaCRUD vcrud = new VendaCRUD();

            try {
                List<Cliente> temp = cRUD.listaCliente();
                List<Produto> produTemp = new ArrayList<Produto>();
                float[] precosFinais = new float[temp.size()];
                float[] valorUtimaComp = new float[temp.size()];
                Date[] datasFinais = new Date[temp.size()];
                req.setAttribute("clientes", temp);
                int i = 0;
                for (Cliente cliente : temp) {
                    float totalCompra = 0;
                    float valorUltiComp = 0;
                    Date ucompra = new Date(2000, 01, 01);
                    int id_pro = 0;
                    List<Venda> temp2 = vcrud.listaVendaCliente(cliente.getId_cli());
                    for (Venda venda : temp2) {
                        totalCompra = venda.getTotal_ven() + totalCompra;
                        if (venda.getData_ven().after(ucompra)) {
                            ucompra = venda.getData_ven();
                            id_pro = venda.getId_pro_ven();
                            valorUltiComp = venda.getPreco_venda_pro_ven();
                            
                        }
                    }
                    Produto temp3 = cRUD2.readID(id_pro);
                    produTemp.add(temp3);
                    precosFinais[i] = totalCompra;
                    datasFinais[i] = ucompra;
                    valorUtimaComp[i] = valorUltiComp;
                }
                req.setAttribute("precosFinais", precosFinais);
                req.setAttribute("datasFinais", datasFinais);
                req.setAttribute("valorUtimoProdu", valorUtimaComp);
                req.setAttribute("produtos", temp);
                
                RequestDispatcher view = req.getRequestDispatcher("RelatorioCliente.jsp");
                view.forward(req, resp);
            } catch (SQLException ex) {
                Logger.getLogger(VendaControl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
