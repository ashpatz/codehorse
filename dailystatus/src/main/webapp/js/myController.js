angular.module('myApp', []).controller('myController', function($scope){
        $scope.getCharges = function(){
            return 350;
        }
        $scope.names = [
                 {name:'Jani',country:'Norway'},
                 {name:'Hege',country:'Sweden'},
                 {name:'Kai',country:'Denmark'}
             ];
    });