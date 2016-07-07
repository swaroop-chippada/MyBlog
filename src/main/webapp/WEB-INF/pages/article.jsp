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
	<%@ include file="../tags/nav.tag"%>
	<!-- Home -->
	<div class="wrapper style1 first">
		<article class="container" id="top">
			<div class="row">

				<div class="12u">
					<header>
						Article Page
					</header>
					<p>${article.heading}</p>
					<p>${article.content}</p>
				</div>
			</div>
		</article>
	</div>
</body>
</html>