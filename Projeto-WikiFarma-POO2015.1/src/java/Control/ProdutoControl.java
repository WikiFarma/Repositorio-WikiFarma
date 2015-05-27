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

import Model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProdutoControl extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        String action = req.getParameter("cmd");

        if (action.equalsIgnoreCase("cadastrar")) {
            try {
                Produto proCadastrar = new Produto(req.getParameter("textDescricao"));   
                proCadastrar.setId_pro(Integer.parseInt(req.getParameter("textID")));
                proCadastrar.setDescricao_pro(req.getParameter("textDescricao"));
                proCadastrar.setCod_barra_pro(Integer.parseInt(req.getParameter("textCodBarra")));
                proCadastrar.setPreco_custo_pro((int) Double.parseDouble(req.getParameter("textData")));
                proCadastrar.setTipo_pro(Integer.parseInt(req.getParameter("textTipo")));
                proCadastrar.setPreco_venda_pro((int) Double.parseDouble(req.getParameter("textTipo")));
                proCadastrar.setPreco_venda_pro_cli((int) Double.parseDouble(req.getParameter("textTipo")));
                proCadastrar.setQtde_pro(Integer.parseInt(req.getParameter("textTipo")));
                proCadastrar.setData_cad_pro(req.getParameter("textTipo"));
                proCadastrar.cadastrar();

                PrintWriter out = resp.getWriter();
                out.println("Cadastrado com sucesso!");
                
            } catch (SQLException e) {
                Logger.getLogger(ProdutoControl.class.getName()).log(Level.SEVERE, null, e);
            }

        }

        //PrintWriter out = resp.getWriter();
        //out.println(nome);
    }
    
}
