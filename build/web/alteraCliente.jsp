<%-- 
    Document   : alteraCliente
    Created on : 09/09/2015, 22:34:30
    Author     : aluno
--%>

<%@page import="controle.ClienteDB"%>
<%@page import="controle.Conexao"%>
<%@page import="java.sql.Connection"%>
<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Altera Cliente</title>

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
            Cliente cliente = null;
            Connection conexao = Conexao.getConexao();
            if (request.getParameter("btnAltera") != null) {
                int codigo = Integer.valueOf(request.getParameter("codigo"));
                String nome = request.getParameter("nome");
                String cpf = request.getParameter("cpf");
                String cnpj = request.getParameter("cnpj");
                String estado = request.getParameter("estado");
                String cidade = request.getParameter("cidade");
                String bairro = request.getParameter("bairro");
                String rua = request.getParameter("rua");
                String telefone = request.getParameter("telefone");
                cliente = new Cliente(codigo, nome, cpf, cnpj, estado, cidade, bairro, rua, telefone);
                boolean alterou = ClienteDB.alteraCliente(cliente, conexao);
                if (alterou) {
                    mensagem = "Cliente alterado com sucesso";
                } else {
                    mensagem = "Erro ao alterar";
                }
            }
            out.println(mensagem);

            String id = request.getParameter("id");
            int codigo = Integer.valueOf(id);
            cliente = ClienteDB.getCliente(codigo, conexao);
        %>    


        <h1 style="text-align: center;">Alteração de Cliente</h1>

        <div class="container-fluid">
            <form name="frmAlterar" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">Nome:</label>
                    <div class="col-sm-9">
                        <input type="text" name="nome" maxlength="10"  class="form-control" id="inputEmail3" placeholder="Nome" value="<%= cliente.getNome()%>"/>
                    </div>
                    <label for="inputEmail3" class="col-sm-2 control-label">CPF:</label>
                    <div class="col-sm-9">
                        <input type="text" name="cpf" maxlength="10"  class="form-control" id="inputEmail3" placeholder="CPF" value="<%= cliente.getCpf()%>"/>
                    </div>
                    <label for="inputEmail3" class="col-sm-2 control-label">CNPJ:</label>
                    <div class="col-sm-9">
                        <input type="text" name="cnpj" maxlength="10"  class="form-control" id="inputEmail3" placeholder="Cnpj" value="<%= cliente.getCnpj()%>"/>
                    </div>
                    <label for="inputEmail3" class="col-sm-2 control-label">Estado:</label>
                    <div class="col-sm-9">
                        <input type="text" name="estado" maxlength="10"  class="form-control" id="inputEmail3" placeholder="Estado" value="<%= cliente.getEstado()%>"/>
                    </div>
                    <label for="inputEmail3" class="col-sm-2 control-label">Cidade:</label>
                    <div class="col-sm-9">
                        <input type="text" name="cidade" maxlength="10"  class="form-control" id="inputEmail3" placeholder="Cidade" value="<%= cliente.getCidade()%>"/>
                    </div>
                    <label for="inputEmail3" class="col-sm-2 control-label">Bairro:</label>
                    <div class="col-sm-9">
                        <input type="text" name="bairro" maxlength="10"  class="form-control" id="inputEmail3" placeholder="Bairro" value="<%= cliente.getBairro()%>"/>
                    </div>
                    <label for="inputEmail3" class="col-sm-2 control-label">Rua:</label>
                    <div class="col-sm-9">
                        <input type="text" name="rua" maxlength="10"  class="form-control" id="inputEmail3" placeholder="Rua" value="<%= cliente.getRua()%>"/>
                    </div>
                    <label for="inputEmail3" class="col-sm-2 control-label">Telefone:</label>
                    <div class="col-sm-9">
                        <input type="text" name="telefone" maxlength="10"  class="form-control" id="inputEmail3" placeholder="Telefone" value="<%= cliente.getTelefone()%>"/>
                    </div>

                </div>
        </div>
        <div style="margin-left: 130px;">
            <a href="listaCliente.jsp" target="_parent" class="btn btn-default" role="button" style="width: 65px;">Voltar</a>
            <input type="hidden" name="codigo" value="<%= id%>"/>
            <input class="btn btn-default" role="button" style="width: 65px;" type="submit" name="btnAltera" value="Alterar"/>

        </div>
    </form>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
