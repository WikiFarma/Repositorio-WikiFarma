/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.ClienteCRUD;
import Model.Cliente;
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
 *
 * classe criada para fazer o controle do crud do cliente
 *
 */
public class ClienteControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("cmd");
        PrintWriter out = resp.getWriter();

        if (action.equalsIgnoreCase("cadastrar")) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Cliente clienteCadatrar = new Cliente();
                clienteCadatrar.setNome(req.getParameter("textNome"));
                clienteCadatrar.setCpf_cli(Integer.parseInt(req.getParameter("textCpf")));
                clienteCadatrar.setTelefone_cli(Integer.parseInt(req.getParameter("textTelefone")));
                clienteCadatrar.setEndereco_cli(req.getParameter("textEndereco"));
                Date data = formatter.parse(req.getParameter("textData"));
                clienteCadatrar.setData_cad_cli(data);

                ClienteCRUD cRUD = new ClienteCRUD();
                String me = cRUD.insetir(clienteCadatrar);

                out.println(me);

            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro1:" + ex.getMessage());
            } catch (ParseException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro2" + ex.getMessage());
            }
        } else if (action.equalsIgnoreCase("deletar")) {
            ClienteCRUD cRUD = new ClienteCRUD();
            try {
                String me = cRUD.delet(Integer.parseInt(req.getParameter("textCpf")));
                out.println(me);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro:" + ex.getMessage());
            }
        } else if (action.equalsIgnoreCase("updata")) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Cliente clienteCadatrar = new Cliente();
                clienteCadatrar.setNome(req.getParameter("textNome"));
                clienteCadatrar.setCpf_cli(Integer.parseInt(req.getParameter("textCpf")));
                clienteCadatrar.setTelefone_cli(Integer.parseInt(req.getParameter("textTelefone")));
                clienteCadatrar.setEndereco_cli(req.getParameter("textEndereco"));
                Date data = formatter.parse(req.getParameter("textData"));
                clienteCadatrar.setData_cad_cli(data);

                ClienteCRUD cRUD = new ClienteCRUD();
                String me = cRUD.update(clienteCadatrar);

                out.println(me);

            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro1:" + ex.getMessage());
            } catch (ParseException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro2" + ex.getMessage());
            }
        } else if (action.equalsIgnoreCase("listar")) {
            
            try {
                ClienteCRUD cRUD = new ClienteCRUD();
                List<Cliente> temp = cRUD.listaCliente();

                req.setAttribute("clientes", temp);
                RequestDispatcher view = req.getRequestDispatcher("ClienteLista.jsp");
                view.forward(req, resp);
                
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro1:" + ex.getMessage());
            }
            
        } else if (action.equalsIgnoreCase("find")) {
            try {
                ClienteCRUD cRUD = new ClienteCRUD();
                Cliente temp = cRUD.read(Integer.parseInt(req.getParameter("textCpfBusca")));
                if (temp == null) {
                    req.setAttribute("clientes", "teste");
                    RequestDispatcher view = req.getRequestDispatcher("ClienteBuscar.jsp");
                    view.forward(req, resp);
                } else {
                    req.setAttribute("clientes", temp);
                    RequestDispatcher view = req.getRequestDispatcher("ClienteBuscar.jsp");
                    view.forward(req, resp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro1:" + ex.getMessage());
            }
        }

        //PrintWriter out = resp.getWriter();
        //out.println(nome);
    }

}
