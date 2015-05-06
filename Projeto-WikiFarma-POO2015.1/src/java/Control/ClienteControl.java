/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("cmd");

        if (action.equalsIgnoreCase("cadastrar")) {
            try {
                Cliente clienteCadatrar = new Cliente(req.getParameter("textNome"));
                clienteCadatrar.setCpf_cli(Integer.parseInt(req.getParameter("textCpf")));
                clienteCadatrar.setTelefone_cli(Integer.parseInt(req.getParameter("textTelefone")));
                clienteCadatrar.setEndereco_cli(req.getParameter("textEndereco"));
                clienteCadatrar.setData_cad_cli(req.getParameter("textData"));

                clienteCadatrar.cadastrar();

                PrintWriter out = resp.getWriter();
                out.println("Cadastrado com sucesso!");
            } catch (SQLException ex) {
                Logger.getLogger(ClienteControl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        //PrintWriter out = resp.getWriter();
        //out.println(nome);
    }

}
