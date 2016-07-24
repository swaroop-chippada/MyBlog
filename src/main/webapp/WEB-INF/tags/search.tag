<%@ include file="../tags/taglibs.tag"%>

<div class="jumbotron">
	<div class="container-fluid">
		<!-- <h2>Welcome !</h2>
			<p>Main purpose of this application is to help people learn
				things about web technologies. I created this application to share
				few concepts and methodologies which im quite familiar about.</p> -->

		<form method="get" action="search">
			<div class="form-group form-margin">
				<div class="col-md-2 col-sm-12 col-xs-12" style="font-size: 21px">
					<label>Search Articles</label>
				</div>

				<div class="col-md-3 col-sm-12 col-xs-12">
					<input id="query" placeholder="Search" name="query"
						class="form-control" />
				</div>
				<div class="col-md-3 col-sm-12 col-xs-12 btn-search-sm">
					<input type="submit" value="Search" class="btn btn-success" />
				</div>

			</div>
			<form>
	</div>
</div>