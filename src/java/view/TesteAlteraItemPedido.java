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
public class TesteAlteraItemPedido {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        ItemPedido item_pedido = new ItemPedido(341, 100, 34, "17", "0.98", "1");
        boolean alterou = ItemPedidoDB.alteraItemPedido(item_pedido, conexao);
        if(alterou){
                System.out.println("Item do pedido alterado com Sucesso!");
        }else{
                System.out.println("Item do pedido não alterado - entre com o suporte tecnico");
        }
    }
    
}
