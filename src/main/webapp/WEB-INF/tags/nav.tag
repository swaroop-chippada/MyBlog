<%@ include file="../tags/taglibs.tag"%>
<%@ attribute name="active" required="false" type="java.lang.String"%>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">SC</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="<c:if test="${active eq 'home'}">active</c:if>"><a
					href="${pageContext.request.contextPath}/home">Home</a></li>
				<li class="<c:if test="${active eq 'news'}">active</c:if>"><a
					href="${pageContext.request.contextPath}/tag?id=news">Tech News</a></li>
				<li class="<c:if test="${active eq 'gadgets'}">active</c:if>"><a
					href="${pageContext.request.contextPath}/tag?id=gadgets">Gadget
						360</a></li>
				<li><a href="${pageContext.request.contextPath}/angularIndex">QuickView
						(beta)</a></li>
				<li class="<c:if test="${active eq 'aboutme'}">active</c:if>"><a
					href="${pageContext.request.contextPath}/about">About Me</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/createArticle"><span
						class="glyphicon glyphicon-log-in"></span> Create Article</a></li>
			</ul>
		</div>
	</div>
</nav>