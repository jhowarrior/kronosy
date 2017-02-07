/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdc.model;

/**
 *
 * @author enan
 */
public class Carrinho {
    private Integer id;
    private Integer qtd;
    private Integer pro;
    private Integer pessoa;

    public Carrinho() {
    }

    public Carrinho(Integer id, Integer qtd, Integer pro, Integer pessoa) {
        this.id = id;
        this.qtd = qtd;
        this.pro = pro;
        this.pessoa = pessoa;
    }

    public Carrinho(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Integer getPro() {
        return pro;
    }

    public void setPro(Integer pro) {
        this.pro = pro;
    }

    public Integer getPessoa() {
        return pessoa;
    }

    public void setPessoa(Integer pessoa) {
        this.pessoa = pessoa;
    }
    
    
}
