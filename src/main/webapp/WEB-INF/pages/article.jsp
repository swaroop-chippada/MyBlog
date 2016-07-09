<%@ include file="../tags/taglibs.tag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Swaroop Chippada</title>
<meta charset="utf-8" />
<meta name="google-site-verification"
	content="w0DVCHIVnjrXlo_0iBjpBDDBavPLscfNQezp6kzbF00" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<%@ include file="../tags/css.tag"%>
<%@ include file="../tags/js.tag"%>
</head>
<body>
	<!-- Nav -->
	<custom:nav></custom:nav>
	<!-- Home -->
	<div class="container-fluid" style="min-height:500px">
		<div class="row content spacer">
			<div class="12u">
				<header class="text-center"><strong>${article.heading}</strong></header>
				<p>${article.content}</p>
			</div>
		</div>
	</div>
	<custom:footer></custom:footer>

</body>
</html>