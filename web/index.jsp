<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<%
    HttpSession sessaoProd = request.getSession(true);
    
    List<Integer> listProd = new ArrayList<>();
    sessaoProd.setAttribute("carrinho", listProd);

%>

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

        <title>LOTR Brasil</title>

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
                    
                    out.print("<a class='navbar-brand' href='Perfil.jsp'>"+sessao.getAttribute("sessaoEmail")+"</a>");
                    out.print("<a href='ServletPessoa?cmd=logout'>Sair</a>");

                    }else if(sessao.getAttribute("sessaoEmail")== null){%>
                    <a class="navbar-brand" href="index.jsp" >Logar</a>
                    <%}%>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <form class="navbar-form navbar-right" action="CadastraPessoa.jsp">
                        <button type="submit" class="btn btn-success">Register</button>
                    </form>
                    <form action="ServletPessoa" class="navbar-form navbar-right" method="post">
                        <div class="form-group">
                            <input type="text" placeholder="Email" class="form-control" name="email">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Password" class="form-control" name="senha">
                        </div>
                        <button type="submit" class="btn btn-success" name="cmd" value="logar">Sign in</button>         
                    </form>
                </div><!--/.navbar-collapse -->
            </div>
        </nav>

        <!--<html>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" type="text/css" href="CSS/estilo.css">
                <title>E-Commerce LOTR</title>
            </head>-->
        <div id="main">
            <div id="header">
                <div id="widgetBar">

                    <!--                    <div class="headerWidget">
                                            <a href="#">
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
                    <p>[ Boas-Vindas ]</p>
                    <hr>
                    <img id="escLotr" src="Imagens/esc_lotr.png">
                </div>
            </div>

            <div id="indexRightColumn">
                <!--                teste-->

                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img class="first-slide" src="Imagens/black.jpeg" alt="First slide" style="width: 100%; height: 100%;">
                            <div class="container">
                                <div class="carousel-caption">
                                    <!--              <h1>Example headline.</h1>
                                                  <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
                                                  <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>-->
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <img class="second-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Second slide">
                            <div class="container">
                                <div class="carousel-caption">
                                    <!--              <h1>Another example headline.</h1>
                                                  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                                  <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>-->
                                </div>
                            </div>
                        </div>
                        <div class="item">
                            <img class="third-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Third slide">
                            <div class="container">
                                <div class="carousel-caption">
                                    <!--              <h1>One more for good measure.</h1>
                                                  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                                                  <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>-->
                                </div>
                            </div>
                        </div>
                    </div>
                    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div><!-- /.carousel -->
                <!--fim teste-->
                <!--    <h1 style="width: 950px; height: 30px">Categoria</h1>-->
                <div class="categoryBox" style="margin-left: 70px">
                    <a href="CategoriaBooks.jsp">
                        <img id="imagem" src="Imagens/books.jpg"/>
                    </a>
                </div>
                <div class="categoryBox">
                    <a href="CategoriaMovies.jsp">
                        <img id="imagem" src="Imagens/movies.jpg"/>
                    </a>
                </div>
                <div class="categoryBox" style="margin-left: 70px">
                    <a href="CategoriaAcessories.jsp">
                        <img id="imagem" src="Imagens/acessories.jpg"/>
                    </a>
                </div>
                <div class="categoryBox">
                    <a href="CategoriaClothes.jsp">
                        <img id="imagem" src="Imagens/clothes.jpg"/>
                    </a>
                </div>
            </div>

            <div id="footer">
                <hr>
                <p id="footerText">[ Texto de RodaPé ]</p>
            </div>
        </div>
    </body>
</html>
