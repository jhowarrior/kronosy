package cdc.model;

import java.util.Date;

/**
 *
 * @author joao
 */
public class NfCompra {
    private int numero;
    private Date dataCompra;
    private int fornecedores_pessoas_codPessoa;

    public NfCompra(int numero, Date dataCompra, int fornecedores_pessoas_codPessoa) {
        this.numero = numero;
        this.dataCompra = dataCompra;
        this.fornecedores_pessoas_codPessoa = fornecedores_pessoas_codPessoa;
    }

    public int getNumero() {
        return numero;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getFornecedores_pessoas_codPessoa() {
        return fornecedores_pessoas_codPessoa;
    }

    public void setFornecedores_pessoas_codPessoa(int fornecedores_pessoas_codPessoa) {
        this.fornecedores_pessoas_codPessoa = fornecedores_pessoas_codPessoa;
    }
    
    
}
