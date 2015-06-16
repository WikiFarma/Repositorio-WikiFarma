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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class VendaControl extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("cmd");
        PrintWriter out = resp.getWriter();

        if (action.equalsIgnoreCase("realizar")) {
            ClienteCRUD cRUD = new ClienteCRUD();
            ProdutoCRUD cRUD2 = new ProdutoCRUD();
            try {
                List<Cliente> temp = cRUD.listaCliente();
                req.setAttribute("clientes", temp);
                List<Produto> temp2 = cRUD2.listaProduto();
                req.setAttribute("produtos", temp2);

                RequestDispatcher view = req.getRequestDispatcher("Venda.jsp");
                view.forward(req, resp);
            } catch (SQLException ex) {
                Logger.getLogger(VendaControl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("cmd");
        PrintWriter out = resp.getWriter();

        if (action.equalsIgnoreCase("cadastrar")) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Venda vendaCadastrar = new Venda();
                ProdutoCRUD pcrud = new ProdutoCRUD();

                Produto produto = pcrud.readID(Integer.parseInt(req.getParameter("textIdProd")));

                vendaCadastrar.setTipo_ven(Integer.parseInt(req.getParameter("textTipo")));
                if (!req.getParameter("textIdCliente").isEmpty()) {
                    vendaCadastrar.setId_cli_ven(Integer.parseInt(req.getParameter("textIdCliente")));
                    vendaCadastrar.setPreco_venda_pro_ven(produto.getPreco_venda_pro_cli());
                } else {
                    vendaCadastrar.setPreco_venda_pro_ven(produto.getPreco_venda_pro());
                }
                vendaCadastrar.setId_pro_ven(Integer.parseInt(req.getParameter("textIdProd")));
                vendaCadastrar.setQtde_pro_ven(Integer.parseInt(req.getParameter("textQuanTProVen")));
                vendaCadastrar.setQtde_ven(Integer.parseInt(req.getParameter("textQuanTProVen")));
                vendaCadastrar.setTotal_ven(vendaCadastrar.getPreco_venda_pro_ven() * vendaCadastrar.getQtde_pro_ven());
                Date data = formatter.parse(req.getParameter("textData"));
                vendaCadastrar.setData_ven(data);

                VendaCRUD vcrud = new VendaCRUD();
                String me = vcrud.insetir(vendaCadastrar);

                out.println(me);

            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro1:" + ex.getMessage());
            } catch (ParseException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro2" + ex.getMessage());
            }

        }
        else if(action.equalsIgnoreCase("buscar")){
            
        }else if(action.equalsIgnoreCase("listar")){
             try {
                VendaCRUD vRUD = new VendaCRUD();
                List<Venda> temp = vRUD.listaVenda();

                req.setAttribute("vendas", temp);
                RequestDispatcher view = req.getRequestDispatcher("Vendalista.jsp");
                view.forward(req, resp);
                
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro1:" + ex.getMessage());
            }
        }

    }

}
