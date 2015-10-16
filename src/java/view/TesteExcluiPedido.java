/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controle.Conexao;
import controle.PedidoDB;
import java.sql.Connection;

/**
 *
 * @author USER
 */
public class TesteExcluiPedido {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        int codigo = 34;
        boolean excluiu = PedidoDB.excluiPedido(codigo, conexao);
        if(excluiu){
            System.out.println("Pedido excluido com sucesso");
        }else{
            System.out.println("Erro ao excluir o pedido - entre em contato com o suporte tecnico");
        }
        
    }
}
