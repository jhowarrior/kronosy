package cdc.model;

/**
 *
 * @author joao
 */
public class Fornecedores {
    private String nomeFantasia;
    private String telefone;
    private String ramal;
    private String cnpj;
    private String inscestadual;
    private String nomeContato;
    private int pessoas_codPessoa;

    public Fornecedores(String nomeFantasia, String telefone, String ramal, String cnpj, String inscestadual, String nomeContato, int pessoas_codPessoa) {
        this.nomeFantasia = nomeFantasia;
        this.telefone = telefone;
        this.ramal = ramal;
        this.cnpj = cnpj;
        this.inscestadual = inscestadual;
        this.nomeContato = nomeContato;
        this.pessoas_codPessoa = pessoas_codPessoa;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscestadual() {
        return inscestadual;
    }

    public void setInscestadual(String inscestadual) {
        this.inscestadual = inscestadual;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public int getPessoas_codPessoa() {
        return pessoas_codPessoa;
    }

    public void setPessoas_codPessoa(int pessoas_codPessoa) {
        this.pessoas_codPessoa = pessoas_codPessoa;
    }
    
    
}
