/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controle.Conexao;
import controle.ItemPedidoDB;
import java.sql.Connection;
import modelo.ItemPedido;

/**
 *
 * @author USER
 */
public class TesteInserirItemPedido {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        ItemPedido item_pedido = new ItemPedido(341, 100, 34, "509.99", "0.10", "10");
        boolean incluiu = ItemPedidoDB.incluiItemPedido(item_pedido, conexao);
        if(incluiu){
            System.out.println("Item do pedido incluido!!!");
        }else{
            System.out.println("Item não pode ser incluido");
        }
    }
}
