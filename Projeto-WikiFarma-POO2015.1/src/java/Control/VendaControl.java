/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.ClienteCRUD;
import Dao.ProdutoCRUD;
import Model.Cliente;
import Model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
       

    }

}
