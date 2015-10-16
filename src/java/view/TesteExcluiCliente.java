/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controle.ClienteDB;
import controle.Conexao;
import java.sql.Connection;

/**
 *
 * @author aluno
 */
public class TesteExcluiCliente {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        int codigo = 67;
        boolean excluiu = ClienteDB.excluiCliente(codigo, conexao);
        if(excluiu){
            System.out.println("Cliente excluido com sucesso");
        }else{
            System.out.println("Erro ao excluir o cliente - entre em contato com o suporte tecnico");
        }
    }
}

