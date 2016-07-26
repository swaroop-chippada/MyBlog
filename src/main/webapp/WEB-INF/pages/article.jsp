<%@ include file="../tags/taglibs.tag"%>
<!DOCTYPE HTML>
<html>
<head>
<title>${article.heading}</title>
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
	<div class="container-fluid page-layout">
		<div class="row content spacer">
			<div class="12u">
				<header>
					<h3>${article.heading}</h3>
					<div>
						By: <span class="author">${article.userId}</span> | Published on: <span class="author">${article.publicationDate}</span>
					</div>
					<hr>
				</header>
				<c:if test="${not empty article.imageUrl}">
					<div><img src="${article.imageUrl}" width="100%"/></div>
				</c:if>
				<p>${article.content}</p>
			</div>
		</div>


		<div id="disqus_thread"></div>
		<script>
			/**
			 *  RECOMMENDED CONFIGURATION VARIABLES: EDIT AND UNCOMMENT THE SECTION BELOW TO INSERT DYNAMIC VALUES FROM YOUR PLATFORM OR CMS.
			 *  LEARN WHY DEFINING THESE VARIABLES IS IMPORTANT: https://disqus.com/admin/universalcode/#configuration-variables
			 */
			/*
			var disqus_config = function () {
			    this.page.url = PAGE_URL;  // Replace PAGE_URL with your page's canonical URL variable
			    this.page.identifier = PAGE_IDENTIFIER; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
			};
			 */
			(function() { // DON'T EDIT BELOW THIS LINE
				var d = document, s = d.createElement('script');

				s.src = '//swaroopchippada.disqus.com/embed.js';

				s.setAttribute('data-timestamp', +new Date());
				(d.head || d.body).appendChild(s);
			})();
		</script>
		<noscript>
			Please enable JavaScript to view the <a
				href="https://disqus.com/?ref_noscript" rel="nofollow">comments
				powered by Disqus.</a>
		</noscript>
	</div>
	<custom:footer></custom:footer>

</body>
</html>