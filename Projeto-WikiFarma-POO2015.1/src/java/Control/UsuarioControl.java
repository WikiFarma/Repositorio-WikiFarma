/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.ClienteCRUD;
import Dao.UsuarioCRUD;
import Model.Usuario;
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
public class UsuarioControl extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("cmd");
        PrintWriter out = resp.getWriter();

        if (action.equalsIgnoreCase("cadastrar")) {
            try {
                Usuario usuario = new Usuario();
                usuario.setLogin_usu(req.getParameter("textLogin"));
                usuario.setSenha_usu(req.getParameter("textSenha"));

                UsuarioCRUD usuarioCRUD = new UsuarioCRUD();

                String me = usuarioCRUD.insetir(usuario);
                
                out.println(me);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (action.equalsIgnoreCase("deletar")) {
            UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
            try {
                String me = usuarioCRUD.delet(req.getParameter("textLogin"));
                out.println(me);
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro:" + ex.getMessage());
            }
        }else if (action.equalsIgnoreCase("updata")) {
            
            try {
                Usuario usuario = new Usuario();
                usuario.setLogin_usu(req.getParameter("textLogin"));
                usuario.setSenha_usu(req.getParameter("textSenha"));

                UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
                String me = usuarioCRUD.update(usuario);

                out.println(me);

            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro1:" + ex.getMessage());
            }
        } else if (action.equalsIgnoreCase("listar")) {
            try {
                UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
                List<Usuario> temp = usuarioCRUD.listaUsuario();

                req.setAttribute("usuarios", temp);
                RequestDispatcher view = req.getRequestDispatcher("UsuarioLista.jsp");
                view.forward(req, resp);
                
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro1:" + ex.getMessage());
            }
            
        } else if (action.equalsIgnoreCase("find")) {
            try {
                UsuarioCRUD usuarioCRUD = new UsuarioCRUD();
                Usuario temp = usuarioCRUD.read(req.getParameter("textLoginBusca"));
                if (temp == null) {
                    out.println("Falha");
                } else {
                    req.setAttribute("usuario", temp);
                    RequestDispatcher view = req.getRequestDispatcher("UsuarioBuscar.jsp");
                    view.forward(req, resp);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Erro1:" + ex.getMessage());
            }
        }
        
    }

}
