<!DOCTYPE html>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-br">
<head>

	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	
	<title>Login - SGO</title>
	
	<!-- Bootstrap Core CSS -->
	<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" />
	
	<!-- MetisMenu CSS -->
	<link href="${pageContext.request.contextPath}/resources/css/metisMenu.min.css" rel="stylesheet" />
	
	<!-- Custom CSS -->
	<link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.css" rel="stylesheet" />

	<!-- Custom Fonts -->
	<link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style>
    	#status_message {
    		position: relative;
    		top: 60px;
    	}
    </style>

</head>

<body>
	<form method="post" action="${pageContext.request.contextPath}/auth/login?url=<%= request.getParameter("url") %>">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<c:if test="${ERROR_MESSAGE != null}">
					  <div class="alert alert-danger" id="status_message">${ERROR_MESSAGE}</div>
					</c:if>
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
	<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="${pageContext.request.contextPath}/resources/js/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.js"></script>

</body>

</html>
