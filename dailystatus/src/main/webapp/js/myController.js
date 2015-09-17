angular.module('myApp', [])
        .controller('myController', function($scope, $http){
        $http.get("http://localhost:8080/dailystatus/status/get")
            .success(function(response){
                $scope.myVar = response.key;
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