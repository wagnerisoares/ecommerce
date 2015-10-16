<%-- 
    Document   : inserirItemPedido
    Created on : 30/09/2015, 21:38:41
    Author     : Wagner_Soares
--%>

<%@page import="modelo.ItemPedido"%>
<%@page import="controle.ItemPedidoDB"%>
<%@page import="controle.Conexao"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Inserir item do pedido</title>

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
            </div>
        </nav>
        <%
            String mensagem = "";
            if (request.getParameter("btnEnviar") != null) {
                int codigo = Integer.valueOf(request.getParameter("codigo"));
                int procodigo = Integer.valueOf(request.getParameter("procodigo"));
                int pedcodigo = Integer.valueOf(request.getParameter("pedcodigo"));
                String totalpedido = request.getParameter("totalpedido");
                String desconto = request.getParameter("desconto");
                String quantidade = request.getParameter("quantidade");
                Connection conexao = Conexao.getConexao();
                ItemPedido item_pedido = new ItemPedido(codigo, procodigo, pedcodigo, totalpedido, desconto, quantidade);
                boolean incluiu = ItemPedidoDB.incluiItemPedido(item_pedido, conexao);
                if (incluiu) {
                    mensagem = "Item inserido com sucesso";
                } else {
                    mensagem = "Erro ao incluir o item do pedido";
                }
            }
            out.println(mensagem);
            out.println("<br/>");

            String id = request.getParameter("id");
        %>
        <h1 style="text-align: center;">Inserir item do pedido</h1>
        <div class="container-fluid">
            <form name="frmItemPedido" method="post" class="form-horizontal">
                <div class="form-group">
                    <input type="hidden" name="codigo" maxlength="10" size="10" value="<%=id%>"/>
                    <label for="inputEmail3" class="col-sm-2 control-label">Código do Produto:</label>
                    <div class="col-sm-9">
                        <input type="text" name="procodigo" maxlength="10"  maxlength="10" class="form-control" id="inputEmail3" placeholder="Código do Produto"/>
                    </div>

                    <input type="hidden" name="pedcodigo" maxlength="10" size="10" value="<%=id%>"/>
                    <label for="inputEmail3" class="col-sm-2 control-label">Total do Pedido:</label>
                    <div class="col-sm-9">
                        <input type="text" name="totalpedido" maxlength="10"  maxlength="10" class="form-control" id="inputEmail3" placeholder="Total do Pedido"/>
                    </div>
                    <label for="inputEmail3" class="col-sm-2 control-label">Desconto:</label>
                    <div class="col-sm-9">
                        <input type="text" name="desconto" maxlength="10"  maxlength="10" class="form-control" id="inputEmail3" placeholder="Desconto"/>
                    </div>
                    <label for="inputEmail3" class="col-sm-2 control-label">Quantidade:</label>
                    <div class="col-sm-9">
                        <input type="text" name="quantidade" maxlength="10"  maxlength="10" class="form-control" id="inputEmail3" placeholder="Quantidade"/>
                    </div>


                </div>

                <div style="margin-left: 130px;">
                    <a href="listaPedidos.jsp" target="_parent" class="btn btn-default" role="button" style="width: 65px;">Voltar</a>
                    <input class="btn btn-default" role="button" style="width: 65px;" type="submit" name="btnEnviar" value="Gravar"/>
                </div>
            </form>
        </div>
    </body>
</html>
