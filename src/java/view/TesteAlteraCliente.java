
package view;

import controle.ClienteDB;
import controle.Conexao;
import java.sql.Connection;
import modelo.Cliente;

/**
 *
 * @author aluno
 */
public class TesteAlteraCliente {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        Cliente cliente = new Cliente(7,"Rodrigo Vignolli","08284115909", "000.000.000/0001-00","sc" ,"Agronômica", "Centro","Rua 6 de junho", "(00)0000-0000");
        boolean alterou = ClienteDB.alteraCliente(cliente, conexao);
        if(alterou){
            System.out.println("Cliente alterado com Sucesso!");
        }else{
            System.out.println("Cliente não alterado - entre com o suporte tecnico");
        }
    }
}
