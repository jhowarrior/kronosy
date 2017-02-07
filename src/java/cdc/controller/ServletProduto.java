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
@WebServlet(name = "ServletProduto", urlPatterns = {"/ServletProduto"})
public class ServletProduto extends HttpServlet {

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
       
       request.setAttribute("adminEmail", getServletConfig().getInitParameter("adminEmail"));
       
      //setando o valor default do cmd
       if(cmd == null){
          cmd = "principal";
       }
        try {
            dao = new ProdutoDAO();
            RequestDispatcher rd = null;//setando o objeto "despachador"
//            if(cmd.equalsIgnoreCase("listar")){
//                List autorList = dao.listaTodos();//recebendo o array list com todos os autores
//                request.setAttribute("autorList", autorList);//enviando parametros via request
//                //setando o despachador
//                rd = request.getRequestDispatcher("/autores.jsp");
//            }else 
               if(cmd.equalsIgnoreCase("update")){
//                Pessoas pessoa;
//                Integer id = Integer.parseInt(request.getParameter("id"));//pegando o parametro id
//                List pessoaList = dao.procura(new Pessoas(id));
//                request.setAttribute("pessoaList", pessoaList);
//                rd = request.getRequestDispatcher("/CadastraPessoa.jsp");
            }else if(cmd.equalsIgnoreCase("saveUpdate")){
//                Integer id = Integer.parseInt(request.getParameter("idPessoa"));
//                String nome = request.getParameter("nome");
//                String bairro = request.getParameter("bairro");
//                String celular = request.getParameter("celular");
//                String cep = request.getParameter("cep");
//                String cidade = request.getParameter("cidade");
//                String cpf = request.getParameter("cpf");
//                String endereco = request.getParameter("endereco");
//                String estado = request.getParameter("estado");
//                String rg = request.getParameter("rg");
//                String sexo = request.getParameter("sexo");
//                String telefone = request.getParameter("telefone");
//                
//                Pessoas pessoa = new Pessoas(id, nome, endereco, cep, bairro, cidade, estado, celular, cpf, rg, sexo, telefone);
//                dao.atualizar(pessoa);
//                rd = request.getRequestDispatcher("/index.html");
            }else if(cmd.equalsIgnoreCase("del")){
//                Integer id  = Integer.parseInt(request.getParameter("id"));
//                Pessoas pessoa = new Pessoas(id);
//                dao.excluir(pessoa);
//                rd = request.getRequestDispatcher("/index.html");
//                
            }else if(cmd.equalsIgnoreCase("cadastrar")){
              //  Integer id = Integer.parseInt(request.getParameter("idAutor"));
              
                   HttpSession sessao = request.getSession();
                   Integer usuario = Integer.parseInt(sessao.getAttribute("usuario_id").toString());
                String nome = request.getParameter("nome");
                String categoria = request.getParameter("categoria");
                String descricao = request.getParameter("descricao");
                Float preco = Float.parseFloat(request.getParameter("preco"));
                Double estoqueMinimo = Double.parseDouble(request.getParameter("estoque"));
                String imagem = request.getParameter("imagem");
                Produtos produto = new Produtos(5, nome, descricao, categoria, preco, estoqueMinimo, imagem, usuario);
                dao.salvar(produto);
                
                rd = request.getRequestDispatcher("/index.jsp");
            }else{
                rd = request.getRequestDispatcher("/index.jsp");
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