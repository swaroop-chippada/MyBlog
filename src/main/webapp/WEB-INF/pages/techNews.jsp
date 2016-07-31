<%@ include file="../tags/taglibs.tag"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>${tag}Page</title>
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

	<!-- Search component -->
	<custom:search></custom:search>

	<custom:pins list="${articleList}"></custom:pins>

	<ul class="pager">
		<li class="<c:if test="${previous}">disabled</c:if>"><a
			href="tag?id=${tag}&offset=${offset-1}">Previous</a></li>
		<li class="<c:if test="${next}">disabled</c:if>"><a
			href="tag?id=${tag}&offset=${offset+1}">Next</a></li>
	</ul>
	<custom:footer></custom:footer>

</body>
</html>