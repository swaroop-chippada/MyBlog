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
						<label for="heading">Feed URL</label> <input type="text"
							class="form-control" id="feedUrl"
							placeholder="Place the feed url here...." />
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
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function onSubmit() {
			$.post("ingest", {
				url : $("#feedUrl").val()
			}).done(function(data) {
				alert("Data Loaded: " + data);
			});
		}
	</script>

</body>
</html>
