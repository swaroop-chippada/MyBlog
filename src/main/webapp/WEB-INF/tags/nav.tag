<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="showSearch" required="false" type="java.lang.Boolean" %>
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
				<a class="navbar-brand" href="<c:url value="/#/" />">SC</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value="/#/" />">Home</a></li>
					<li><a href="<c:url value="/#/allArticles" />">Recent Articles</a></li>
					<li><a href="<c:url value="/#/aboutMe" />">About Me</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<c:url value="createArticle" />">Create
							Article</a></li>
					<c:if test="${isUserLogged}">
						<li><a href="<c:url value="/logout" />"><span
								class="glyphicon glyphicon-log-in"></span> Sign Out</a></li>
					</c:if>
				</ul>
				<c:if test="${showSearch}">
					<form class="navbar-form navbar-right" ng-submit="search()">
						<div class="form-group">
							<input type="text" class="form-control" ng-model="searchKey"
								placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
				</c:if>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</header>
