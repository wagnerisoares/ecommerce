/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controle.Conexao;
import controle.PedidoDB;
import java.sql.Connection;
import java.util.ArrayList;
import modelo.Pedido;

/**
 *
 * @author USER
 */
public class TesteListaPedido {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        ArrayList lista = PedidoDB.getListaPedido(conexao);
        for(int i = 0; i<lista.size(); i++){
            Pedido pedido = (Pedido) lista.get(i);
            System.out.println("--------------------------");
            System.out.println("Código do pedido: "+ pedido.getPedcodigo());
            System.out.println("Código do cliente: "+ pedido.getClicodigo());
            System.out.println("Data da emissão: "+ pedido.getEmissao());
            System.out.println("Entrega: "+ pedido.getEntrega());
            System.out.println("--------------------------");
        }
    }
}
