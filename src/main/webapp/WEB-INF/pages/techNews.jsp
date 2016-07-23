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
<link rel="stylesheet"
	href="<c:url value="/resources/assets/css/grid.css"/>">
</head>
<body>

	<!-- Nav -->
	<custom:nav active="${tag}"></custom:nav>

	<div class="container-fluid page-layout-news">
		<div id="wrapper">
			<div id="columns">
				<c:forEach var="article" items="${articleList}">
					<a href="${article.relativeUrl}">

						<div class="pin">
							<c:choose>
								<c:when test="${empty article.imageUrl}">
									<img src="<c:url value="/resources/images/defaultImage.png"/>" />
								</c:when>
								<c:otherwise>
									<img src="${article.imageUrl}" />
								</c:otherwise>
							</c:choose>
							<p>${article.heading}</p>
						</div>
					</a>
				</c:forEach>
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