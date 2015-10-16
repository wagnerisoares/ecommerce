/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controle.ClienteDB;
import controle.Conexao;
import java.sql.Connection;
import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author aluno
 */
public class TesteListaCliente {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        ArrayList lista = ClienteDB.getListaCliente(conexao);
        for(int i =0; i<lista.size(); i++){
            Cliente cliente = (Cliente) lista.get(i);
            System.out.println("----------------------------");
            System.out.println("Código: "+ cliente.getClicodigo());
            System.out.println("Nome: "+ cliente.getNome());
            System.out.println("Cpf: "+ cliente.getCpf());
            System.out.println("Cnpj: "+ cliente.getCnpj());
            System.out.println("Estado: "+ cliente.getEstado());
            System.out.println("Bairro: "+ cliente.getBairro());
            System.out.println("Cidade: "+ cliente.getCidade());
            System.out.println("Rua: "+ cliente.getRua());
            System.out.println("Telefone: "+ cliente.getTelefone());
            System.out.println("----------------------------");
        }
    }
}
