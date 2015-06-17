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
        //verifica se houve uma solicitação get com o parametro do 
        //cmd = realizar se sim ele faz o redirecionamento da pagina
        //isso se faz necessario para enviar dados dos produtos cadastrados e dos clientes cadastrados
        if (action.equalsIgnoreCase("realizar")) {
            ClienteCRUD cRUD = new ClienteCRUD();
            ProdutoCRUD cRUD2 = new ProdutoCRUD();
            try {
                //recupera os clientes e produtos cadastrados no banco
                //e os envia para serem exibidos na tela de cadastrod de venda
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
        //verifica se houve uma solicitação post com o parametro do 
        //cmd = cadastrar se sim ele faz o redirecionamento da pagina
        //enviando o resultado do cadastro
        if (action.equalsIgnoreCase("cadastrar")) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Venda vendaCadastrar = new Venda();
                ProdutoCRUD pcrud = new ProdutoCRUD();
                //Busca o produto atravez do id para otenção de outros dados como preço de venda e outros
                Produto produto = pcrud.readID(Integer.parseInt(req.getParameter("textIdProd")));
                //pega os dados enviados pelo cliente para serem cadastrados na venda.
                vendaCadastrar.setTipo_ven(Integer.parseInt(req.getParameter("textTipo")));
                //verifica se a venda esta sendo feita para um cliente
                //ja cadastrado ou se é para outro usuario sem cadastro no sistema
                //caso o cliente ja esteja cadastrado o sistema realiza a venda com
                //o desconto cadastrado para o cliente na tabela de produto.
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
        //verifica se houve uma solicitação post com o parametro do 
        //cmd = listar se sim ele faz o redirecionamento da pagina
        //enviando o resultado das vendas cadastradas.
        else if(action.equalsIgnoreCase("listar")){
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
