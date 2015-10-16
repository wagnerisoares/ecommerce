/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controle.Conexao;
import controle.PedidoDB;
import java.sql.Connection;
import modelo.Pedido;

/**
 *
 * @author USER
 */
public class TesteInserirPedido {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        Pedido pedido = new Pedido(34, 67, "10/09/2015", "23/09/2015");
        boolean incluiu = PedidoDB.incluiPedido(pedido, conexao);
        if(incluiu){
            System.out.println("Pedido incluido com sucesso!!!");
        }else{
            System.out.println("Pedido não incluido - entre com o suporte tecnico");
        }
    }
}
