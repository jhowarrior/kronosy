package cdc.util;

import cdc.model.Pessoas;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author enan
 */
public interface DAO {
    void atualizar(Object ob) throws Exception;
    
    void excluir(Object ob) throws Exception;
    
    List listaTodos() throws Exception;
    
    Integer buscaEmail(Object ob) throws Exception;
    
    Object procuraTodos(Object ob) throws Exception;
    
    void salvar(Object ob) throws Exception;
}
