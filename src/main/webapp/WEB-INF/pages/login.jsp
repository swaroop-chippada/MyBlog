<%@ include file="../tags/taglibs.tag"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<meta name="google-site-verification"
	content="w0DVCHIVnjrXlo_0iBjpBDDBavPLscfNQezp6kzbF00" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<%@ include file="../tags/css.tag"%>
<%@ include file="../tags/js.tag"%>
<title>Login</title>
</head>
<body>

	<custom:nav></custom:nav>

	<div class="container-fluid spacer">
		<c:if test="${not empty Message}">
			<div class="alert alert-block">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<h4>${Message}</h4>
			</div>
		</c:if>
		<article>
			<div>
				<div class="row content spacer">
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
						<header>
							<h2>Login</h2>
						</header>
						<form name='loginForm' method="post"
							action="<c:url value='login' />">
							<div class="form-group">
								<label for="heading">UserName</label> <input type="text"
									class="form-control" name="userName" id="userName"
									placeholder="UserName" />
							</div>
							<div class="form-group">
								<label for="heading">Password</label> <input type="password"
									class="form-control" name="password" id="password"
									placeholder="password" />
							</div>
							<div class="form-group">
								<input type="submit" class="btn btn-success" value="Login" /> <input
									type="reset" value="Clear" class="btn btn-danger" />
							</div>
						</form>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
						<header>
							<h2>New User</h2>
						</header>
						<form:form method="post" modelAttribute="newUser"
							action="register">
							<div class="form-group">
								<label for="heading">UserName</label>
								<form:input type="text" path="userName" class="form-control"
									id="userName" placeholder="UserName" />
							</div>
							<div class="form-group">
								<label for="heading">Password</label>
								<form:input type="password" path="password" class="form-control"
									id="password" placeholder="password" />
							</div>
							<div class="form-group">
								<label for="heading">Email</label>
								<form:input type="text" path="email" id="email"
									class="form-control" placeholder="Email" />
							</div>
							<div class="form-group">
								<label for="heading">First Name</label>
								<form:input type="text" path="firstName" id="firstName"
									class="form-control" placeholder="First Name" />
							</div>
							<div class="form-group">
								<label for="heading">Last Name</label>
								<form:input type="text" path="lastName" id="lastName"
									class="form-control" placeholder="Last Name" />
							</div>
							<div class="form-group">
								<input type="submit" class="btn btn-success" value="Register" />
								<input type="reset" value="Clear" class="btn btn-danger" />
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</article>
	</div>
		<custom:footer></custom:footer>
</body>
</html>
