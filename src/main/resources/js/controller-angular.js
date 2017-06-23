
var app = angular.module('javafxwebdemo', []);

app.controller('JavaFXWebDemoController', function ($scope) {

  // fruits
  $scope.fruits = [];
  $scope.update=function(){ 
   $scope.fruits = [{getName: function() {return 'loading...'}}];
    var callback = function(data) {
        
        // clone the array, because if we use the raw array returned from Java, 
        // a pseudo-javascript Array is created which returns different object 
        // wrapper instances each time a position is accessed
        // for example: data[0] === data[0] is false!!, so Angular will throw a
        // digest infinite loop exception because elements are allways dirty
       $scope.fruits = Array.from(data);

       $scope.$apply();
    }
    fruitsService.loadFruits(callback);
  }
  
  $scope.update();
  // calculator
  $scope.number1 = 0;
  $scope.number2 = 2;

  $scope.sum = function() {    
    return calculatorService.sum($scope.number1, $scope.number2);
  }
});

