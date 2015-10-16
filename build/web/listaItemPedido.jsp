<%-- 
    Document   : listaItemPedido
    Created on : 30/09/2015, 21:09:23
    Author     : Wagner_Soares
--%>

<%@page import="modelo.ItemPedido"%>
<%@page import="controle.ItemPedidoDB"%>
<%@page import="controle.PedidoDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controle.Conexao"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Connection conexao = Conexao.getConexao();
            ArrayList lista = ItemPedidoDB.getListaItemPedido(conexao);
            out.println("<table border='2'>");
            out.println("<tr>");
            out.println("<td>N° Item</td>");
            out.println("<td>Codigo do produto</td>");
            out.println("<td>N° Pedido</td>");
            out.println("<td>Total</td>");
            out.println("<td>Desconto</td>");
            out.println("<td>Quantidade</td>");
            out.println("</tr>");
            
            for(int i = 0;i < lista.size(); i++){
                ItemPedido itemPedido = (ItemPedido)lista.get(i);
                out.println("<tr>");
                out.println("<td>"+itemPedido.getItecodigo() +"</td>");
                out.println("<td>"+itemPedido.getProcodigo()+"</td>");
                out.println("<td>"+itemPedido.getPedcodigo()+"</td>");
                out.println("<td>"+itemPedido.getTotalpedido()+"</td>");
                out.println("<td>"+itemPedido.getDesconto()+"</td>");
                out.println("<td>"+itemPedido.getQuantidade()+"</td>");
                out.println("<td>");
                out.println("<a href=\"excluiItemPedido.jsp?id="+itemPedido.getItecodigo()+"\">Excluir</a>");
                out.println("<a href=\"alteraItemPedido.jsp?id="+itemPedido.getItecodigo()+"\">Altera</a>");
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        %>
    </body>
</html>
