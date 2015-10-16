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
import modelo.Pedido;

/**
 *
 * @author USER
 */
public class PedidoDB {
    public static ArrayList getListaPedido(Connection conexao){
        ArrayList lista = new ArrayList();
        try{
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery("select * from pedido");
            while(rs.next()){
                int auxPedcodigo = rs.getInt("pedcodigo");
                int auxClicodigo = rs.getInt("clicodigo");
                String auxEmissao = rs.getString("emissao");
                String auxEntrega = rs.getString("entrega");
                Pedido pedido = new Pedido(auxPedcodigo, auxClicodigo, auxEmissao, auxEntrega);
                lista.add(pedido);
                
            }
        }catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
        }finally{
            return lista;
        }
    }
    
    public static boolean incluiPedido(Pedido pedido, Connection conexao){
        boolean incluiu = false;
        try{
            PreparedStatement ps = conexao.prepareStatement("insert into pedido (pedcodigo, clicodigo, emissao, entrega) values(?,?,?,?)");
            ps.setInt(1, pedido.getPedcodigo());
            ps.setInt(2, pedido.getClicodigo());
            ps.setString(3, pedido.getEmissao());
            ps.setString(4, pedido.getEntrega());
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
    
    public static boolean alteraPedido(Pedido pedido, Connection conexao){
        boolean alterou = false;
        try{
            PreparedStatement ps = conexao.prepareStatement("update pedido set clicodigo = ?, emissao = ?, entrega = ? where pedcodigo = ?");
            ps.setInt(1, pedido.getClicodigo());
            ps.setString(2, pedido.getEmissao());
            ps.setString(3, pedido.getEntrega());
            ps.setInt(4, pedido.getPedcodigo());
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
    
    public static boolean excluiPedido(int codigo, Connection conexao){
        boolean excluiu = false;
        try{
            PreparedStatement ps = conexao.prepareStatement("delete from pedido where pedcodigo = ?");
            ps.setInt(1, codigo);
            int valor = ps.executeUpdate();
            if(valor == 1){
                excluiu = true;
            }
            
        }catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
        }finally{
            return excluiu;
        }
    }
    
    public static Pedido getPedido(int codigo, Connection conexao){
        Pedido pedido = null;
        try{
            PreparedStatement ps = conexao.prepareStatement("select * from pedido where pedcodigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int auxPedcodigo = rs.getInt("pedcodigo");
                int auxClicodigo = rs.getInt("clicodigo");
                String auxEmissao = rs.getString("emissao");
                String auxEntrega = rs.getString("entrega");
                pedido = new Pedido(auxPedcodigo, auxClicodigo, auxEmissao, auxEntrega);
            }
        }catch(SQLException e){
            System.out.println("Erro de SQL: "+ e.getMessage());
        }finally{
            return pedido;
        }
    }
}
