package cdc.model;

/**
 *
 * @author joao
 */
public class ItensPedido {
    private double quantidade;
    private int pedidos_numero;
    private int produtos_cdProduto;

    public ItensPedido(double quantidade, int pedidos_numero, int produtos_cdProduto) {
        this.quantidade = quantidade;
        this.pedidos_numero = pedidos_numero;
        this.produtos_cdProduto = produtos_cdProduto;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public int getPedidos_numero() {
        return pedidos_numero;
    }

    public void setPedidos_numero(int pedidos_numero) {
        this.pedidos_numero = pedidos_numero;
    }

    public int getProdutos_cdProduto() {
        return produtos_cdProduto;
    }

    public void setProdutos_cdProduto(int produtos_cdProduto) {
        this.produtos_cdProduto = produtos_cdProduto;
    }
    
    
}
