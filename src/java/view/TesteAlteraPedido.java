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
public class TesteAlteraPedido {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        Pedido pedido = new Pedido(15, 6, "16/09/2015", "23/09/2015");
        boolean alterou = PedidoDB.alteraPedido(pedido, conexao);
        if(alterou){
            System.out.println("Pedido alterado com sucesso!!!");
        }else{
            System.out.println("Pedido não alterado!!!");
        }
    }
}
