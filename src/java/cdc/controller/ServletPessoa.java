package cdc.controller;

import cdc.DAO.PessoasDAO;
import cdc.model.Pessoas;
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
@WebServlet(name = "ServletPessoa", urlPatterns = {"/ServletPessoa"})
public class ServletPessoa extends HttpServlet {

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
            dao = new PessoasDAO();
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
                String nome = request.getParameter("nome");
                String endereco = request.getParameter("endereco");
                String cep = request.getParameter("cep");
                String bairro = request.getParameter("bairro");
                String cidade = request.getParameter("cidade");
                String estado = request.getParameter("estado");
                String celular = request.getParameter("celular");
                String cpf = request.getParameter("cpf");
                String rg = request.getParameter("rg");
                String sexo = request.getParameter("sexo");
                String telefone = request.getParameter("telefone");
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");
                Pessoas pessoa = new Pessoas(0, nome, endereco, cep, bairro, cidade, estado, celular, cpf, rg, sexo, telefone, email, senha);
                dao.salvar(pessoa);
                rd = request.getRequestDispatcher("/index.jsp");
            }else if(cmd.equalsIgnoreCase("logar")){
//                Integer codPessoa = Integer.parseInt(request.getParameter("codPessoa"));
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");
                Pessoas pessoa = new Pessoas(email, senha);
                PessoasDAO pe = new PessoasDAO();
                if (pe.autentica(pessoa)) { 
                    pe = new PessoasDAO();
                    Integer pesso = pe.buscaEmail(new Pessoas(email));
                    HttpSession sessao = request.getSession();
                    sessao.setAttribute("sessaoEmail", email);
                    
                    
                    //aqui deve setar o id do usuario para a sessao
                    //fazer metodo de busca pelo email setar o id do usuario
                    sessao.setAttribute("usuario_id", pesso);
//                    sessao.setAttribute("usuario_id", 5);
                    
                    
                    rd = request.getRequestDispatcher("/index.jsp");
                } else if(cmd.equalsIgnoreCase("logout")){
                    HttpSession sessao = request.getSession(true);
                    sessao.setAttribute("sessaoEmail", null);
                    rd = request.getRequestDispatcher("/index.jsp");
                    
                } else {
                    rd = request.getRequestDispatcher("/CadastraPessoa.jsp");
                }
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