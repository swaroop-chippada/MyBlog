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
	<custom:nav active="home"></custom:nav>
	<c:if test="${articleCreated}">
		<div class="alert alert-block">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<h4>Successfully!</h4>
			Article is successfully published.
		</div>
	</c:if>

	<div class="jumbotron">
		<div class="container-fluid">
			<h2>Welcome !</h2>
			<p>Main purpose of this application is to help people learn
				things about web technologies. I created this application to share
				few concepts and methodologies which im quite familiar about.</p>
		</div>
	</div>
	<div class="container-fluid page-layout">
		<div class="row">
			<div class="col-xs-4">
				<h2>JAVA</h2>
				<p>The section will help you understand the basics of JAVA, so
					that you can create your own web pages or website using JAVA.</p>
				<p>
					<a href="category?id=java" class="btn btn-primary">Click to see
						JAVA articles</a>
				</p>
			</div>
			<div class="col-xs-4">
				<h2>Spring</h2>
				<p>The section will help you understand the basics of Spring, so
					that you can create high performing, easily testable and reusable
					code.</p>
				<p>
					<a href="category?id=spring" class="btn btn-primary">Click to
						see Spring articles</a>
				</p>
			</div>
			<div class="col-xs-4">
				<h2>Hibernate</h2>
				<p>The section will help you understand the basics of Hibernate.
					What is ORM and also some of the main features of Hibernate.</p>
				<p>
					<a href="category?id=hibernate" class="btn btn-primary">Click
						to see Hibernate articles</a>
				</p>
			</div>
		</div>
		<hr>
		<div class="row">
			<div class="col-xs-12 text-left">

				<div class="panel panel-primary">
					<div class="panel-heading">Recent Articles</div>
					<div class="panel-body">
						<div class="list-group">
							<c:forEach var="article" items="${articleList}">
								<a href="article.html?articleId=${article.id}"
									class="list-group-item"> <span
									class="badge ${article.category}">${article.category}</span>
									${article.heading}
								</a>

							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<custom:footer></custom:footer>

</body>
</html>