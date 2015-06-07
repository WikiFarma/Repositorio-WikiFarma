/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Thayse
 * classe criada para fazer o controle do crud do cliente
 */

import Dao.ProdutoCRUD;
import Model.Produto;
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


public class ProdutoControl extends HttpServlet{
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("cmd");
        PrintWriter out = resp.getWriter();
        
        if (action.equalsIgnoreCase("cadastrar")) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Produto proCadastrar = new Produto();
                
                proCadastrar.setDescricao_pro(req.getParameter("textDesc"));
                proCadastrar.setCod_barra_pro(Integer.parseInt(req.getParameter("textCod")));
                proCadastrar.setPreco_custo_pro(Float.parseFloat(req.getParameter("textCusto")));
                if(req.getParameter("radioTipe").equalsIgnoreCase("remedio")){
                    proCadastrar.setTipo_pro(1);
                }else{
                    proCadastrar.setTipo_pro(2);
                }
                proCadastrar.setPreco_venda_pro(Float.parseFloat(req.getParameter("textPreVenda")));
                proCadastrar.setPreco_venda_pro_cli(Float.parseFloat(req.getParameter("textPreVendaCli")));
                proCadastrar.setQtde_pro(Integer.parseInt(req.getParameter("textQtde")));
                Date data = formatter.parse(req.getParameter("textData"));
                proCadastrar.setData_cad_pro(data);
                
                ProdutoCRUD cRUD = new ProdutoCRUD();
                
                String me = cRUD.inserir(proCadastrar);
                
                out.println(me);
                 
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro1:" + ex.getMessage());
            } catch (ParseException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro2" + ex.getMessage());
            }

        }else if (action.equalsIgnoreCase("deletar")) {
            ProdutoCRUD cRUD = new ProdutoCRUD();
            try {
                String me = cRUD.delet(Integer.parseInt(req.getParameter("textCod")));
                out.println(me);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro:" + ex.getMessage());
            }
        } else if (action.equalsIgnoreCase("updata")) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Produto proCadastrar = new Produto();
                
                proCadastrar.setDescricao_pro(req.getParameter("textDesc"));
                proCadastrar.setCod_barra_pro(Integer.parseInt(req.getParameter("textCod")));
                proCadastrar.setPreco_custo_pro(Float.parseFloat(req.getParameter("textCusto")));
                if(req.getParameter("radioTipe").equalsIgnoreCase("remedio")){
                    proCadastrar.setTipo_pro(1);
                }else{
                    proCadastrar.setTipo_pro(2);
                }
                proCadastrar.setPreco_venda_pro(Float.parseFloat(req.getParameter("textPreVenda")));
                proCadastrar.setPreco_venda_pro_cli(Float.parseFloat(req.getParameter("textPreVendaCli")));
                proCadastrar.setQtde_pro(Integer.parseInt(req.getParameter("textQtde")));
                Date data = formatter.parse(req.getParameter("textData"));
                proCadastrar.setData_cad_pro(data);

                ProdutoCRUD cRUD = new ProdutoCRUD();
                String me = cRUD.update(proCadastrar);

                out.println(me);

            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro1:" + ex.getMessage());
            } catch (ParseException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro2" + ex.getMessage());
            }
        }else if (action.equalsIgnoreCase("listar")) {
            
            try {
                ProdutoCRUD cRUD = new ProdutoCRUD();
                List<Produto> temp = cRUD.listaProduto();

                req.setAttribute("produtos", temp);
                RequestDispatcher view = req.getRequestDispatcher("ProdutoLista.jsp");
                view.forward(req, resp);
                
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro1:" + ex.getMessage());
            }
            
        } else if (action.equalsIgnoreCase("find")) {
            try {
                ProdutoCRUD cRUD = new ProdutoCRUD();
                Produto temp = cRUD.read(Integer.parseInt(req.getParameter("textCodBuscar")));
                if (temp == null) {
                    out.println("Falha");
                } else {
                    req.setAttribute("produto", temp);
                    RequestDispatcher view = req.getRequestDispatcher("ProdutoBuscar.jsp");
                    view.forward(req, resp);
                }
                                    
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro1:" + ex.getMessage());
            }
        }

    }
    
}
