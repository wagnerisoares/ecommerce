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
public class TesteInserirProduto {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        Produto produto = new Produto(100, "Açúcar do vale", "10.90", "Alimentos", "120");
        boolean incluiu = ProdutoDB.incluiProduto(produto, conexao);
        if(incluiu){
            System.out.println("Produto incluido com sucesso!!!");
        }else{
            System.out.println("Produto não incluido - entre com o suporte tecnico\"");
        }
    }
}
