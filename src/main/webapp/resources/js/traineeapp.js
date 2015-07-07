/**
 * 
 */
/*var traineemodule=angular.module('FAtraineeApp', [])

.controller('mainController', function($scope) {
  $scope.sortType     = 'name'; // set the default sort type
  $scope.sortReverse  = true;  // set the default sort order
  $scope.searchFish   = '';     // set the default search/filter term
  
  // create the list of sushi rolls 
  $scope.sushi = [
    { name: 'Cali Roll', fish: 'Crab', tastiness: 2 },
    { name: 'Philly', fish: 'Tuna', tastiness: 4 },
    { name: 'Tiger', fish: 'Eel', tastiness: 7 },
    { name: 'Rainbow', fish: 'Variety', tastiness: 6 }
  ];
  
});*/
var traineemodule=angular.module('FAtraineeApp', []);
var list;
var Baseurl="http://172.20.144.83:9090/FeedBackAutomation";
traineemodule.controller('FATraineeController',function($scope,$http)
		{
			$http.get(Baseurl+'/validatelogin').
			success(function(data){
				$scope.list=data;
			})
	
		})
	
	
