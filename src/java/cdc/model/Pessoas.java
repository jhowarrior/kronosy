package cdc.model;

/**
 *
 * @author joao
 */
public class Pessoas {
    private int idPessoa;
    private String nome;
    private String endereco;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String celular;
    private String cpf;
    private String rg;
    private String sexo;
    private String telefone;
    private String email;
    private String senha;

    public Pessoas(int idPessoa, String nome, String endereco, String cep, String bairro, String cidade, String estado, String celular, String cpf, String rg, String sexo, String telefone, String email, String senha) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.celular = celular;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Pessoas(int idPessoa, String email, String senha) {
        this.idPessoa = idPessoa;
        this.email = email;
        this.senha = senha;
    }

    public Pessoas(String nome, String endereco, String cep, String bairro, String cidade, String estado, String celular, String cpf, String rg, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.celular = celular;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
    }

    public Pessoas(String nome, String cep, String bairro, String cidade, String cpf, String rg, String endereco,String estado, String telefone, String celular) {
        this.nome = nome;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
         this.estado = estado;
         this.telefone = telefone;
         this.celular = celular;
    }  
    
     public Pessoas(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Pessoas() {
    }

    public Pessoas(String email) {
        this.email = email;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }




    
    
}
