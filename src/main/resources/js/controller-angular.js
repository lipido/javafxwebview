
var app = angular.module('javafxwebdemo', []);

app.controller('JavaFXWebDemoController', function ($scope) {

  // fruits
  $scope.fruits = ["loading..."];
  angular.element(document).ready(function () {
	$scope.update();
  });
    
  $scope.update=function(){ 
    $scope.fruits = ["loading..."];
    
    fruitsService.loadFruits(function(data){
      $scope.fruits = data;
      $scope.$apply();      
    });
  }
  
  // calculator
  $scope.number1 = 0;
  $scope.number2 = 2;

  $scope.sum=function() {    
    return calculatorService.sum($scope.number1, $scope.number2);
  }
});

