<%-- 
    Document   : listaPedidos
    Created on : 30/09/2015, 19:07:02
    Author     : Wagner_Soares
--%>


<%@page import="controle.PedidoDB"%>
<%@page import="modelo.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controle.Conexao"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Lista de Pedidos</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">E-Commerce</a>
                </div>
                <div class="collapse navbar-collapse" style="float: right;"e id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="listaCliente.jsp">Clientes <span class="sr-only">(current)</span></a></li>
                        <li><a href="listaProduto.jsp">Produtos</a></li>
                        <li><a href="listaPedidos.jsp">Pedidos</a></li>
                    </ul> 

                    <div class=" right collapse navbar-collapse" style="float: right;" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Opções<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="listaCliente.jsp">Clientes</a></li>
                                    <li><a href="listaProduto.jsp">Produtos</a></li>
                                    <li><a href="listaPedidos.jsp">Pedidos</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
        </nav>

        <h1 style="text-align: center;">Lista de Pedidos</h1>
        <%
            Connection conexao = Conexao.getConexao();
            ArrayList lista = PedidoDB.getListaPedido(conexao);
            out.println("<div class='table-responsive' style='margin-top:50px;'>");
            out.println("<table class='table table-condensed'>");
            out.println("<tr>");
            out.println("<th>Codigo do Pedido</th>");
            out.println("<th>Codigo do Cliente</th>");
            out.println("<th>Emissão</th>");
            out.println("<th>Entrega</th>");
            out.println("<th>Produtos</th>");
            out.println("<th>Opções</th>");
            out.println("</tr>");

            for (int i = 0; i < lista.size(); i++) {
                Pedido pedido = (Pedido) lista.get(i);
                out.println("<tr>");
                out.println("<td>" + pedido.getPedcodigo() + "</td>");
                out.println("<td>" + pedido.getClicodigo() + "</td>");
                out.println("<td>" + pedido.getEmissao() + "</td>");
                out.println("<td>" + pedido.getEntrega() + "</td>");
                out.println("<td>");
                out.println("<a class='btn btn-success' href=\"inserirItemPedido.jsp?id=" + pedido.getPedcodigo() + "\">Adicionar</a>");
                out.println("</td>");
                out.println("<td>");
                out.println("<a class='btn btn-default' role='button' href=\"excluiPedido.jsp?id=" + pedido.getPedcodigo() + "\">Excluir</a>");
                out.println("<a class='btn btn-default' role='button' href=\"alteraPedido.jsp?id=" + pedido.getPedcodigo() + "\">Altera</a>");
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        %>

        <a href="index.html"  target="_parent" class="btn btn-default" role="button" style="width: 65px;">Voltar</a>
        <a href="inserirPedido.jsp"  target="_parent" class="btn btn-default" role="button" style="width: 65px;">Novo</a>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
