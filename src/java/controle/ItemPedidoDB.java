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
import modelo.ItemPedido;

/**
 *
 * @author USER
 */
public class ItemPedidoDB {
    public static ArrayList getListaItemPedido(Connection conexao){
        ArrayList lista = new ArrayList();
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from item_pedido");
            while(rs.next()){
                int auxItecodigo = rs.getInt("itecodigo");
                int auxProcodigo = rs.getInt("procodigo");
                int auxPedcodigo = rs.getInt("pedcodigo");
                String auxTotalpedido = rs.getString("totalpedido");
                String auxDesconto = rs.getString("desconto");
                String auxQuantidade = rs.getString("quantidade");
                ItemPedido item_pedido = new ItemPedido(auxItecodigo, auxProcodigo, auxPedcodigo, auxTotalpedido, auxDesconto, auxQuantidade);
                lista.add(item_pedido);
            }
       }catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
        }finally{
            return lista;
        }
    }
    
    public static boolean incluiItemPedido(ItemPedido item_pedido, Connection conexao){
        boolean incluiu = false;
        try{
            PreparedStatement ps = conexao.prepareStatement("insert into item_pedido (itecodigo, procodigo, pedcodigo, totalpedido, desconto, quantidade) values (?,?,?,?,?,?)");
            ps.setInt(1, item_pedido.getItecodigo());
            ps.setInt(2, item_pedido.getProcodigo());
            ps.setInt(3, item_pedido.getPedcodigo());
            ps.setString(4, item_pedido.getTotalpedido());
            ps.setString(5, item_pedido.getDesconto());
            ps.setString(6, item_pedido.getQuantidade());
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
    
    public static boolean alteraItemPedido(ItemPedido item_pedido, Connection conexao){
        boolean alterou = false;
        try{
            PreparedStatement ps = conexao.prepareStatement("update item_pedido set procodigo = ?, pedcodigo = ?, totalpedido = ?, desconto = ?, quantidade = ? where itecodigo = ?");
            ps.setInt(1, item_pedido.getProcodigo());
            ps.setInt(2, item_pedido.getPedcodigo());
            ps.setString(3, item_pedido.getTotalpedido());
            ps.setString(4, item_pedido.getDesconto());
            ps.setString(5, item_pedido.getQuantidade());
            ps.setInt(6, item_pedido.getItecodigo());
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
    
    public static boolean excluiItemPedido(int codigo, Connection conexao){
        boolean excluiu = false;
        try{
            PreparedStatement ps = conexao.prepareStatement("delete from item_pedido where itecodigo = ?");
            ps.setInt(1, codigo);
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
    
    public static ItemPedido getItemPedido(int codigo, Connection conexao){
        ItemPedido item_pedido = null;
        try{
            PreparedStatement ps = conexao.prepareStatement("select * from item_pedido where itecodigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int auxItecodigo = rs.getInt("itecodigo");
                int auxProcodigo = rs.getInt("procodigo");
                int auxPedcodigo = rs.getInt("pedcodigo");
                String auxTotalpedido = rs.getString("totalpedido");
                String auxDesconto = rs.getString("desconto");
                String auxQuantidade = rs.getString("quantidade");
                item_pedido = new ItemPedido(auxItecodigo, auxProcodigo, auxPedcodigo, auxTotalpedido, auxDesconto, auxQuantidade);
            }
        }catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
        }finally{
            return item_pedido;
        }
    }
}
