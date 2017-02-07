package cdc.controller;

import cdc.DAO.PessoasDAO;
import cdc.DAO.ProdutoDAO;
import cdc.model.Pessoas;
import cdc.model.Produtos;
import cdc.util.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author joao
 */
@WebServlet(name = "ServletMostrador", urlPatterns = {"/ServletMostrador"})
public class ServletMosrtrador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cmd = request.getParameter("cmd");
       DAO dao;
       
//       request.setAttribute("adminEmail", getServletConfig().getInitParameter("adminEmail"));
       
      //setando o valor default do cmd
       if(cmd == null){
          cmd = "principal";
       }
        try {
            dao = new PessoasDAO();
            RequestDispatcher rd = null;//setando o objeto "despachador"
//            if(cmd.equalsIgnoreCase("listar")){
//                List autorList = dao.listaTodos();//recebendo o array list com todos os autores
//                request.setAttribute("autorList", autorList);//enviando parametros via request
//                //setando o despachador
//                rd = request.getRequestDispatcher("/autores.jsp");
//            }else 
               
                if(cmd.equals("buscar")){
                    Integer id = Integer.parseInt(request.getParameter("id"));
                    dao = new ProdutoDAO();
                    Produtos produtoList = new ProdutoDAO().buscarId(new Produtos(id));
                    request.setAttribute("produto",produtoList);
                    HttpSession sessao = request.getSession(true);
                    sessao.setAttribute("idProd", id);
                    rd=request.getRequestDispatcher("/Mostrador.jsp");
                    
                }else{
                                  //    rd=request.getRequestDispatcher("/index.jsp");
  
                }

//            //dispachando para a pagina setada, segundo as opcoes acima
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}