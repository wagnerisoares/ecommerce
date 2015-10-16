/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controle.Conexao;
import controle.ProdutoDB;
import java.sql.Connection;
import modelo.Produto;

/**
 *
 * @author USER
 */
public class TesteAlteraProduto {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        Produto produto = new Produto(100, "Coca-Cola", "6.97", "Bebidas", "20");
        boolean alterou = ProdutoDB.alteraProduto(produto, conexao);
        if(alterou){
            System.out.println("Produto alterado com sucesso!!!");
        }else{
            System.out.println("Produto não alterado - entre com o suporte tecnico\"");
        }
    }
}
