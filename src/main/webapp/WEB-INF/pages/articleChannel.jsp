<%@ include file="../tags/taglibs.tag"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>${tag} Page</title>
<meta charset="utf-8">
<meta name="google-site-verification"
	content="w0DVCHIVnjrXlo_0iBjpBDDBavPLscfNQezp6kzbF00" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ include file="../tags/css.tag"%>
<%@ include file="../tags/js.tag"%>
</head>
<body>

	<!-- Nav -->
	<custom:nav active="${tag}"></custom:nav>

	<div class="container-fluid page-layout">
		<div class="row">
			<div class="col-xs-12 text-left spacer">
				<div class="panel panel-default">
					<div class="panel-heading text-transformer"><h4>${tag} Articles</h4></div>
					<div class="panel-body">
						<c:forEach var="article" items="${articleList}">
							<p>
								<a href="${article.relativeUrl}">${article.heading}</a>
							</p>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>

	<ul class="pager">
		<li class="<c:if test="${previous}">disabled</c:if>"><a
			href="tag?id=${tag}&offset=${offset-1}">Previous</a></li>
		<li class="<c:if test="${next}">disabled</c:if>"><a
			href="tag?id=${tag}&offset=${offset+1}">Next</a></li>
	</ul>
	<custom:footer></custom:footer>

</body>
</html>