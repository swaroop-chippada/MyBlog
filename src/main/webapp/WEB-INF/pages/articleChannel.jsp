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

	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 text-left">
				<header>
					<h3>${articleCategory} Articles</h3>
				</header>
				<c:forEach var="article" items="${articleList}">
					<p>
						<a href="article.html?articleId=${article.id}">${article.heading}</a>
					</p>
				</c:forEach>
			</div>
		</div>
	</div>

	<custom:footer></custom:footer>

</body>
</html>