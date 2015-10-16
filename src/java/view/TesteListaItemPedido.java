/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controle.Conexao;
import controle.ItemPedidoDB;
import java.sql.Connection;
import java.util.ArrayList;
import modelo.ItemPedido;

/**
 *
 * @author USER
 */
public class TesteListaItemPedido {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        ArrayList lista = ItemPedidoDB.getListaItemPedido(conexao);
        for(int i = 0; i<lista.size(); i++){
            ItemPedido item_pedido = (ItemPedido) lista.get(i);
            System.out.println("----------------------------------");
            System.out.println("Código do item: "+ item_pedido.getItecodigo());
            System.out.println("Código do produto: "+ item_pedido.getProcodigo());
            System.out.println("Código do pedido: "+ item_pedido.getPedcodigo());
            System.out.println("Total do pedido: "+ item_pedido.getTotalpedido());
            System.out.println("Desconto: "+ item_pedido.getDesconto());
            System.out.println("Quantidade: "+ item_pedido.getQuantidade());
            System.out.println("----------------------------------");
        
        }
    }
}
