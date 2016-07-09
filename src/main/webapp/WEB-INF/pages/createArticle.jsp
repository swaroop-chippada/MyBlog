<%@ include file="../tags/taglibs.tag"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<meta name="google-site-verification"
	content="w0DVCHIVnjrXlo_0iBjpBDDBavPLscfNQezp6kzbF00" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<%@ include file="../tags/css.tag"%>
<%@ include file="../tags/js.tag"%>
<title>Create New Article</title>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.js"></script>
</head>
<body>

<custom:nav></custom:nav>
	<div class="container-fluid">
		
		<article>
			<header>
				<h2>Article creation</h2>
			</header>
			<div>
				<div class="row">
					<div class="col-md-12">
						<form:form method="post" modelAttribute="article"
							action="articleCreation.do" onsubmit="beforeSubmit()">
							<div class="form-group">
								<label for="heading">Article Heading</label>
								<form:input type="text" path="heading" class="form-control"
									id="heading" placeholder="Article heading" />
							</div>
							<div class="form-group">
								<div id="textEditor">
									<p>New Article</p>
								</div>
								<form:hidden path="content" id="content" />
							</div>
							<div class="form-group">
								<label for="heading">Author</label>
								<form:input type="text" path="author" id="author"
									class="form-control" placeholder="Article Author" />
							</div>
							<div class="form-group">
								<input type="submit" class="btn btn-default" value="Post" /> <input
									type="reset" value="Clear" class="btn btn-default" />
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</article>
	</div>
<%-- 	<custom:footer></custom:footer> --%>

	<script>
		$(document).ready(function() {
			var textArea = $('#textEditor').summernote({
				height : 300, // set editor height
				minHeight : null, // set minimum height of editor
				maxHeight : null, // set maximum height of editor
			});
		});

		function beforeSubmit() {
			$('#content').val($('#textEditor').summernote('code'));
		}
	</script>
</body>
</html>
