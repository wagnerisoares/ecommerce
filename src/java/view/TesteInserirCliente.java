
package view;

import controle.ClienteDB;
import controle.Conexao;
import java.sql.Connection;
import modelo.Cliente;

/**
 *
 * @author aluno
 */
public class TesteInserirCliente {
    public static void main(String[] args) {
        Connection conexao = Conexao.getConexao();
        Cliente cliente = new Cliente(67,"Juninho","16765656543", "","MT" ,"Rio Comprido", "Acarijó","Rua Azevedo Leopoldo, 34", "(61)8890-2815");
        boolean incluiu = ClienteDB.incluiCliente(cliente, conexao);
        if(incluiu){
            System.out.println("Cliente Incluido");
        }
        else{
            System.out.println("Erro ao Incluir o cliente");
        }
    }
}
