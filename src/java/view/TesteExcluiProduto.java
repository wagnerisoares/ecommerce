/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controle.ProdutoDB;
import controle.Conexao;
import controle.ProdutoDB;
import java.sql.Connection;

/**
 *
 * @author USER
 */
public class TesteExcluiProduto {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        int codigo = 100;
        boolean excluiu = ProdutoDB.excluiProduto(codigo, conexao);
        if(excluiu){
            System.out.println("Produto excluido com sucesso");
        }else{
            System.out.println("Erro ao excluir o produto - entre em contato com o suporte tecnico");
        }
    }
}
