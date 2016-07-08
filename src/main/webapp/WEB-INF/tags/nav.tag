<%@ include file="../tags/taglibs.tag"%>
<%@ attribute name="active" required="false" type="java.lang.String" %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">SC</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="<c:if test="${active eq 'home'}">active</c:if>"><a href="Home">Home</a></li>
        <li class="<c:if test="${active eq 'aboutme'}">active</c:if>"><a href="about">About Me</a></li>
      </ul>
      <!-- <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul> -->
      <ul class="nav navbar-nav navbar-right">
        <li><a href="createArticle"><span class="glyphicon glyphicon-log-in"></span> Create Article</a></li>
      </ul>
    </div>
  </div>
</nav>