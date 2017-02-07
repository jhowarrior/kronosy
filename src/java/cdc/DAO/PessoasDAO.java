package cdc.DAO;

import cdc.model.Clientes;
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
public class PessoasDAO implements DAO{
private Connection conn;
    
    public PessoasDAO() throws Exception{
        try{
            this.conn = ConnectionDAO.getConnection();
        }catch(Exception e){
            throw new Exception("Erro: \n"+e.getMessage());                    
        }
    }
    @Override
    public void atualizar(Object ob) throws Exception {
        Pessoas pes = (Pessoas) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if(pes==null){
            throw new Exception("O valor passado não pode ser nulo");
        }
        try{
            conn = this.conn;
            ps = conn.prepareStatement("UPDATE pessoas SET bairro=?, cep=?, cidade=?, endereco=?, estado=?, nome=? WHERE codPessoa=?");
            ps.setString(1, pes.getBairro());
            ps.setString(2, pes.getCep());
            ps.setString(3, pes.getCidade());
            ps.setString(4, pes.getEndereco());
            ps.setString(5, pes.getEstado());
            ps.setString(6, pes.getNome());
            ps.setInt(3, pes.getIdPessoa());
            ps.executeUpdate();
        }catch(SQLException sqle){
            throw new Exception("Erro ao atualizar dados: "+sqle);
        }finally{
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    @Override
    public void excluir(Object ob) throws Exception {
        Pessoas pes = (Pessoas) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if(pes==null){
            throw new Exception("O dado informado não pode ser nulo");
        }
        try{
            conn = this.conn;
            ps = conn.prepareStatement("DELETE FROM pessoas WHERE codPessoa=?");
            ps.setInt(1, pes.getIdPessoa());
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
            ps = conn.prepareStatement("SELECT * FROM pessoas");
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


    public Object procuraTodos(Object ob) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Pessoas pessoa = (Pessoas) ob;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM pessoas WHERE email=?");
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getEmail());
            ps.setString(3, pessoa.getCpf());
            ps.setString(4, pessoa.getRg());
            ps.setString(5, pessoa.getEndereco());
            ps.setString(6, pessoa.getBairro());
            ps.setString(7, pessoa.getCidade());
            ps.setString(8, pessoa.getCep());
            ps.setString(9, pessoa.getEstado());
            ps.setString(10, pessoa.getTelefone());
            ps.setString(11, pessoa.getCelular());
            
            rs = ps.executeQuery();
//            List<Pessoas> list = new ArrayList<>();
            while (rs.next()) {
                return new Pessoas(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
            }
        } catch (SQLException e) {
            throw new Exception("Erro:" + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return null;
    }

    @Override
    public void salvar(Object ob) throws Exception {
        Pessoas pes;
        pes =  (Pessoas) ob;
        PreparedStatement ps = null;
        Connection conn = null;
        if (pes == null){
            throw new Exception("O dado informado não pode ser nulo!");
        }
        try{
            String SQL = "INSERT INTO pessoas (nome, endereco, cep, bairro, cidade, estado, celular, cpf, rg, sexo, telefone, email, senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, pes.getNome());
            ps.setString(2, pes.getEndereco());
            ps.setString(3, pes.getCep());
            ps.setString(4, pes.getBairro());
            ps.setString(5, pes.getCidade());
            ps.setString(6, pes.getEstado());
            ps.setString(7, pes.getCelular());
            ps.setString(8, pes.getCpf());
            ps.setString(9, pes.getRg());
            ps.setString(10, pes.getSexo());
            ps.setString(11, pes.getTelefone());
            ps.setString(12, pes.getEmail());
            ps.setString(13, pes.getSenha());
            ps.executeUpdate();
        }catch (SQLException sqle){
            throw new Exception("Erro ao inserir dados da pessoa: \n"+sqle);
        }finally{
            ConnectionDAO.closeConnection(conn,ps);
        }
    }
    
    public Pessoas buscaPorId(Integer  id) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("SELECT * FROM pessoas WHERE codPessoa=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
//            List<Pessoas> list = new ArrayList<>();
            while (rs.next()) {
                return  new Pessoas(rs.getString("nome"), rs.getString("cep"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("cpf"), rs.getString("rg"), rs.getString("endereco"), rs.getString("estado"), rs.getString("telefone"), rs.getString("celular"));
            }
        } catch (SQLException e) {
            throw new Exception("Erro:" + e);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return null;
    }

}
