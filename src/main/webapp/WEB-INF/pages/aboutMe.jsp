<%@ include file="../tags/taglibs.tag"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Swaroop Chippada HomePage</title>
<meta charset="utf-8">
<meta name="google-site-verification"
	content="w0DVCHIVnjrXlo_0iBjpBDDBavPLscfNQezp6kzbF00" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ include file="../tags/css.tag"%>
<%@ include file="../tags/js.tag"%>
</head>
<body>

	<!-- Nav -->
	<custom:nav active="aboutme"></custom:nav>

	<c:if test="${questionPosted}">
		<div class="alert alert-block">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<h4>Thanks for posting. Will answer you shortly!</h4>
		</div>
	</c:if>

	<div class="container-fluid text-center">
		<div class="row content spacer">
			<!-- <div class="col-sm-2 sidenav">
				<p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p> 
			</div> -->
			<div class="col-sm-12">
				<div class="col-sm-4 col-xs-12">
					<img src="<c:url value="/resources/images/Swap-Profile.JPG"/>"
						class="img-circle" alt="swaroop chippada" width="304" height="236" />
				</div>
				<div class="col-sm-8 col-xs-12 text-left">
					<header>
						<h1>
							Hi. I'm <strong>Swaroop Chippada</strong>.
						</h1>
					</header>
					<p>
						And this is <strong>My page</strong>, I'm a passionate software
						developer. I love programming and want to continously learn new
						things and make things easy for simple living. I Developed various
						WEB based applications. I'm Primarily a backend java developer. i
						worked on various frameworks such as Spring, Hibernate, Spring
						batch, GWT and JSF. I have deep knowledge of and experience with
						the SOLR search platform and Mongo DB. My passion towards
						technology drives me more and explore each of the framework and
						learn its benefits. I started this website just for helping people
						find solutions for complex problems.
					</p>
				</div>
			</div>
			<div class="col-sm-12">
				<div class="container col-sm-12">
					<header class="spacer">
						<h4>Following are some technologies and frameworks which i have worked on.</h4>
					</header>
					<div class="col-sm-2 col-xs-12">
						<img src="<c:url value="/resources/images/javalogo.png"/>"
							alt="swaroop chippada" width="150" height="100" />
					</div>
					<div class="col-sm-2 col-xs-12">
						<img src="<c:url value="/resources/images/spring1.png"/>"
							alt="swaroop chippada" width="150" height="100" />
					</div>
					<div class="col-sm-2 col-xs-12">
						<img src="<c:url value="/resources/images/Hibernate_logo_a.png"/>"
							alt="swaroop chippada" width="150" height="100" />
					</div>
					<div class="col-sm-2 col-xs-12">
						<img src="<c:url value="/resources/images/solr1.png"/>"
							alt="swaroop chippada" width="150" height="100" />
					</div>
					<div class="col-sm-2 col-xs-12">
						<img src="<c:url value="/resources/images/oracle-logo.png"/>"
							alt="swaroop chippada" width="150" height="100" />
					</div>
					<div class="col-sm-2 col-xs-12">
						<img src="<c:url value="/resources/images/MongoDB-Logo.svg.png"/>"
							alt="swaroop chippada" width="150" height="100" />
					</div>
				</div>
				<div class="container col-sm-12">
					<div class="col-sm-2 col-xs-12">
						<img src="<c:url value="/resources/images/jQuery.gif"/>"
							alt="swaroop chippada" width="150" height="100" />
					</div>
					<div class="col-sm-2 col-xs-12">
						<img src="<c:url value="/resources/images/bootstrap.gif"/>"
							alt="swaroop chippada" width="150" height="100" />
					</div>
				</div>
			</div>
			<div class="container col-sm-12 spacer">
				<h3 class="form-padding40">
					<strong>Feel Free to post any questions below. so that i
						can try to help you in finding answer for you ?</strong>
				</h3>
				<form:form method="post" modelAttribute="questionForm"
					action="postQuestion.do">

					<div class="form-group form-padding40">
						<div class="col-sm-6 col-xs-12">
							<form:input path="userName" id="name" placeholder="Name"
								class="form-control" />
						</div>
						<div class="col-sm-6 col-xs-12">
							<form:input path="email" id="email" placeholder="Email"
								class="form-control" />
						</div>
					</div>
					<div class="form-group form-padding40">
						<div class="col-sm-12">
							<form:textarea row="4" path="question" id="question"
								placeholder="Post your Question here !" class="form-control" />
						</div>
					</div>
					<div class="form-group form-padding50">
						<div class="col-sm-12">
							<input type="submit" value="Post" class="btn btn-success" /> <input
								type="reset" value="Clear" class="btn btn-danger" />
						</div>
					</div>

				</form:form>


			</div>
			<!-- <div class="col-sm-2 sidenav">
				<div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div> 
			</div> -->
		</div>
	</div>

	<custom:footer></custom:footer>

</body>
</html>