var app = angular.module("myApp", [ 'ngRoute', 'ngSanitize' ]);

app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'templates/home.html',
		controller : 'HomeController'
	}).when('/aboutMe', {
		templateUrl : 'templates/aboutMe.html',
	}).when('/search', {
		templateUrl : 'templates/searchResults.html',
		controller : 'SearchController'
	}).when('/articlePage/:id', {
		templateUrl : 'templates/article.view',
		controller : 'ArticleController'
	});
});

app.controller('ArticleController', [ '$scope', '$http', '$route',
		function($scope, $http, $route) {
			$http({
				method : 'GET',
				url : 'ajax/article?id=' + $route.current.params.id,
			}).success(function(data) {
				console.log("success" + data);
				$scope.article = data;
			}).error(function(data) {
				console.log("error");
			});
		} ]);

app.controller('IndexController', [ '$scope', '$http', function($scope, $http) {
	$scope.searchKey = "";
} ]);

app.controller('HomeController', [ '$scope', '$http', function($scope, $http) {
	$scope.articles = [];
	$scope.searchVO = {
		tagId : 'news',
		offset : 0,
		size : 3
	}
	$scope.loadTagPage = function(searchVO) {
		$http({
			method : 'POST',
			url : 'ajax/tag',
			data : searchVO
		}).success(function(data) {
			$scope.articles = data.articles;
			$scope.next = !data.next;
			$scope.previous = !data.previous;
		}).error(function(data) {
			console.log("error" + data);
		});
	}

	var loadGadgets = function() {
		$http({
			method : 'POST',
			url : 'ajax/tag',
			data : {
				tagId : 'gadgets',
				offset : 0,
				size : 5
			}
		}).success(function(data) {
			$scope.gadgets = data.articles;
		}).error(function(data) {
			console.log("error" + data);
		});
	}
	loadGadgets();

	$scope.loadTagPage($scope.searchVO);
	$scope.nextPage = function() {
		if ($scope.next) {
			$scope.searchVO.offset = $scope.searchVO.offset + 1;
			$scope.loadTagPage($scope.searchVO);
		}
	}
	$scope.previousPage = function() {
		if ($scope.previous) {
			$scope.searchVO.offset = $scope.searchVO.offset - 1;
			$scope.loadTagPage($scope.searchVO);
		}
	}
} ]);

app.controller('SearchController', [ '$scope', '$http',
		function($scope, $http) {
			$scope.searchVO = {
				searchKey : $scope.searchKey,
				offset : 0,
				size : 3
			}
			$scope.loadSearchPage = function(searchVO) {
				$http({
					method : 'POST',
					url : 'ajax/search',
					data : searchVO
				}).success(function(data) {
					$scope.articles = data.articles;
					$scope.next = !data.next;
					$scope.previous = !data.previous;
				}).error(function(data) {
					console.log("error");
				});
			}
			$scope.loadSearchPage($scope.searchVO);

			$scope.$watch('searchKey', function(newVal, oldVal) {
				if ($scope.searchKey != '' && $scope.searchKey != undefined) {
					$scope.searchVO = {
						searchKey : $scope.searchKey,
						offset : 0,
						size : 3
					}
					$scope.loadSearchPage($scope.searchVO);
				}
			});
			$scope.nextPage = function() {
				if ($scope.next) {
					$scope.searchVO.offset = $scope.searchVO.offset + 1;
					$scope.loadSearchPage($scope.searchVO);
				}
			}
			$scope.previousPage = function() {
				if ($scope.previous) {
					$scope.searchVO.offset = $scope.searchVO.offset - 1;
					$scope.loadSearchPage($scope.searchVO);
				}
			}
		} ]);

app.filter('htmlToPlaintext', function() {
	return function(text) {
		return text ? String(text).replace(/<[^>]+>/gm, '') : '';
	};
});