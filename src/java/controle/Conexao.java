/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class Conexao {
    private static String servidor = "localhost";
    private static String banco = "ecommerce";
    private static String usuario = "root";
    private static String senha = "";
    private static String porta = "3306";
    private static String url = "jdbc:mysql://"+servidor+":"+porta+"/"+banco;
    private static String driver = "com.mysql.jdbc.Driver";
    
    public static Connection getConexao(){
        Connection conexao = null;
        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
        }catch(SQLDataException e){
            System.out.println("Erro de conexão: "+e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("Erro de driver: "+e.getMessage());
        }finally{
            return conexao;
        }
    }
    
    public static void fechaConexao(Connection conexao){
        if(conexao != null){
            try{
                conexao.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar a conexão: "+e.getMessage());
            }
        }
    }
}
