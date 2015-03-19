<!DOCTYPE html>
<html lang="pt-br">
<head>

	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	
	<title>Login - SGO</title>
	
	<!-- Bootstrap Core CSS -->
	<link href="/stateless-session//resources/css/bootstrap.min.css" rel="stylesheet" />
	
	<!-- MetisMenu CSS -->
	<link href="/stateless-session/resources/css/metisMenu.min.css" rel="stylesheet" />
	
	<!-- Custom CSS -->
	<link href="/stateless-session/resources/css/sb-admin-2.css" rel="stylesheet" />

	<!-- Custom Fonts -->
	<link href="/stateless-session/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<form method="post" action="/stateless-session/auth/authentication">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="login-panel panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Login</h3>
						</div>
						<div class="panel-body">
								<fieldset>
									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon" id="basic-addon1"> <i
												class="fa fa-user"></i>
											</span>
											<input id="login" name="login" placeholder="Login" required="required" class="form-control" />
										</div>
									</div>

									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon" id="basic-addon1"> <i
												class="fa fa-lock"></i>
											</span>
											<input type="password" id="senha" name="password" placeholder="Senha" required="required" class="form-control" />
										</div>
									</div>

									<div class="checkbox">
										<label> <input name="remember" type="checkbox" value="Remember Me" />Continuar conectado
										</label>
									</div>

									<input type="submit" value="Entrar" class="btn btn-lg btn-success btn-block" />
								</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>

	<!-- jQuery -->
	<script src="/stateless-session/resources/js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/stateless-session/resources/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="/stateless-session/resources/js/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="/stateless-session/resources/js/sb-admin-2.js"></script>

</body>

</html>
