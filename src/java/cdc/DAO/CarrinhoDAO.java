package cdc.DAO;

import cdc.model.Carrinho;
import cdc.model.Clientes;
import cdc.model.Pedidos;
import cdc.model.Pessoas;
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
public class CarrinhoDAO implements DAO{
private Connection conn;
    
    public CarrinhoDAO() throws Exception{
        try{
            this.conn = ConnectionDAO.getConnection();
        }catch(Exception e){
            throw new Exception("Erro: \n"+e.getMessage());                    
        }
    }
    @Override
    public void atualizar(Object ob) throws Exception {
        
    }

    @Override
    public void excluir(Object ob) throws Exception {
         Pedidos ped = (Pedidos) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if(ped==null){
            throw new Exception("O dado informado não pode ser nulo");
        }
        try{
            conn = this.conn;
            ps = conn.prepareStatement("DELETE FROM pedidos WHERE numero=?");
            ps.setInt(1, ped.getId());
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
            ps = conn.prepareStatement("SELECT * FROM carrinho");
            rs = ps.executeQuery();
            List<Pessoas> list = new ArrayList<Pessoas>();
            while(rs.next()){
                   Integer idPessoa = rs.getInt(1);
                   String email = rs.getString(2);
                   String senha = rs.getString(3);
                   list.add(new Pessoas(idPessoa,email,senha));
            }
            return list;
        }catch(SQLException sqle){
            throw new Exception(sqle);
        }finally{
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }
    
    
    public boolean autentica (Pessoas pessoas) throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try{
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM pessoas WHERE email=? and senha=?");
            ps.setString(1, pessoas.getEmail());
            ps.setString(2, pessoas.getSenha());
            rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
            return false;
        }catch(SQLException sqle){
            throw new Exception(sqle);
        }finally{
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
    }

    /**
     *
     * @param ob
     * @return
     * @throws Exception
     */
    @Override
    public Integer buscaEmail(Object ob) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Pessoas pessoa = (Pessoas) ob;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM pessoas WHERE email=?");
            ps.setString(1, pessoa.getEmail());
            rs = ps.executeQuery();
//            List<Pessoas> list = new ArrayList<>();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new Exception("Erro:" + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return null;
    }


    public List procuraPorPessoa(Object ob) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Carrinho carrinho = (Carrinho) ob;
                    List<Carrinho> list = new ArrayList<>();

        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM carrinho WHERE car_pess=?");
            ps.setInt(1, carrinho.getPessoa());
           
            
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Carrinho(rs.getInt("car_id"), rs.getInt("car_qtd"), rs.getInt("car_produto"), rs.getInt("car_pess")));
            }
            return list;
        } catch (SQLException e) {
            throw new Exception("Erro:" + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        
    }

    @Override
    public void salvar(Object ob) throws Exception {
        Carrinho ped;
        ped =  (Carrinho) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if (ped == null){
            throw new Exception("O dado informado não pode ser nulo!");
        }
        try{
            String SQL = "INSERT INTO `carrinho`( `car_qtd`, `car_produto`, `car_pess`) VALUES (?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, ped.getQtd());
            ps.setInt(2, ped.getPro());
            ps.setInt(3, ped.getPessoa());
            ps.executeUpdate();
        }catch (SQLException sqle){
            throw new Exception("Erro ao inserir carrinho: \n"+sqle);
        }finally{
            ConnectionDAO.closeConnection(conn,ps);
        }
    }

    @Override
    public Object procuraTodos(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean verificaSeExiste(Integer id, Integer pessoa) throws Exception{
    
  
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try{
            String SQL = "SELECT * FROM `carrinho` WHERE car_id = ? AND car_pess = ?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.setInt(2, pessoa);
           
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        }catch (SQLException sqle){
            throw new Exception("Erro ao verificar: \n"+sqle);
        }finally{
            ConnectionDAO.closeConnection(conn,ps);
        }return false;
}
}
