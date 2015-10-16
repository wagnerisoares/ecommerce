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
import modelo.Produto;

/**
 *
 * @author USER
 */
public class ProdutoDB {
    public static ArrayList getListaProduto(Connection conexao){
        ArrayList lista = new ArrayList();
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from produto");
            while(rs.next()){
                int auxProcodigo = rs.getInt("procodigo");
                String auxDescricao = rs.getString("descricao");
                String auxPreco = rs.getString("preco");
                String auxCategoria = rs.getString("categoria");
                String auxEstoque = rs.getString("estoque");
                Produto produto = new Produto(auxProcodigo, auxDescricao, auxPreco, auxCategoria, auxEstoque);
                lista.add(produto);
            }
        }catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
        }finally{
            return lista;
        }
    }
    
    public static boolean incluiProduto(Produto produto, Connection conexao){
        boolean incluiu = false;
        try{
            PreparedStatement ps = conexao.prepareStatement("insert into produto (procodigo, descricao, preco, categoria, estoque) values (?,?,?,?,?)");
            ps.setInt(1, produto.getProcodigo());
            ps.setString(2, produto.getDescricao());
            ps.setString(3, produto.getPreco());
            ps.setString(4, produto.getCategoria());
            ps.setString(5, produto.getEstoque());
            int valor = ps.executeUpdate();
            if(valor == 1){
                incluiu = true;
            }
        }catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
        }finally{
            return incluiu;
        }
    }
    
    public static boolean alteraProduto(Produto produto, Connection conexao){
    boolean alterou = false;
        try{
            PreparedStatement ps = conexao.prepareStatement("update produto set descricao = ?, preco = ?, categoria = ?, estoque = ? where procodigo = ?");
            ps.setString(1, produto.getDescricao());
            ps.setString(2, produto.getPreco());
            ps.setString(3, produto.getCategoria());
            ps.setString(4, produto.getEstoque());
            ps.setInt(5, produto.getProcodigo());
            int valor = ps.executeUpdate();
            if(valor == 1){
                alterou = true;
            }
        }catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
        }finally{
            return alterou;
        }
    }
    
    public static boolean excluiProduto(int codigo, Connection conexao){
        boolean excluiu = false;
        try{
            PreparedStatement ps = conexao.prepareStatement("delete from produto where procodigo = ?");
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
    
    public static Produto getProduto(int codigo, Connection conexao){
        Produto produto = null;
        try{
            PreparedStatement ps = conexao.prepareStatement("select * from produto where procodigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int auxProcodigo = rs.getInt("procodigo");
                String auxDescricao = rs.getString("descricao");
                String auxPreco = rs.getString("preco");
                String auxCategoria = rs.getString("categoria");
                String auxEstoque = rs.getString("estoque");
                produto = new Produto(auxProcodigo, auxDescricao, auxPreco, auxCategoria, auxEstoque);
            }
        }catch(SQLException e){
            System.out.println("Erro de SQL: "+e.getMessage());
        }finally{
            return produto;
        }
    }
}
