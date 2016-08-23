var app = angular.module("myApp", [ 'ngRoute', 'ngSanitize', 'ui.bootstrap' ]);

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
	}).when('/login', {
		templateUrl : 'templates/login.html',
		controller : 'LoginController'
	}).when('/allArticles', {
		templateUrl : 'templates/allArticles.html',
		controller : 'RecentArticlesController'
	});

});

app.controller('ArticleController', [ '$scope', '$http', '$route',
		function($scope, $http, $route) {
			$http({
				method : 'GET',
				url : 'ajax/article?id=' + $route.current.params.id,
			}).success(function(data) {
				$scope.article = data;
				var d = document, s = d.createElement('script');

				s.src = '//swaroopchippada.disqus.com/embed.js';

				s.setAttribute('data-timestamp', +new Date());
				(d.head || d.body).appendChild(s);
			}).error(function(data) {
				console.log("error");
			});
		} ]);

app.controller('IndexController', [ '$scope', '$http', '$location',
		'$uibModal', function($scope, $http, $location, $uibModal) {
			$scope.search = function() {
				$location.path("/search");
			};
			$scope.openPostModal = function() {
				var modalInstance = $uibModal.open({
					animation : true,
					ariaLabelledBy : 'modal-title',
					ariaDescribedBy : 'modal-body',
					templateUrl : 'templates/post.html',
					controller : 'PostController',
					size : 'lg',
				// resolve: {
				// items: function () {
				// return $ctrl.items;
				// }
				// }
				});
			};
		} ]);

app.controller('PostController', [ '$scope', '$http',
		function($scope, $http) {
			$scope.postQuestion = function() {
				var question = {
					name : $scope.userName,
					email : $scope.email,
					question : $scope.question
				}
				$http({
					method : 'POST',
					url : 'ajax/postQuestion',
					data : question
				}).success(function(data) {
					console.log("successfully posted");
//					$uibModalInstance.dismiss('cancel');
				}).error(function(data) {
					// $scope.message = "Registered Successfully"
				});
			}
		} ]);

app.controller('LoginController', [ '$scope', '$http', function($scope, $http) {
	$scope.login = function() {
		var newUser = {
			userName : $scope.userName,
			password : $scope.password,
			firstName : $scope.firstName,
			lastName : $scope.lastName,
			email : $scope.email
		}
		$http({
			method : 'POST',
			url : 'ajax/register',
			data : newUser
		}).success(function(data) {
			if (data) {
				$scope.message = "Registered Successfully"
			} else {
				$scope.message = "UserName Already Exist !"
			}
		}).error(function(data) {
		});
	}
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

app.controller('RecentArticlesController', [ '$scope', '$http',
		function($scope, $http) {
			$scope.articles = [];
			$scope.searchVO = {
				offset : 0,
				size : 3
			}
			$scope.loadRecentArticles = function(searchVO) {
				$http({
					method : 'POST',
					url : 'ajax/allArticles',
					data : searchVO
				}).success(function(data) {
					$scope.articles = data.articles;
					$scope.next = !data.next;
					$scope.previous = !data.previous;
				}).error(function(data) {
					console.log("error" + data);
				});
			}

			$scope.loadRecentArticles($scope.searchVO);
			$scope.nextPage = function() {
				if ($scope.next) {
					$scope.searchVO.offset = $scope.searchVO.offset + 1;
					$scope.loadRecentArticles($scope.searchVO);
				}
			}
			$scope.previousPage = function() {
				if ($scope.previous) {
					$scope.searchVO.offset = $scope.searchVO.offset - 1;
					$scope.loadRecentArticles($scope.searchVO);
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