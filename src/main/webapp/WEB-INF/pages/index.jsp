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
	
	<!-- Search component -->
	<custom:search></custom:search>

	<div class="container-fluid page-layout">
		<div class="row">
			<div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">
				<h2>Java</h2>
				<p>Click below to check articles on Java</p>
				<p>
					<a href="tag?id=java" class="btn btn-primary"> Java
						</a>
				</p>
			</div>
			<div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">
				<h2>Spring</h2>
				<p>Click below to check articles on Spring</p>
				<p>
					<a href="tag?id=spring" class="btn btn-primary">
						Spring </a>
				</p>
			</div>
			<div class="col-lg-4 col-md-12 col-sm-12 col-xs-12">
				<h2>Hibernate</h2>
				<p>Click below to check articles on Hibernate</p>
				<p>
					<a href="tag?id=hibernate" class="btn btn-primary">
						Hibernate articles</a>
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
								<a href="${article.relativeUrl}"
									class="list-group-item"> <c:forEach items="${article.tags}"
										var="tag">
										<span class="badge ${tag}">${tag}</span>
									</c:forEach> ${article.heading}
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