<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Swaroop Chippada Home Page</title>
<meta charset="utf-8">
<meta name="google-site-verification"
	content="w0DVCHIVnjrXlo_0iBjpBDDBavPLscfNQezp6kzbF00" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
<%-- <link rel="stylesheet"
	href="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">--%>
<link rel="stylesheet" href="<c:url value="angular/css/app.css" />" />
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular-route.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular-sanitize.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular-animate.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular-touch.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/2.0.1/ui-bootstrap-tpls.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="<c:url value="angular/js/main.js" />">
	
</script>
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
<body ng-app="myApp" ng-controller="IndexController">
	<header>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">SC</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="#/">Home</a></li>
						<li><a href="#/allArticles">Recent Articles</a></li>
						<li><a href="#/aboutMe">About Me</a></li>
					</ul>
					<form class="navbar-form navbar-right" ng-submit="search()">
						<div class="form-group">
							<input type="text" class="form-control" ng-model="searchKey"
								placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="<c:url value="createArticle" />">Create
								Article</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</header>
	<br>
	<div ng-view class="view-min-height"></div>
	<footer>
		<div class="container-fluid footer-style">
			<div class="col-sm-6">
				<h4>Follow me on</h4>
				<a href="https://www.facebook.com/public/Swaroop-Chippada"
					class="social-icons"><i class="fa fa-facebook"
					aria-hidden="true"></i> </a> <a
					href="https://in.linkedin.com/in/swaroop-chippada-71ba5981"
					class="social-icons"><i class="fa fa-linkedin"
					aria-hidden="true"></i></a> <a
					href="https://plus.google.com/104471467782100958291"
					class="social-icons"><i class="fa fa-google-plus"
					aria-hidden="true"></i></a>
			</div>
			<div class="col-sm-3">
				<p></p>
			</div>
			<div class="col-sm-3">
				<h4>Tags</h4>
				<span class="tag-label">Java</span> <span class="tag-label">Spring</span>
				<span class="tag-label">Angular</span> <span class="tag-label">Hibernate</span>
				<span class="tag-label">Mongo</span> <span class="tag-label">JavaScript</span>
			</div>
		</div>
	</footer>
</body>
</html>