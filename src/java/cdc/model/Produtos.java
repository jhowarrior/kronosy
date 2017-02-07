package cdc.model;

/**
 *
 * @author joao
 */
public class Produtos {
   private int cdProduto;
   private String nome;
   private String descricao;
   private String categoria;
   private float preco;
   private double estoqueMinimo;
   private String imagem;
   private Integer pessoa;

    public Integer getPessoa() {
        return pessoa;
    }

    public void setPessoa(Integer pessoa) {
        this.pessoa = pessoa;
    }

    public Produtos(int cdProduto, String nome, String descricao, String categoria, float preco, double estoqueMinimo, String imagem, Integer pessoa) {
        this.cdProduto = cdProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.estoqueMinimo = estoqueMinimo;
        this.imagem = imagem;
        this.pessoa = pessoa;
    }

    public Produtos(int cdProduto, String nome, String descricao, String categoria, float preco, double estoqueMinimo, String imagem) {
        this.cdProduto = cdProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.estoqueMinimo = estoqueMinimo;
        this.imagem = imagem;
    }

    public Produtos() {
    }

    public Produtos(int cdProduto) {
        this.cdProduto = cdProduto;
    }

    public Produtos(int cdProduto, String nome, String descricao, float preco, double estoqueMinimo, String imagem) {
        this.cdProduto = cdProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoqueMinimo = estoqueMinimo;
        this.imagem = imagem;
    }

    
    
    public int getCdProduto() {
        return cdProduto;
    }

    public void setCdProduto(int cdProduto) {
        this.cdProduto = cdProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public double getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(double estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }


}
