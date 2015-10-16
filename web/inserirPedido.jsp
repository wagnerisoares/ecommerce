<%-- 
    Document   : inserirPedido
    Created on : 30/09/2015, 19:29:29
    Author     : Wagner_Soares
--%>

<%@page import="controle.PedidoDB"%>
<%@page import="controle.Conexao"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.Pedido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Novo Cliente</title>

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
            if (request.getParameter("btnGravar") != null) {
                int codigo = Integer.valueOf(request.getParameter("codigo"));
                int codigoc = Integer.valueOf(request.getParameter("cliente"));
                String emissao = request.getParameter("emissao");
                String entrega = request.getParameter("entrega");
                Pedido pedido = new Pedido(codigo, codigoc, emissao, entrega);
                Connection conexao = Conexao.getConexao();
                boolean incluiu = PedidoDB.incluiPedido(pedido, conexao);
                if (incluiu) {
                    mensagem = "Pedido incluido com sucesso!";
                } else {
                    mensagem = "Erro ao enserir o pedido- entre em contato com o suporte tecnico!";
                }
            }
            out.println(mensagem);
        %>
        
        <h1 style="text-align: center;"> Inserir Pedidos</h1>
        <br/>
        <div class="container-fluid">
            <form name="frmPedido" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">N° Pedido:</label>
                    <div class="col-sm-9">
                        <input type="text" name="codigo" maxlength="10"  class="form-control" id="inputEmail3" placeholder="Pedido"/>
                    </div>
                    <label for="inputEmail3" class="col-sm-2 control-label">Código do Cliente:</label>
                    <div class="col-sm-9">
                        <input type="text" name="cliente" maxlength="10"  class="form-control" id="inputEmail3" placeholder="Código do Cliente"/>
                    </div>
                    <label for="inputEmail3" class="col-sm-2 control-label">Emissão:</label>
                    <div class="col-sm-9">
                        <input type="text" name="emissao" maxlength="10"  class="form-control" id="inputEmail3" placeholder="Emissão"/>
                    </div>
                    <label for="inputEmail3" class="col-sm-2 control-label">Entrega:</label>
                    <div class="col-sm-9">
                        <input type="text" name="entrega" maxlength="10"  class="form-control" id="inputEmail3" placeholder="Entrega"/>
                    </div>
                    
                    
                </div>
                 <div style="margin-left: 130px;">
                     <a href="listaPedidos.jsp" target="_parent" class="btn btn-default" role="button" style="width: 65px;">Voltar</a>
                    <input class="btn btn-default" role="button" style="width: 65px;" type="submit" name="btnGravar" value="Gravar"/>
                </div>
            </form>
        </div>
    </body>
</html>
