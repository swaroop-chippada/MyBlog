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
<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script',
			'https://www.google-analytics.com/analytics.js', 'ga');
	ga('create', 'UA-48025306-2', 'auto');
	ga('send', 'pageview');
</script>
</head>
<body>
	<!-- Nav -->
	<%@ include file="../tags/nav.tag"%>

	<!-- Home -->
	<div class="wrapper style1 first">
		<article class="container" id="top">
			<div class="row">
				<div class="4u 12u(mobile)">
					<span class="image fit"><img
						src="<c:url value="/resources/images/Swap-Profile.JPG"/>"
						alt="swaroop chippada" /></span>
				</div>
				<div class="8u 12u(mobile)">
					<header>
						<h1>
							Hi. I'm <strong>Swaroop Chippada</strong>.
						</h1>
					</header>
					<p>
						And this is <strong>My page</strong>, I'm a passionate software
						developer. I love programming and want to continously learn new
						things and make things easy for simple living. I Developed various
						WEB based applications. I'm Primarily a backend java developer. i
						worked on various frameworks such as Spring, Hibernate, Spring
						batch, GWT and JSF. I have deep knowledge of and experience with
						the SOLR search platform and Mongo DB. My passion towards
						technology drives me more and explore each of the framework and
						learn its benefits. I started this website just for helping people
						find solutions for complex problems.
					</p>
					<!-- <a href="#work" class="button big scrolly">Learn about what I
						do</a> -->

					<footer>
						<p>Do you have any questions on your mind ?</p>
						<a href="#contact" class="button big scrolly">Post me here</a>
					</footer>
				</div>
			</div>
		</article>
	</div>

	<!-- Contact -->
	<div class="wrapper style4">
		<article id="contact" class="container 75%">
			<header>
				<h2>Let me help you in finding answer for you ?</h2>
				<!-- 						<p>Let me help you in creating a high performance and robust application for you.</p> -->
			</header>
			<div>
				<div class="row">
					<div class="12u">
						<form:form method="post" modelAttribute="questionForm"
							action="postQuestion.do">
							<div>
								<div class="row">
									<div class="6u 12u(mobile)">
										<form:input type="text" path="userName" id="name"
											placeholder="Name" />
									</div>
									<div class="6u 12u(mobile)">
										<form:input type="text" path="email" id="email"
											placeholder="Email" />
									</div>
								</div>
								<div class="row">
									<div class="12u">
										<form:input type="text" path="question" id="question"
											placeholder="Post your Question here !" />
									</div>
								</div>
								<div class="row 200%">
									<div class="12u">
										<ul class="actions">
											<li><input type="submit" value="Post" /></li>
											<li><input type="reset" value="Clear" class="alt" /></li>
										</ul>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
				<div class="row">
					<div class="12u">
						<hr />
						<h3>Find me on ...</h3>
						<ul class="social">
							<li><a
								href="https://www.facebook.com/public/Swaroop-Chippada"
								class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a
								href="https://in.linkedin.com/in/swaroop-chippada-71ba5981"
								class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
							<li><a href="https://plus.google.com/104471467782100958291"
								class="icon fa-google-plus"><span class="label">Google+</span></a></li>
						</ul>
						<hr />
					</div>
				</div>
			</div>
		</article>
	</div>
</body>
</html>