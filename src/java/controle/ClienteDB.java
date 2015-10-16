/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author aluno
 */
public class ClienteDB {
    public static ArrayList getListaCliente(Connection conexao){
        ArrayList lista = new ArrayList();
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from cliente");
            while(rs.next()){
                int auxClicodigo = rs.getInt("clicodigo");
                String auxNome = rs.getString("nome");
                String auxCpf = rs.getString("cpf");
                String auxCnpj = rs.getString("cnpj");
                String auxEstado = rs.getString("estado");
                String auxCidade = rs.getString("cidade");
                String auxBairro = rs.getString("bairro");
                String auxRua = rs.getString("rua");
                String auxTelefone = rs.getString("telefone");
                Cliente cliente = new Cliente(auxClicodigo, auxNome, auxCpf, auxCnpj, auxEstado, auxCidade, auxBairro, auxRua, auxTelefone);
                lista.add(cliente);
            }
        }catch(SQLException e){
            System.out.println("Erro de SQL: "+e.getMessage());
        }finally{
            return lista;
        }
    }
    
    public static boolean incluiCliente(Cliente cliente, Connection conexao){
        boolean incluiu = false;
        try{
            PreparedStatement ps = conexao.prepareStatement("insert into cliente (clicodigo, nome,cpf, cnpj, estado, cidade, bairro, rua, telefone)values(?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, cliente.getClicodigo());
            ps.setString(2,cliente.getNome());
            ps.setString(3,cliente.getCpf());
            ps.setString(4,cliente.getCnpj());
            ps.setString(5,cliente.getEstado());
            ps.setString(6,cliente.getCidade());
            ps.setString(7,cliente.getBairro());
            ps.setString(8,cliente.getRua());
            ps.setString(9,cliente.getTelefone());
            int valor = ps.executeUpdate();
            if(valor == 1){
                incluiu = true;
            }
        }catch(SQLException e){
            System.out.println("Erro de sql: "+e.getMessage());
        }finally{
            return incluiu;
        }
    }
    
    public static boolean alteraCliente(Cliente cliente, Connection conexao){
        boolean alterou = false;
        try{
            PreparedStatement ps = conexao.prepareStatement("update cliente set nome = ?, cpf = ?, cnpj = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, telefone = ? where clicodigo = ?");
            ps.setString(1,cliente.getNome());
            ps.setString(2,cliente.getCpf());
            ps.setString(3,cliente.getCnpj());
            ps.setString(4,cliente.getEstado());
            ps.setString(5,cliente.getCidade());
            ps.setString(6,cliente.getBairro());
            ps.setString(7,cliente.getRua());
            ps.setString(8,cliente.getTelefone());
            ps.setInt(9, cliente.getClicodigo());
            int valor = ps.executeUpdate();
            if(valor == 1){
                alterou = true;
            }
        }catch(SQLException e){
            System.out.println("Erro de SQL: "+e.getMessage());
        }finally{
            return alterou;
        }
    }
    public static boolean excluiCliente(int codigo, Connection conexao){
        boolean excluiu = false;
        try{
            PreparedStatement ps = conexao.prepareStatement("delete from cliente where clicodigo = ?");
            ps.setInt(1,codigo);
            int valor = ps.executeUpdate();
            if(valor == 1){
                excluiu = true;
            }
        }catch(SQLException e){
            System.out.println("Erro de sql: "+e.getMessage());
        }finally{
            return excluiu;
        }
    }
    public static Cliente getCliente(int codigo, Connection conexao){
        Cliente cliente = null;
        try{
            PreparedStatement ps = conexao.prepareStatement("select * from cliente where clicodigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int auxClicodigo = rs.getInt("clicodigo");
                String auxNome = rs.getString("nome");
                String auxCpf = rs.getString("cpf");
                String auxCnpj = rs.getString("cnpj");
                String auxEstado = rs.getString("estado");
                String auxCidade = rs.getString("cidade");
                String auxBairro = rs.getString("bairro");
                String auxRua = rs.getString("rua");
                String auxTelefone = rs.getString("telefone");
                cliente = new Cliente(auxClicodigo, auxNome, auxCpf, auxCnpj, auxEstado, auxCidade, auxBairro, auxRua, auxTelefone);
            }
        }catch(SQLException e){
            System.out.println("Erro de SQL: "+e.getMessage());
        }finally{
            return cliente;
        }
    }
}
