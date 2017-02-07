<%-- 
    Document   : CadastraPessoa
    Created on : 31/10/2016, 22:23:38
    Author     : joao
--%>

<%
                    HttpSession sessao = request.getSession();
                    if(sessao.getAttribute("sessaoEmail")== null){
                        
                        getServletContext().getRequestDispatcher("/CadastraPessoa.jsp").forward(request, response);

                    }%>
                    
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <link rel="stylesheet" type="text/css" href="CSS/estilo.css">

        <title>LOTR Brasil - Novo Produto</title>

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
                        if (sessao.getAttribute("sessaoEmail") != null) {

                            out.print("<a class='navbar-brand' href='index.jsp'>" + sessao.getAttribute("sessaoEmail") + "</a>");

                        } else {%>
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

        <div id="main">
            <div id="header">
                <div id="widgetBar">

                    <!--<div class="headerWidget">
                                            <a href="#">
                                                [ Return menu ]
                                            </a>
                                        </div>-->

                    <div class="headerWidget">
                        <a href="#">
                            [ carrinho de compras ]
                        </a>
                    </div>

                </div>

                <a href="index.jsp">
                    <img id="logoimg" src="Imagens/logo.jpg">
                </a>
            </div>

            <div id="indexLeftColumnCadastro">
                <div id="welcomeText">
                    <p>[ Dicas ]</p>
                </div>
            </div>

            <div id="indexRightColumnCadastro">
                <h2>Formulário de Cadastro</h2>
                <form id="fundoCadastro" action="ServletProduto" style="padding: 40px; margin: 50px 150px">
                    <fieldset>
                        <legend>Product Information</legend>
                        <select name="categoria" style="position: absolute; left: 40%; right: 0%; height: 27px; width: 545px">
                            <option value="-1">--- Selecione uma categoria ---</option>
                            <option value="book">Book</option>
                            <option value="movie">Movie</option>
                            <option value="acessorie">Acessorie</option>
                            <option value="clothe">Clothe</option>
                        </select> 
                        <br><br><br><br><br>
                        <input name="nome" type="text" placeholder="Nome do Produto" value="" size="73" style="position: absolute; left: 40%; right: 0px"><br><br><br>

                        <input name="estoque" type="text" placeholder="Estoque do produto" value="" size="32" style="position: absolute; left: 40%">
                        <input name="preco" type="text" placeholder="Preco do produto" value="" size="32" style="position: absolute; left: 61.2%">
                        <br><br><br>
                        <label style="position: absolute; left: 40%">Descrição:</label><br>
                        <textarea name="descricao" placeholder="Informe aqui todas as informacoes sobre o produto. (Em caso de vestimentas, informe o tamanho da mesma e o sexo para o qual é destinado)" style="position: absolute; left: 40%; width: 545px; height: 200px"></textarea>

                        <label style="position: absolute; left: 40%; bottom: -310px">Imagem:</label>
                                            <input name="imagem" type="text" placeholder="Informe a URL da imagem do produto" value="" size="73" style="position: absolute; left: 40%; bottom: -340px">
                        
                    </fieldset>

                    <script>
                        function salvo(){
                            alert("Produto cadastrado com sucesso!");
                        }
                    </script>
                    <button class="button" name="cmd" onclick="salvo()" value="cadastrar" style="position: absolute; left: 77%; bottom:-515px"> Cadastrar </button>
                    
                </form>

            </div>


            <div id="footer">
                <hr>
                <p id="footerText">[ Texto de RodaPé ]</p>
            </div>
        </div>
    </body>
</html>
