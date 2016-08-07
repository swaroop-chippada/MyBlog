<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<title>Swaroop Beta Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">

<link rel="stylesheet" href="<c:url value="angular/css/app.css" />" />
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-route.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-sanitize.js"></script>

<script type="text/javascript"
	src="<c:url value="angular/js/main.js" />">
	
</script>

</head>
<body ng-app="myApp">
	<header>
		<!-- Sub Navigation -->
		<div class="top-bar">
			<div class="top-bar-left">
				<ul class="menu">
					<li><a href="#/">Home</a></li>
					<li><a href="#/aboutMe">About Me</a></li>
				</ul>
			</div>
			<div class="top-bar-right">
				<form ng-action="#/search/{{searchKey}}">
					<ul class="menu">
						<li><input type="search" ng-bind="searchKey"
							placeholder="Search"></li>
						<li><button type="button" class="button">Search</button></li>
					</ul>
				</form>
			</div>
		</div>
		<!-- /Sub Navigation -->

		<div class="title-bar" data-responsive-toggle="main-menu"
			data-hide-for="medium">
			<div class="title-bar-title"></div>
		</div>

	</header>

	<br>
	<div ng-view></div>

	<footer>
		<div class="row expanded callout secondary no-margin">
			<div class="large-6 columns">
				<h5>Follow me on</h5>
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
			<div class="large-3 columns">
				<h5></h5>
				<p></p>
			</div>
			<div class="large-3 columns">
				<h5>Tags</h5>
				<span class="secondary label">Java</span> <span
					class="secondary label">Spring</span> <span class="secondary label">Angular</span>
				<span class="secondary label">Hibernate</span> <span
					class="secondary label">Mongo</span> <span class="secondary label">JavaScript</span>
			</div>
		</div>
	</footer>
</body>
</html>