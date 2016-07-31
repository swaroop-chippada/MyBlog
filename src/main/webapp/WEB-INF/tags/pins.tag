<%@ include file="../tags/taglibs.tag"%>
<%@ attribute name="list" required="true" type="java.util.List"%>

<div class="container-fluid page-layout-news">
		<div id="wrapper">
			<div id="columns">
				<c:forEach var="article" items="${articleList}">
					<a href="${article.relativeUrl}"> <c:choose>
							<c:when test="${empty article.imageUrl}">
								<div class="pin no-pin-image">
									<p>${article.heading}</p>
								</div>
							</c:when>
							<c:otherwise>
								<div class="pin">
									<img src="${article.imageUrl}" />
									<p>${article.heading}</p>
								</div>
							</c:otherwise>
						</c:choose>

					</a>
				</c:forEach>
			</div>
		</div>
	</div>