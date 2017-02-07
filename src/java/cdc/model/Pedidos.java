package cdc.model;

import java.util.Date;

/**
 *
 * @author joao
 */
public class Pedidos {
    private int id;
    private int idProdutos;
    private int quantidade;
    private double valorTotal;

    public Pedidos() {
    }

    public Pedidos(int id, int idProdutos, int quantidade, double valorTotal) {
        this.id = id;
        this.idProdutos = idProdutos;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public Pedidos(int idProdutos, int quantidade, double valorTotal) {
        this.idProdutos = idProdutos;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public Pedidos(int id) {
        this.id = id;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
    