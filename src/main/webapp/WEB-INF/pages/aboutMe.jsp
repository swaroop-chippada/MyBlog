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

	<div class="container-fluid text-center">
		<div class="row content">
			<!-- <div class="col-sm-2 sidenav">
				<p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p> 
			</div> -->
			<div class="col-sm-12">
				<div class="col-sm-4">
					<img src="<c:url value="/resources/images/Swap-Profile.JPG"/>"
						class="img-circle" alt="swaroop chippada" width="304" height="236" />
				</div>
				<div class="col-sm-8 text-left">
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
			<div class="container col-sm-12">
				<p>Let me help you in finding answer for you ?</p>
				<form:form method="post" modelAttribute="questionForm"
					action="postQuestion.do">

					<div class="form-group form-padding40">
						<div class="col-sm-6">
							<form:input path="userName" id="name"
								placeholder="Name" class="form-control" />
						</div>
						<div class="col-sm-6">
							<form:input path="email" id="email"
								placeholder="Email" class="form-control" />
						</div>
					</div>
					<div class="form-group form-padding40">
						<div class="col-sm-12">
							<form:textarea row="4" path="question" id="question"
								placeholder="Post your Question here !" class="form-control" />
						</div>
					</div>
					<div class="form-group form-padding40">
						<div class="col-sm-12">
							<input type="submit" value="Post" class="btn btn-default" /> <input
								type="reset" value="Clear" class="btn btn-default" />
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