<%-- 
    Document   : CadastraPessoa
    Created on : 31/10/2016, 22:23:38
    Author     : joao
--%>
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

        <title>LOTR Brasil - Novo Cadastro</title>

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
                    
                    out.print("<a class='navbar-brand' href='index.jsp'>"+sessao.getAttribute("sessaoEmail")+"</a>");

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

                    <div class="headerWidget">
                        <a href="#">
                            [ View profile ]
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
                <form id="fundoCadastro" action="ServletPessoa" style="padding: 40px; margin: 50px 150px">
                    <fieldset>
                        <legend>Personal Information</legend>
                    <input name="nome" type="text" placeholder="Nome Completo" value="" size="73" style="position: absolute; left: 40%; right: 0px"><br><br>
                    <label style="position: absolute; left: 40%">Masculino</label>
                    <label style="position: absolute; left: 49%">Feminino</label>
                    <input name="sexo" type="radio" value="Masculino" style="position: absolute; left: 46%">
                    <input name="sexo" type="radio" value="Feminino" style="position: absolute; left: 54.5%">
                    <br><br>

                    <input name="rg" type="text" placeholder="Registro Geral (RG)" value="" size="32" style="position: absolute; left: 40%; right: 0px">

                    <input name="cpf" type="text" placeholder="CPF" value="" size="32" style="position: absolute; left: 61.2%; right: 0px">
                    </fieldset>
                    
                    <br><br><br>
                    
                    <fieldset>
                        <legend>Other Information</legend>
                    <input name="endereco" type="text" placeholder="Endereço" value="" size="47" style="position: absolute; left: 40%; right: 0px">
                    
                    <input name="cep" type="text" placeholder="CEP (XXXXX-ZZZ)" value="" size="18" style="position: absolute; left: 68.3%; right: 0px">
                    <br><br>
                    
                    <label style="position: absolute; left: 40%; ">Estado:</label>
                    <select name="estado" style="position: absolute; left: 45%; right: 0%">
                        <option value="GO">GO</option>
                        <option value="SP">SP</option>
                        <option value="RJ">RJ</option>
                        <option value="PA">PA</option>
                    </select>
                    <br><br>

                    <input name="cidade" type="text" placeholder="Cidade" value="" size="32" style="position: absolute; left: 40%; right: 0px">
                    <input name="bairro" type="text" placeholder="Bairro" value="" size="32" style="position: absolute; left: 61.2%; right: 0px">
                    </fieldset>
                    <br><br><br>
                 
                    <fieldset>
                        <legend>Contact</legend>
                    <input name="telefone" type="text" placeholder="Telefone (Ex: 11 11112222)" value="" size="30" style="position: absolute; left: 40%; right: 0px">
                    <br><br>
                    <input name="celular" type="text" placeholder="Celular (Ex: 11 9 11112222)" value="" size="30" style="position: absolute; left: 40%; right: 0px">
                    </fieldset>
                    <br><br><br>
                    
                    <fieldset>
                        <legend>Register Login</legend>
                    <input name="email" type="text" placeholder="Email (Ex: nome@exemplo.com.br)" value="" size="40" style="position: absolute; left: 40%; right: 0px">
                    <br><br>
                    <input name="senha" type="password" placeholder="Senha" value="" size="40" style="position: absolute; left: 40%; right: 0px">
                    </fieldset>
                    <br><br><br><br>
                    <script>
                        function funcao1()
                        {
                            alert("Cadastro realizado com sucesso!!");
                        }
                    </script>
                    <button class="button" onclick="funcao1()" name="cmd" value="cadastrar" style="position: absolute; left: 77%"> Cadastrar </button>
                    
                </form>
                
            </div>


            <div id="footer">
                <hr>
                <p id="footerText">[ Texto de RodaPé ]</p>
            </div>
        </div>
    </body>
</html>
