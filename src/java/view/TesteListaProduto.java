/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controle.Conexao;
import controle.ProdutoDB;
import java.sql.Connection;
import java.util.ArrayList;
import modelo.Produto;

/**
 *
 * @author USER
 */
public class TesteListaProduto {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        ArrayList lista = ProdutoDB.getListaProduto(conexao);
        for(int i = 0; i<lista.size(); i++){
            Produto produto = (Produto) lista.get(i);
            System.out.println("----------------------");
            System.out.println("Código: "+produto.getProcodigo());
            System.out.println("Descrição: "+ produto.getDescricao());
            System.out.println("Preço: "+ produto.getPreco());
            System.out.println("Categoria: "+ produto.getCategoria());
            System.out.println("Estoque: "+ produto.getEstoque());
            System.out.println("---------------------");
        }    
    }
}
