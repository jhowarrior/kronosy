package cdc.model;

/**
 *
 * @author joao
 */
public class Clientes {
    private int pessoas_codPessoas;
    private String sexo;
    private String rg;
    private String cpf;
    private String telefone;
    private String celular;

    public Clientes(int pessoas_codPessoas, String sexo, String rg, String cpf, String telefone, String celular) {
        this.pessoas_codPessoas = pessoas_codPessoas;
        this.sexo = sexo;
        this.rg = rg;
        this.cpf = cpf;
        this.telefone = telefone;
        this.celular = celular;
    }

    public Clientes(String cpf, String rg, Integer idCliente) {
        this.cpf = cpf;
        this.rg = rg;
        this.pessoas_codPessoas = idCliente;
    }

    public int getPessoas_codPessoas() {
        return pessoas_codPessoas;
    }

    public void setPessoas_codPessoas(int pessoas_codPessoas) {
        this.pessoas_codPessoas = pessoas_codPessoas;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
}
