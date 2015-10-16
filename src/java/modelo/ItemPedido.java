/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author aluno
 */
public class ItemPedido {
    private int itecodigo;
    private int procodigo;
    private int pedcodigo;
    private String totalpedido;
    private String desconto;
    private String quantidade;

    public ItemPedido(int itecodigo, int procodigo, int pedcodigo, String totalpedido, String desconto, String quantidade) {
        this.itecodigo = itecodigo;
        this.pedcodigo = pedcodigo;
        this.procodigo = procodigo;
        this.totalpedido = totalpedido;
        this.desconto = desconto;
        this.quantidade = quantidade;
    }

    
    public int getItecodigo() {
        return itecodigo;
    }

    public void setItecodigo(int itecodigo) {
        this.itecodigo = itecodigo;
    }

    public int getPedcodigo() {
        return pedcodigo;
    }

    public void setPedcodigo(int pedcodigo) {
        this.pedcodigo = pedcodigo;
    }

    public int getProcodigo() {
        return procodigo;
    }

    public void setProcodigo(int procodigo) {
        this.procodigo = procodigo;
    }

    public String getTotalpedido() {
        return totalpedido;
    }

    public void setTotalpedido(String totalpedido) {
        this.totalpedido = totalpedido;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
}
