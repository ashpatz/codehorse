var app = angular.module('myApp', []);
    app.controller('myController', function($scope, $http){
        $http.get("http://localhost:8080/dailystatus/rest/employee/fetch/all")
            .success(function(response){
                $scope.employees = response;
            });
        $scope.getCharges = function(){
            return 350;
        }
        $scope.names = [
                 {name:'Jani',country:'Norway'},
                 {name:'Hege',country:'Sweden'},
                 {name:'Kai',country:'Denmark'}
             ];
    });