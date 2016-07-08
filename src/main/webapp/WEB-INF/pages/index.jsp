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

	<div class="container-fluid text-center">
		<div class="row content">
			<!-- <div class="col-sm-2 sidenav">
				<p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p> 
			</div> -->
			<div class="col-sm-12">
				<div class="text-left">
					<header>
						<h1>Latest Articles</h1>
					</header>
					<c:forEach var="article" items="${articleList}">
						<h3>
							<a href="article.html?articleId=${article.id}">${article.heading}</a>
						</h3>
					</c:forEach>
				</div>
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