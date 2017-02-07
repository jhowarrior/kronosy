package cdc.DAO;

import cdc.model.Clientes;
import cdc.model.Pessoas;
import cdc.model.Produtos;
import cdc.util.ConnectionDAO;
import cdc.util.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao
 */
public class ProdutoDAO implements DAO{
private Connection conn;
    
    public ProdutoDAO() throws Exception{
        try{
            this.conn = ConnectionDAO.getConnection();
        }catch(Exception e){
            throw new Exception("Erro: \n"+e.getMessage());                    
        }
    }
    @Override
    public void atualizar(Object ob) throws Exception {
        Produtos pro = (Produtos) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if(pro==null){
            throw new Exception("O dado informado não pode ser nulo");
        }
        try{
            conn = this.conn;
            ps = conn.prepareStatement("UPDATE produtos SET nome=?, categoria=?, descricao=?, preco=?, estoqueMinimo=?, imagem=? WHERE cdProduto=?");
            ps.setString(1, pro.getNome());
            ps.setString(2, pro.getCategoria());
            ps.setString(3, pro.getDescricao());
            ps.setFloat(4, pro.getPreco());
            ps.setDouble(5, pro.getEstoqueMinimo());
            ps.setString(6, pro.getImagem());
            ps.executeUpdate();
        }catch(SQLException sqle){
            throw new Exception("Erro ao atualizar dados: "+sqle);
        }finally{
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        Produtos pro = (Produtos) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if(pro==null){
            throw new Exception("O dado informado não pode ser nulo");
        }
        try{
            conn = this.conn;
            ps = conn.prepareStatement("DELETE FROM produtos WHERE cdProduto=?");
            ps.setInt(1, pro.getCdProduto());
            ps.executeUpdate();
        }catch(SQLException sqle){
            throw new Exception("Erro ao excluir dados: "+sqle);
        }finally{
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public List listaTodos() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try{
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM produtos");
            rs = ps.executeQuery();
            List<Produtos> list = new ArrayList<Produtos>();
            while(rs.next()){
                   Integer idProduto = rs.getInt(1);
                   String nome = rs.getString(8);
                   String descricao = rs.getString(2);
                   Float preco = rs.getFloat(3);
                   Double estoque = rs.getDouble(4);
                   String imagem = rs.getString(7);
                   list.add(new Produtos(0, nome, descricao, preco, estoque, imagem));
            }
            return list;
        }catch(SQLException sqle){
            throw new Exception(sqle);
        }finally{
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
    
    //listar acessorios
    public List listaTodosAcessories() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try{
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM produtos WHERE categoria='acessorie'");
            rs = ps.executeQuery();
            List<Produtos> list = new ArrayList<Produtos>();
            while(rs.next()){
                   Integer idProduto = rs.getInt(1);
                   String nome = rs.getString(8);
                   String descricao = rs.getString(2);
                   Float preco = rs.getFloat(3);
                   Double estoque = rs.getDouble(4);
                   String imagem = rs.getString(7);
                   list.add(new Produtos(idProduto, nome, descricao, preco, estoque, imagem));
            }
            return list;
        }catch(SQLException sqle){
            throw new Exception(sqle);
        }finally{
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
    
    //listar livros
    public List listaTodosBooks() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try{
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM produtos WHERE categoria='book'");
            rs = ps.executeQuery();
            List<Produtos> list = new ArrayList<Produtos>();
            while(rs.next()){
                   Integer idProduto = rs.getInt(1);
                   String nome = rs.getString(8);
                   String descricao = rs.getString(2);
                   Float preco = rs.getFloat(3);
                   Double estoque = rs.getDouble(4);
                   String imagem = rs.getString(7);
                   list.add(new Produtos(idProduto, nome, descricao, preco, estoque, imagem));
            }
            return list;
        }catch(SQLException sqle){
            throw new Exception(sqle);
        }finally{
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
    
    //listar roupas
    public List listaTodosClothes() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try{
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM produtos WHERE categoria='clothe'");
            rs = ps.executeQuery();
            List<Produtos> list = new ArrayList<Produtos>();
            while(rs.next()){
                   Integer idProduto = rs.getInt(1);
                   String nome = rs.getString(8);
                   String descricao = rs.getString(2);
                   Float preco = rs.getFloat(3);
                   Double estoque = rs.getDouble(4);
                   String imagem = rs.getString(7);
                   list.add(new Produtos(idProduto, nome, descricao, preco, estoque, imagem));
            }
            return list;
        }catch(SQLException sqle){
            throw new Exception(sqle);
        }finally{
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
    
    //listar filmes
    public List listaTodosMovies() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try{
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM produtos WHERE categoria='movie'");
            rs = ps.executeQuery();
            List<Produtos> list = new ArrayList<Produtos>();
            while(rs.next()){
                   Integer idProduto = rs.getInt(1);
                   String nome = rs.getString(8);
                   String descricao = rs.getString(2);
                   Float preco = rs.getFloat(3);
                   Double estoque = rs.getDouble(4);
                   String imagem = rs.getString(7);
                   list.add(new Produtos(idProduto, nome, descricao, preco, estoque, imagem));
            }
            return list;
        }catch(SQLException sqle){
            throw new Exception(sqle);
        }finally{
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    public Produtos buscarId(Produtos produto) throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try{
            conn = this.conn;
            Produtos prod;
            ps = conn.prepareStatement("SELECT * FROM produtos WHERE cdProduto=?");
            ps.setInt(1, produto.getCdProduto());
            rs = ps.executeQuery();
            if(rs.next()){
                return new Produtos(rs.getInt("cdProduto"), rs.getString("nome"), rs.getString("descricao"), rs.getFloat("preco"), rs.getDouble("estoqueMinimo"), null);
           // return new Produtos(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
                    }
        }catch(SQLException sqle){
            throw new Exception(sqle);
        }finally{
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return null;
    }
    
    public Integer buscaEmail(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object procuraTodos(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Object ob) throws Exception {
        Produtos pro;
        pro =  (Produtos) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (pro == null){
            throw new Exception("O dado informado não pode ser nulo!");
        }
        try{
            String SQL = "INSERT INTO produtos (descricao, nome, categoria, preco, estoqueMinimo, imagem, pessoas_codPessoa) VALUES (?,?,?,?,?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(2, pro.getNome());
            ps.setString(3, pro.getCategoria());
            ps.setString(1, pro.getDescricao());
            ps.setFloat(4, pro.getPreco());
            ps.setDouble(5, pro.getEstoqueMinimo());
            ps.setString(6, pro.getImagem());
            ps.setInt(7, pro.getPessoa());
            ps.executeUpdate();
        }catch (SQLException sqle){
            throw new Exception("Erro ao inserir dados do produto: \n"+sqle);
        }finally{
            ConnectionDAO.closeConnection(conn,ps);
        }
    }
    
}
