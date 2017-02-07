<%-- 
    Document   : Perfil
    Created on : 01/11/2016, 00:26:02
    Author     : joao
--%>
<%@page import="cdc.DAO.PessoasDAO"%>
<%@page import="cdc.model.Pessoas"%>
<%
                    HttpSession sessao = request.getSession();
                    if(sessao.getAttribute("sessaoEmail")== null){
                        
                        getServletContext().getRequestDispatcher("/CadastraPessoa.jsp").forward(request, response);

                    }%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <link rel="stylesheet" type="text/css" href="CSS/estilo.css">

        <title>LOTR Brasil - Perfil</title>

        <!-- Bootstrap core CSS -->
        <link href="CSS/dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="CSS/docs/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="jumbotron.css" rel="stylesheet">

        <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
        <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <%
                    sessao = request.getSession();
                    if(sessao.getAttribute("sessaoEmail")!= null){
                    
                    out.print("<a class='navbar-brand' href='index.jsp'>"+sessao.getAttribute("sessaoEmail")+"</a>");

                    }else{%>
                    <a class="navbar-brand" href="Perfil.jsp">Logar</a>
                    <%}%>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <form class="navbar-form navbar-right">
                        <div class="form-group">
                            <input type="text" placeholder="Email" class="form-control">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Password" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-success">Sign in</button>
                    </form>
                </div><!--/.navbar-collapse -->
            </div>
        </nav>

        <!--    <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" type="text/css" href="CSS/estilo.css">
                <title>E-Commerce LOTR</title>
            </head>-->
        <div id="main">
            <div id="header">
                <div id="widgetBar">

                    <!--                    <div class="headerWidget">
                                            <a href="index.html">
                                                [ Return menu ]
                                            </a>
                                        </div>-->

                    <div class="headerWidget">
                        <a href="Carrinho.jsp">
                            [ Shopping cart ]
                        </a>
                    </div>

                    <div class="headerWidget">
                        <a href="CadastraProduto.jsp">
                            [ Add new item ]
                        </a>
                    </div>

                </div>

                <a href="index.jsp">
                    <img id="logoimg" src="Imagens/logo.jpg">
                </a>
            </div>

            <div id="indexLeftColumn">
                <div id="welcomeText">
                    <h3><p>[ Categorias ]</p></h3><br>
                </div>
                
            </div>

            <div id="indexRightColumn">
                <p id="categoryTitle">[ Principal ]</p>

                <form id="fundoCadastro" action="ServletProduto" style="padding: 40px; margin: 50px 150px">
                    <legend>Informações Pessoais</legend>
                    <p style="padding: 20px; position: absolute; left: 44%">E-mail: </p>
                    <%
                    if(sessao.getAttribute("sessaoEmail")!= null){
                    
                    out.print("<p style='padding: 20px; position: absolute; left:47.5%'>"+sessao.getAttribute("sessaoEmail")+"</p><br><br><br>");
                    Pessoas pess = new Pessoas();
                    pess = new PessoasDAO().buscaPorId(Integer.parseInt(sessao.getAttribute("usuario_id").toString()));
                    
                    out.print("<p style='padding: 20px; position: absolute; left: 44%'>Nome: "+pess.getNome()+" </p><br><br><br>");
                    out.print("<p style='padding: 20px; position: absolute; left: 44%'>Endereco:"+pess.getEndereco()+" </p><br><br><br>");
                    out.print("<p style='padding: 20px; position: absolute; left: 44%'>Bairro:"+pess.getBairro()    +" </p>");
                    out.print("<p style='padding: 20px; position: absolute; left: 60%'>Cidade:"+pess.getCidade()+" </p><br><br><br>");
                    out.print("<p style='padding: 20px; position: absolute; left: 44%'>Cep:"+pess.getCep()+" </p>");
                    out.print("<p style='padding: 20px; position: absolute; left: 60%'>Estado:"+pess.getEstado()+" </p><br><br><br>");
                    out.print("<p style='padding: 20px; position: absolute; left: 44%'>Telefone:"+pess.getTelefone()+" </p>");
                    out.print("<p style='padding: 20px; position: absolute; left: 60%'>Celular:"+pess.getCelular()+" </p><br><br><br>");
                   
                    out.print("<input style='margin: 60px 250px 100px' class='button' type='submit' value='Alterar Dados'>");
                    }else{%>
                    <a class="navbar-brand" href="Perfil.jsp">Logar</a>
                    <%}%>
            </div>


            <div id="footer">
                <hr>
                <p id="footerText">[ Texto de RodaPé ]</p>
            </div>
    </body>
</html>
