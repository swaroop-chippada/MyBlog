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
<title>Ingest feeds</title>
<link href="<c:url value="/resources/assets/css/tagit.ui-zendesk.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/assets/css/jquery.tagit.css"/>"
	rel="stylesheet" type="text/css">

<script src="<c:url value="/resources/assets/js/tag-it.min.js"/>"
	type="text/javascript" charset="utf-8"></script>
</head>
<body>

	<custom:nav></custom:nav>
	<div class="container-fluid">
		<header>
			<h2>Ingest Feeds</h2>
		</header>
		<div class="row">
			<div class="col-md-12">
				<form>
					<div class="form-group">
						<label for="heading">Feed Provider Name</label> <input type="text"
							class="form-control" id="feedProviderName"
							placeholder="Feed provider Name" />
					</div>
					<div class="form-group">
						<label for="heading">Feed URL</label> <input type="text"
							class="form-control" id="feedUrl"
							placeholder="Place the feed url here...." />
					</div>

					<div class="form-group">
						<label for="heading">Feed Tags</label> <input class="form-control"
							id="feedTags" />
					</div>

					<div class="btn-group" data-toggle="buttons">
						<label for="heading">Feed Type</label> </br> <label
							class="btn btn-primary active"> <input type="radio"
							name="type" value="Atom" />Atom
						</label> <label class="btn btn-primary"> <input type="radio"
							name="type" value="RSS" />RSS
						</label>
					</div>

					<div class="form-group">
						</br> <input type="button" class="btn btn-success" value="Ingest"
							onclick="onSubmit();" />
					</div>
					<div class="form-group hide" id="loading">
						</br> <img alt="" src=" <c:url value="/resources/images/loading.gif"/>"
							style="width: 10%">
					</div>

				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#feedTags').tagit();
		});
		function onSubmit() {
			$("#loading").removeClass("hide");
			$("#loading").show();
			var feed = {}
			feed["feedUrl"] = $("#feedUrl").val();
			feed["feedType"] = $("input:checked").val();
			feed["feedProviderName"] = $("#feedProviderName").val();
			feed["feedTags"] = $("#feedTags").val();

			var request = $.ajax({
				type: "POST",
	             contentType: "application/json",
	             url: "ingest",
	             data: JSON.stringify(feed),
	             dataType: 'json',
	             timeout: 600000,
				});
				 
				request.done(function( msg ) {
					 $("#loading").hide();
	 				 alert("Feed uploaded successfully");
				});
				 
				request.fail(function( jqXHR, textStatus ) {
					$("#loading").hide();
	 				alert("failed to upload feed"+textStatus);
				});
			
			
		}
	</script>

</body>
</html>
