<%-- 
    Document   : Categoria
    Created on : 01/11/2016, 00:26:02
    Author     : joao
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cdc.model.Produtos"%>
<%@page import="cdc.DAO.ProdutoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

        <title>LOTR Brasil - Carrinho de Compra</title>

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
                    HttpSession sessao = request.getSession();
                    if(sessao.getAttribute("sessaoEmail")!= null){
                    
                    out.print("<a class='navbar-brand' href='perfil.jsp'>"+sessao.getAttribute("sessaoEmail")+"</a>");

                    }else{%>
                    <a class="navbar-brand" href="index.jsp">Logar</a>
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
                <a href="CategoriaBooks.jsp" class="categoryButton">
                    <span class="categoryText">Books</span>
                </a>

                <a href="CategoriaMovies.jsp" class="categoryButton">
                    <span class="categoryText">Movies</span>
                </a>

                <div class="categoryButton" id="selectedCategory">
                    <span class="categoryText">Acessories</span>
                </div>

                <a href="CategoriaClothes.jsp" class="categoryButton">
                    <span class="categoryText">Clothes</span>
                </a>
            </div>

            <div id="indexRightColumn">
                
                <c:forEach var="itens" items="${requestScope.listProduto}">
                    <div class="lightBlue">
                        <div id="fotoCarrinho"> foto </div>     
                   Produto | ${itens.nome}---
                   Preço| <span class="preco">${itens.preco}</span>R$---
                   Descricao| ${itens.descricao}
                   <br><br>
                    </div>
                </c:forEach>
                
                <input style="margin: 40px 350px 100px" class="button" id="btn-finalizar" type="submit" value="Finalizar Compra">
            </div>


            <div id="footer">
                <hr>
                <p id="footerText">[ Texto de RodaPé ]</p>
            </div>
    </body>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript">
        alert('ff');
        $("#btn-finalizar").click(function(){
            var valor = 0;
            $(".preco").each(function(){
//                alert($(this).text());
                valor += Number($(this).text());
            })
            alert("Compra realizada com sucesso! Valor total R$ "+valor+ " Prossiga para realizar o pagamento!");
            window.location = "https://pagseguro.uol.com.br/#rmcl";
            
        })
        </script>
</html>
