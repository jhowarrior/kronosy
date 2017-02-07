package cdc.model;

/**
 *
 * @author joao
 */
public class ItensCompra {
    private double quantidade;
    private double desconto;
    private int nfCompra_numero;
    private int produtos_cdProduto;

    public ItensCompra(double quantidade, double desconto, int nfCompra_numero, int produtos_cdProduto) {
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.nfCompra_numero = nfCompra_numero;
        this.produtos_cdProduto = produtos_cdProduto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public int getNfCompra_numero() {
        return nfCompra_numero;
    }

    public void setNfCompra_numero(int nfCompra_numero) {
        this.nfCompra_numero = nfCompra_numero;
    }

    public int getProdutos_cdProduto() {
        return produtos_cdProduto;
    }

    public void setProdutos_cdProduto(int produtos_cdProduto) {
        this.produtos_cdProduto = produtos_cdProduto;
    }
    
    
}
