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
public class Pedido {
    private int pedcodigo;
    private int clicodigo;
    private String emissao;
    private String entrega;

    public Pedido(int pedcodigo, int clicodigo, String emissao, String entrega) {
        this.pedcodigo = pedcodigo;
        this.clicodigo = clicodigo;
        this.emissao = emissao;
        this.entrega = entrega;
    }
    
    public int getPedcodigo() {
        return pedcodigo;
    }

    public void setPedcodigo(int pedcodigo) {
        this.pedcodigo = pedcodigo;
    }

    public int getClicodigo() {
        return clicodigo;
    }

    public void setClicodigo(int clicodigo) {
        this.clicodigo = clicodigo;
    }

    public String getEmissao() {
        return emissao;
    }

    public void setEmissao(String emissao) {
        this.emissao = emissao;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }
    
    
    
}
